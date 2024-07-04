package me.ShermansWorld.AlathraExtras;

import com.palmergames.bukkit.towny.utils.NameUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class AlathraExtrasTabCompleter implements TabCompleter {
    private final List<String> commandCompletions = List.of(
        "give",
        "toggleitemdamage"
    );

    private final List<String> giveCompletions = List.of(
        "tiny_xp_pouch",
        "alathran_iron",
        "uncharged_silver_melon",
        "charged_silver_melon",
        "tungsten",
        "silver",
        "platinum"
    );

    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        switch (args[0].toLowerCase()) {
            case "give" -> {
                if (args.length == 1) return Collections.emptyList();
                if (args.length == 2) return NameUtil.filterByStart(giveCompletions, args[1]);
                else return Collections.emptyList();
            }
            case "toggleitemdamage" -> {
                return Collections.emptyList();
            }
            default -> {
                if (args.length == 1) {
                    return NameUtil.filterByStart(commandCompletions, args[0]);
                }
                return Collections.emptyList();
            }
        }
    }
}

