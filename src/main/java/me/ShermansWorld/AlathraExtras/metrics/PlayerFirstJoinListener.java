package me.ShermansWorld.AlathraExtras.metrics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoinListener implements Listener {
    private static int newJoins = 0;

    @EventHandler
    private static void onPlayerJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPlayedBefore()) return;

        increment();
    }

    private static void increment() {
        newJoins++;
    }

    public static int getNewJoins() {
        return newJoins;
    }
}
