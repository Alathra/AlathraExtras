package me.ShermansWorld.AlathraExtras.balancing;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.GrindstoneInventory;
import org.bukkit.inventory.ItemStack;

import me.ShermansWorld.AlathraExtras.Helper;
public class GrindstoneListener implements Listener {
	@EventHandler
	public static void onCure(InventoryClickEvent e) {
		if (e.getInventory().getType() == InventoryType.GRINDSTONE && e.getSlotType() == InventoryType.SlotType.RESULT ) {
			GrindstoneInventory grindstoneInv =  (GrindstoneInventory) e.getInventory();
			for (int i = 0; i < grindstoneInv.getContents().length; i++) {
				ItemStack item = grindstoneInv.getContents()[i];
				if (item.hasItemMeta()) {
					if (item.getItemMeta().hasLore()) {
						for (String loreLine : item.getItemMeta().getLore()) {
							if (loreLine.contains(Helper.color("&a&lAlathran Item"))) {
								grindstoneInv.getViewers().get(0).sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot repair Alathran items in the grindstone!"));
								e.setCancelled(true);
							}
						}
					}
				}
			}
		}
	}
}
