package me.ShermansWorld.AlathraExtras.items;

import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private static ItemStack setAlathranItem(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add(Helper.color("&a&lAlathran Item"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getTinyXPPouch() {
        ItemStack tinyXPPouch = new ItemStack(Material.PAPER, 1);
        tinyXPPouch = setAlathranItem(tinyXPPouch);
        ItemMeta meta = tinyXPPouch.getItemMeta();
        meta.setDisplayName(Helper.color("&5Tiny XP Pouch"));
        meta.setCustomModelData(14702);
        tinyXPPouch.setItemMeta(meta);
        return tinyXPPouch;
    }
}
