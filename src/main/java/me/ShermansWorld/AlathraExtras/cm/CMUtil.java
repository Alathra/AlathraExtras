package me.ShermansWorld.AlathraExtras.cm;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;

public class CMUtil {

	public static HashSet<String> candidates = new HashSet<>();
		
	static {
		candidates.add("slayer10300");
		candidates.add("xdmoon");
		candidates.add("iclockwork");
	}
	
	
	public static boolean hasEnoughPlaytime(Player p) {
		// Name misleading, actually records ticks
		long playtime = p.getStatistic(Statistic.PLAY_ONE_MINUTE);
		playtime /= 20; // playtime in seconds
		playtime /= 60; // playtime in minutes
		playtime /= 60; // playtime in hours

		return playtime >= 10;
	}

	public static boolean isAlt(Player p, String candidate) {
		for (Object value : Main.cmVoteData.getConfig().getConfigurationSection(candidate).getValues(true).values()) {
			if (value.toString().contentEquals(p.getAddress().toString())) {
				if (!Main.cmVoteData.getConfig().getConfigurationSection(candidate)
						.contains(p.getUniqueId().toString())) {
					p.sendMessage(Helper.Chatlabel() + Helper.color("&4&lYou have already voted from another account!"));
					return true;
				}
			}
		}
		return false;
	}

	public static void addVote(Player p, String candidate) {
		if (!hasEnoughPlaytime(p)) {
			p.sendMessage(Helper.Chatlabel() + Helper.color("&c&lYou do not have enough playtime to vote!"));
			return;
		}
			Main.cmVoteData.getConfig().set(candidate + "." + p.getUniqueId().toString(), null);
			Main.cmVoteData.getConfig().set(candidate + "." + p.getUniqueId().toString() + ".name", p.getName());
			Main.cmVoteData.getConfig().set(candidate + "." + p.getUniqueId().toString() + ".ip",
					p.getAddress().toString());
			Main.cmVoteData.saveConfig();
			p.sendMessage(Helper.Chatlabel() + Helper.color("&a&lVote added to &e" + candidate));
	}

	public static void removeVote(Player p, String candidate) {
		Main.cmVoteData.getConfig().set(candidate + "." + p.getUniqueId().toString(), null);
		Main.cmVoteData.saveConfig();
		p.sendMessage(Helper.Chatlabel() + Helper.color("&c&lVote removed from &e" + candidate));
	}

}
