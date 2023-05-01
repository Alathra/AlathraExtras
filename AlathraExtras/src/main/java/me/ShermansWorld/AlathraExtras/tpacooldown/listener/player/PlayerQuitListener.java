package me.ShermansWorld.AlathraExtras.tpacooldown.listener.player;

import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownCache;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownDB;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerQuitListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerQuit(PlayerQuitEvent e) {
        final UUID uuid = e.getPlayer().getUniqueId();
        if (CooldownCache.isCooldownActive(uuid)) {
            CooldownDB.savePlayerData(uuid, CooldownCache.get(uuid));
            CooldownCache.remove(uuid);
        }
    }
}
