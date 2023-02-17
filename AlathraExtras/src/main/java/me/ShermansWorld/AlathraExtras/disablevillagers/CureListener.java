package me.ShermansWorld.AlathraExtras.disablevillagers;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.ShermansWorld.AlathraExtras.Helper;


public class CureListener implements Listener {
	
	@EventHandler
	public static void onCure(PlayerInteractEntityEvent e) {
		if (e.getRightClicked().getType() == EntityType.ZOMBIE_VILLAGER) {
			Player p = e.getPlayer();
			if (p.getInventory().getItemInMainHand() != null) {
				if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_APPLE) {
					p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot cure zombie villagers!"));
					e.setCancelled(true);
				}
			}
		}
	}
}
