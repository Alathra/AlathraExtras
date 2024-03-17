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

        // TODO Fix bug where original book gets the 'Copy' Tag

        // If player is not a Bukkit Player return
        if(!(event.getPlayer() instanceof Player player)) return;
		// Inventory is a LecternInventory
        if(event.getInventory() instanceof LecternInventory lecternInventory &&
            (!lecternInventory.isEmpty())) {
                PlayerInventory playerInventory = player.getInventory();
                if (playerInventory.getItemInMainHand().getType() == Material.BOOK && playerInventory.getItemInOffHand().getType() == Material.GLOW_INK_SAC) {
                    if (lecternInventory.getBook() == null) return;
                    // Get the book from the lectern
                    ItemStack writtenBook = lecternInventory.getBook();
                    ItemMeta writtenBookMeta = writtenBook.getItemMeta();

                    ItemStack duplicateBook = writtenBook.clone();
                    ItemMeta duplicateBookMeta = duplicateBook.getItemMeta();
                    if(duplicateBook.getType() != Material.WRITABLE_BOOK) {
                        if (duplicateBook.getItemMeta().lore() != null)
                            duplicateBookMeta.lore().add(ColorParser.of("<yellow>Copy</yellow>").build());
                        else
                            duplicateBookMeta.lore(Collections.singletonList(ColorParser.of("<yellow>Copy</yellow>").build()));
                    }
                    duplicateBook.setItemMeta(duplicateBookMeta);
                    // Make sure its just one in the itemstack
                    duplicateBook.asOne();
                    // Get the book in the players hand
                    ItemStack book = playerInventory.getItemInMainHand();
                    // Only get one
                    book.asOne();
                    // Get the glow ink sack in the offhand
                    ItemStack glowInkSack = playerInventory.getItemInOffHand();
                    //Only get one
                    glowInkSack.asOne();
                    // Schedule a task to remove the book, give them the item and add the new book.

                    writtenBook.setItemMeta(writtenBookMeta);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), () ->
                    {
                        // Check the players values again so that nothing breaks.
                        if (playerInventory.getItemInMainHand().isSimilar(book) && playerInventory.getItemInOffHand().isSimilar(glowInkSack)) {
                            // Actually remove the book and the glow ink sack, and give the written book
                            playerInventory.getItemInMainHand().setAmount(playerInventory.getItemInMainHand().getAmount() - 1);
                            playerInventory.getItemInOffHand().setAmount(playerInventory.getItemInOffHand().getAmount()-1);
                            playerInventory.addItem(duplicateBook);
                        }
                    }, 1L);
                }
        }
    }
}
