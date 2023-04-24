package me.ShermansWorld.AlathraExtras.tutorialbook;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

import me.ShermansWorld.AlathraExtras.CustomItems;
import me.ShermansWorld.AlathraExtras.Helper;

public class AnvilListener implements Listener {
	@EventHandler
	public static void commandSent(PrepareAnvilEvent e) { 
		if (e.getInventory().getItem(0) != null) {
			if (e.getInventory().getItem(0).isSimilar(CustomItems.tutorialBook())) {
				Player p = (Player) e.getView().getPlayer();
				p.closeInventory();
				p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot put the Player's Guide in an anvil!"));
				
			}
		}
	}
}
