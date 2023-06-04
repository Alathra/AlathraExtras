package me.ShermansWorld.AlathraExtras.essentials;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.ess3.api.events.AfkStatusChangeEvent;

@SuppressWarnings("deprecation")
public class AFKListener implements Listener {
	
	@EventHandler
	public static void onAfk(AfkStatusChangeEvent e) {
		e.getAffected().getBase().performCommand("lobby");
		e.setCancelled(true);
	}
}
