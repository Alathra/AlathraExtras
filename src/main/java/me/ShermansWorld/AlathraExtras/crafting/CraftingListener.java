package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import com.github.alathra.siegeengines.api.SiegeEnginesAPI;

import me.ShermansWorld.AlathraExtras.items.Items;

public class CraftingListener implements Listener {
	@EventHandler
	public void onCraftPrepare(PrepareItemCraftEvent event) {
		ItemStack[] craftingGridItemStacks = event.getInventory().getMatrix();
		Material[] craftingGrid = new Material[craftingGridItemStacks.length];

		for (int a = 0; a < craftingGridItemStacks.length; a++) {
			if (craftingGridItemStacks[a] != null) {
				craftingGrid[a] = craftingGridItemStacks[a].getType();
			}
		}

		if (event.getInventory().getType() == InventoryType.WORKBENCH) {
			craftingTableStoneRecipeOverrides(event, craftingGrid);
			craftingTableSwivelCannonRecipeOverrides(event, craftingGridItemStacks, craftingGrid);
			craftingTableBreachCannonRecipeOverrides(event, craftingGridItemStacks, craftingGrid);
			return;
		}

		playerCraftingStoneRecipeOverrides(event, craftingGrid);

	}

	public void craftingTableSwivelCannonRecipeOverrides(PrepareItemCraftEvent event,
			ItemStack[] craftingGridItemStacks, Material[] craftingGrid) {

		Material[] swivelCannonRecipe = new Material[] { Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
				Material.IRON_BLOCK, Material.IRON_BLOCK, Material.CAULDRON, null, null, Material.ANVIL };
		if (recipeCheck(craftingGrid, swivelCannonRecipe, true)) {
			if (craftingGridItemStacks[0].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[1].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[2].equals(Items.getAlathranIron())
                    && craftingGridItemStacks[3].equals(new ItemStack(Material.IRON_BLOCK, 1))
                    && craftingGridItemStacks[4].equals(new ItemStack(Material.IRON_BLOCK, 1))
                    && craftingGridItemStacks[5].equals(new ItemStack(Material.CAULDRON, 1))
                    && craftingGridItemStacks[8].equals(new ItemStack(Material.ANVIL, 1))
            ) {
				event.getInventory().setResult(SiegeEnginesAPI.getSwivelCannonItem());
			}
		}

	}

	public void craftingTableBreachCannonRecipeOverrides(PrepareItemCraftEvent event,
			ItemStack[] craftingGridItemStacks, Material[] craftingGrid) {
		
		Material[] breachCannonRecipe = new Material[] { null, Material.IRON_INGOT, Material.CAULDRON, Material.IRON_INGOT, Material.CARVED_PUMPKIN, Material.IRON_INGOT, Material.ANVIL, Material.IRON_INGOT, null };
		
		if (recipeCheck(craftingGrid, breachCannonRecipe, true)) {
			if (craftingGridItemStacks[1].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[3].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[5].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[7].equals(Items.getAlathranIron())
					&& craftingGridItemStacks[4].equals(SiegeEnginesAPI.getSwivelCannonItem())
                    && craftingGridItemStacks[2].equals(new ItemStack(Material.CAULDRON, 1))
                    && craftingGridItemStacks[6].equals(new ItemStack(Material.ANVIL, 1))

            ) {
				event.getInventory().setResult(SiegeEnginesAPI.getBreachCannonItem());
			}
		}
	}

	public void craftingTableStoneRecipeOverrides(PrepareItemCraftEvent event, Material[] craftingGrid) {
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

		if (polishedDeepslateCraftingTableOverride(craftingGrid)) {
			event.getInventory().setResult(new ItemStack(Material.POLISHED_DEEPSLATE, 4));
		}
	}

