package me.ShermansWorld.AlathraExtras.balancing.disablespawners;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DisableSpawners implements Listener {

    private final static ArrayList<String> enabledInWorlds = new ArrayList<>(Arrays.asList("World-o", "World-o_nether"));
    public static ArrayList<EntityType> badSpawners = new ArrayList<>(Arrays.asList(EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CAVE_SPIDER, EntityType.SILVERFISH, EntityType.BLAZE));
    public static ArrayList<Material> rewardBlocks = new ArrayList<>(Arrays.asList(Material.RAW_IRON_BLOCK, Material.RAW_GOLD_BLOCK, Material.EMERALD_BLOCK, Material.DIAMOND_BLOCK));
    public static ArrayList<World> activeWorlds = new ArrayList<>();

    public DisableSpawners() {
        parseWorldConfig();
    }

    @EventHandler
    public static void spawnerReplace(SpawnerSpawnEvent e) {
        if (!activeWorlds.contains(e.getLocation().getWorld())) return;

        CreatureSpawner spawner = e.getSpawner();

        if (!badSpawners.contains(spawner.getSpawnedType())) return;

        final int reward = new Random().nextInt(rewardBlocks.size());

        spawner.getBlock().setType(rewardBlocks.get(reward));

        e.setCancelled(true);
    }

    private void parseWorldConfig() {
        enabledInWorlds.forEach((worldName) -> {
            if (AlathraExtras.getInstance().getServer().getWorld(worldName) != null) {
                activeWorlds.add(AlathraExtras.getInstance().getServer().getWorld(worldName));
            }
        });
    }
}
