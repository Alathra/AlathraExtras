package me.ShermansWorld.AlathraExtras.roll;


import com.github.milkdrinkers.colorparser.ColorParser;
import com.palmergames.bukkit.TownyChat.Chat;
import com.palmergames.bukkit.TownyChat.channels.Channel;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


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
        boolean usedComparator = !comparatorSign.isEmpty();

        String rollComparator = "%s %s %s".formatted(rollTotal, comparatorSign, comparator);
        String rollStatus = usedComparator ?
            "(<italic>%s %s</italic>)".formatted(rollResult ? "Success" : "Fail", rollComparator) :
            "";
        String rollAction = String.join(" ", Arrays.stream(args).skip(1).toArray(String[]::new));

        if (sender instanceof Player p) {
            var channel = Chat.getTownyChat().getPlayerChannel(p);
            Resident resident = TownyUniverse.getInstance().getResident(p.getUniqueId());
            @Nullable Town town = TownyAPI.getInstance().getResidentTownOrNull(resident);
            @Nullable Nation nation = TownyAPI.getInstance().getResidentNationOrNull(resident);
            var recipients = getRecipients(p, town, nation, channel, new HashSet<>(Bukkit.getOnlinePlayers()));

            var message = ColorParser.of("<channel><#44FFA6><player> <dark_gray>»<#44FFA6> rolled <roll_sum><modifier> using <dice_count> <plural_dice> of <dice_sides> <plural_side>. <roll_status><roll_actions>")
                .parseMinimessagePlaceholder("channel", channel.getChannelTag().isEmpty() ? "" : "%s ".formatted(channel.getChannelTag())) // Add trailing space after tag
                .parseMinimessagePlaceholder("player", p.getName())
                .parseMinimessagePlaceholder("roll_sum", String.valueOf(rollSum))
                .parseMinimessagePlaceholder("modifier", usedModifier ? "(" + modifierSign + modifier + ") = " + rollTotal : "")
                .parseMinimessagePlaceholder("dice_count", String.valueOf(numberOfDie))
                .parseMinimessagePlaceholder("plural_dice", numberOfDie == 1 ? "die" : "dice")
                .parseMinimessagePlaceholder("dice_sides", String.valueOf(dieSides))
                .parseMinimessagePlaceholder("plural_side", dieSides == 1 ? "side" : "sides")
                .parseMinimessagePlaceholder("roll_status", rollStatus)
                .parseMinimessagePlaceholder("roll_actions", rollAction.isEmpty() ? "" : " (<italic>%s</italic>)".formatted(rollAction))
                .build();

            recipients.forEach(recipient -> recipient.sendMessage(message));
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

    private Set<Player> getRecipients(Player player, @Nullable Town town, @Nullable Nation nation, Channel channel, Set<Player> recipients) {
        return switch (channel.getType()) {
            case TOWN ->
                town != null ? new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayers(town))) : new HashSet<>();
            case NATION ->
                nation != null ? new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayers(nation))) : new HashSet<>();
            case ALLIANCE ->
                nation != null ? new HashSet<>(receivers(channel, player, TownyAPI.getInstance().getOnlinePlayersAlliance(nation))) : new HashSet<>();
            case DEFAULT, GLOBAL, PRIVATE -> new HashSet<>(receivers(channel, player, new ArrayList<>(recipients)));
        };
    }

    private Set<Player> receivers(Channel channel, Player sender, List<Player> playerList) {
        playerList.forEach(player -> checkChannels(player, channel));
        return playerList.stream()
            .filter(player -> !Chat.getTownyChat().isIgnoredByEssentials(sender, player))
            .filter(player -> !channel.isAbsent(player.getName()))
            .filter(channel::hasPermission)
            .filter(player -> isInRange(channel.getRange(), sender, player))
            .collect(Collectors.toSet());
    }

    private boolean isInRange(double range, Player firstPlayer, Player secondPlayer) {
        return switch ((int) range) {
            case -1 -> true;
            case 0 -> firstPlayer.getWorld().equals(secondPlayer.getWorld());
            default -> firstPlayer.getWorld().equals(secondPlayer.getWorld()) &&
                firstPlayer.getLocation().distance(secondPlayer.getLocation()) < range;
        };
    }

    private void checkChannels(Player player, Channel channel) {
        if (!channel.isPresent(player.getName())) channel.forgetPlayer(player);
    }
}
