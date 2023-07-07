package me.ShermansWorld.AlathraExtras.joinleavemessages;

import de.leonhard.storage.Config;
import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.joinleavemessages.listener.ListenerHandler;

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
        cfg = new Config("joinleavemessages", Main.getInstance().getDataFolder().getPath(), Main.getInstance().getResource("joinleavemessages.yml"));
        listenerHandler = new ListenerHandler(cfg);
    }

    public void onEnable() {
        listenerHandler.onEnable();
    }

    public void onDisable() {
        listenerHandler.onDisable();
    }
}
