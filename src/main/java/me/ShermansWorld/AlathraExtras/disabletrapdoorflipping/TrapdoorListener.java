package me.ShermansWorld.AlathraExtras.disabletrapdoorflipping;

import com.destroystokyo.paper.MaterialTags;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Listens for trapdoor interaction events
 */
public class TrapdoorListener implements Listener {

    /**
     * Checks for player interactions with a trapdoor.
     * @param e the player interaction event
     */
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        // Checks if the action is right click, and the right click is at a block.
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK
            && e.getClickedBlock() != null
            && e.getClickedBlock().getType().toString().toLowerCase().contains("trapdoor")
            && e.getClickedBlock().getWorld().getName().equals("world")
            && e.getPlayer().getGameMode() != GameMode.CREATIVE
        ) // If so, cancel the interaction.
        {
            AlathraExtras.logger.log("Test log.");
            e.setCancelled(true);
        }
    }
}
