package me.ShermansWorld.AlathraExtras.farming;

import com.destroystokyo.paper.MaterialTags;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.utilities.CommandSenderUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FarmingListener implements Listener {
    
    /**
     * Listens for player interactions with tilled dirt and gives the player a grub bait (basic_bait_4) at a variable chance.
     * @param playerInteractEvent the player interaction event
     */
    @EventHandler
    public void onFarm(PlayerInteractEvent playerInteractEvent){
        //Final Vars
        final String GRUB_BAIT_ID = "basic_bait_4";
        final String playerUsername = playerInteractEvent.getPlayer().getName();
        final String giveCommand = "cfishing items give %s %s".formatted(playerUsername, GRUB_BAIT_ID);
        final int randomValueCap = 60;
        
        int randomValue = AlathraExtras.rand.nextInt(0,randomValueCap);

        // Check if the CustomFishingPlugin is loaded
        if (AlathraExtras.customFishingPlugin == null) {
            AlathraExtras.logger.log("CustomFishingPlugin is not loaded, cannot give grub bait.");
            return;
        }
        
        // Check if the clicked block is null
        if(playerInteractEvent.getClickedBlock() == null){
            return;
        }

        // Check if the clicked block is of type GRASS_BLOCK, DIRT, or FARMLAND
        if (!Set.of(Material.GRASS_BLOCK, Material.DIRT, Material.FARMLAND).contains(playerInteractEvent.getClickedBlock().getType())) {
            return;
        }
        
        final float fortuneModifier = switch (playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)){
            case 1 -> 2;
            case 2 -> 3;
            case 3 -> 4;
            case 4 -> 5;
            case 5 -> 6;
            default -> 1;
        };
        
        // Schedule a task to give the player a grub bait if the final environment and item check passes and the random value is less than or equal to the fortune modifier
        if(finalEnvironmentAndItemCheck(playerInteractEvent) 
            && randomValue <= fortuneModifier){
            Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), () -> CommandSenderUtil.sendConsoleCommand(giveCommand), 2L);
        }
    }


    /**
     * Does the environment and item check for the onFarm method.
     * @param playerInteractEvent the player interaction event
     * @return true if the player is holding a hoe and interacting with grass or dirt, or if the player is holding seeds and interacting with farmland
     */
    private static boolean finalEnvironmentAndItemCheck(PlayerInteractEvent playerInteractEvent) {
        final ArrayList<Material> seedTypes = new ArrayList<>(List.of(
            Material.BEETROOT_SEEDS,
            Material.MELON_SEEDS,
            Material.PUMPKIN_SEEDS,
            Material.WHEAT_SEEDS,
            Material.CARROT,
            Material.POTATO
        ));
        try {
            Material itemMainHandType = playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType();
            Material blockType = playerInteractEvent.getClickedBlock().getType();
            return (MaterialTags.HOES.isTagged(itemMainHandType) && Set.of(Material.GRASS_BLOCK, Material.DIRT).contains(blockType))
                || (seedTypes.contains(itemMainHandType) && Objects.equals(Material.FARMLAND, blockType)
                && playerInteractEvent.getBlockFace() == BlockFace.UP && playerInteractEvent.getClickedBlock().getRelative(BlockFace.UP).getType().isAir());
        } catch (NullPointerException e) {
            return false;
        }
    }

}
