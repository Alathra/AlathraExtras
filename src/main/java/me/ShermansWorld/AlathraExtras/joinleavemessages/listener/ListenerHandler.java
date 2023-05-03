package me.ShermansWorld.AlathraExtras.joinleavemessages.listener;

import de.leonhard.storage.Config;
import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.joinleavemessages.listener.player.PlayerJoinListener;
import me.ShermansWorld.AlathraExtras.joinleavemessages.listener.player.PlayerQuitListener;

public class ListenerHandler {
    private final Config cfg;

    public ListenerHandler(Config cfg) {
        this.cfg = cfg;
    }

    public void onEnable() {
        if (cfg.getOrDefault("Joining.Enabled", false))
            Main.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinListener(), Main.getInstance());

        if (cfg.getOrDefault("Leaving.Enabled", false))
            Main.getInstance().getServer().getPluginManager().registerEvents(new PlayerQuitListener(), Main.getInstance());
    }

    public void onDisable() {
        if (cfg.getOrDefault("Joining.Enabled", false))
            PlayerJoinListener.unregister();

        if (cfg.getOrDefault("Leaving.Enabled", false))
            PlayerQuitListener.unregister();
    }
}
