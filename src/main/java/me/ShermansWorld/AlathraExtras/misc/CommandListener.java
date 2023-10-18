package me.ShermansWorld.AlathraExtras.misc;

import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void commandSent(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equalsIgnoreCase("/help")) {
			Player p = e.getPlayer();
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ibooks open tutorial_book " + e.getPlayer().getName());
			p.playSound(p.getLocation(), Sound.ITEM_BOOK_PUT, 10F, 1F);
			e.setCancelled(true);
			return;
		} else if (e.getMessage().equalsIgnoreCase("/rtp")) {
			Player p = e.getPlayer();
			if (p.getWorld().getName().contentEquals("world")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 9));
			}
			return;
		} else if (e.getMessage().equalsIgnoreCase("/wild")) {
			Player p = e.getPlayer();
			if (p.getWorld().getName().contentEquals("world")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 9));
			}
			return;
		} else if (e.getMessage().length() == 1) {
			return;
		} else if (e.getMessage().charAt(1) == ' ') {
			Player p = e.getPlayer();
			p.sendMessage(Helper.Chatlabel() + Helper.color("&cThis command is not allowed"));
			e.setCancelled(true);
			return;
		}
		
	}
}