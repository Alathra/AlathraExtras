package me.ShermansWorld.AlathraExtras.book;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
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

        //TODO Come up with alternative cost for Book duplication (new item? or feather?)
        //TODO Make sure Books and Quills can be duplicated as well

        // If player is not a Bukkit Player return
        if(!(event.getPlayer() instanceof Player player)) return;
		// Inventory is a LecternInventory
        if(event.getInventory() instanceof LecternInventory lecternInventory &&
            (!lecternInventory.isEmpty())) {
                PlayerInventory playerInventory = player.getInventory();
                if (playerInventory.getItemInMainHand().getType() == Material.BOOK) {
                    if (lecternInventory.getBook() == null) return;
                    // Get the book from the lectern
                    ItemStack writtenBook = lecternInventory.getBook();

                    ItemMeta writtenBookMeta = writtenBook.getItemMeta();
                    if(writtenBook.getItemMeta().lore() != null)
                        writtenBookMeta.lore().add(ColorParser.of("<yellow>Copy</yellow>").build());
                    else
                        writtenBookMeta.lore(Collections.singletonList(ColorParser.of("<yellow>Copy</yellow>").build()));
                    writtenBook.setItemMeta(writtenBookMeta);

                    // Make sure its just one in the itemstack
                    writtenBook.asOne();
                    // Get the book in the players hand
                    ItemStack book = playerInventory.getItemInMainHand();
                    // Only get one
                    book.asOne();
                    // Schedule a task to remove the book, give them the item and add the new book.
                    Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), () ->
                    {
                        // Check the players values again so that nothing breaks.
                        if (playerInventory.getItemInMainHand().isSimilar(book)) {
                            // Actually remove the book, and give the written book
                            playerInventory.getItemInMainHand().setAmount(playerInventory.getItemInMainHand().getAmount() - 1);
                            playerInventory.addItem(writtenBook);
                        }
                    }, 1L);


                }

        }
    }


}
