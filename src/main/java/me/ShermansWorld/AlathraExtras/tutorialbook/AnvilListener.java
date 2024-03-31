package me.ShermansWorld.AlathraExtras.tutorialbook;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.items.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class AnvilListener implements Listener {
    @EventHandler
    public void commandSent(PrepareAnvilEvent e) {
        if (e.getInventory().getItem(0) != null) {
            if (e.getInventory().getItem(0).isSimilar(Items.tutorialBook())) {
                Player p = (Player) e.getView().getPlayer();
                p.closeInventory();
                p.sendMessage(Helper.Chatlabel() + Helper.color("&cYou cannot put the Player's Guide in an anvil!"));

            }
        }
    }
}
