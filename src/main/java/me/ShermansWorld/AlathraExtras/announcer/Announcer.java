package me.ShermansWorld.AlathraExtras.announcer;

import de.leonhard.storage.Config;
import me.ShermansWorld.AlathraExtras.Main;
import org.bukkit.scheduler.BukkitTask;

public class Announcer {
    private static Announcer instance;
    private static Config cfg;
    private BukkitTask task;

    /**
     * Returns instance of Announcer, instantiates if it doesn't exist
     *
     * @return Announcer
     */
    public static Announcer getInstance() {
        if (instance == null) {
            instance = new Announcer();
        }
        return instance;
    }

    protected static Config getConfig() {
        return cfg;
    }

    public void onLoad() {
        cfg = new Config("announcer", Main.getInstance().getDataFolder().getPath(), Main.getInstance().getResource("announcer.yml"));
    }

    public void onEnable() {
        task = new AnnouncerRunnable()
            .runTaskTimerAsynchronously(Main.getInstance(), 0, (20L * cfg.getInt("Announcer.Interval")));
    }

    public void onDisable() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }
}
