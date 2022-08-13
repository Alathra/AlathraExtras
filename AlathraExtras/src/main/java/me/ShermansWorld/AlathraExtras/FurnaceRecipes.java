package me.ShermansWorld.AlathraExtras;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;

public class FurnaceRecipes {
	
	public void rottenFleshtoLeather() {
	    NamespacedKey key = new NamespacedKey(Main.getInstance(), Main.getInstance().getDescription().getName() + "1");
	    FurnaceRecipe leatherRecipe = new FurnaceRecipe(key, Main.recycledLeather, Material.ROTTEN_FLESH, 0.0F, 200);
	    Main.getInstance().getServer().addRecipe(leatherRecipe);
	}
}
