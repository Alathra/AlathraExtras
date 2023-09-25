package me.ShermansWorld.AlathraExtras.playtime;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.AlathraExtras;

public class PlaytimeCommand implements CommandExecutor {

	public static ArrayList<Player> freeOpList = new ArrayList<Player>();

	public PlaytimeCommand(final AlathraExtras plugin) {
		plugin.getCommand("playtime").setExecutor((CommandExecutor) this);
	}

	public String getPlaytime(OfflinePlayer offlinePlayer) {
		// Name misleading, actually records ticks
		long playtime = offlinePlayer.getStatistic(Statistic.PLAY_ONE_MINUTE);
		long playtimeSeconds = playtime /= 20; // playtime in seconds
		int days = (int) TimeUnit.SECONDS.toDays(playtimeSeconds);
		long hours = TimeUnit.SECONDS.toHours(playtimeSeconds) - (days * 24);
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

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;

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
