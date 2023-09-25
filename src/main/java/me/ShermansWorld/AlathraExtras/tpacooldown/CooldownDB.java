package me.ShermansWorld.AlathraExtras.tpacooldown;

import de.leonhard.storage.Json;
import de.leonhard.storage.internal.settings.ReloadSettings;
import me.ShermansWorld.AlathraExtras.AlathraExtras;

import java.io.File;
import java.util.UUID;

/**
 * This class can be easily modified to serializing/deserialize
 * some sort of player data object if we want to store more data
 */
public class CooldownDB {
    private static Json db; // Simplix-storage

    CooldownDB() {
        // Initialize database
        db = new Json("cooldowns_db", AlathraExtras.getInstance().getDataFolder().getPath() + File.separator + "database", AlathraExtras.getInstance().getResource("cooldowns_db.json"));
        db.setReloadSettings(ReloadSettings.INTELLIGENT);
    }

    /**
     * Fetch data for player from DB
     *
     * @param uuid player uuid
     *
     * @return defaults to  0.0
     */
    public static long getPlayerData(UUID uuid) {
        return db.getLong(uuid.toString());
    }

    /**
     * Save data for player to DB, overwrites existing player data
     *
     * @param uuid player uuid
     * @param cooldownExpirationTime long
     */
    public static void savePlayerData(UUID uuid, long cooldownExpirationTime) {
        db.set(uuid.toString(), cooldownExpirationTime);
    }

    /**
     * Removes data for player in the DB
     *
     * @param uuid player uuid
     */
    public static void clearPlayerData(UUID uuid) {
        db.remove(uuid.toString());
    }
}
