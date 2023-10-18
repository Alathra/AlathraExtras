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
    public void cookedSharkMeat(FurnaceSmeltEvent e) {

        if (!(e.getSource().getType() == Material.COD))
            return;

        if (!e.getSource().getItemMeta().hasCustomModelData())
            return;

        if (!(e.getSource().getItemMeta().getCustomModelData() == 2800))
            return;

        ItemStack cooked = new ItemStack(Material.COOKED_COD);
        ItemMeta meta = cooked.getItemMeta();

        meta.displayName(ColorParser.of("Cooked Shark Meat").build());
        meta.setCustomModelData(2800);

        cooked.setItemMeta(meta);

        e.setResult(cooked);
    }

    @EventHandler
    public void cookedVenison(FurnaceSmeltEvent e) {

        if (!(e.getSource().getType() == Material.MUTTON))
            return;

        if (!e.getSource().getItemMeta().hasCustomModelData())
            return;

        if (!(e.getSource().getItemMeta().getCustomModelData() == 2800))
            return;

        ItemStack cooked = new ItemStack(Material.COOKED_MUTTON);
        ItemMeta meta = cooked.getItemMeta();

        meta.displayName(ColorParser.of("Cooked Venison").build());
        meta.setCustomModelData(2800);

        cooked.setItemMeta(meta);

        e.setResult(cooked);
    }

    @EventHandler
    public static void cookedElephantMeat(FurnaceSmeltEvent e) {
        if (!(e.getSource().getType() == Material.BEEF))
            return;

        if (!e.getSource().getItemMeta().hasCustomModelData())
            return;

        if (!(e.getSource().getItemMeta().getCustomModelData() == 2800))
            return;

        ItemStack cooked = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = cooked.getItemMeta();

        meta.displayName(ColorParser.of("Cooked Elephant Meat").build());
        meta.setCustomModelData(2800);

        cooked.setItemMeta(meta);

        e.setResult(cooked);
    }

    @EventHandler
    public static void cookedCalamari(FurnaceSmeltEvent e) {
        if (!(e.getSource().getType() == Material.COD))
            return;

        if (!e.getSource().getItemMeta().hasCustomModelData())
            return;

        if (!(e.getSource().getItemMeta().getCustomModelData() == 2801))
            return;

        ItemStack cooked = new ItemStack(Material.COOKED_COD);
        ItemMeta meta = cooked.getItemMeta();

        meta.displayName(ColorParser.of("Cooked Calamari").build());
        meta.setCustomModelData(2801);

        cooked.setItemMeta(meta);

        e.setResult(cooked);
    }
}
