package me.ShermansWorld.AlathraExtras.items;

import com.github.alathra.siegeengines.api.SiegeEnginesAPI;
import com.github.alathra.siegeengines.libs.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.lumine.mythic.bukkit.MythicBukkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {

    private static final Component ALATHRAN_ITEM_TAG = ColorParser.of("<green><bold>Alathran Item</bold></green>").build().decoration(TextDecoration.ITALIC, false);
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

    /**
     * Gets an Uncharged Silver Melon item
     * @return the Uncharged Silver Melon item
     */
    public static ItemStack getUnchargedSilverMelon() {

        ItemStack silverMelon = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = silverMelon.getItemMeta();
        meta.setCustomModelData(420);
        meta.displayName(ColorParser.of("<bold><white>Uncharged Silver Melon</white></bold>").build()
            .decoration(TextDecoration.ITALIC, false));
        List<Component> lore = new ArrayList<>();
        lore.add(ColorParser.of("<yellow>It's metallic surface is shiny and</yellow>").build());
        lore.add(ColorParser.of("<yellow>looks tasty to eat.</yellow>").build());
        lore.add(ALATHRAN_ITEM_TAG);
        List<Component> lore2 = new ArrayList<>();
        lore.forEach( c -> {
            c = c.decoration(TextDecoration.ITALIC, false);
            lore2.add(c);
        });
        meta.lore(lore2);
        silverMelon.setItemMeta(meta);
        return silverMelon;
    }

    /**
     * Gets a charged Silver Melon item
     * @return the charged Silver Melon item
     */
    public static ItemStack getChargedSilverMelon() {
        ItemStack chargedSilverMelon = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = chargedSilverMelon.getItemMeta();
        meta.setCustomModelData(421);
        meta.displayName(ColorParser.of("<bold><white>Charged Silver Melon</white></bold>").build()
            .decoration(TextDecoration.ITALIC, false));
        List<Component> lore = new ArrayList<>();
        lore.add(ColorParser.of("<yellow>It's metallic surface is sparking and glimmering.</yellow>").build());
        lore.add(ColorParser.of("<yellow>Looks painful to eat.</yellow>").build());
        lore.add(ALATHRAN_ITEM_TAG);
        List<Component> lore2 = new ArrayList<>();
        lore.forEach( c -> {
            c = c.decoration(TextDecoration.ITALIC, false);
            lore2.add(c);
        });
        meta.lore(lore2);
        meta.addEnchant(Enchantment.LURE, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chargedSilverMelon.setItemMeta(meta);
        return chargedSilverMelon;
    }

    /**
     * Gets a mythic mobs Tungsten item
     * @return the mythic mobs Tungsten item
     */
    public static ItemStack getTungsten() {
        return MythicBukkit.inst().getItemManager().getItemStack("Tungsten");
    }

    /**
     * Gets a mythic mobs Platinum item
     * @return the mythic mobs Platinum item
     */
    public static ItemStack getPlatinum() {
        return  MythicBukkit.inst().getItemManager().getItemStack("Platinum");
    }

    /**
     * Gets a mythic mobs Silver item
     * @return the mythic mobs Silver item
     */
    public static ItemStack getSilver() {
        return MythicBukkit.inst().getItemManager().getItemStack("Silver");
    }

    /**
     * Gets a formatted Swivel Cannon item
     * @return the formatted Swivel Cannon item
     */
    public static ItemStack getFormattedSwivelCannon(){
        ItemStack swivelCannon = SiegeEnginesAPI.getSwivelCannonItem();
        String s = "Swivel Cannon";
        swivelCannon.setAmount(1);
        ItemMeta swivelCannonMeta = swivelCannon.getItemMeta();
        swivelCannonMeta.displayName(ColorParser.of("<bold><yellow>%s</yellow></bold>".formatted(s)).build().decoration(TextDecoration.ITALIC, false));
        swivelCannonMeta.lore(Collections.singletonList(ColorParser.of("<yellow>Place as a block to spawn a %s</yellow>".formatted(s)).build().decoration(TextDecoration.ITALIC, false)));
        swivelCannon.setItemMeta(swivelCannonMeta);
        return swivelCannon;
    }
}
