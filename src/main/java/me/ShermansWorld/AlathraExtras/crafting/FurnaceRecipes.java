package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class FurnaceRecipes {

    public void rottenFleshtoLeather() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "1");
        FurnaceRecipe leatherRecipe = new FurnaceRecipe(key, AlathraExtras.recycledLeather, Material.ROTTEN_FLESH,
            0.1F, 200);
        AlathraExtras.getInstance().getServer().addRecipe(leatherRecipe);
    }

    public void mossyCobbletoAndesite() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "15");
        ItemStack outputAndesite = new ItemStack(Material.ANDESITE, 1);
        FurnaceRecipe andesiteRecipe = new FurnaceRecipe(key, outputAndesite, Material.MOSSY_COBBLESTONE,
            0.1F, 200);
        AlathraExtras.getInstance().getServer().addRecipe(andesiteRecipe);
    }
}
