package me.ShermansWorld.AlathraExtras.customroles;

import me.ShermansWorld.AlathraExtras.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;

public class CustomRoleTabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Map pData = (Map) Main.DataManager.getData(player.getUniqueId());

        String cmdName = command.getName();
        List<String> completions = new ArrayList<>();
        if(cmdName.equalsIgnoreCase("mercenary")){
            if(args.length == 1) {
                completions.add("hire");
                if ((Boolean) pData.get("MercPermission")) {
                    completions.add("accept");
                    completions.add("decline");
                    completions.add("complete");
                }
                if (player.hasPermission("AlathraExtras.Admin")) {
                    completions.add("add");
                    completions.add("remove");
                }
                return completions;
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("add")) {
                    return null;
                } else if (args[0].equalsIgnoreCase("remove")) {
                    return null;
                } else if (args[0].equalsIgnoreCase("accept")) {
                    // Get everyone who has a request
                    return null;
                } else if (args[0].equalsIgnoreCase("decline")) {
                    // Get everyone who has a request
                    return null;
                } else if (args[0].equalsIgnoreCase("hire")) {
                    return null;
                }
                return completions;
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("hire")) {
                    completions.add("10000");
                    completions.add("20000");
                    completions.add("50000");
                    completions.add("100000");
                    return completions;
                }
            } else {
                return null;
            }
        }
        else if (cmdName.equalsIgnoreCase("assassin")) {
            if(args.length == 1) {
                completions.add("hire");
                if ((Boolean) pData.get("AssassinPermission")) {
                    completions.add("accept");
                    completions.add("decline");
                    completions.add("complete");
                }
                if (player.hasPermission("AlathraExtras.Admin")) {
                    completions.add("add");
                    completions.add("remove");
                }
                return completions;
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("add")) {
                    return null;
                } else if (args[0].equalsIgnoreCase("remove")) {
                    return null;
                } else if (args[0].equalsIgnoreCase("accept")) {
                    // Get everyone who has a request
                    return null;
                } else if (args[0].equalsIgnoreCase("decline")) {
                    // Get everyone who has a request
                    return null;
                } else if (args[0].equalsIgnoreCase("hire")) {
                    return null;
                }
                return completions;
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("hire")) {
                    completions.add("10000");
                    completions.add("20000");
                    completions.add("50000");
                    completions.add("100000");
                    return completions;
                }
            } else {
                return null;
            }
        }
        return null;
    }
}