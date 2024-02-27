package me.ShermansWorld.AlathraExtras;


import me.ShermansWorld.AlathraExtras.items.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AlathraExtrasCommands implements CommandExecutor {

    public static boolean itemDamageOn;

    public AlathraExtrasCommands(AlathraExtras plugin) {
        plugin.getCommand("alathraextras").setExecutor(this);
        itemDamageOn = true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
                if (args[1].equalsIgnoreCase("tiny_xp_pouch")) {
                    player.getInventory().addItem(Items.getTinyXPPouch());
                    return true;
                }
                if (args[1].equalsIgnoreCase("alathran_iron")) {
                    player.getInventory().addItem(Items.getAlathranIron());
                    return true;
                }
                if (args[1].equalsIgnoreCase("uncharged_silver_melon")) {
                    player.getInventory().addItem(Items.getUnchargedSilverMelon());
                    return true;
                }
                if (args[1].equalsIgnoreCase("charged_silver_melon")) {
                    player.getInventory().addItem(Items.getChargedSilverMelon());
                    return true;
                }
            }
        }
        return false;
    }

}

