package me.ShermansWorld.AlathraExtras.misc;

import java.util.Arrays;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import me.ShermansWorld.AlathraExtras.Helper;

public class CraftingListener implements Listener {
	@EventHandler
	public static void craftEvent(CraftItemEvent e) {
		if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.tutorialBook())) {
			e.getWhoClicked()
					.sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with the Player's Guide!"));
			e.setCancelled(true);
		} else if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getBeetrootPouch())
				|| Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getCarrotPouch())) {
			if (e.getCurrentItem().equals(CustomItems.getBeetrootPouch()) || e.getCurrentItem().equals(CustomItems.getCarrotPouch())) {
				return;
			} else {
				e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with this item!"));
				e.setCancelled(true);
			}
		}
	}
}
