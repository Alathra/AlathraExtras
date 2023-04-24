package me.ShermansWorld.AlathraExtras.tutorialbook;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ShermansWorld.AlathraExtras.CustomItems;

public class PlayerClickHelpBook implements Listener {
	
	
	@EventHandler
	public static void onPlayerUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getItem() == null) {
			return;
		}
		if (e.getItem().isSimilar(CustomItems.tutorialBook())) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ibooks open tutorial_book " + e.getPlayer().getName());
			p.playSound(p.getLocation(), Sound.ITEM_BOOK_PUT, 10F, 1F);
		}
	}
}
