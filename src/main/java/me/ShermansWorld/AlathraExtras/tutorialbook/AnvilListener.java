package me.ShermansWorld.AlathraExtras.tutorialbook;

import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.items.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilListener implements Listener {
    @EventHandler
    public void commandSent(PrepareAnvilEvent e) {
        if (e.getInventory().getItem(0) != null) {
            ItemStack eItem = e.getInventory().getItem(0);

            if (eItem == null) return;

            if (eItem.isSimilar(Items.tutorialBook())) {
                Player p = (Player) e.getView().getPlayer();
                p.closeInventory();
                p.sendMessage(ColorParser.of(Helper.Chatlabel() + "&cYou cannot put the Player's Guide in an anvil!").parseLegacy().build());

            }
        }
    }
}
