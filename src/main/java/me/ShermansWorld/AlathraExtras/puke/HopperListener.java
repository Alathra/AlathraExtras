package me.ShermansWorld.AlathraExtras.puke;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class HopperListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHopper(InventoryPickupItemEvent event) {
//        Bukkit.getLogger().info(event.getItem().getScoreboardTags().toString());
        if(event.getItem().getScoreboardTags().contains("puke") || event.getItem().getScoreboardTags().contains("puke2")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHopper(EntityPickupItemEvent event) {
//        Bukkit.getLogger().info(event.getItem().getScoreboardTags().toString());
        if(event.getItem().getScoreboardTags().contains("puke") || event.getItem().getScoreboardTags().contains("puke2")) {
            event.setCancelled(true);
        }
    }

}
