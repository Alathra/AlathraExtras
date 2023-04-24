package me.ShermansWorld.AlathraExtras;

import java.util.Arrays;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftingEvent implements Listener {
	@EventHandler
	public static void craftEvent(CraftItemEvent e) {
		if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.tutorialBook())) {
			e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with the Player's Guide!"));
			e.setCancelled(true);
		} else if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getBeetrootPouch())) {
			e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with this item!"));
			e.setCancelled(true);
		} else if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getCarrotPouch())) {
			e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with this item!"));
			e.setCancelled(true);
		}
	}
}
