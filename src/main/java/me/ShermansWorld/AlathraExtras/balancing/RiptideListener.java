package me.ShermansWorld.AlathraExtras.balancing;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.ShermansWorld.AlathraExtras.Helper;



public class RiptideListener implements Listener {
	
	@EventHandler
	public static void onCure(PlayerMoveEvent e) {
		if (e.getPlayer().isRiptiding()) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cRiptide is disabled."));
		}
	}
}