package me.ShermansWorld.AlathraExtras.balancing;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

import me.ShermansWorld.AlathraExtras.AlathraExtrasCommands;


public class ItemDamageListener implements Listener {

	@EventHandler
	public static void onItemDamage(PlayerItemDamageEvent e) {
		if (AlathraExtrasCommands.itemDamageOn) {
			return;
		} else {
			e.setCancelled(true);
		}
	}
}