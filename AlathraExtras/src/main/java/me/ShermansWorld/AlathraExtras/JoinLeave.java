package me.ShermansWorld.AlathraExtras;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        // Called when a player joins a server
        Player player = event.getPlayer();
        String joinMessage = event.getJoinMessage();
        Main.DataManager.getData(player.getUniqueId());
    }
    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        // Called when a player leaves a server
        Player player = event.getPlayer();
        String quitMessage = event.getQuitMessage();
    }
}
