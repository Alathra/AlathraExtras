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
	public static void tinyXPPouchUse(PlayerInteractEvent e) {
		if (e.getHand() == EquipmentSlot.HAND) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PAPER) {
					ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
					if (item.hasItemMeta()) {
						if (item.getItemMeta().hasCustomModelData()) {

							// legacy code for xp pouch
							if (item.getItemMeta().getCustomModelData() == 14702) {
								// spawn in 30 xp points at player's location
								e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), ExperienceOrb.class)
										.setExperience(30);
								// remove xp orb
								if (item.getAmount() > 1) {
									item.setAmount(item.getAmount() - 1);
									e.getPlayer().getInventory().setItemInMainHand(item);
								} else {
									e.getPlayer().getInventory().remove(item);
								}
								e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(),
										Sound.ITEM_BUNDLE_REMOVE_ONE, 5F, 1F);
							}

							int xpAmount = 0;
							switch (item.getItemMeta().getCustomModelData()) {
							// xp 1
							case 14703:
								xpAmount = 16;
								break;
							// xp 2
							case 14704:
								xpAmount = 27;
								break;
							// xp 3
							case 14705:
								xpAmount = 40;
								break;
							// xp 4
							case 14706:
								xpAmount = 55;
								break;
							// xp 5
							case 14707:
								xpAmount = 72;
								break;
							// xp 6
							case 14708:
								xpAmount = 91;
								break;
							// xp 7
							case 14709:
								xpAmount = 112;
								break;
							// xp 8
							case 147010:
								xpAmount = 160;
								break;
							// xp 9
							case 147011:
								xpAmount = 216;
								break;
							// xp 10
							case 14712:
								xpAmount = 352;
								break;
							default:
								return;
							}

							// spawn in 30 xp points at player's location
							e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), ExperienceOrb.class)
									.setExperience(xpAmount);
							// remove xp orb
							if (item.getAmount() > 1) {
								item.setAmount(item.getAmount() - 1);
								e.getPlayer().getInventory().setItemInMainHand(item);
							} else {
								e.getPlayer().getInventory().remove(item);
							}
							e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(),
									Sound.ITEM_BUNDLE_REMOVE_ONE, 5F, 1F);

						}
					}
				}
			}
		}
	}
}
