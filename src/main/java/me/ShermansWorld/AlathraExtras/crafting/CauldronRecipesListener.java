package me.ShermansWorld.AlathraExtras.crafting;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class CauldronRecipesListener implements Listener {
    // I know that I can cut down on this with material tags, but I'm being lazy here.
    private static final HashMap<Material, Material> transformations = new HashMap<>(Map.ofEntries(
        Map.entry(Material.BLACK_CONCRETE_POWDER, Material.BLACK_CONCRETE),
        Map.entry(Material.BLUE_CONCRETE_POWDER, Material.BLUE_CONCRETE),
        Map.entry(Material.BROWN_CONCRETE_POWDER, Material.BROWN_CONCRETE),
        Map.entry(Material.COARSE_DIRT, Material.MUD),
        Map.entry(Material.CYAN_CONCRETE_POWDER, Material.CYAN_CONCRETE),
        Map.entry(Material.DIRT, Material.MUD),
        Map.entry(Material.GRAY_CONCRETE_POWDER, Material.GRAY_CONCRETE),
        Map.entry(Material.GREEN_CONCRETE_POWDER, Material.GREEN_CONCRETE),
        Map.entry(Material.LIGHT_BLUE_CONCRETE_POWDER, Material.LIGHT_BLUE_CONCRETE),
        Map.entry(Material.LIGHT_GRAY_CONCRETE_POWDER, Material.LIGHT_GRAY_CONCRETE),
        Map.entry(Material.LIME_CONCRETE_POWDER, Material.LIME_CONCRETE),
        Map.entry(Material.MAGENTA_CONCRETE_POWDER, Material.MAGENTA_CONCRETE),
        Map.entry(Material.ORANGE_CONCRETE_POWDER, Material.ORANGE_CONCRETE),
        Map.entry(Material.PINK_CONCRETE_POWDER, Material.PINK_CONCRETE),
        Map.entry(Material.PURPLE_CONCRETE_POWDER, Material.PURPLE_CONCRETE),
        Map.entry(Material.RED_CONCRETE_POWDER, Material.RED_CONCRETE),
        Map.entry(Material.ROOTED_DIRT, Material.MUD),
        Map.entry(Material.WHITE_CONCRETE_POWDER, Material.WHITE_CONCRETE),
        Map.entry(Material.YELLOW_CONCRETE_POWDER, Material.YELLOW_CONCRETE)
    ));

    @EventHandler
    @SuppressWarnings("unused")
    public void CauldronListener(PlayerDropItemEvent dropEvent) {
        if (!transformations.containsKey(dropEvent.getItemDrop().getItemStack().getType())) return;

        CauldronRunnable cauldronRunnable = new CauldronRunnable(dropEvent.getItemDrop());

        cauldronRunnable.runTaskTimer(AlathraExtras.getInstance(), 1, 10);
    }

    @EventHandler()
    @SuppressWarnings("unused")
    public void onDropMerge(ItemMergeEvent e) {
        // Only run check on concrete powder
        if (!transformations.containsKey(e.getTarget().getItemStack().getType())) return;

        // Cancel merges and run drop logic independently to not fuckup item stacks
        e.setCancelled(true);
    }

    private static class CauldronRunnable extends BukkitRunnable {
        Item dropItem;
        Location lastItemLocation;
        Location updatedItemLocation;
        int count;

        private CauldronRunnable(Item dropItem) {
            this.dropItem = dropItem;
            lastItemLocation = null;
            count = 0;
        }

        @Override
        public void run() {
            count++;

            if (count >= 120) {
                AlathraExtras.getInstance().getLogger().info("Error: Cauldron event never terminated. " +
                    "Ending manually.");
                cancel();
                return;
            }

            if (!dropItem.isValid()) {
                cancel();
                return;
            }

            if (lastItemLocation == null) {
                lastItemLocation = dropItem.getLocation();
                return;
            }

            updatedItemLocation = dropItem.getLocation();

            if (!lastItemLocation.equals(updatedItemLocation)) {
                lastItemLocation = updatedItemLocation;
                return;
            }

            if (updatedItemLocation.getBlock().getType() != Material.WATER_CAULDRON) {
                cancel();
                return;
            }

            Block cauldron = updatedItemLocation.getBlock();

            Levelled cauldronData = (Levelled) cauldron.getBlockData();

            if (cauldronData.getLevel() > 1) {
                cauldronData.setLevel(cauldronData.getLevel() - 1);

                cauldron.setBlockData(cauldronData);
            } else if (cauldronData.getLevel() == 1){
                cauldron.setType(Material.CAULDRON);
            } else {
                cancel();
                return;
            }

            ItemStack newDropItemStack = new ItemStack(transformations.get(dropItem.getItemStack().getType()),
                dropItem.getItemStack().getAmount());

            dropItem.setItemStack(newDropItemStack);

            cancel();
        }
    }
}
