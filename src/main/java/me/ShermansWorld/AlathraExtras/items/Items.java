package me.ShermansWorld.AlathraExtras.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ShermansWorld.AlathraExtras.Helper;

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
