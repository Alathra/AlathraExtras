package me.ShermansWorld.AlathraExtras.items;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;

import org.bukkit.event.hanging.HangingPlaceEvent;

public class ItemFrameListener implements Listener {
    @EventHandler
    public void itemFrameBreakEvent(HangingBreakEvent e) {
        if (e.getEntity().getType().equals(EntityType.ITEM_FRAME)) {
            if (!e.getCause().equals(RemoveCause.EXPLOSION)) {
                ItemFrame itemFrame = (ItemFrame) e.getEntity();
                if (!itemFrame.isVisible()) {
                    e.getEntity().remove();
                    e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), itemFrame.getItem());
                    e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), Items.getInvisibleItemFrame());
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void itemFramePlaceEvent(HangingPlaceEvent e) {
        if (e.getEntity().getType().equals(EntityType.ITEM_FRAME)) {
            ItemFrame itemFrame = (ItemFrame) e.getEntity();
            if (e.getItemStack().isSimilar(Items.getInvisibleItemFrame())) {
                itemFrame.setVisible(false);
            }
        }
    }
}
