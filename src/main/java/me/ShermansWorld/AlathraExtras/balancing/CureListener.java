package me.ShermansWorld.AlathraExtras.balancing;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class CureListener implements Listener {
    @EventHandler
    public void onCure(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.ZOMBIE_VILLAGER) {
            Player p = e.getPlayer();
            if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_APPLE) {
                p.sendMessage(ColorParser.of(Helper.Chatlabel() + "&cYou cannot cure zombie villagers!")
                    .parseLegacy().build());
                e.setCancelled(true);
            }
        } else if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            if (e.getRightClicked().getWorld().getName().contentEquals("World-o")) {
                e.setCancelled(true);
            }
        }
    }
}
