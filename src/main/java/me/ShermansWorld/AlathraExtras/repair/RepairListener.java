package me.ShermansWorld.AlathraExtras.repair;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class RepairListener implements Listener {
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
}
