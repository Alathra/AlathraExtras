package me.ShermansWorld.AlathraExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerListeners implements Listener {
	
	@EventHandler
    public void cancelRiptide(PlayerMoveEvent event) {
        if(event.getPlayer().isRiptiding() && event.getPlayer().getWorld().getName().equals("event_world")) {
            event.getPlayer().setVelocity(new Vector(0,0,0));
        }
    }
	
}
