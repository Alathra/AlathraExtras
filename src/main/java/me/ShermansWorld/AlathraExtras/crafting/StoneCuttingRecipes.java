package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoneCuttingRecipes {

    public static void setWoodcuttingRecipes() {
        Map<String, Integer> map = Map.of(
            "BUTTON", 4,
            "FENCE", 8,
            "FENCE_GATE", 4,
            "PLANKS", 4,
            "PRESSURE_PLATE", 4,
            "SIGN", 4,
            "SLAB", 8,
            "STAIRS", 4,
            "TRAPDOOR", 4,
            "DOOR", 1
        );

        for (Material log : Tag.LOGS.getValues()) {
            String logString = log.toString();

            //Removes "STRIPPED_" from stripped logs.
            if (logString.contains("STRIPPED")) {
                logString = logString.substring(9);
            }
            String[] materialArray = logString.split("_");

            // Handles dark oak.
            if (materialArray.length > 2 && materialArray[2] != null) {
                materialArray[0] = materialArray[0].concat("_").concat(materialArray[1]);
            }

            List<ItemStack> itemStackList = new ArrayList<ItemStack>();

            map.forEach((item, count) -> {
                Material itemName = Material.getMaterial(materialArray[0].concat("_").concat(item));

                ItemStack itemStack = new ItemStack(itemName, count);
                itemStackList.add(itemStack);
            });

            for (ItemStack item : itemStackList) {
                NamespacedKey namespacedKey = new NamespacedKey(AlathraExtras.getInstance(),
                    AlathraExtras.getInstance().getDescription().getName()
                        .concat(log.toString()).concat("_").concat(item.getType().toString()));
                StonecuttingRecipe recipe = new StonecuttingRecipe(namespacedKey, item, log);

                AlathraExtras.getInstance().getServer().addRecipe(recipe);
            }
        }
    }

    public static void setBamboocuttingRecipes() {
        Map<String, Integer> map = Map.of(
            "BUTTON", 2,
            "FENCE", 4,
            "FENCE_GATE", 2,
            "PLANKS", 2,
            "PRESSURE_PLATE", 2,
            "SIGN", 2,
            "SLAB", 4,
            "STAIRS", 2,
            "TRAPDOOR", 2,
            "DOOR", 1
        );

        for (Material bambooBlock : Tag.BAMBOO_BLOCKS.getValues()) {
            String blockString = bambooBlock.toString();

            //Removes "STRIPPED_" from stripped bamboo blocks.
            if (blockString.contains("STRIPPED")) {
                blockString = blockString.substring(9);
            }

            String[] materialArray = blockString.split("_");

            List<ItemStack> itemStackList = new ArrayList<ItemStack>();

            map.forEach((item, count) -> {
                Material itemName = Material.getMaterial(materialArray[0].concat("_").concat(item));

                ItemStack itemStack = new ItemStack(itemName, count);
                itemStackList.add(itemStack);
            });

            for (ItemStack item : itemStackList) {
                NamespacedKey namespacedKey = new NamespacedKey(AlathraExtras.getInstance(),
                    AlathraExtras.getInstance().getDescription().getName()
                        .concat(bambooBlock.toString()).concat("_").concat(item.getType().toString()));
                StonecuttingRecipe recipe = new StonecuttingRecipe(namespacedKey, item, bambooBlock);

                AlathraExtras.getInstance().getServer().addRecipe(recipe);
            }
        }
    }
}