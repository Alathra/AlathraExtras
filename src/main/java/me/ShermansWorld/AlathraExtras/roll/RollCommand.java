package me.ShermansWorld.AlathraExtras.roll;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.ShermansWorld.AlathraExtras.Helper;
import com.palmergames.bukkit.TownyChat.Chat;
import com.palmergames.bukkit.TownyChat.channels.Channel;


public class RollCommand implements CommandExecutor {

    private final Random random = new Random();
    private final Pattern pattern = Pattern.compile("^(\\d*)d?(\\d*)([-+*/]?)(\\d*)([><=><=]?)(\\d*)");

    public RollCommand(final JavaPlugin plugin) {
        plugin.getCommand("roll").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int numberOfDie = 1;
        int dieSides = 6;
        int modifier = 0;
        String modifierSign = "+";
        int comparator = 0;
        String comparatorSign = "";

        if (args.length > 0) {
            Matcher matcher = pattern.matcher(args[0]);
            if (matcher.find()) {
                if (!matcher.group(1).equals("")) numberOfDie = Integer.parseInt(matcher.group(1));
                if (!matcher.group(2).equals("")) dieSides = Integer.parseInt(matcher.group(2));
                if (!matcher.group(3).equals("")) modifierSign = matcher.group(3);
                if (!matcher.group(4).equals("")) modifier = Integer.parseInt(matcher.group(4));
                if (!matcher.group(5).equals("")) comparatorSign = matcher.group(5);
                if (!matcher.group(6).equals("")) comparator = Integer.parseInt(matcher.group(6));
            }
        }

        if (numberOfDie > 100) numberOfDie = 100;
        if (dieSides > 100) dieSides = 100;

        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < numberOfDie; i++) {
            int roll = random.nextInt(dieSides) + 1;
            rolls.add(roll);
        }

        int rollSum = rolls.stream().reduce(0, Integer::sum);
        int rollTotal = getRollTotal(modifier, modifierSign, rollSum);
        boolean rollResult = isRollResult(comparator, comparatorSign, rollTotal);
        boolean usedModifier = !(modifierSign.equals("+") && modifier == 0) && !(modifierSign.equals("-") && modifier == 0) && !(modifierSign.equals("/") && modifier == 1);
        boolean usedComparator = !comparatorSign.equals("");

        String rollComparator = "(" + rollTotal + comparatorSign + comparator + ") ";
        String rollStatus = usedComparator ? ((rollResult ? "succeeded" : "failed") + " " + rollComparator) : "";
        String rollAction = String.join(" ", Arrays.stream(args).skip(1).toArray(String[]::new));
        if (!rollStatus.equals("") || !rollAction.equals("")) rollAction += " | ";
        String rollMessage = "rolled " + rollSum + (usedModifier ? "(" + modifierSign + modifier + ") = " + rollTotal : "") + " using " + numberOfDie + "d" + dieSides;
        String message = (rollStatus + rollAction + rollMessage).trim().replace(" +", " ");
        if (sender instanceof Player player) {
            Channel channel = Chat.getTownyChat().getPlayerChannel(player);
            channel.chatProcess(new AsyncPlayerChatEvent(true, player, message, new HashSet<>()));
            player.chat(message);
        }
        return true;


    }

    private static boolean isRollResult(int comparator, String comparatorSign, int rollTotal) {
        return switch (comparatorSign) {
            case ">" -> rollTotal > comparator;
            case "<" -> rollTotal < comparator;
            case ">=" -> rollTotal >= comparator;
            case "<=" -> rollTotal <= comparator;
            default -> false;
        };
    }

    private static int getRollTotal(int modifier, String modifierSign, int rollSum) {
        return switch (modifierSign) {
            case "+" -> (rollSum + modifier);
            case "-" -> (rollSum - modifier);
            case "*" -> (rollSum * modifier);
            case "/" -> (rollSum / modifier == 0 ? 1 : modifier);
            default -> rollSum;
        };
    }


}
