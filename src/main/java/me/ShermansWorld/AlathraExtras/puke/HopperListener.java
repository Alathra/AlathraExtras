package me.ShermansWorld.AlathraExtras.puke;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class HopperListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHopper(InventoryPickupItemEvent event) {
        if(event.getItem().getScoreboardTags().contains("puke") || event.getItem().getScoreboardTags().contains("puke2")) {
            event.setCancelled(true);
        }
    }

}
