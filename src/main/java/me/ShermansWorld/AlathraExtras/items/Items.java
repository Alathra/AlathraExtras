package me.ShermansWorld.AlathraExtras.items;

import com.github.alathra.siegeengines.libs.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.lumine.mythic.bukkit.MythicBukkit;

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
    
	public static ItemStack getAlathranIron() {
		return MythicBukkit.inst().getItemManager().getItemStack("Alathran_Iron");
	}

    //TODO: Adjust method and command names away from apple to something else.
    public static ItemStack getUnchargedSilverMelon() {
        ItemStack silverMelon = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = silverMelon.getItemMeta();
        meta.setCustomModelData(420);
        meta.displayName(ColorParser.of("<bold><gold>Uncharged Silver Melon</gold></bold>").build());
        List<Component> lore = new ArrayList<>();
        lore.add(ColorParser.of("<green>It's metallic surface is shiny and</green>").build());
        lore.add(ColorParser.of("<green>looks tasty to eat.</green>").build());
        lore.add(ColorParser.of("&a&lAlathran Item").build());
        lore.forEach( component -> component = component.decoration(TextDecoration.ITALIC, false));
        meta.lore(lore);
        silverMelon.setItemMeta(meta);
        return silverMelon;
    }

    public static ItemStack getChargedSilverMelon() {
        ItemStack chargedSilverMelon = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = chargedSilverMelon.getItemMeta();
        meta.setCustomModelData(421);
        meta.displayName(ColorParser.of("<bold><gold>Charged Silver Melon</gold></bold>").build());
        List<Component> lore = new ArrayList<>();
        lore.add(ColorParser.of("<green>It's metallic surface is sparking and glimmering.</green>").build());
        lore.add(ColorParser.of("<green>Looks painful to eat.</green>").build());
        lore.add(ColorParser.of("&a&lAlathran Item").build());
        lore.forEach( component -> component = component.decoration(TextDecoration.ITALIC, false));
        meta.lore(lore);
        meta.addEnchant(Enchantment.LURE, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chargedSilverMelon.setItemMeta(meta);
        return chargedSilverMelon;
    }
}
