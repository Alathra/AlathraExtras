package me.ShermansWorld.AlathraExtras.crafting;

import com.github.alathra.siegeengines.libs.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.misc.CustomItems;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import com.github.alathra.siegeengines.api.SiegeEnginesAPI;

public class CraftingRecipes {
	
    public static void saddleRecipe() {
        ItemStack saddle = new ItemStack(Material.SADDLE, 1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "saddleRecipe");
        ShapedRecipe saddleRecipe = new ShapedRecipe(key, saddle);
        saddleRecipe.shape("%%%", "@ @");
        saddleRecipe.setIngredient('@', Material.TRIPWIRE_HOOK);
        saddleRecipe.setIngredient('%', Material.LEATHER);
        AlathraExtras.getInstance().getServer().addRecipe(saddleRecipe);
    }

    public static void charcoalBlock() {
        ItemStack charcoalBlock = new ItemStack(Material.COAL_BLOCK, 1);
        ItemMeta meta = charcoalBlock.getItemMeta();
        meta.setDisplayName(Helper.color("&8Block of Charcoal"));
        charcoalBlock.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "charcoalBlock");
        ShapelessRecipe charcoalBlockRecipe = new ShapelessRecipe(key, charcoalBlock);
        charcoalBlockRecipe.addIngredient(9, Material.CHARCOAL);
        AlathraExtras.getInstance().getServer().addRecipe(charcoalBlockRecipe);
    }

    public static void redDyeRecipe() {
        ItemStack redDye = new ItemStack(Material.RED_DYE, 1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "redDyeRecipe");
        ShapelessRecipe redDyeRecipe = new ShapelessRecipe(key, redDye);
        redDyeRecipe.addIngredient(1, Material.REDSTONE);
        AlathraExtras.getInstance().getServer().addRecipe(redDyeRecipe);
    }

    public static void redSandRecipe() {
        ItemStack redSand = new ItemStack(Material.RED_SAND, 8);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "redSandRecipe");
        ShapelessRecipe redSandRecipe = new ShapelessRecipe(key, redSand);
        redSandRecipe.addIngredient(8, Material.SAND);
        redSandRecipe.addIngredient(1, Material.RED_DYE);
        AlathraExtras.getInstance().getServer().addRecipe(redSandRecipe);
    }

    public static void bellRecipe() {
        ItemStack bell = new ItemStack(Material.BELL, 1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "bellRecipe");
        ShapedRecipe bellRecipe = new ShapedRecipe(key, bell);
        bellRecipe.shape(" @ ", "@%@");
        bellRecipe.setIngredient('@', Material.GOLD_BLOCK);
        bellRecipe.setIngredient('%', Material.GOLD_INGOT);
        AlathraExtras.getInstance().getServer().addRecipe(bellRecipe);
    }

    public static void blackDyeRecipe() {
        ItemStack blackDye = new ItemStack(Material.BLACK_DYE, 1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "blackDyeRecipe");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.COAL, Material.CHARCOAL);
        ShapelessRecipe blackDyeRecipe = new ShapelessRecipe(key, blackDye);
        blackDyeRecipe.addIngredient(input);
        AlathraExtras.getInstance().getServer().addRecipe(blackDyeRecipe);
    }

    public static void beetrootPouchRecipe() {
        ItemStack beetRootPouch = CustomItems.getBeetrootPouch();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "beetrootPouchRecipe");
        ShapelessRecipe beetrootPouchRecipe = new ShapelessRecipe(key, beetRootPouch);
        beetrootPouchRecipe.addIngredient(9, Material.BEETROOT);
        AlathraExtras.getInstance().getServer().addRecipe(beetrootPouchRecipe);
    }

    public static void carrotPouchRecipe() {
        ItemStack carrotPouch = CustomItems.getCarrotPouch();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "carrotPouchRecipe");
        ShapelessRecipe carrotPouchRecipe = new ShapelessRecipe(key, carrotPouch);
        carrotPouchRecipe.addIngredient(9, Material.CARROT);
        AlathraExtras.getInstance().getServer().addRecipe(carrotPouchRecipe);
    }

    public static void potatoPouchRecipe() {
        ItemStack potatoPouch = CustomItems.getPotatoPouch();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "potatoPouchRecipe");
        ShapelessRecipe potatoPouchRecipe = new ShapelessRecipe(key, potatoPouch);
        potatoPouchRecipe.addIngredient(9, Material.POTATO);
        AlathraExtras.getInstance().getServer().addRecipe(potatoPouchRecipe);
    }

    public static void dioriteRecipe1() {
        ItemStack diorite1 = new ItemStack(Material.DIORITE, 2);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "dioriteRecipe1");
        ShapelessRecipe dioriteRecipe1 = new ShapelessRecipe(key, diorite1);
        dioriteRecipe1.addIngredient(2, Material.ANDESITE);
        dioriteRecipe1.addIngredient(1, Material.QUARTZ);
        AlathraExtras.getInstance().getServer().addRecipe(dioriteRecipe1);
    }

    public static void dioriteRecipe2() {
        ItemStack diorite2 = new ItemStack(Material.DIORITE, 2);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "dioriteRecipe2");
        ShapelessRecipe dioriteRecipe2 = new ShapelessRecipe(key, diorite2);
        dioriteRecipe2.addIngredient(1, Material.GRANITE);
        dioriteRecipe2.addIngredient(1, Material.COBBLESTONE);
        AlathraExtras.getInstance().getServer().addRecipe(dioriteRecipe2);
    }

    public static void dioriteRecipe3() {
        ItemStack diorite3 = new ItemStack(Material.DIORITE, 3);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "dioriteRecipe3");
        ShapelessRecipe dioriteRecipe3 = new ShapelessRecipe(key, diorite3);
        dioriteRecipe3.addIngredient(2, Material.ANDESITE);
        dioriteRecipe3.addIngredient(1, Material.GRANITE);
        AlathraExtras.getInstance().getServer().addRecipe(dioriteRecipe3);
    }

    public static void greenDyeRecipe() {
        ItemStack greenDye = new ItemStack(Material.GREEN_DYE, 2);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "greenDyeRecipe");
        ShapelessRecipe greenDyeRecipe = new ShapelessRecipe(key, greenDye);
        greenDyeRecipe.addIngredient(1, Material.BLUE_DYE);
        greenDyeRecipe.addIngredient(1, Material.YELLOW_DYE);
        AlathraExtras.getInstance().getServer().addRecipe(greenDyeRecipe);
    }

    public static void pinkPetalsRecipe() {
        ItemStack pinkPetals = new ItemStack(Material.PINK_PETALS, 1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "pinkPetalsRecipe");
        ShapelessRecipe pinkPetalsRecipe = new ShapelessRecipe(key, pinkPetals);
        pinkPetalsRecipe.addIngredient(1, Material.CHERRY_LEAVES);
        AlathraExtras.getInstance().getServer().addRecipe(pinkPetalsRecipe);
    }

    public static void stonesToGravel(int a) {
        for (int b = 0; b <= a; b++) {
            NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
                AlathraExtras.getInstance().getName() + "stonesToGravela" + a + "b" + b);
            ItemStack result = new ItemStack(Material.GRAVEL, a);

            ShapelessRecipe recipe = new ShapelessRecipe(key, result);

            recipe.addIngredient(a - b, Material.COBBLESTONE);
            recipe.addIngredient(b, Material.COBBLED_DEEPSLATE);

            AlathraExtras.getInstance().getServer().addRecipe(recipe);
        }
    }

    public static void gravelToSand(int a) {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "gravelToSand" + a);
        ItemStack result = new ItemStack(Material.SAND, a);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(a, Material.GRAVEL);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void dioriteToQuartz() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "dioriteToQuartz");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.DIORITE);
        ItemStack result = new ItemStack(Material.QUARTZ, 1);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void coarseDirtToDirt(int a) {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "coarseDirtToDirt" + a);
        ItemStack result = new ItemStack(Material.DIRT, a);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(a, Material.COARSE_DIRT);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void beetrootPouchToBeetroots() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "beetrootPouchToBeetroots");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getBeetrootPouch());
        ItemStack result = new ItemStack(Material.BEETROOT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void carrotPouchToCarrots() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "carrotPouchToCarrots");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getCarrotPouch());
        ItemStack result = new ItemStack(Material.CARROT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void potatoPouchToPotatos() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "potatoPouchToPotatos");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getPotatoPouch());
        ItemStack result = new ItemStack(Material.POTATO, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void allMultiBlockRecipes() {
        for (int a = 1; a <= 9; a++) {
            stonesToGravel(a);
            gravelToSand(a);
            coarseDirtToDirt(a);
        }
    }

    public static void cryingObsidianRecipe() {
        ItemStack cryingObsidian = new ItemStack(Material.CRYING_OBSIDIAN, 4);
        NamespacedKey key = new NamespacedKey((@NotNull Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "25");
        ShapedRecipe cryingObsidianRecipe = new ShapedRecipe(key, cryingObsidian);
        cryingObsidianRecipe.shape(new String[]{
            "%@%",
            "@#@",
            "%@%"
        });
        cryingObsidianRecipe.setIngredient('@', Material.GHAST_TEAR);
        cryingObsidianRecipe.setIngredient('%', Material.OBSIDIAN);
        cryingObsidianRecipe.setIngredient('#', Material.WATER_BUCKET);

        AlathraExtras.getInstance().getServer().addRecipe((Recipe) cryingObsidianRecipe);
    }
    
    public static Recipe trebuchetRecipe() {
		ItemStack trebuchet = SiegeEnginesAPI.getTrebuchetItem();
        ItemMeta trebuchetItemMeta = trebuchet.getItemMeta();
        trebuchetItemMeta.displayName(ColorParser.of("<yellow><bold>Trebuchet</bold></yellow>").build());
        trebuchet.setItemMeta(trebuchetItemMeta);
		NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
				AlathraExtras.getInstance().getName() + "trebuchetRecipe");
		ShapedRecipe trebuchetRecipe = new ShapedRecipe(key, trebuchet);
		trebuchetRecipe.shape("$@$", "%#$", "@^@");
		trebuchetRecipe.setIngredient('@', Material.OAK_FENCE);
		trebuchetRecipe.setIngredient('%', Material.OAK_LOG);
		trebuchetRecipe.setIngredient('#', Material.OAK_TRAPDOOR);
		trebuchetRecipe.setIngredient('$', Material.STRING);
		trebuchetRecipe.setIngredient('^', Material.BOWL);
		AlathraExtras.getInstance().getServer().addRecipe(trebuchetRecipe);
		return trebuchetRecipe;
	}
	
	public static Recipe ballistaRecipe() {
		ItemStack ballista = SiegeEnginesAPI.getBallistaItem();
        ItemMeta ballistaItemMeta = ballista.getItemMeta();
        ballistaItemMeta.displayName(ColorParser.of("<yellow><bold>Ballista</bold></yellow>").build());
        ballista.setItemMeta(ballistaItemMeta);
		NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
				AlathraExtras.getInstance().getName() + "ballistaRecipe");
		ShapedRecipe ballistaRecipe = new ShapedRecipe(key, ballista);
		ballistaRecipe.shape("@%%", "%# ", "% $");
		ballistaRecipe.setIngredient('@', Material.CROSSBOW);
		ballistaRecipe.setIngredient('%', Material.STICK);
		ballistaRecipe.setIngredient('#', Material.OAK_PLANKS);
		ballistaRecipe.setIngredient('$', Material.OAK_LOG);
		AlathraExtras.getInstance().getServer().addRecipe(ballistaRecipe);
		return ballistaRecipe;
	}

    public static void registerAllCraftingRecipes() {
        saddleRecipe();
        charcoalBlock();
        redDyeRecipe();
        redSandRecipe();
        bellRecipe();
        blackDyeRecipe();
        beetrootPouchRecipe();
        carrotPouchRecipe();
        potatoPouchRecipe();
        dioriteRecipe1();
        dioriteRecipe2();
        dioriteRecipe3();
        greenDyeRecipe();
        pinkPetalsRecipe();
        dioriteToQuartz();
        beetrootPouchToBeetroots();
        carrotPouchToCarrots();
        potatoPouchToPotatos();
        cryingObsidianRecipe();
        trebuchetRecipe();
        ballistaRecipe();
        allMultiBlockRecipes();
    }
}
