package me.ShermansWorld.AlathraExtras.weather;

import me.ShermansWorld.AlathraExtras.items.Items;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class lightningListener {
    @EventHandler
    public void onItemDestroy(EntityDamageEvent event) {

        if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {

            Location lightningStrikeLocation = event.getEntity().getLocation();
            if (event.getEntityType() == EntityType.DROPPED_ITEM) {
                Item item = (Item) event.getEntity();
                if (item.getItemStack().getType().equals(Material.GOLDEN_APPLE)
                    && item.getItemStack().getItemMeta().getCustomModelData() == 420)
                {
                    ItemStack resultingItemStack = Items.getChargedCopperApple();
                    resultingItemStack.setAmount(item.getItemStack().getAmount());
                    item.setItemStack(resultingItemStack);
                }
            }

        }
    }
}
