package me.ShermansWorld.AlathraExtras.tpacooldown.listener.player;

import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownCache;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownDB;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

/**
 * Load data about player into cache if exists
 */
public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent e) {
        final UUID uuid = e.getPlayer().getUniqueId();
        final long cooldownExpirationTime = CooldownDB.getPlayerData(uuid);

        // Early return if DB returned default value (player doesn't exist in DB)
        if (cooldownExpirationTime == 0.0 || cooldownExpirationTime == 0L) return;

        // Check if cooldown is expired or not
        if (CooldownCache.isCooldownApplicable(cooldownExpirationTime)) {
            CooldownCache.add(uuid, cooldownExpirationTime);
        } else {
            CooldownDB.clearPlayerData(uuid); // Clear the old cooldown from db since it's no longer valid
        }
    }
}
