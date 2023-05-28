package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.Main;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;

public class StonecutterRecipes {
	public void sandtoSandstone() {
		NamespacedKey key = new NamespacedKey(Main.getInstance(), String.valueOf(Main.getInstance().getDescription().getName()) + "15");
		ItemStack sandstone = new ItemStack(Material.SANDSTONE, 1);
		StonecuttingRecipe sandstoneRecipe = new StonecuttingRecipe(key, sandstone, Material.SAND);
		Main.getInstance().getServer().addRecipe(sandstoneRecipe);
	}
}
