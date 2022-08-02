package me.ShermansWorld.AlathraExtras.tutorialbook;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ShermansWorld.AlathraExtras.Helper;

public class CustomItems {
	
	public static ItemStack tutorialBook() {
		ItemStack tutorialBook = new ItemStack(Material.BOOK, 1);
		ItemMeta meta = tutorialBook.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Helper.color("&eRight click the book in your hand or type /help"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(Helper.color("&6&lPlayer's Guide to &a&lAlathra&2&lMC"));
		meta.setCustomModelData(14899);
		tutorialBook.setItemMeta(meta);
		return tutorialBook;
	}
}
