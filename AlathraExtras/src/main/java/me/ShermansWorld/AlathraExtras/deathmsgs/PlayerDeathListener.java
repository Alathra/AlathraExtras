package me.ShermansWorld.AlathraExtras.deathmsgs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;

import me.ShermansWorld.AlathraExtras.Helper;

public class PlayerDeathListener implements Listener {

	@EventHandler
	public static void deathListener(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player killed = e.getEntity();
			Player killer = killed.getKiller();
			if (killed.hasMetadata("NPC")) {
				e.setDeathMessage(null);
			} else if (killer.hasMetadata("NPC")) {
				Bukkit.broadcastMessage(killed.getName() + " has been slain by " + killer.getName());
			}  else if (killer.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
				e.setDeathMessage(killed.getName() + " has been assassinated by an invisible player");
				Bukkit.getLogger().info(Helper.Chatlabel() + killed.getName() + " was killed by " + killer.getName());
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("AlathraExtras.deathmsg")) {
						p.sendMessage(Helper.Chatlabel() + killed.getName() + " was killed by " + killer.getName());
					}
				}
			}
		}
	}
}
