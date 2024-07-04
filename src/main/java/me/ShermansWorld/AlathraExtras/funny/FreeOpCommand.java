package me.ShermansWorld.AlathraExtras.funny;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FreeOpCommand implements CommandExecutor {

    public static ArrayList<Player> freeOpList = new ArrayList<>();

    public FreeOpCommand(final AlathraExtras plugin) {
        PluginCommand freeopCommand = plugin.getCommand("freeop");

        if (freeopCommand == null) return;

        freeopCommand.setExecutor(this);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player p)) {
            return false;
        }

        int randNum = AlathraExtras.rand.nextInt(13) + 1; // random number between 1 and 10

        if (freeOpList.contains(p)) {
            p.sendMessage(Helper.color("&cThis command has a 30 second cooldown"));
            return false;
        }

        switch (randNum) {
            case 1:
                p.chat("I am a fool!");
                break;
            case 2:
                p.chat("I am a very gullible person.");
                break;
            case 3:
                p.chat("I ain't the sharpest tool in the shed.");
                break;
            case 4:
                p.chat("All I wanted is free op, but all I shall recieve is shame from my peers.");
                break;
            case 5:
                p.chat("My disappointment is immeasureable and my day is ruined.");
                break;
            case 6:
                p.chat("Am I a dunderhead? Yes or No?");
                break;
            case 7:
                p.chat("My head is as empty as the island of Valtara.");
                break;
            case 8:
                p.chat("Sometimes I like to take a can of baked beans, strain out the goo, and then slurp on it through a silly straw.");
                break;
            case 9:
                p.chat("Anyone know the lore behind Binky Barnes? He's my favorite side character of all time.");
                break;
            case 10:
                p.chat("I like to drink orange juice right after I brush my teeth.");
                break;
            case 11:
                p.chat("Who wants free money?");
                break;
            case 12:
                p.chat("Knock knock!");
                break;
        }
        freeOpList.add(p);
        Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), new Runnable() {
            public void run() {
                freeOpList.remove(p);
            }
        }, 600L); //30 seconds
        return true;
    }

}
