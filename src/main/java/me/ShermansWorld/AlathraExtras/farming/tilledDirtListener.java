package me.ShermansWorld.AlathraExtras.farming;

import com.earth2me.essentials.utils.MaterialUtil;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import net.momirealms.customfishing.api.BukkitCustomFishingPlugin;
import net.momirealms.customfishing.api.integration.ItemProvider;
import net.momirealms.customfishing.api.mechanic.context.Context;
import net.momirealms.customfishing.api.mechanic.item.CustomFishingItem;
import net.momirealms.customfishing.api.mechanic.item.CustomFishingItemImpl;
import net.momirealms.customfishing.api.mechanic.item.ItemManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.net.ssl.ExtendedSSLSession;
import java.util.EventListener;

public class tilledDirtListener implements EventListener {

    net.momirealms.customfishing.api.mechanic.item.ItemManager customFishingItemManager = AlathraExtras.customFishingPlugin==null ? null : BukkitCustomFishingPlugin.getInstance().getItemManager();
    
    /**
     * Listens for player interactions with tilled dirt and gives the player a grub bait (basic_bait_4) at a 1 percent chance.
     * @param playerInteractEvent the player interaction event
     */
    @EventHandler
    public void onTillDirt(PlayerInteractEvent playerInteractEvent){
        if (customFishingItemManager == null) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        Block block = playerInteractEvent.getClickedBlock();
        ItemStack grubBait = customFishingItemManager.buildInternal(Context.player(player), "basic_bait_4");
        grubBait.setAmount(1);
        if (block == null || block.getType() != Material.FARMLAND) {
            return;
        }
        if (AlathraExtras.rand.nextInt(0,1) < 0.01) {
            if (grubBait != null) {
                player.getInventory().addItem(grubBait);
            }
        }
    }
    
}
