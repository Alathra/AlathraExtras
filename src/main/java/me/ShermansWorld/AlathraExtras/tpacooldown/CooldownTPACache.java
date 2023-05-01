package me.ShermansWorld.AlathraExtras.tpacooldown;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownTPACache {
    private static final ConcurrentHashMap<UUID, Long> teleporting = new ConcurrentHashMap<>(); // Tracks players that are in teleport warmup

    public static void teleportingAdd(UUID uuid, long val) {
        teleporting.put(uuid, val);
    }

    public static long teleportingGet(UUID uuid) {
        return teleporting.getOrDefault(uuid, 0L);
    }

    public static void teleportingRemove(UUID uuid) {
        teleporting.remove(uuid);
    }

    public static void teleportingRemove(UUID uuid, long val) {
        teleporting.remove(uuid, val);
    }
}
