package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {
    @EventHandler
    public void furnaceOverride(PrepareItemCraftEvent event) {
        ItemStack[] craftingGrid = event.getInventory().getMatrix();

        if (craftingGrid[4] != null) return;

        for (int a = 0; a <= 8; a++) {
            if (a == 4) continue;

            if (craftingGrid[a].getType() != Material.COBBLESTONE) return;
        }

        event.getInventory().setResult(new ItemStack(Material.FURNACE));
    }
}
