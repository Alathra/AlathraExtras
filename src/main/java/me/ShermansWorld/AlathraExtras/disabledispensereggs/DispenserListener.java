package me.ShermansWorld.AlathraExtras.disabledispensereggs;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class DispenserListener implements Listener {

    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent b){
        if(b.getItem().getType() == Material.EGG){
            b.setCancelled(true);
        }
    }
}
