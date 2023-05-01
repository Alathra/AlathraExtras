package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.misc.CustomItems;

public class CraftingRecipes {
	
	public void saddleRecipe() {
		ItemStack saddle = new ItemStack(Material.SADDLE, 1);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "2");
		ShapedRecipe saddleRecipe = new ShapedRecipe(key, saddle);
		saddleRecipe.shape(new String[] { "   ", "%%%", "@ @" });
		saddleRecipe.setIngredient('@', Material.TRIPWIRE_HOOK);
		saddleRecipe.setIngredient('%', Material.LEATHER);
		Main.getInstance().getServer().addRecipe((Recipe) saddleRecipe);
	}
	
	public void charcoalBlock() {
		ItemStack charcoalBlock = new ItemStack(Material.COAL_BLOCK, 1);
		ItemMeta meta = charcoalBlock.getItemMeta();
		meta.setDisplayName(Helper.color("&8Block of Charcoal"));
		charcoalBlock.setItemMeta(meta);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "3");
		ShapedRecipe charcoalBlockRecipe = new ShapedRecipe(key, charcoalBlock);
		charcoalBlockRecipe.shape(new String[] { "@@@", "@@@", "@@@" });
		charcoalBlockRecipe.setIngredient('@', Material.CHARCOAL);
		Main.getInstance().getServer().addRecipe((Recipe) charcoalBlockRecipe);
	}
	
	public void redDyeRecipe() {
		ItemStack redDye = new ItemStack(Material.RED_DYE, 1);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "4");
		ShapelessRecipe redDyeRecipe = new ShapelessRecipe(key, redDye);
		redDyeRecipe.addIngredient(1, Material.REDSTONE);
		Main.getInstance().getServer().addRecipe((Recipe) redDyeRecipe);
	}
	
	public void redSandRecipe() {
		ItemStack redSand = new ItemStack(Material.RED_SAND, 8);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "5");
		ShapedRecipe redSandRecipe = new ShapedRecipe(key, redSand);
		redSandRecipe.shape(new String[] { "@@@", "@%@", "@@@" });
		redSandRecipe.setIngredient('@', Material.SAND);
		redSandRecipe.setIngredient('%', Material.RED_DYE);
		Main.getInstance().getServer().addRecipe((Recipe) redSandRecipe);
	}
	
	public void bellRecipe() {
		ItemStack bell = new ItemStack(Material.BELL, 1);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "6");
		ShapedRecipe bellRecipe = new ShapedRecipe(key, bell);
		bellRecipe.shape(new String[] { " @ ", "@%@", "   " });
		bellRecipe.setIngredient('@', Material.GOLD_BLOCK);
		bellRecipe.setIngredient('%', Material.GOLD_INGOT);
		Main.getInstance().getServer().addRecipe((Recipe) bellRecipe);
	}
	
	public void blackDyeRecipe1() {
		ItemStack blackDye1 = new ItemStack(Material.BLACK_DYE, 1);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "7");
		ShapelessRecipe blackDyeRecipe1 = new ShapelessRecipe(key, blackDye1);
		blackDyeRecipe1.addIngredient(1, Material.COAL);
		Main.getInstance().getServer().addRecipe((Recipe) blackDyeRecipe1);
	}
	
	public void blackDyeRecipe2() {
		ItemStack blackDye2 = new ItemStack(Material.BLACK_DYE, 1);
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "8");
		ShapelessRecipe blackDyeRecipe2 = new ShapelessRecipe(key, blackDye2);
		blackDyeRecipe2.addIngredient(1, Material.CHARCOAL);
		Main.getInstance().getServer().addRecipe((Recipe) blackDyeRecipe2);
	}
	
	public void beetRootPouchRecipe() {
		ItemStack beetRootPouch = CustomItems.getBeetrootPouch();
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "9");
		ShapedRecipe beetRootPouchRecipe = new ShapedRecipe(key, beetRootPouch);
		beetRootPouchRecipe.shape(new String[] { "@@@", "@@@", "@@@" });
		beetRootPouchRecipe.setIngredient('@', Material.BEETROOT);
		Main.getInstance().getServer().addRecipe((Recipe) beetRootPouchRecipe);
	}
	
	public void carrotPouchRecipe() {
		ItemStack carrotPouch = CustomItems.getCarrotPouch();
		NamespacedKey key = new NamespacedKey((Plugin) Main.getInstance(),
				String.valueOf(Main.getInstance().getDescription().getName()) + "10");
		ShapedRecipe CarrotPouchRecipe = new ShapedRecipe(key, carrotPouch);
		CarrotPouchRecipe.shape(new String[] { "@@@", "@@@", "@@@" });
		CarrotPouchRecipe.setIngredient('@', Material.CARROT);
		Main.getInstance().getServer().addRecipe((Recipe) CarrotPouchRecipe);
	}
	
}
