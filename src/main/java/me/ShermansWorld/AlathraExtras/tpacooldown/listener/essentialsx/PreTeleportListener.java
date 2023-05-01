package me.ShermansWorld.AlathraExtras.tpacooldown.listener.essentialsx;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownCache;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownTPACache;
import net.ess3.api.IUser;
import net.ess3.api.events.teleport.PreTeleportEvent;
import org.bukkit.Bukkit;
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

        // Check TPA Cost
        final double bal = Main.economy.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId()));
        if (bal < 50) {
            p.sendMessage(Helper.Chatlabel() + Helper.color("&cTeleportation canceled. You need at least &a$50 &cto teleport!"));
            e.setCancelled(true);
            return;
        }

        // Check if player has cooldown
        if (CooldownCache.isCooldownActive(uuid)) {
            e.setCancelled(true);
            p.sendMessage(CooldownCache.getCooldownMessage(CooldownCache.get(uuid)));
            return;
        }

        // TPA Cost
        Main.economy.withdrawPlayer(p, 50);

        // Add different user depending on what type of teleport this is
        CooldownCache.add(uuid);
    }
}
