package me.ShermansWorld.AlathraExtras.book;

import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class UnwritableBookClickListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().isRightClick()){
            PlayerInventory inventory = event.getPlayer().getInventory();
            //Player is holding a book in their main hand, and a written book in their offhand
            if(inventory.getItemInMainHand().getType() == Material.BOOK
                && inventory.getItemInOffHand().isSimilar(new ItemStack(Material.WRITTEN_BOOK).asOne())){
                // Take the book info from their off hand
                ItemStack book = inventory.getItemInOffHand();
                // Get the amount of books being copied from the main hand
                int unwrittenBookAmount = inventory.getItemInMainHand().getAmount();
                // Update the item stack so that it matches the number of books being copied
                book.setAmount(unwrittenBookAmount);
                // Update the inventory slot appropriately
                inventory.setItemInMainHand(book);
            } else if (inventory.getItemInOffHand().getType() == Material.BOOK
                && inventory.getItemInMainHand().isSimilar(new ItemStack(Material.WRITTEN_BOOK).asOne())){
                // Take the book info from their off hand
                ItemStack book = inventory.getItemInMainHand();
                // Get the amount of books being copied from the main hand
                int unwrittenBookAmount = inventory.getItemInOffHand().getAmount();
                // Update the item stack so that it matches the number of books being copied
                book.setAmount(unwrittenBookAmount);
                // Update the inventory slot appropriately
                inventory.setItemInOffHand(book);
            }
        }
    }
}
