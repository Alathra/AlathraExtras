package me.ShermansWorld.AlathraExtras;


import me.ShermansWorld.AlathraExtras.items.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class AlathraExtrasCommands implements CommandExecutor {
    public static boolean itemDamageOn;

    public AlathraExtrasCommands(AlathraExtras plugin) {
        PluginCommand alathraextrasCommand = plugin.getCommand("alathraextras");

        if (alathraextrasCommand == null) return;

        alathraextrasCommand.setExecutor(this);
        itemDamageOn = true;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player;
        if (sender instanceof Player) {
            player = (Player) sender;
            if (!player.hasPermission("AlathraExtras.admin")) {
                sender.sendMessage(Helper.Chatlabel() + Helper.color("&cYou do not have permission to use this command"));
                return false;
            }
        } else {
            return false;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("toggleitemdamage")) {
                if (itemDamageOn) {
                    sender.sendMessage(Helper.Chatlabel() + Helper.color("&eItem damage disabled"));
                    itemDamageOn = false;
                } else {
                    sender.sendMessage(Helper.Chatlabel() + Helper.color("&eItem damage enabled"));
                    itemDamageOn = true;
                }
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("give")) {
                switch(args[1].toLowerCase()){
                    case "tiny_xp_pouch" -> {
                        player.getInventory().addItem(Items.getTinyXPPouch());
                        return true;
                    }
                    case "alathran_iron" -> {
                        player.getInventory().addItem(Items.getAlathranIron());
                        return true;
                    }
                    case "uncharged_silver_melon" -> {
                        player.getInventory().addItem(Items.getUnchargedSilverMelon());
                        return true;
                    }
                    case "charged_silver_melon" -> {
                        player.getInventory().addItem(Items.getChargedSilverMelon());
                        return true;
                    }
                    case "tungsten" -> {
                        player.getInventory().addItem(Items.getTungsten());
                        return true;
                    }
                    case "silver" -> {
                        player.getInventory().addItem(Items.getSilver());
                        return true;
                    }
                    case "platinum" -> {
                        player.getInventory().addItem(Items.getPlatinum());
                        return true;
                    }
                    default -> {return false;}
                }

            }
        }
        return false;
    }

}

