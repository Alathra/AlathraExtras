package me.ShermansWorld.AlathraExtras.repair;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.Repairable;

import java.util.Map;

public class RepairListener implements Listener {
    private final Map<Material, Material> customRepairRecipes = Map.of(Material.BOW, Material.STRING,
            Material.CROSSBOW, Material.STRING, Material.TRIDENT, Material.PRISMARINE_CRYSTALS,
            Material.SHEARS, Material.IRON_INGOT, Material.FLINT_AND_STEEL, Material.IRON_INGOT,
            Material.FISHING_ROD, Material.STRING);

    @EventHandler
    public void disableRepairCostIncrease(PrepareAnvilEvent anvilEvent) {
        if (anvilEvent.getInventory().getFirstItem() == null) return;

        if (anvilEvent.getInventory().getSecondItem() == null) return;

        if (anvilEvent.getResult() == null) return;

        if (!anvilEvent.getInventory().getFirstItem().isRepairableBy(anvilEvent.getInventory().getSecondItem())) return;

        if (anvilEvent.getInventory().getFirstItem().getType() == anvilEvent.getInventory().getSecondItem().getType())
            return;

        if (!(anvilEvent.getInventory().getFirstItem().getItemMeta() instanceof Repairable)) return;

        if (anvilEvent.getInventory().getFirstItem().getType() != anvilEvent.getResult().getType()) return;

        ItemStack repairItem = anvilEvent.getInventory().getFirstItem();
        ItemStack result = anvilEvent.getResult();

        Repairable repairMeta = (Repairable) repairItem.getItemMeta();
        Repairable resultMeta = (Repairable) result.getItemMeta();

        resultMeta.setRepairCost(repairMeta.getRepairCost());

        result.setItemMeta(resultMeta);
    }

    @EventHandler
    public void customRepairs(PrepareAnvilEvent anvilEvent) {
        if (invalidityCheck(anvilEvent.getInventory())) return;

        assert anvilEvent.getInventory().getFirstItem() != null;
        assert anvilEvent.getInventory().getSecondItem() != null;

        ItemStack result = new ItemStack(anvilEvent.getInventory().getFirstItem());

        Damageable resultDamageable = (Damageable) result.getItemMeta();

        if (!resultDamageable.hasDamage()) return;

        int repairItemsUsed = getRepairItemsUsed(resultDamageable.getDamage(), result.getType().getMaxDurability(),
                anvilEvent.getInventory().getSecondItem().getAmount());

        int reducedDamage = resultDamageable.getDamage() -
                ((result.getType().getMaxDurability() / 4) * repairItemsUsed);

        if (reducedDamage <= 0) reducedDamage = 0;

        resultDamageable.setDamage(reducedDamage);

        result.setItemMeta(resultDamageable);

        anvilEvent.setResult(result);

        Repairable resultRepairable = (Repairable) result.getItemMeta();

        anvilEvent.getInventory().setRepairCost((resultRepairable.getRepairCost() + 1) * repairItemsUsed);
    }

    @EventHandler
    public void forceResult(InventoryClickEvent clickEvent) {
        if (!(clickEvent.getClickedInventory() instanceof AnvilInventory anvil)) return;

        if (clickEvent.getSlotType() != InventoryType.SlotType.RESULT) return;

        if (invalidityCheck(anvil)) return;

        assert anvil.getFirstItem() != null;
        assert anvil.getSecondItem() != null;
        assert anvil.getResult() != null;

        Damageable resultDamageable = (Damageable) anvil.getFirstItem().getItemMeta();

        int repairItemsUsed = getRepairItemsUsed(resultDamageable.getDamage(),
                anvil.getFirstItem().getType().getMaxDurability(), anvil.getSecondItem().getAmount());

        if (!(clickEvent.getWhoClicked() instanceof Player player)) return;

        Repairable resultRepairable = (Repairable) anvil.getResult().getItemMeta();

        // anvil.getRepairCost() does not work for some reason - gives wrong values.
        int newExperience = player.getLevel() - ((resultRepairable.getRepairCost() + 1) * repairItemsUsed);

        if (newExperience < 0) return;

        ItemStack reducedMaterials = anvil.getSecondItem();

        reducedMaterials.setAmount(anvil.getSecondItem().getAmount() - repairItemsUsed);

        clickEvent.getWhoClicked().setItemOnCursor(anvil.getResult());
        anvil.setFirstItem(null);
        anvil.setSecondItem(reducedMaterials);
        anvil.setResult(null);
        player.setLevel(newExperience);
    }

    private boolean invalidityCheck(AnvilInventory anvil) {
        if (anvil.getFirstItem() == null) return true;

        if (anvil.getSecondItem() == null) return true;

        if (!customRepairRecipes.containsKey(anvil.getFirstItem().getType())) return true;

        if (customRepairRecipes.get(anvil.getFirstItem().getType()) != anvil.getSecondItem().getType()) return true;

        return !(anvil.getFirstItem().getItemMeta() instanceof Damageable);
    }

    private int getRepairItemsUsed(int damage, int maxDurability, int amountOffered) {
        if (damage >= ((maxDurability / 4) * amountOffered)) return amountOffered;

        return (damage / (maxDurability / 4)) + 1;
    }
}