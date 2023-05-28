package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

import me.ShermansWorld.AlathraExtras.Main;

public class FurnaceRecipes {
	
	public void rottenFleshtoLeather() {
	    NamespacedKey key = new NamespacedKey(Main.getInstance(), Main.getInstance().getDescription().getName() + "1");
	    FurnaceRecipe leatherRecipe = new FurnaceRecipe(key, Main.recycledLeather, Material.ROTTEN_FLESH, 0.1F, 200);
	    Main.getInstance().getServer().addRecipe(leatherRecipe);
	}
	
	public void mossyCobbletoAndesite() {
		NamespacedKey key = new NamespacedKey(Main.getInstance(), Main.getInstance().getDescription().getName() + "14");
		ItemStack outputAndesite = new ItemStack(Material.ANDESITE, 1);
		FurnaceRecipe andesiteRecipe = new FurnaceRecipe(key, outputAndesite, Material.MOSSY_COBBLESTONE, 0.1F, 200);
		Main.getInstance().getServer().addRecipe(andesiteRecipe);
	}
}
