package me.ShermansWorld.AlathraExtras.balancing;

import me.ShermansWorld.AlathraExtras.AlathraExtrasCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;


public class ItemDamageListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDamage(PlayerItemDamageEvent e) {
        if (!AlathraExtrasCommands.itemDamageOn) {
            e.setCancelled(true);
        }
    }
}