package me.ShermansWorld.AlathraExtras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class AlathraExtrasTabCompleter implements TabCompleter {
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> completions = new ArrayList<String>();
		if (args.length == 1) {
			completions.add("give");
			return completions;
		} else if (args.length == 2) {
			completions.add("tiny_xp_pouch");
			return completions;
		}
		return Collections.emptyList();
	}
}

