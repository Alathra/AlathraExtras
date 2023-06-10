package me.ShermansWorld.AlathraExtras;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ShermansWorld.AlathraExtras.items.Items;


public class AlathraExtrasCommands implements CommandExecutor {

	public AlathraExtrasCommands(Main plugin) {
		plugin.getCommand("alathraextras").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player;
		if (sender instanceof Player) {
			player = (Player) sender;
			if (!player.hasPermission("AlathraExtras.admin")) {
				player.sendMessage(Helper.Chatlabel() + Helper.color("&cYou do not have permission to use this command"));
				return false; 
			}
		} else {
			return false;
		}
		
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("give")) {
				if (args[1].equalsIgnoreCase("tiny_xp_pouch")) {
					player.getInventory().addItem(Items.getTinyXPPouch());
					return true;
				}
			}
		}
		return false;
	}

}

