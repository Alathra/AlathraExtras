package me.ShermansWorld.AlathraExtras;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public static void commandSent(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().toLowerCase().contains("tpa")) {
			double bal = Main.economy.getBalance(Bukkit.getOfflinePlayer(e.getPlayer().getUniqueId()));
			if (bal < 500) {
				e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&ctpa/tpahere request canceled. You must have at least &a$500 &cto run this command!"));
				e.setCancelled(true);
			}
		} else if (e.getMessage().equalsIgnoreCase("/help")) {
			Player p = e.getPlayer();
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ibooks open tutorial_book " + e.getPlayer().getName());
			p.playSound(p.getLocation(), Sound.ITEM_BOOK_PUT, 10F, 1F);
			e.setCancelled(true);
		}
	}
}