package me.ShermansWorld.AlathraExtras.tpacooldown;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownManager {
    private static final CooldownDB cooldownDB = new CooldownDB();
    private static final CooldownCache cooldownCache = new CooldownCache();
    private static final CooldownTPACache cooldownTPACache = new CooldownTPACache();
    private static CooldownManager instance;

    /**
     * Returns instance of cooldownmanager, instantiates if it doesn't exist
     *
     * @return
     */
    public static CooldownManager getInstance() {
        if (instance == null) {
            instance = new CooldownManager();
        }
        return instance;
    }

    /**
     * Save all player cooldowns to flat file storage
     */
    public static void onDisable() {
        final ConcurrentHashMap<UUID, Long> cache = CooldownCache.get();

        cache.forEach((uuid, aLong) -> {
            if (CooldownCache.isCooldownActive(uuid)) {
                CooldownDB.savePlayerData(uuid, CooldownCache.get(uuid));
                CooldownCache.remove(uuid);
            }
        });
    }
}
