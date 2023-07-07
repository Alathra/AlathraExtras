package me.ShermansWorld.AlathraExtras.enderchersblock;

import com.github.milkdrinkers.colorparser.ColorParser;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderChestBlockListener implements Listener {
    @EventHandler
    private static void onOpen(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            return;

        if (!e.getClickedBlock().getType().equals(Material.ENDER_CHEST))
            return;

        if (e.getPlayer().hasPermission("AlathraExtras.enderchest.bypass"))
            return;

        e.getPlayer().sendMessage(
            new ColorParser("<red>Ender chests are disabled on our server.").build()
        );

        e.setCancelled(true);
    }
}
