package me.ShermansWorld.AlathraExtras.tpacooldown.listener.essentialsx;

import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownCache;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownTPACache;
import net.ess3.api.IUser;
import net.ess3.api.events.teleport.PreTeleportEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

public class PreTeleportListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPreTeleport(PreTeleportEvent e) {
        if (e.getTeleportCause() != PlayerTeleportEvent.TeleportCause.COMMAND) return;

        final IUser user = e.getTeleportee();
        final Player p = user.getBase();
        final UUID uuid = p.getUniqueId();

        // Ensure this code is only run on players teleporting using TPA
        if (CooldownTPACache.teleportingGet(uuid) == 0L) return;

        CooldownTPACache.teleportingRemove(uuid);

        // Check if player has cooldown
        if (CooldownCache.isCooldownActive(uuid)) {
            e.setCancelled(true);
            p.sendMessage(CooldownCache.getCooldownMessage(CooldownCache.get(uuid)));
            return;
        }

        // Add different user depending on what type of teleport this is
        CooldownCache.add(uuid);
    }
}
