package me.ShermansWorld.AlathraExtras.towny;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.palmergames.bukkit.towny.event.town.TownRuinedEvent;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;

import me.ShermansWorld.AlathraExtras.Main;

public class TownyListener implements Listener {

	private static long delay = 20;
	private static final Set<Material> signs = new HashSet<>();
	static {
		signs.add(Material.ACACIA_SIGN);
		signs.add(Material.BIRCH_SIGN);
		signs.add(Material.DARK_OAK_SIGN);
		signs.add(Material.JUNGLE_SIGN);
		signs.add(Material.SPRUCE_SIGN);
		signs.add(Material.OAK_SIGN);
		signs.add(Material.CRIMSON_SIGN);
		signs.add(Material.WARPED_SIGN);
		signs.add(Material.ACACIA_WALL_SIGN);
		signs.add(Material.BIRCH_WALL_SIGN);
		signs.add(Material.DARK_OAK_WALL_SIGN);
		signs.add(Material.JUNGLE_WALL_SIGN);
		signs.add(Material.SPRUCE_WALL_SIGN);
		signs.add(Material.OAK_WALL_SIGN);
		signs.add(Material.CRIMSON_WALL_SIGN);
		signs.add(Material.WARPED_WALL_SIGN);
	}
	
	
	public static void deleteSignsInChunk(TownBlock townBlock, World w, long delay) {
		int x = townBlock.getX() * 16;
		int z = townBlock.getZ() * 16;
		for (int xx = x; xx < x + 16; xx++) {
			for (int zz = z; zz < z + 16; zz++) {
				for (int yy = -63; yy < 319; yy++) {
					Block b = w.getBlockAt(xx, yy, zz);
					if (!b.getType().isAir()) {
						if (signs.contains(b.getType())) { // if block is a sign
							b.setType(Material.AIR); // set to air, or delete sign
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public static void checkForSigns(TownRuinedEvent e) {
		Town town = e.getTown();
		World w = town.getWorld();
		for (TownBlock townBlock : town.getTownBlocks()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			    @Override
			    public void run() {
			    	deleteSignsInChunk(townBlock, w, delay);
			    }
			}, delay); //20 Tick (1 Second) delay before run() is called
			delay += 100; // 5 seconds
		}
	}
}