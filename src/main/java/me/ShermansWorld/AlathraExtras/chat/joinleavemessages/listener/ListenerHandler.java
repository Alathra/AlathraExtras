package me.ShermansWorld.AlathraExtras.chat.joinleavemessages.listener;

import com.github.milkdrinkers.Crate.Config;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.chat.joinleavemessages.listener.player.PlayerJoinListener;
import me.ShermansWorld.AlathraExtras.chat.joinleavemessages.listener.player.PlayerQuitListener;

public class ListenerHandler {
    private final Config cfg;

    public ListenerHandler(Config cfg) {
        this.cfg = cfg;
    }

    public void onEnable() {
        if (cfg.getOrDefault("Joining.Enabled", false))
            AlathraExtras.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinListener(), AlathraExtras.getInstance());

        if (cfg.getOrDefault("Leaving.Enabled", false))
            AlathraExtras.getInstance().getServer().getPluginManager().registerEvents(new PlayerQuitListener(), AlathraExtras.getInstance());
    }

    public void onDisable() {
        if (cfg.getOrDefault("Joining.Enabled", false))
            PlayerJoinListener.unregister();

        if (cfg.getOrDefault("Leaving.Enabled", false))
            PlayerQuitListener.unregister();
    }
}
