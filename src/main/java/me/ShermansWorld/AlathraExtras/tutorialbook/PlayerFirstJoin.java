package me.ShermansWorld.AlathraExtras.tutorialbook;

import me.ShermansWorld.AlathraExtras.misc.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {
    @EventHandler
    public void commandSent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!(p.hasPlayedBefore())) {
            p.getInventory().addItem(CustomItems.tutorialBook());
        }
    }
}
