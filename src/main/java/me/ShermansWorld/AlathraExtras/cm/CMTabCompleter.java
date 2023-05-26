package me.ShermansWorld.AlathraExtras.cm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CMTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> completions = new ArrayList<>();

		if (args.length == 1) {
			completions.add("add");
			completions.add("remove");
			return completions;
		} else if (args.length == 2) {
			completions.add("Slayer10300");
			completions.add("GnomeSaying_");
			completions.add("xdMoon");
			completions.add("IClockwork");
			return completions;
		}

		return Collections.emptyList();
	}
}