package me.ShermansWorld.AlathraExtras;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class AnvilListener implements Listener {
	@EventHandler
	public static void commandSent(PrepareAnvilEvent e) { 
		if (e.getInventory().getItem(0).isSimilar(CustomItems.tutorialBook()) || e.getInventory().getItem(1).isSimilar(CustomItems.tutorialBook())) {
			Player p = (Player) e.getView().getPlayer();
			p.closeInventory();
			p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot put the Player's Guide in an anvil!"));
			
		}
	}
}
