package me.ShermansWorld.AlathraExtras.balancing;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class RiptideListener implements Listener {

    @EventHandler
    public void onRipTide(PlayerMoveEvent e) {
        if (!e.getPlayer().isRiptiding())
            return;

        if (e.getPlayer().getEyeLocation().getBlock().getType() == Material.WATER)
            return;

        e.getPlayer().sendMessage(ColorParser.of(Helper.Chatlabel() + "&cRiptide is disabled when not underwater.")
            .parseLegacy().build());
        e.setCancelled(true);
    }
}