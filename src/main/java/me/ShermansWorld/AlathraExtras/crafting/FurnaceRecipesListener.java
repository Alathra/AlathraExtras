package me.ShermansWorld.AlathraExtras.crafting;

import com.github.milkdrinkers.colorparser.ColorParser;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FurnaceRecipesListener implements Listener {
    @EventHandler
    public void cookedMeats(FurnaceSmeltEvent event) {
        if (!event.getSource().getItemMeta().hasCustomModelData()) return;

        ItemStack cookedMeat = null;

        if (event.getSource().getType() == Material.COD)
            cookedMeat = cookedCods(event.getSource());

        if (event.getSource().getType() == Material.MUTTON)
            cookedMeat = cookedMuttons(event.getSource());

        if (event.getSource().getType() == Material.BEEF)
            cookedMeat = cookedBeefs(event.getSource());

        if (event.getSource().getType() == Material.PORKCHOP)
            cookedMeat = cookedPorks(event.getSource());

        if (cookedMeat == null) return;

        event.setResult(cookedMeat);
    }

    private ItemStack cookedCods(ItemStack cooking) {
        String substituteName = null;
        int substituteCustomModelData = 0;

        if (cooking.getItemMeta().getCustomModelData() == 2800) {
            substituteName = "Cooked Shark Meat";
            substituteCustomModelData = 2800;
        }

        if (cooking.getItemMeta().getCustomModelData() == 2801) {
            substituteName  = "Cooked Calamari";
            substituteCustomModelData = 2801;
        }

        if (substituteName == null) return null;

        return makeCooked(Material.COOKED_COD, substituteName, substituteCustomModelData);
    }

    private ItemStack cookedMuttons(ItemStack cooking) {
        String substituteName = null;
        int substituteCustomModelData = 0;

        if (cooking.getItemMeta().getCustomModelData() == 2800) {
            substituteName = "Cooked Venison";
            substituteCustomModelData = 2800;
        }

        if (substituteName == null) return null;

        return makeCooked(Material.COOKED_MUTTON, substituteName, substituteCustomModelData);
    }

    private ItemStack cookedBeefs(ItemStack cooking) {
        String substituteName = null;
        int substituteCustomModelData = 0;

        if (cooking.getItemMeta().getCustomModelData() == 2800) {
            substituteName = "Cooked Elephant Meat";
            substituteCustomModelData = 2800;
        }

        if (substituteName == null) return null;

        return makeCooked(Material.COOKED_BEEF, substituteName, substituteCustomModelData);
    }

    private ItemStack cookedPorks(ItemStack cooking) {
        String substituteName = null;
        int substituteCustomModelData = 0;

        if (cooking.getItemMeta().getCustomModelData() == 2800) {
            substituteName = "Cooked Boar Meat";
            substituteCustomModelData = 2800;
        }

        if (substituteName == null) return null;

        return makeCooked(Material.COOKED_PORKCHOP, substituteName, substituteCustomModelData);
    }

    private ItemStack makeCooked(Material material, String name, int customModelData) {
        ItemStack cooked = new ItemStack(material);

        ItemMeta meta = cooked.getItemMeta();

        meta.displayName(ColorParser.of(name).build());
        meta.setCustomModelData(customModelData);

        cooked.setItemMeta(meta);

        return cooked;
    }
}