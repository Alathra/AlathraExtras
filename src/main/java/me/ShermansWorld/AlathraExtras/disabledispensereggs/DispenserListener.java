package me.ShermansWorld.AlathraExtras.disabledispensereggs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Dispenser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class DispenserListener implements Listener {

    @EventHandler
    public void onDispense(BlockDispenseEvent e) {
        if (e.getBlock().getType() == Material.DISPENSER) {
            if (e.getItem().getType() == Material.EGG) {
                e.setCancelled(true);
                Dispenser dispenser = (Dispenser) e.getBlock().getState();
                dispenser.getInventory().setItem(dispenser.getInventory().first(Material.EGG), dispenser.getInventory().getItem(dispenser.getInventory().first(Material.EGG)).subtract(1));
                org.bukkit.block.data.type.Dispenser dispenserData = (org.bukkit.block.data.type.Dispenser) e.getBlock().getBlockData();
                Location location = e.getBlock().getRelative(dispenserData.getFacing()).getLocation();
                location.getWorld().dropItem(location, new ItemStack(Material.EGG, 1));
            }
        }
    }
}
