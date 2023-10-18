package me.ShermansWorld.AlathraExtras.funny;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class AetherPortalListener implements Listener {
	
	@EventHandler()
	public void onAetherPortalCreate(PlayerBucketEmptyEvent e) {
		if (e.getBucket().equals(Material.WATER_BUCKET)) {
			if(isInsideAetherPortal(e.getBlock())) {
				e.getPlayer().sendMessage("AETHER PORTAL DETECTED");
			}
		}
	}

	private boolean isInsideAetherPortal(Block block) {
        if (block.getType().equals(Material.AIR)) {
        	
        }
        return false;
    }

}
