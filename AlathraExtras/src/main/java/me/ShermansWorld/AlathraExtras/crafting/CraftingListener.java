package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import me.ShermansWorld.AlathraExtras.Helper;

public class CraftingListener implements Listener {
	public static void onCraft(CraftItemEvent e) {
		if (e.getCurrentItem().getType() == Material.PAPER) {
			if (e.getInventory().contains(Material.CARROT) || e.getInventory().contains(Material.BEETROOT)) {
				e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft this with this item!"));
				e.setCancelled(true);
			}
		}
	}
}
