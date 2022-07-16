package me.ShermansWorld.AlathraExtras;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

public class EssentialsListener implements Listener {
	
	public static Essentials ess = null;
	
	public static void initEssentials() {
		if (ess == null) {
			@SuppressWarnings("unused")
			Essentials ess = JavaPlugin.getPlugin(Essentials.class); 
		}
	}
	
	@EventHandler
	public static void tpaSent(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().toLowerCase().contains("tpa")) {
			double bal = Main.economy.getBalance(Bukkit.getOfflinePlayer(e.getPlayer().getUniqueId()));
			if (bal < 500) {
				e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&ctpa/tpahere request canceled. You must have at least &a$500 &cto run this command!"));
				e.setCancelled(true);
			}
		}
	}
}