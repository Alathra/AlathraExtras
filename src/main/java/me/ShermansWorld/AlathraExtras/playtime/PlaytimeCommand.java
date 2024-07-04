package me.ShermansWorld.AlathraExtras.playtime;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class PlaytimeCommand implements CommandExecutor {
    public PlaytimeCommand(final AlathraExtras plugin) {
        PluginCommand playtimeCommand = plugin.getCommand("playtime");

        if (playtimeCommand == null) return;

        playtimeCommand.setExecutor(this);
    }

    public String getPlaytime(OfflinePlayer offlinePlayer) {
        // Name misleading, actually records ticks
        long playtime = offlinePlayer.getStatistic(Statistic.PLAY_ONE_MINUTE);
        long playtimeSeconds = playtime /= 20; // playtime in seconds
        int days = (int) TimeUnit.SECONDS.toDays(playtimeSeconds);
        long hours = TimeUnit.SECONDS.toHours(playtimeSeconds) - (days * 24L);
        long minutes = TimeUnit.SECONDS.toMinutes(playtimeSeconds) - (TimeUnit.SECONDS.toHours(playtimeSeconds) * 60);
        long seconds = TimeUnit.SECONDS.toSeconds(playtimeSeconds) - (TimeUnit.SECONDS.toMinutes(playtimeSeconds) * 60);

        if (days < 1) {
            if (hours < 1) {
                if (minutes < 1) {
                    return seconds + " seconds.";
                }
                return minutes + " minutes and " + seconds + " seconds.";
            }
            return hours + " hours, " + minutes + " minutes and " + seconds + " seconds.";
        }
        return days + " days, " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds.";
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length == 0) {
            player.sendMessage(Helper.Chatlabel() + Helper.color("&a" + player.getName() + " has been playing for " + getPlaytime(player)));
            return true;
        } else if (args.length == 1) {
            String playername = args[0];
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playername);
            player.sendMessage(Helper.Chatlabel() + Helper.color("&a" + playername + " has been playing for " + getPlaytime(offlinePlayer)));
            return true;
        }
        return false;
    }

}
