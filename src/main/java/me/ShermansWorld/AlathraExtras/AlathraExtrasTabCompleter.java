package me.ShermansWorld.AlathraExtras;

import com.palmergames.bukkit.towny.utils.NameUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlathraExtrasTabCompleter implements TabCompleter {

    private List<String> commandCompletions = List.of(
        "give",
        "toggleitemdamage"
    );

    private List<String> giveCompletions = List.of(
        "tiny_xp_pouch",
        "alathran_iron",
        "uncharged_silver_melon",
        "charged_silver_melon",
        "tungsten",
        "silver",
        "platinum"
    );

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			return new ArrayList<String>(commandCompletions);
        } else if(args.length <= 2){
            switch (args[0].toLowerCase()){
                case "give" -> {
                    return giveCompletions;
                }
                case "toggleitemdamage" -> {
                    return Collections.emptyList();
                }
                default -> {
                    if (args[0].equals("give")) return NameUtil.filterByStart(giveCompletions, args[1]);
                    return Collections.emptyList();
                }
            }
		}
         return Collections.emptyList();
    }
}

