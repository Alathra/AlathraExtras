package me.ShermansWorld.AlathraExtras.book;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.LecternInventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class UnwritableBookClickListener implements Listener {

    @EventHandler
    public void onInteract(InventoryOpenEvent event){
        // If player is not a Bukkit Player return
        if(!(event.getPlayer() instanceof Player player)) return;
		// Inventory is a LecternInventory
        if(event.getInventory() instanceof LecternInventory lecternInventory &&
            (!lecternInventory.isEmpty())) {

            PlayerInventory playerInventory = player.getInventory();
            ItemStack itemInMainHand = playerInventory.getItemInMainHand();
            ItemStack itemInOffHand = playerInventory.getItemInOffHand();

            if (itemInMainHand.getType() == Material.BOOK && itemInOffHand.getType() == Material.GLOW_INK_SAC) {
                    if (lecternInventory.getBook() == null) return;
                    // Get the book from the lectern
                    ItemStack writtenBook = lecternInventory.getBook();
                    ItemMeta writtenBookMeta = writtenBook.getItemMeta();

                    ItemStack duplicateBook = writtenBook.clone();
                    // Make sure its just one in the itemstack
                    duplicateBook.setAmount(1);
                    // Get the book in the players hand
                    ItemStack book = itemInMainHand;
                    // Only get one
                    book.asOne();
                    // Get the glow ink sack in the offhand
                    ItemStack glowInkSack = itemInOffHand;
                    // Schedule a task to remove the book, give them the item and add the new book.

                    writtenBook.setItemMeta(writtenBookMeta);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), () ->
                    {
                        // Check the players values again so that nothing breaks.
                        if (itemInMainHand.isSimilar(book) && itemInOffHand.isSimilar(glowInkSack)) {
                            // Actually remove the book and the glow ink sack, and give the written book
                            itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
                            itemInOffHand.setAmount(itemInOffHand.getAmount() - 1);
                            playerInventory.addItem(duplicateBook);
                        }
                    }, 1L);
                }
        }
    }
}
