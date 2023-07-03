package me.ShermansWorld.AlathraExtras.balancing;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.ShermansWorld.AlathraExtras.Helper;



public class RiptideListener implements Listener {

	@EventHandler
	public static void onRipTide(PlayerMoveEvent e) {
		if (!e.getPlayer().isRiptiding())
			return;

		if (e.getPlayer().getEyeLocation().getBlock().getType() == Material.WATER)
			return;

		e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cRiptide is disabled when not underwater."));
		e.setCancelled(true);
	}
}