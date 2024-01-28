package me.ShermansWorld.AlathraExtras;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlathraExtrasTabCompleter implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<String>();
        if (args.length == 1) {
            completions.add("give");
            completions.add("toggleitemdamage");
            return completions;
        } else if (args.length == 2) {
            completions.add("tiny_xp_pouch");
            completions.add("alathran_iron");
            return completions;
        }
        return Collections.emptyList();
    }
}

