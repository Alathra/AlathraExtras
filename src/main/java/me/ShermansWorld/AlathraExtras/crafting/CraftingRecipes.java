package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.misc.CustomItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CraftingRecipes {

    public void saddleRecipe() {
        ItemStack saddle = new ItemStack(Material.SADDLE, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "2");
        ShapedRecipe saddleRecipe = new ShapedRecipe(key, saddle);
        saddleRecipe.shape(new String[]{"%%%", "@ @"});
        saddleRecipe.setIngredient('@', Material.TRIPWIRE_HOOK);
        saddleRecipe.setIngredient('%', Material.LEATHER);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) saddleRecipe);
    }

    public void charcoalBlock() {
        ItemStack charcoalBlock = new ItemStack(Material.COAL_BLOCK, 1);
        ItemMeta meta = charcoalBlock.getItemMeta();
        meta.setDisplayName(Helper.color("&8Block of Charcoal"));
        charcoalBlock.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "3");
        ShapedRecipe charcoalBlockRecipe = new ShapedRecipe(key, charcoalBlock);
        charcoalBlockRecipe.shape(new String[]{"@@@", "@@@", "@@@"});
        charcoalBlockRecipe.setIngredient('@', Material.CHARCOAL);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) charcoalBlockRecipe);
    }

    public void redDyeRecipe() {
        ItemStack redDye = new ItemStack(Material.RED_DYE, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "4");
        ShapelessRecipe redDyeRecipe = new ShapelessRecipe(key, redDye);
        redDyeRecipe.addIngredient(1, Material.REDSTONE);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) redDyeRecipe);
    }

    public void redSandRecipe() {
        ItemStack redSand = new ItemStack(Material.RED_SAND, 8);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "5");
        ShapedRecipe redSandRecipe = new ShapedRecipe(key, redSand);
        redSandRecipe.shape(new String[]{"@@@", "@%@", "@@@"});
        redSandRecipe.setIngredient('@', Material.SAND);
        redSandRecipe.setIngredient('%', Material.RED_DYE);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) redSandRecipe);
    }

    public void bellRecipe() {
        ItemStack bell = new ItemStack(Material.BELL, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "6");
        ShapedRecipe bellRecipe = new ShapedRecipe(key, bell);
        bellRecipe.shape(new String[]{" @ ", "@%@"});
        bellRecipe.setIngredient('@', Material.GOLD_BLOCK);
        bellRecipe.setIngredient('%', Material.GOLD_INGOT);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) bellRecipe);
    }

    public void blackDyeRecipe1() {
        ItemStack blackDye1 = new ItemStack(Material.BLACK_DYE, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "7");
        ShapelessRecipe blackDyeRecipe1 = new ShapelessRecipe(key, blackDye1);
        blackDyeRecipe1.addIngredient(1, Material.COAL);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) blackDyeRecipe1);
    }

    public void blackDyeRecipe2() {
        ItemStack blackDye2 = new ItemStack(Material.BLACK_DYE, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "8");
        ShapelessRecipe blackDyeRecipe2 = new ShapelessRecipe(key, blackDye2);
        blackDyeRecipe2.addIngredient(1, Material.CHARCOAL);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) blackDyeRecipe2);
    }

    public void beetRootPouchRecipe() {
        ItemStack beetRootPouch = CustomItems.getBeetrootPouch();
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "9");
        ShapedRecipe beetRootPouchRecipe = new ShapedRecipe(key, beetRootPouch);
        beetRootPouchRecipe.shape(new String[]{"@@@", "@@@", "@@@"});
        beetRootPouchRecipe.setIngredient('@', Material.BEETROOT);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) beetRootPouchRecipe);
    }

    public void carrotPouchRecipe() {
        ItemStack carrotPouch = CustomItems.getCarrotPouch();
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "10");
        ShapedRecipe CarrotPouchRecipe = new ShapedRecipe(key, carrotPouch);
        CarrotPouchRecipe.shape(new String[]{"@@@", "@@@", "@@@"});
        CarrotPouchRecipe.setIngredient('@', Material.CARROT);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) CarrotPouchRecipe);
    }

    public void potatoPouchRecipe() {
        ItemStack potatoPouch = CustomItems.getPotatoPouch();
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "11");
        ShapedRecipe PotatoPouchRecipe = new ShapedRecipe(key, potatoPouch);
        PotatoPouchRecipe.shape(new String[]{"@@@", "@@@", "@@@"});
        PotatoPouchRecipe.setIngredient('@', Material.POTATO);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) PotatoPouchRecipe);
    }

    public void dioriteRecipe1() {
        ItemStack diorite1 = new ItemStack(Material.DIORITE, 2);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "12");
        ShapelessRecipe dioriteRecipe1 = new ShapelessRecipe(key, diorite1);
        dioriteRecipe1.addIngredient(2, Material.ANDESITE);
        dioriteRecipe1.addIngredient(1, Material.QUARTZ);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) dioriteRecipe1);
    }

    public void dioriteRecipe2() {
        ItemStack diorite2 = new ItemStack(Material.DIORITE, 2);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "13");
        ShapelessRecipe dioriteRecipe2 = new ShapelessRecipe(key, diorite2);
        dioriteRecipe2.addIngredient(1, Material.GRANITE);
        dioriteRecipe2.addIngredient(1, Material.COBBLESTONE);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) dioriteRecipe2);
    }

    public void dioriteRecipe3() {
        ItemStack diorite3 = new ItemStack(Material.DIORITE, 3);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "14");
        ShapelessRecipe dioriteRecipe3 = new ShapelessRecipe(key, diorite3);
        dioriteRecipe3.addIngredient(2, Material.ANDESITE);
        dioriteRecipe3.addIngredient(1, Material.GRANITE);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) dioriteRecipe3);
    }

    public void greenDyeRecipe() {
        ItemStack greenDye = new ItemStack(Material.GREEN_DYE, 2);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "16");
        ShapelessRecipe greenDyeRecipe = new ShapelessRecipe(key, greenDye);
        greenDyeRecipe.addIngredient(1, Material.BLUE_DYE);
        greenDyeRecipe.addIngredient(1, Material.YELLOW_DYE);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) greenDyeRecipe);
    }

    public void pinkPetalsRecipe() {
        ItemStack pinkPetals = new ItemStack(Material.PINK_PETALS, 1);
        NamespacedKey key = new NamespacedKey((Plugin) AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "17");
        ShapelessRecipe pinkPetalsRecipe = new ShapelessRecipe(key, pinkPetals);
        pinkPetalsRecipe.addIngredient(1, Material.CHERRY_LEAVES);
        AlathraExtras.getInstance().getServer().addRecipe((Recipe) pinkPetalsRecipe);
    }

    public void stonesToGravel() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "18");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.COBBLESTONE, Material.COBBLED_DEEPSLATE);
        ItemStack result = new ItemStack(Material.GRAVEL, 1);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void gravelToSand() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "19");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.GRAVEL);
        ItemStack result = new ItemStack(Material.SAND, 1);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void dioriteToQuartz() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "20");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.DIORITE);
        ItemStack result = new ItemStack(Material.QUARTZ, 1);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void coarseDirtToDirt() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "21");
        RecipeChoice.MaterialChoice input = new RecipeChoice.MaterialChoice(Material.COARSE_DIRT);
        ItemStack result = new ItemStack(Material.DIRT, 1);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void beetrootPouchToBeetroot() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "22");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getBeetrootPouch());
        ItemStack result = new ItemStack(Material.BEETROOT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void carrotPouchToCarrot() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "23");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getCarrotPouch());
        ItemStack result = new ItemStack(Material.CARROT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public void potatoPouchToPotato() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            String.valueOf(AlathraExtras.getInstance().getDescription().getName()) + "24");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(CustomItems.getPotatoPouch());
        ItemStack result = new ItemStack(Material.POTATO, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }
}
