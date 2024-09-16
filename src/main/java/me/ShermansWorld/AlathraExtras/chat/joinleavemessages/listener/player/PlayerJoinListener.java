package me.ShermansWorld.AlathraExtras.chat.joinleavemessages.listener.player;

import com.earth2me.essentials.Essentials;
import com.github.milkdrinkers.Crate.Config;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.chat.joinleavemessages.JoinLeaveMessages;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.Permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayerJoinListener implements Listener {
    private static PlayerJoinListener listener;
    private final Config cfg = JoinLeaveMessages.getConfig();
    private final String messagePrefix = cfg.getOrDefault("Joining.Prefix", "");
    private final HashMap<String, List<String>> messagesJoin = new HashMap<>();
    private final List<String> messagesFirstJoin = cfg.getStringList("Joining.Welcome");
    private final boolean essentialsLoaded = AlathraExtras.getInstance().getServer().getPluginManager().isPluginEnabled("Essentials");
    private final Essentials essentials = (Essentials) AlathraExtras.getInstance().getServer().getPluginManager().getPlugin("Essentials");
    private final Random random = new Random();

    public PlayerJoinListener() {
        listener = this;

        // Load normal join messages from groups and register permission nodes
        final Map<String, List<String>> groupNames = cfg.getMapParameterized("Joining.Messages");
        messagesJoin.putAll(groupNames);
        messagesJoin.forEach((groupName, messages) -> Bukkit.getPluginManager().addPermission(new Permission(("alathraextras.join.%s").formatted(groupName))));
    }

    /**
     * Unregister all listeners defined in the class
     */
    public static void unregister() {
        PlayerJoinEvent.getHandlerList().unregister(listener);
    }

    /**
     * Get the message prefix with a space after if prefix is set
     *
     * @return prefix
     */
    private String getMessagePrefix() {
        return (!messagePrefix.isEmpty() ? ("%s ").formatted(messagePrefix) : "");
    }

    /**
     * Get a random message for player
     *
     * @param p player
     * @return message
     */
    private String getRandomFirstJoinMessage(Player p) {
        return Helper.color(getMessagePrefix() + PlaceholderAPI.setPlaceholders(p, messagesFirstJoin.get(random.nextInt(messagesFirstJoin.size()))));
    }

    /**
     * Get a random message for player
     *
     * @param p        player
     * @param messages List of messages
     * @return message
     */
    private String getRandomMessageFromList(Player p, List<String> messages) {
        return Helper.color(getMessagePrefix() + PlaceholderAPI.setPlaceholders(p, messages.get(random.nextInt(messages.size()))));
    }

    /**
     * Get messages for one of the players' groups
     *
     * @param p player
     * @return List of messages or null
     */
    private List<String> getMessageFromPlayerGroup(Player p) {
        for (Map.Entry<String, List<String>> set : messagesJoin.entrySet()) {
            if (p.hasPermission(("alathraextras.join.%s").formatted(set.getKey()))) {
                return set.getValue();
            }
        }
        return null;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        String msg = null;

        if (!essentialsLoaded || !essentials.getUser(p).isHidden()) { // Check vanish
            if (!p.hasPlayedBefore()) { // First join message
                msg = getRandomFirstJoinMessage(p);
            } else { // Normal message
                final List<String> messages = getMessageFromPlayerGroup(p);
                if (messages != null) {
                    msg = getRandomMessageFromList(p, messages);
                }
            }
        }

        e.setJoinMessage(msg);
    }
}
