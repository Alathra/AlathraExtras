package me.ShermansWorld.AlathraExtras.disablespawners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class DisableSpawners implements Listener{
	
	public static ArrayList<String> badSpawners = new ArrayList<String>(Arrays.asList("ZOMBIE", "SKELETON", "SPIDER", "CAVE_SPIDER", "SILVERFISH", "BLAZE"));
	public static ArrayList<String> rewardBlocks = new ArrayList<String>(Arrays.asList("RAW_IRON_BLOCK", "RAW_GOLD_BLOCK", "EMERALD_BLOCK", "DIAMOND_BLOCK"));
	public static ArrayList<String> appliedWorlds = new ArrayList<String>(Arrays.asList("World-o", "World-o_nether"));
	
	@EventHandler
	public static void spawnerReplace(SpawnerSpawnEvent e) {
		try {
			CreatureSpawner spawner = e.getSpawner();
			
			if (badSpawners.contains(spawner.getSpawnedType().toString()) && appliedWorlds.contains(e.getLocation().getWorld().getName())) {
				Random rand = new Random();
				int reward = rand.nextInt(rewardBlocks.size());
				
				spawner.getBlock().setType(Material.valueOf(rewardBlocks.get(reward)));
				
				e.setCancelled(true);
			}
		} catch (NullPointerException error) {
			return;
		}
	}
}
