package me.ShermansWorld.AlathraExtras.balancing;

import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashSet;
import java.util.Set;


public class SiegeWorldBuildListener implements Listener {

    private static final Set<Material> allowedBlocks = new HashSet<>();

    static {
        allowedBlocks.add(Material.CARVED_PUMPKIN);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getPlayer().getWorld().equals(Bukkit.getWorld("siege_world"))) {
            if (e.getPlayer().hasPermission("alathraextas.siegeoverride")) {
                return;
            }
            if (!allowedBlocks.contains(e.getBlockPlaced().getType())) {
                e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cYou can only build cannons during the siege event!"));
                e.setCancelled(true);
                return;
            }
        }
        return;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getPlayer().getWorld().equals(Bukkit.getWorld("siege_world"))) {
            if (e.getPlayer().hasPermission("alathraextas.siegeoverride")) {
                return;
            }
            if (!allowedBlocks.contains(e.getBlock().getType())) {
                e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cYou can only build cannons during the siege event!"));
                e.setCancelled(true);
            }
        }
        return;
    }
}