package me.ShermansWorld.AlathraExtras.tutorialbook;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;

public class GiveTutorialBookCommand implements CommandExecutor {
	
	public GiveTutorialBookCommand(final Main plugin) {
		plugin.getCommand("tutorialbook").setExecutor((CommandExecutor) this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player p = (Player) sender;
		
		if (!p.hasPermission("AlathraExtras.tutorialbook")) {
			p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou do not have permission to do this!"));
			return false;
		}
		
		p.getInventory().addItem(CustomItems.tutorialBook());
		return true;
	}
}
