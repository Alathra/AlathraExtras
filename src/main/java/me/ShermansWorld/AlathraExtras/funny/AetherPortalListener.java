package me.ShermansWorld.AlathraExtras.funny;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AetherPortalListener implements Listener {
	
	@EventHandler()
	public void onAetherPortalCreate(BlockPlaceEvent e) {
		e.getPlayer().sendMessage("RAN1");
		if (e.getBlockPlaced().getType().equals(Material.WATER_BUCKET)) {
			e.getPlayer().sendMessage("RAN2");
			if(isInsideNetherPortal(e.getBlockPlaced())) {
				e.getPlayer().sendMessage("AETHER PORTAL DETECTED");
			}
		}
	}

	private boolean isInsideNetherPortal(Block block) {
		World world = block.getWorld();
		int x = block.getX();
		int y = block.getY();
		int z = block.getZ();

		// Check for a 4x5 Nether portal frame in any cardinal direction.
		for (int xOffset = -2; xOffset <= 1; xOffset++) {
			for (int yOffset = -2; yOffset <= 2; yOffset++) {
				for (int zOffset = -1; zOffset <= 3; zOffset++) {
					Block portalBlock = world.getBlockAt(x + xOffset, y + yOffset, z + zOffset);

					// You can customize this part to check for any specific blocks used in your
					// portal frame.
					// Here, we check for obsidian, but you may have other materials.
					if (portalBlock.getType() != Material.GLOWSTONE) {
						return false;
					}
				}
			}
		}

		// At this point, we've determined that the water bucket was placed inside a 4x5
		// Nether portal frame.
		return true;
	}

}
