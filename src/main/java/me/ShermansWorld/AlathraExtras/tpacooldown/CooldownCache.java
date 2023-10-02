package me.ShermansWorld.AlathraExtras.tpacooldown;

import me.ShermansWorld.AlathraExtras.Helper;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class CooldownCache {
    private static final int COMMAND_COOLDOWN = 5 * 3600 * 1000; // Cooldown duration (12 hours)
    private static final ConcurrentHashMap<UUID, Long> cooldowns = new ConcurrentHashMap<>();

    /**
     * Get the blocked command message
     *
     * @param cooldownExpirationTime timestamp
     *
     * @return message
     *
     * @apiNote Check isCooldownApplicable before using this
     */
    public static String getCooldownMessage(long cooldownExpirationTime) {
        Instant expirationTime = Instant.ofEpochMilli(cooldownExpirationTime);
        final Duration duration = Duration.between(Instant.now(), expirationTime);

        // This only happens if
        if (duration.isNegative()) {
            return "";
        }

        final String durationString = ( "%s hours, %s minutes and %s seconds" ).formatted(duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());

        return Helper.color(( "&cYou can teleport again in %s." ).formatted(durationString));
    }

    /**
     * Does this timestamp still represent an active cooldown
     *
     * @param cooldownExpirationTime timestamp
     *
     * @return boolean
     */
    public static boolean isCooldownApplicable(long cooldownExpirationTime) {
        final long currentTime = Calendar.getInstance().getTimeInMillis();
        return cooldownExpirationTime > currentTime;
    }

    /**
     * Does the player have an active cooldown
     *
     * @param uuid player UUID
     *
     * @return boolean
     *
     * @apiNote Returns 0L if no cooldown was found for player
     */
    public static boolean isCooldownActive(UUID uuid) {
        final long cooldownExpirationTime = cooldowns.getOrDefault(uuid, 0L); // If exptime is zero (player has no cooldown)

        return isCooldownApplicable(cooldownExpirationTime);
    }

    /**
     * Get cooldown value for player
     *
     * @param uuid player UUID
     *
     * @return long or null
     *
     * @apiNote Returns null if player data is not in cache
     */
    public static long get(UUID uuid) {
        return cooldowns.get(uuid);
    }

    /**
     * Return entire cache
     */
    public static ConcurrentHashMap<UUID, Long> get() {
        return cooldowns;
    }

    /**
     * Add a cooldown for this player to cache
     *
     * @param uuid player UUID
     */
    public static void add(UUID uuid) {
        final long currentTime = Calendar.getInstance().getTimeInMillis();
        final long cooldownExpirationTime = currentTime + COMMAND_COOLDOWN;

        add(uuid, cooldownExpirationTime);
    }

    /**
     * Add player data to cache
     *
     * @param uuid player UUID
     * @param cooldownExpirationTime long or null
     */
    public static void add(UUID uuid, long cooldownExpirationTime) {
        cooldowns.putIfAbsent(uuid, cooldownExpirationTime);
    }

    /**
     * Yeet player data from cache
     *
     * @param uuid player UUID
     */
    public static void remove(UUID uuid) {
        cooldowns.remove(uuid);
    }
}