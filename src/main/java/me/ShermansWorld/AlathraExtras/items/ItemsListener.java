package me.ShermansWorld.AlathraExtras.items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ItemsListener implements Listener {
	
	@EventHandler
	public static void tinyXPPouchUse(PlayerInteractEvent  e) {
		if (e.getHand() == EquipmentSlot.HAND)  {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PAPER) {
					ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
					if (item.hasItemMeta()) {
						if (item.getItemMeta().hasCustomModelData()) {
							if (item.getItemMeta().getCustomModelData() == 14702) {
								// spawn in 30 xp points at player's location
								e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), ExperienceOrb.class).setExperience(30);
								// remove xp orb
								if (item.getAmount() > 1) {
									item.setAmount(item.getAmount()-1);
									e.getPlayer().getInventory().setItemInMainHand(item);
								} else {
									e.getPlayer().getInventory().remove(item);
								}
								e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ITEM_BUNDLE_REMOVE_ONE, 5F, 1F);
							}
						}
					}
				}
			}
		}
	}
}
