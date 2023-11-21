package me.ShermansWorld.AlathraExtras.misc;

import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class CraftingListener implements Listener {
    @EventHandler
    public void craftEvent(CraftItemEvent e) {
        if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.tutorialBook())) {
            e.getWhoClicked()
                .sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with the Player's Guide!"));
            e.setCancelled(true);
        } else if (Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getBeetrootPouch())
            || Arrays.asList(e.getInventory().getStorageContents()).contains(CustomItems.getCarrotPouch())) {
            if (!e.getCurrentItem().equals(CustomItems.getBeetrootPouch()) || e.getCurrentItem().equals(CustomItems.getCarrotPouch())) {
                if (!e.getRecipe().getResult().equals(new ItemStack(Material.BEETROOT, 9))
                    && !e.getRecipe().getResult().equals(new ItemStack(Material.CARROT, 9))
                    && !e.getRecipe().getResult().equals(new ItemStack(Material.POTATO, 9))
                    && !e.getRecipe().getResult().equals(CustomItems.getBeetrootPouch())
                    && !e.getRecipe().getResult().equals(CustomItems.getCarrotPouch())
                    && !e.getRecipe().getResult().equals(CustomItems.getPotatoPouch())) {
                    e.getWhoClicked().sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot craft with this item!"));
                    e.setCancelled(true);
                }
            }
        }
    }
}
