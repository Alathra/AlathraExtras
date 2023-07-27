package me.ShermansWorld.AlathraExtras.playtime;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaytimeTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> completions = new ArrayList<>();

		if (args.length == 1) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				completions.add(player.getName());
			}
			return completions;
		}

		return Collections.emptyList();
	}
}