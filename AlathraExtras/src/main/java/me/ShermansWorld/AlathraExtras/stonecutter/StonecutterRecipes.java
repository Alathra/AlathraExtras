package me.ShermansWorld.AlathraExtras.stonecutter;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.StonecuttingRecipe;

import me.ShermansWorld.AlathraExtras.Main;

public class StonecutterRecipes {
	
	public void gravelFromCobble() {
	    NamespacedKey key = new NamespacedKey(Main.getInstance(), Main.getInstance().getDescription().getName() + "100");
	    StonecuttingRecipe gravelRecipe = new StonecuttingRecipe(key, Main.recycledLeather, Material.ROTTEN_FLESH);
	    Main.getInstance().getServer().addRecipe(gravelRecipe);
	}
	
}
