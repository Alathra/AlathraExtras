package me.ShermansWorld.AlathraExtras.smithing;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import me.ShermansWorld.AlathraExtras.Main;

public class SmithingTableListener implements Listener {

	@EventHandler
	public void onInvClick(final InventoryClickEvent e) {
		if (e.getInventory().getType() == InventoryType.SMITHING) {
			// if empty inventory
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					if (e.getInventory().getItem(0) != null) {
						if (e.getInventory().getItem(0).getType() == Material.COBBLESTONE
								|| e.getInventory().getItem(0).getType() == Material.COBBLED_DEEPSLATE) {
							int amount = e.getInventory().getItem(0).getAmount();
							ItemStack gravel = new ItemStack(Material.GRAVEL, amount);
							e.getInventory().clear();
							Player p = (Player) e.getView().getPlayer();
							p.closeInventory();
							p.getInventory().addItem(gravel);
							p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
						}
						if (e.getInventory().getItem(0).getType() == Material.GRAVEL) {
							int amount = e.getInventory().getItem(0).getAmount();
							ItemStack sand = new ItemStack(Material.SAND, amount);
							e.getInventory().clear();
							Player p = (Player) e.getView().getPlayer();
							p.closeInventory();
							p.getInventory().addItem(sand);
							p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
						}
					}
				}
			}, 5L); // 20 Tick (1 Second) delay before run() is called
		}
	}

}
