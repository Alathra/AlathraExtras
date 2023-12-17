package me.ShermansWorld.AlathraExtras.disabledispensereggs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.BlockProjectileSource;

public class DispenserListener implements Listener {

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof BlockProjectileSource) {
            if (e.getEntity().getType().equals(EntityType.EGG)) {
                e.setCancelled(true);
                Location location = e.getEntity().getLocation();
                location.getWorld().dropItem(location, new ItemStack(Material.EGG, 1)).setVelocity(e.getEntity().getVelocity());
            }
        }
    }
}
