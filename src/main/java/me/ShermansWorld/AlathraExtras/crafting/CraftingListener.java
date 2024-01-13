package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {
    @EventHandler
    public void stoneRecipeOverrides(PrepareItemCraftEvent event) {
        ItemStack[] craftingGridItemStacks = event.getInventory().getMatrix();
        Material[] craftingGrid = new Material[9];

        for (int a = 0; a <= 8; a++) {
            if (craftingGridItemStacks[a] != null) {
                craftingGrid[a] = craftingGridItemStacks[a].getType();
            }
        }

        if (furnaceOverride(craftingGrid)) {
            event.getInventory().setResult(new ItemStack(Material.FURNACE));

            return;
        }

        if (slabOverride(craftingGrid, Material.COBBLESTONE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLESTONE_SLAB, 6));

            return;
        }

        if (slabOverride(craftingGrid, Material.COBBLED_DEEPSLATE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLED_DEEPSLATE_SLAB, 6));

            return;
        }

        if (wallOverride(craftingGrid, Material.COBBLESTONE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLESTONE_WALL, 6));

            return;
        }

        if (wallOverride(craftingGrid, Material.COBBLED_DEEPSLATE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLED_DEEPSLATE_WALL, 6));

            return;
        }

        if (stairOverride(craftingGrid, Material.COBBLESTONE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLESTONE_STAIRS, 4));

            return;
        }

        if (stairOverride(craftingGrid, Material.COBBLED_DEEPSLATE)) {
            event.getInventory().setResult(new ItemStack(Material.COBBLED_DEEPSLATE_STAIRS, 4));

            return;
        }

        if (polishedDeepslateOverride(craftingGrid)) {
            event.getInventory().setResult(new ItemStack(Material.POLISHED_DEEPSLATE, 4));
        }
    }

    public boolean furnaceOverride(Material[] craftingGrid) {
        if (craftingGrid[4] != null) return false;

        for (int a = 0; a <= 8; a++) {
            if (a == 4) continue;

            if (craftingGrid[a] == null) return false;

            boolean validMat = craftingGrid[a] == Material.COBBLESTONE;

            if (craftingGrid[a] == Material.COBBLED_DEEPSLATE) validMat = true;

            if (!validMat) return false;
        }

        return true;
    }

    public boolean slabOverride(Material[] craftingGrid, Material material) {
        Material[] slabRecipe1 = new Material[]{material, material, material, null, null, null, null, null, null};
        Material[] slabRecipe2 = new Material[]{null, null, null, material, material, material, null, null, null};
        Material[] slabRecipe3 = new Material[]{null, null, null, null, null, null, material, material, material};

        if (recipeCheck(craftingGrid, slabRecipe1)) return true;

        if (recipeCheck(craftingGrid, slabRecipe2)) return true;

        return recipeCheck(craftingGrid, slabRecipe3);
    }

    public boolean wallOverride(Material[] craftingGrid, Material material) {
        Material[] wallRecipe1 = new Material[]{material, material, material, material, material, material,
            null, null, null};
        Material[] wallRecipe2 = new Material[]{null, null, null, material, material, material,
            material, material, material};

        if (recipeCheck(craftingGrid, wallRecipe1)) return true;

        return recipeCheck(craftingGrid, wallRecipe2);
    }

    public boolean stairOverride(Material[] craftingGrid, Material material) {
        Material[] stairRecipe1 = new Material[]{material, null, null, material, material, null,
            material, material, material};
        Material[] stairRecipe2 = new Material[]{null, null, material, null, material, material,
            material, material, material};

        if (recipeCheck(craftingGrid, stairRecipe1)) return true;

        return recipeCheck(craftingGrid, stairRecipe2);
    }

    public boolean polishedDeepslateOverride(Material[] craftingGrid) {
        Material material = Material.COBBLED_DEEPSLATE;

        Material[] polishedDeepslateRecipe1 = new Material[]{material, material, null, material, material, null,
        null, null, null};
        Material[] polishedDeepslateRecipe2 = new Material[]{null, material, material, null, material, material,
        null, null, null};
        Material[] polishedDeepslateRecipe3 = new Material[]{null, null, null, material, material, null,
        material, material, null};
        Material[] polishedDeepslateRecipe4 = new Material[]{null, null, null, null, material, material,
        null, material, material};

        if (recipeCheck(craftingGrid, polishedDeepslateRecipe1)) return true;

        if (recipeCheck(craftingGrid, polishedDeepslateRecipe2)) return true;

        if (recipeCheck(craftingGrid, polishedDeepslateRecipe3)) return true;

        return recipeCheck(craftingGrid, polishedDeepslateRecipe4);
    }

    public boolean recipeCheck(Material[] craftingGrid, Material[] recipe) {
        for (int a = 0; a <= 8; a++) {
            if (craftingGrid[a] != recipe[a]) return false;
        }

        return true;
    }
}
