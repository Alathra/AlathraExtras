package me.ShermansWorld.AlathraExtras.tpacooldown.listener.essentialsx;

import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownTPACache;
import net.ess3.api.IUser;
import net.essentialsx.api.v2.events.TeleportRequestResponseEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.Calendar;

/**
 * Add cooldown to the teleporting user
 */
public class TeleportRequestResponseListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleportRequestResponse(TeleportRequestResponseEvent e) {
        if (e.isCancelled() || e.isDeny()) return;

        final IUser requester = e.getRequester(); // The user that sends prompt
        final IUser receiver = e.getRequestee(); // The user that receives prompt

        final long currentTimeStamp = Calendar.getInstance().getTimeInMillis();

        // Add to 'isTeleporting' cache
        CooldownTPACache.teleportingAdd(requester.getUUID(), currentTimeStamp);
        CooldownTPACache.teleportingAdd(receiver.getUUID(), currentTimeStamp);

        // Remove from 'isTeleporting' cache if still there
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            CooldownTPACache.teleportingRemove(requester.getUUID(), currentTimeStamp);
            CooldownTPACache.teleportingRemove(receiver.getUUID(), currentTimeStamp);
        }, 5 * 20 + 20);
    }
}
