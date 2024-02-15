package me.ShermansWorld.AlathraExtras.disabletrapdoorflipping;

import com.destroystokyo.paper.MaterialTags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TrapdoorListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        // Checks if the action is right click, and the right click is at a block.
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK
            && e.getClickedBlock() != null
            && (MaterialTags.TRAPDOORS.isTagged(e.getClickedBlock().getType())
            && e.getClickedBlock().getWorld().getName().equals("world")
        )) // If so, cancel the interaction.
        {
            e.setCancelled(true);
        }
    }
}
