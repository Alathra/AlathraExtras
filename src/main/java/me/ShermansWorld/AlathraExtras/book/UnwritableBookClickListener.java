package me.ShermansWorld.AlathraExtras.book;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class UnwritableBookClickListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        // Check that the player sneak right clicked a lectern
        Player player = event.getPlayer();
        if(event.getAction().isRightClick() && player.isSneaking() &&
            (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.LECTERN)){
                Lectern lectern = (Lectern) event.getClickedBlock();
                // Check that the lectern isn't empty and that the player is holding a book while having >50 experience points
                if(!lectern.getInventory().isEmpty() &&
                    (player.getInventory().getItemInMainHand().getType() == Material.BOOK &&
                        player.getTotalExperience() > 50)){
                        // Get the book from the lectern
                        ItemStack writtenBook = lectern.getSnapshotInventory().getItem(lectern.getSnapshotInventory().first(Material.WRITTEN_BOOK));
                        if(writtenBook==null) return;
                        // Make sure its just one in the itemstack
                        writtenBook.asOne();
                        // Get the book in the players hand
                        ItemStack book = player.getInventory().getItemInMainHand();
                        // Only get one
                        book.asOne();
                        // Schedule a task to remove the book, give them the item and add the new book.
                        Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), ()->
                        {
                            // Check the players values again so that nothing breaks.
                            if(player.getTotalExperience() > 50 && player.getInventory().contains(book)) {
                                player.getInventory().remove(book);
                                player.giveExp(-50);
                                player.getInventory().addItem(writtenBook);
                            }
                        }, 1L);
                }

        }
    }
}
