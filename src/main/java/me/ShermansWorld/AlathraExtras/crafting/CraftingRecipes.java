package me.ShermansWorld.AlathraExtras.crafting;

import com.github.alathra.siegeengines.libs.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.items.Items;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.alathra.siegeengines.api.SiegeEnginesAPI;

import java.util.Collections;
import java.util.List;

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
        ItemStack beetRootPouch = Items.getBeetrootPouch();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "beetrootPouchRecipe");
        ShapelessRecipe beetrootPouchRecipe = new ShapelessRecipe(key, beetRootPouch);
        beetrootPouchRecipe.addIngredient(9, Material.BEETROOT);
        AlathraExtras.getInstance().getServer().addRecipe(beetrootPouchRecipe);
    }

    public static void carrotPouchRecipe() {
        ItemStack carrotPouch = Items.getCarrotPouch();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "carrotPouchRecipe");
        ShapelessRecipe carrotPouchRecipe = new ShapelessRecipe(key, carrotPouch);
        carrotPouchRecipe.addIngredient(9, Material.CARROT);
        AlathraExtras.getInstance().getServer().addRecipe(carrotPouchRecipe);
    }

    public static void potatoPouchRecipe() {
        ItemStack potatoPouch = Items.getPotatoPouch();
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

    public static void railsRecipe() {
        ItemStack rails = new ItemStack(Material.RAIL, 64);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "railsRecipe");
        ShapedRecipe railsRecipe = new ShapedRecipe(key, rails);
        railsRecipe.shape("I I", "ISI", "I I");
        railsRecipe.setIngredient('I', Material.IRON_INGOT);
        railsRecipe.setIngredient('S', Material.STICK);
        AlathraExtras.getInstance().getServer().addRecipe(railsRecipe);
    }

    public static void poweredRailsRecipe() {
        ItemStack poweredRails = new ItemStack(Material.POWERED_RAIL,  24);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "poweredRailsRecipe");
        ShapedRecipe poweredRailsRecipe = new ShapedRecipe(key, poweredRails);
        poweredRailsRecipe.shape("G G", "GSG", "GRG");
        poweredRailsRecipe.setIngredient('G', Material.GOLD_INGOT);
        poweredRailsRecipe.setIngredient('S', Material.STICK);
        poweredRailsRecipe.setIngredient('R', Material.REDSTONE);
        AlathraExtras.getInstance().getServer().addRecipe(poweredRailsRecipe);
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
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(Items.getBeetrootPouch());
        ItemStack result = new ItemStack(Material.BEETROOT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void carrotPouchToCarrots() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "carrotPouchToCarrots");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(Items.getCarrotPouch());
        ItemStack result = new ItemStack(Material.CARROT, 9);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(input);

        AlathraExtras.getInstance().getServer().addRecipe(recipe);
    }

    public static void potatoPouchToPotatos() {
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "potatoPouchToPotatos");
        RecipeChoice.ExactChoice input = new RecipeChoice.ExactChoice(Items.getPotatoPouch());
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
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "25");
        ShapedRecipe cryingObsidianRecipe = new ShapedRecipe(key, cryingObsidian);
        cryingObsidianRecipe.shape(
            "%@%",
            "@#@",
            "%@%"
        );
        cryingObsidianRecipe.setIngredient('@', Material.GHAST_TEAR);
        cryingObsidianRecipe.setIngredient('%', Material.OBSIDIAN);
        cryingObsidianRecipe.setIngredient('#', Material.WATER_BUCKET);

        AlathraExtras.getInstance().getServer().addRecipe(cryingObsidianRecipe);
    }

    public static void rootedDirtRecipe() {
        ItemStack rootedDirt = new ItemStack(Material.ROOTED_DIRT, 8);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "rootedDirtRecipe");
        ShapedRecipe rootedDirtRecipe = new ShapedRecipe(key, rootedDirt);
        rootedDirtRecipe.shape("CCC", "CHC", "CCC");
        rootedDirtRecipe.setIngredient('C', Material.COARSE_DIRT);
        rootedDirtRecipe.setIngredient('H', Material.HANGING_ROOTS);
        AlathraExtras.getInstance().getServer().addRecipe(rootedDirtRecipe);
    }
    
    public static Recipe trebuchetRecipe() {
		ItemStack trebuchet = SiegeEnginesAPI.getTrebuchetItem();
        setSiegeEngineItemMeta(trebuchet, "Trebuchet");
        trebuchet.setAmount(1);
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
        setSiegeEngineItemMeta(ballista, "Ballista");
        ballista.setAmount(1);
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

    public static void breachCannonRecipe() {
        ItemStack breachCannon = SiegeEnginesAPI.getBreachCannonItem();
        setSiegeEngineItemMeta(breachCannon, "Breach Cannon");
        breachCannon.setAmount(1);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "breachCannonRecipe");
        ShapedRecipe breachCannonRecipe = new ShapedRecipe(key, breachCannon);
        breachCannonRecipe.shape(" XC", "XBX", "AX ");
        breachCannonRecipe.setIngredient('X', Items.getTungsten());
        breachCannonRecipe.setIngredient('C', Material.CAULDRON);
        breachCannonRecipe.setIngredient('B', Items.getFormattedSwivelCannon());
        breachCannonRecipe.setIngredient('A', Material.ANVIL);
        AlathraExtras.getInstance().getServer().addRecipe(breachCannonRecipe);
    }

    public static void swivelCannonRecipe() {
        ItemStack swivelCannon = Items.getFormattedSwivelCannon();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "swivelCannonRecipe");
        ShapedRecipe swivelCannonRecipe = new ShapedRecipe(key, swivelCannon);
        swivelCannonRecipe.shape("XXX", "BBC", "  A");
        swivelCannonRecipe.setIngredient('X', Items.getTungsten());
        swivelCannonRecipe.setIngredient('B', Material.IRON_BLOCK);
        swivelCannonRecipe.setIngredient('C', Material.CAULDRON);
        swivelCannonRecipe.setIngredient('A', Material.ANVIL);
        AlathraExtras.getInstance().getServer().addRecipe(swivelCannonRecipe);
    }

    private static void setSiegeEngineItemMeta(ItemStack itemStack, String s) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(ColorParser.of("<bold><yellow>%s</yellow></bold>".formatted(s)).build().decoration(TextDecoration.ITALIC, false));
        itemMeta.lore(Collections.singletonList(ColorParser.of("<yellow>Place as a block to spawn a %s</yellow>".formatted(s)).build().decoration(TextDecoration.ITALIC, false)));
        itemStack.setItemMeta(itemMeta);
    }

    public static void unchargedSilverMelonRecipe() {
        ItemStack unchargedSilverMelon = Items.getUnchargedSilverMelon();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "unchargedSilverMelonRecipe");
        ShapedRecipe unchargedSilverMelonRecipe = new ShapedRecipe(key, unchargedSilverMelon);
        unchargedSilverMelonRecipe.shape("C%C", "%D%", "C%C");
        unchargedSilverMelonRecipe.setIngredient('%', Items.getSilver());
        unchargedSilverMelonRecipe.setIngredient('D', Material.GLISTERING_MELON_SLICE);
        unchargedSilverMelonRecipe.setIngredient('C', Material.COPPER_INGOT);
        AlathraExtras.getInstance().getServer().addRecipe(unchargedSilverMelonRecipe);
    }

    public static void chargedSilverMelonRecipe() {
        ItemStack chargedSilverMelon = Items.getChargedSilverMelon();
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "chargedSilverMelonRecipe");
        ShapelessRecipe chargedSilverMelonRecipe = new ShapelessRecipe(key, chargedSilverMelon);
        chargedSilverMelonRecipe.addIngredient(Items.getUnchargedSilverMelon());
        chargedSilverMelonRecipe.addIngredient(Material.DRAGON_BREATH);
        chargedSilverMelonRecipe.addIngredient(Material.BLAZE_POWDER);
        chargedSilverMelonRecipe.addIngredient(Material.REDSTONE);
        chargedSilverMelonRecipe.addIngredient(Material.GLOWSTONE_DUST);
        AlathraExtras.getInstance().getServer().addRecipe(chargedSilverMelonRecipe);
    }

    // ALATHRA ACCESSORIES RECIPES

    public static void orangeHatRecipe() {
        ItemStack orangeHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta orangeHatMeta = orangeHat.getItemMeta();
        orangeHatMeta.displayName(ColorParser.of("Sunset Hues").build());
        orangeHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        orangeHatMeta.setCustomModelData(201);
        orangeHat.setItemMeta(orangeHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "orange_hat");
        ShapedRecipe orangeHatRecipe = new ShapedRecipe(key, orangeHat);
        orangeHatRecipe.shape("@@@", "@#@", "$ $");
        orangeHatRecipe.setIngredient('@', Material.ORANGE_WOOL);
        orangeHatRecipe.setIngredient('#', Material.LEATHER_HELMET);
        orangeHatRecipe.setIngredient('$', Material.STRING);
        AlathraExtras.getInstance().getServer().addRecipe(orangeHatRecipe);
    }

    public static void strawHatRecipe() {
        ItemStack strawHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta strawHatMeta = strawHat.getItemMeta();
        strawHatMeta.displayName(ColorParser.of("Strawman Redemption").build());
        strawHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        strawHatMeta.setCustomModelData(202);
        strawHat.setItemMeta(strawHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "straw_hat");
        ShapedRecipe strawHatRecipe = new ShapedRecipe(key, strawHat);
        strawHatRecipe.shape("@@@", "@ @", "$ $");
        strawHatRecipe.setIngredient('@', Material.WHEAT);
        strawHatRecipe.setIngredient('$', Material.STRING);
        AlathraExtras.getInstance().getServer().addRecipe(strawHatRecipe);
    }

    public static void pirateHatRecipe() {
        ItemStack pirateHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta pirateHatMeta = pirateHat.getItemMeta();
        pirateHatMeta.displayName(ColorParser.of("The High Seas").build());
        pirateHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        pirateHatMeta.setCustomModelData(203);
        pirateHat.setItemMeta(pirateHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "pirate_hat");
        ShapedRecipe pirateHatRecipe = new ShapedRecipe(key, pirateHat);
        pirateHatRecipe.shape(" % ", "@#@", "$ $");
        pirateHatRecipe.setIngredient('@', Material.BONE);
        pirateHatRecipe.setIngredient('#', Material.LEATHER_HELMET);
        pirateHatRecipe.setIngredient('$', Material.STRING);
        pirateHatRecipe.setIngredient('%', Material.FEATHER);
        AlathraExtras.getInstance().getServer().addRecipe(pirateHatRecipe);
    }

    public static void redHatRecipe() {
        ItemStack redHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta redHatMeta = redHat.getItemMeta();
        redHatMeta.displayName(ColorParser.of("Merlot Memories").build());
        redHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        redHatMeta.setCustomModelData(204);
        redHat.setItemMeta(redHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "red_hat");
        ShapedRecipe redHatRecipe = new ShapedRecipe(key, redHat);
        redHatRecipe.shape("@@@", "@#@", "$ $");
        redHatRecipe.setIngredient('@', Material.RED_WOOL);
        redHatRecipe.setIngredient('#', Material.LEATHER_HELMET);
        redHatRecipe.setIngredient('$', Material.STRING);
        AlathraExtras.getInstance().getServer().addRecipe(redHatRecipe);
    }

    public static void purpleHatRecipe() {
        ItemStack purpleHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta purpleHatMeta = purpleHat.getItemMeta();
        purpleHatMeta.displayName(ColorParser.of("Periwinkle Promises").build());
        purpleHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        purpleHatMeta.setCustomModelData(205);
        purpleHat.setItemMeta(purpleHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "purple_hat");
        ShapedRecipe purpleHatRecipe = new ShapedRecipe(key, purpleHat);
        purpleHatRecipe.shape("@@@", "@#@", "$ $");
        purpleHatRecipe.setIngredient('@', Material.PURPLE_WOOL);
        purpleHatRecipe.setIngredient('#', Material.LEATHER_HELMET);
        purpleHatRecipe.setIngredient('$', Material.STRING);
        AlathraExtras.getInstance().getServer().addRecipe(purpleHatRecipe);
    }

    public static void greenHatRecipe() {
        ItemStack greenHat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta greenHatMeta = greenHat.getItemMeta();
        greenHatMeta.displayName(ColorParser.of("Mint Memo").build());
        greenHatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        greenHatMeta.setCustomModelData(207);
        greenHat.setItemMeta(greenHatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "green_hat");
        ShapedRecipe greenHatRecipe = new ShapedRecipe(key, greenHat);
        greenHatRecipe.shape("@@@", "@#@", "$ $");
        greenHatRecipe.setIngredient('@', Material.LIME_WOOL);
        greenHatRecipe.setIngredient('#', Material.LEATHER_HELMET);
        greenHatRecipe.setIngredient('$', Material.STRING);
        AlathraExtras.getInstance().getServer().addRecipe(greenHatRecipe);
    }

    public static void watchRecipe() {
        ItemStack watch = new ItemStack(Material.CLOCK);
        ItemMeta watchMeta = watch.getItemMeta();
        watchMeta.displayName(ColorParser.of("Punctuality").build());
        watchMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        watchMeta.setCustomModelData(201);
        watch.setItemMeta(watchMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "watch");
        ShapedRecipe watchRecipe = new ShapedRecipe(key, watch);
        watchRecipe.shape("###", "#@#", "###");
        watchRecipe.setIngredient('@', Material.CLOCK);
        watchRecipe.setIngredient('#', Material.LEATHER);
        AlathraExtras.getInstance().getServer().addRecipe(watchRecipe);
    }

    public static void caneRecipe() {
        ItemStack cane = new ItemStack(Material.STICK);
        ItemMeta caneMeta = cane.getItemMeta();
        caneMeta.displayName(ColorParser.of("Distinguished Soul").build());
        caneMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        caneMeta.setCustomModelData(201);
        cane.setItemMeta(caneMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "cane");
        ShapedRecipe caneRecipe = new ShapedRecipe(key, cane);
        caneRecipe.shape("  #", " @ ", "@  ");
        caneRecipe.setIngredient('@', Material.IRON_INGOT);
        caneRecipe.setIngredient('#', Material.COAL_BLOCK);
        AlathraExtras.getInstance().getServer().addRecipe(caneRecipe);
    }

    public static void scepterRecipe() {
        ItemStack scepter = new ItemStack(Material.STICK);
        ItemMeta scepterMeta = scepter.getItemMeta();
        scepterMeta.displayName(ColorParser.of("Ruler's Scepter").build());
        scepterMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        scepterMeta.setCustomModelData(202);
        scepter.setItemMeta(scepterMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "scepter");
        ShapedRecipe scepterRecipe = new ShapedRecipe(key, scepter);
        scepterRecipe.shape("@# ", "$%$", " ^%");
        scepterRecipe.setIngredient('@', Material.AMETHYST_SHARD);
        scepterRecipe.setIngredient('#', Material.LAPIS_LAZULI);
        scepterRecipe.setIngredient('$', Material.REDSTONE);
        scepterRecipe.setIngredient('%', Material.GOLD_INGOT);
        scepterRecipe.setIngredient('^', Material.EMERALD);
        AlathraExtras.getInstance().getServer().addRecipe(scepterRecipe);
    }

    public static void wizardStaffRecipe() {
        ItemStack wizardStaff = new ItemStack(Material.STICK);
        ItemMeta wizardStaffMeta = wizardStaff.getItemMeta();
        wizardStaffMeta.displayName(ColorParser.of("Wizard's Staff").build());
        wizardStaffMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        wizardStaffMeta.setCustomModelData(203);
        wizardStaff.setItemMeta(wizardStaffMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "wizardStaff");
        ShapedRecipe wizardStaffRecipe = new ShapedRecipe(key, wizardStaff);
        wizardStaffRecipe.shape(" @@", " #@", "  @");
        wizardStaffRecipe.setIngredient('@', Material.STICK);
        wizardStaffRecipe.setIngredient('#', Material.LAPIS_BLOCK);
        AlathraExtras.getInstance().getServer().addRecipe(wizardStaffRecipe);
    }

    public static void tophatRecipe() {
        ItemStack tophat = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta tophatMeta = tophat.getItemMeta();
        tophatMeta.displayName(ColorParser.of("Gentleman's Pride").build());
        tophatMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        tophatMeta.setCustomModelData(207);
        tophat.setItemMeta(tophatMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "tophat");
        ShapedRecipe tophatRecipe = new ShapedRecipe(key, tophat);
        tophatRecipe.shape(" @ ", " # ", "$$$");
        tophatRecipe.setIngredient('@', Material.BLACK_WOOL);
        tophatRecipe.setIngredient('#', Material.WHITE_WOOL);
        tophatRecipe.setIngredient('$', Material.BLACK_CARPET);
        AlathraExtras.getInstance().getServer().addRecipe(tophatRecipe);
    }

    public static void hornedHelmetRecipe() {
        ItemStack hornedHelmet = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta hornedHelmetMeta = hornedHelmet.getItemMeta();
        hornedHelmetMeta.displayName(ColorParser.of("Horned Helmet").build());
        hornedHelmetMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        hornedHelmetMeta.setCustomModelData(208);
        hornedHelmet.setItemMeta(hornedHelmetMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "hornedHelmet");
        ShapedRecipe hornedHelmetRecipe = new ShapedRecipe(key, hornedHelmet);
        hornedHelmetRecipe.shape("@ @", "$#$", "$ $");
        hornedHelmetRecipe.setIngredient('@', Material.BONE);
        hornedHelmetRecipe.setIngredient('#', Material.IRON_INGOT);
        hornedHelmetRecipe.setIngredient('$', Material.LEATHER);
        AlathraExtras.getInstance().getServer().addRecipe(hornedHelmetRecipe);
    }

    public static void mustacheRecipe() {
        ItemStack mustache = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta mustacheMeta = mustache.getItemMeta();
        mustacheMeta.displayName(ColorParser.of("Mighty Stache").build());
        mustacheMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        mustacheMeta.setCustomModelData(209);
        mustache.setItemMeta(mustacheMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "mustache");
        ShapedRecipe mustacheRecipe = new ShapedRecipe(key, mustache);
        mustacheRecipe.shape("   ", "@@@", "@ @");
        mustacheRecipe.setIngredient('@', Material.BLACK_WOOL);
        AlathraExtras.getInstance().getServer().addRecipe(mustacheRecipe);
    }

    public static void crownRecipe() {
        ItemStack crown = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta crownMeta = crown.getItemMeta();
        crownMeta.displayName(ColorParser.of("Ruler's Crown").build());
        crownMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        crownMeta.setCustomModelData(210);
        crown.setItemMeta(crownMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "crown");
        ShapedRecipe crownRecipe = new ShapedRecipe(key, crown);
        crownRecipe.shape("@ @", "###", "$%^");
        crownRecipe.setIngredient('@', Material.GOLD_INGOT);
        crownRecipe.setIngredient('#', Material.GOLD_BLOCK);
        crownRecipe.setIngredient('$', Material.LAPIS_LAZULI);
        crownRecipe.setIngredient('%', Material.REDSTONE);
        crownRecipe.setIngredient('^', Material.EMERALD);
        AlathraExtras.getInstance().getServer().addRecipe(crownRecipe);
    }

    public static void wreathRecipe() {
        ItemStack wreath = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta wreathMeta = wreath.getItemMeta();
        wreathMeta.displayName(ColorParser.of("Wreath of Suns").build());
        wreathMeta.lore(List.of(ColorParser.of("<green><bold>Alathran Accessory</bold></green>").build()));
        wreathMeta.setCustomModelData(211);
        wreath.setItemMeta(wreathMeta);
        NamespacedKey key = new NamespacedKey(AlathraExtras.getInstance(),
            AlathraExtras.getInstance().getName() + "wreath");
        ShapedRecipe wreathRecipe = new ShapedRecipe(key, wreath);
        wreathRecipe.shape("@#@", "# #", "@#@");
        wreathRecipe.setIngredient('@', Material.VINE);
        wreathRecipe.setIngredient('#', Material.SUNFLOWER);
        AlathraExtras.getInstance().getServer().addRecipe(wreathRecipe);
    }

    public static void registerAllCraftingRecipes() {
        saddleRecipe();
        rootedDirtRecipe();
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
        breachCannonRecipe();
        swivelCannonRecipe();
        allMultiBlockRecipes();
        unchargedSilverMelonRecipe();
        chargedSilverMelonRecipe();
        strawHatRecipe();
        pirateHatRecipe();
        orangeHatRecipe();
        redHatRecipe();
        purpleHatRecipe();
        greenHatRecipe();
        watchRecipe();
        caneRecipe();
        scepterRecipe();
        wizardStaffRecipe();
        tophatRecipe();
        hornedHelmetRecipe();
        mustacheRecipe();
        crownRecipe();
        wreathRecipe();
        railsRecipe();
        poweredRailsRecipe();
    }
}