	public void playerCraftingStoneRecipeOverrides(PrepareItemCraftEvent event, Material[] craftingGrid) {
		if (polishedDeepslatePlayerCraftingOverride(craftingGrid)) {
			event.getInventory().setResult(new ItemStack(Material.POLISHED_DEEPSLATE, 4));
		}
	}

	public boolean furnaceOverride(Material[] craftingGrid) {
		if (craftingGrid[4] != null)
			return false;

		for (int a = 0; a <= 8; a++) {
			if (a == 4)
				continue;

			if (craftingGrid[a] == null)
				return false;

			boolean validMat = craftingGrid[a] == Material.COBBLESTONE;

			if (craftingGrid[a] == Material.COBBLED_DEEPSLATE)
				validMat = true;

			if (!validMat)
				return false;
		}

		return true;
	}

	public boolean slabOverride(Material[] craftingGrid, Material material) {
		Material[] slabRecipe1 = new Material[] { material, material, material, null, null, null, null, null, null };
		Material[] slabRecipe2 = new Material[] { null, null, null, material, material, material, null, null, null };
		Material[] slabRecipe3 = new Material[] { null, null, null, null, null, null, material, material, material };

		if (recipeCheck(craftingGrid, slabRecipe1, true))
			return true;

		if (recipeCheck(craftingGrid, slabRecipe2, true))
			return true;

		return recipeCheck(craftingGrid, slabRecipe3, true);
	}

	public boolean wallOverride(Material[] craftingGrid, Material material) {
		Material[] wallRecipe1 = new Material[] { material, material, material, material, material, material, null,
				null, null };
		Material[] wallRecipe2 = new Material[] { null, null, null, material, material, material, material, material,
				material };

		if (recipeCheck(craftingGrid, wallRecipe1, true))
			return true;

		return recipeCheck(craftingGrid, wallRecipe2, true);
	}

	public boolean stairOverride(Material[] craftingGrid, Material material) {
		Material[] stairRecipe1 = new Material[] { material, null, null, material, material, null, material, material,
				material };
		Material[] stairRecipe2 = new Material[] { null, null, material, null, material, material, material, material,
				material };

		if (recipeCheck(craftingGrid, stairRecipe1, true))
			return true;

		return recipeCheck(craftingGrid, stairRecipe2, true);
	}

	public boolean polishedDeepslateCraftingTableOverride(Material[] craftingGrid) {
		Material[] polishedDeepslateRecipe1 = new Material[] { Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE,
				null, Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE, null, null, null, null };
		Material[] polishedDeepslateRecipe2 = new Material[] { null, Material.COBBLED_DEEPSLATE,
				Material.COBBLED_DEEPSLATE, null, Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE, null, null,
				null };
		Material[] polishedDeepslateRecipe3 = new Material[] { null, null, null, Material.COBBLED_DEEPSLATE,
				Material.COBBLED_DEEPSLATE, null, Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE, null };
		Material[] polishedDeepslateRecipe4 = new Material[] { null, null, null, null, Material.COBBLED_DEEPSLATE,
				Material.COBBLED_DEEPSLATE, null, Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE };

		if (recipeCheck(craftingGrid, polishedDeepslateRecipe1, true))
			return true;

		if (recipeCheck(craftingGrid, polishedDeepslateRecipe2, true))
			return true;

		if (recipeCheck(craftingGrid, polishedDeepslateRecipe3, true))
			return true;

		return recipeCheck(craftingGrid, polishedDeepslateRecipe4, true);
	}

	public boolean polishedDeepslatePlayerCraftingOverride(Material[] craftingGrid) {
		return recipeCheck(craftingGrid, new Material[] { Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE,
				Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE }, false);
	}

	public boolean recipeCheck(Material[] craftingGrid, Material[] recipe, boolean craftingTable) {
		int slots;

		if (craftingTable)
			slots = 9;

		else
			slots = 4;

		for (int a = 0; a < slots; a++) {
			if (craftingGrid[a] != recipe[a]) {
				return false;
			}
		}

		return true;
	}
}