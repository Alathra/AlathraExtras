package me.ShermansWorld.AlathraExtras.balancing;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.ShermansWorld.AlathraExtras.Helper;



public class RiptideListener implements Listener {
	
	@EventHandler
	public static void onRipTide(PlayerMoveEvent e) {
		if (e.getPlayer().isRiptiding()) {
			if (e.getPlayer().getWorld().hasStorm()) {
				e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cRiptide is disabled while it is raining."));
				e.setCancelled(true);
			}
		}
	}
}