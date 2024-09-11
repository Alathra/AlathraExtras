package me.ShermansWorld.AlathraExtras.farming;

import com.destroystokyo.paper.MaterialTags;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.utilities.CommandSenderUtil;
import net.momirealms.customfishing.api.BukkitCustomFishingPlugin;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class FarmingListener implements Listener {
    
    /**
     * Listens for player interactions with tilled dirt and gives the player a grub bait (basic_bait_4) at a 1 percent chance.
     * @param playerInteractEvent the player interaction event
     */
    @EventHandler
    public void onTillDirt(PlayerInteractEvent playerInteractEvent){
        
        final String GRUB_BAIT_ID = "basic_bait_4";
        final String playerUsername = playerInteractEvent.getPlayer().getName();
        final String giveCommand = "cfishing items give %s %s".formatted(playerUsername, GRUB_BAIT_ID);
        

        
        if (AlathraExtras.customFishingPlugin == null) {
            AlathraExtras.logger.log("CustomFishingPlugin is not loaded, cannot give grub bait.");
            return;
        }
        if(playerInteractEvent.getClickedBlock() == null){
            return;
        }
        if(playerInteractEvent.getClickedBlock().getType() != Material.FARMLAND){
            return;
        }
        final ArrayList<Material> seedTypes = new ArrayList<>(List.of(
            Material.BEETROOT_SEEDS,
            Material.MELON_SEEDS,
            Material.PUMPKIN_SEEDS,
            Material.WHEAT_SEEDS,
            Material.CARROT,
            Material.POTATO
        ));
        
        final float fortuneModifier = switch (playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)){
            case 1 -> 2;
            case 2 -> 3;
            case 3 -> 4;
            case 4 -> 5;
            case 5 -> 6;
            default -> 1;
        };
        
        if(MaterialTags.HOES.isTagged(playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType()) || seedTypes.contains(playerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType()) && AlathraExtras.rand.nextInt(0,255) < fortuneModifier){
            //Debugging comments
            
            Player player = playerInteractEvent.getPlayer();
            Block block = playerInteractEvent.getClickedBlock();
            AlathraExtras.logger.log("Player " + player.getName() + " interacted with block " + block.getType().name() + " at " + block.getLocation().toString() + " in world " + block.getWorld().getName());
            
            CommandSenderUtil.sendConsoleCommand(giveCommand);
        }
    }
    
}
