package me.ShermansWorld.AlathraExtras.chat.joinleavemessages;

import com.github.milkdrinkers.Crate.Config;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.chat.joinleavemessages.listener.ListenerHandler;

public class JoinLeaveMessages {
    private static JoinLeaveMessages instance;
    private static Config cfg;
    private static ListenerHandler listenerHandler;

    /**
     * Returns instance of JoinLeaveMessages, instantiates if it doesn't exist
     *
     * @return JoinLeaveMessages
     */
    public static JoinLeaveMessages getInstance() {
        if (instance == null) {
            instance = new JoinLeaveMessages();
        }
        return instance;
    }

    public static Config getConfig() {
        return cfg;
    }

    public void onLoad() {
        cfg = new Config("joinleavemessages", AlathraExtras.getInstance().getDataFolder().getPath(), AlathraExtras.getInstance().getResource("joinleavemessages.yml"));
        listenerHandler = new ListenerHandler(cfg);
    }

    public void onEnable() {
        listenerHandler.onEnable();
    }

    public void onDisable() {
        listenerHandler.onDisable();
    }
}
