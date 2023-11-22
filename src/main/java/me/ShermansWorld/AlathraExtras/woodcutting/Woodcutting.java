package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Woodcutting {

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
            if (logString.contains("STRIPPED")) {
                logString = logString.substring(9);
            }
            String[] materialArray = logString.split("_");

            if (materialArray.length > 2 && materialArray[2] != null) {
                materialArray[0] = materialArray[0].concat("_").concat(materialArray[1]);
            }

            List<ItemStack> itemStackList = new ArrayList<ItemStack>();

            for (int i = 0; i < woodcuttingItems.length; i++) {
                String item = woodcuttingItems[i];
                int count = woodcuttingCount[i];

                Material itemName = Material.getMaterial(materialArray[0].concat("_").concat(item));

                ItemStack itemStack = new ItemStack(itemName, count);
                itemStackList.add(itemStack);
            }

            String key = log.name() + Math.random();

            for (ItemStack item : itemStackList) {
                NamespacedKey namespacedKey = new NamespacedKey((Plugin) AlathraExtras.getInstance(), key.concat(item.getType().name()));
                StonecuttingRecipe recipe = new StonecuttingRecipe(namespacedKey, item, log);

                AlathraExtras.getInstance().getServer().addRecipe(recipe);
            }

        }
    }
}
