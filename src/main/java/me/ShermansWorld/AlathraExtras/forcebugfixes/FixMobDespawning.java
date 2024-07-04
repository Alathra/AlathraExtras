package me.ShermansWorld.AlathraExtras.forcebugfixes;

import io.papermc.paper.entity.Bucketable;
import io.papermc.paper.event.player.PlayerNameEntityEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class FixMobDespawning implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void featherClick(PlayerInteractEntityEvent clickEvent) {
        if (clickEvent.getHand() != EquipmentSlot.HAND) return;

        if (clickEvent.getPlayer().getInventory().getItemInMainHand().getType() != Material.FEATHER) return;

        clickEvent.setCancelled(true);

        if (!clickEvent.getRightClicked().isCustomNameVisible())
            clickEvent.getRightClicked().setCustomNameVisible(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void persistAfterNaming(PlayerNameEntityEvent nameEvent) {
        nameEvent.setPersistent(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void fishRelease(CreatureSpawnEvent fishSpawn) {
        if (fishSpawn.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) return;

        if (!(fishSpawn.getEntity() instanceof Bucketable bucketable)) return;

        bucketable.setFromBucket(true);
    }
}
