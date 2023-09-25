package me.ShermansWorld.AlathraExtras.joinleavemessages.listener.player;

import com.earth2me.essentials.Essentials;
import de.leonhard.storage.Config;
import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.joinleavemessages.JoinLeaveMessages;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayerQuitListener implements Listener {
    private static PlayerQuitListener listener;
    private final Config cfg = JoinLeaveMessages.getConfig();
    private final String messagePrefix = cfg.getOrDefault("Leaving.Prefix", "");
    private final HashMap<String, List<String>> messagesLeave = new HashMap<>();
    private final boolean essentialsLoaded = AlathraExtras.getInstance().getServer().getPluginManager().isPluginEnabled("Essentials");
    private final Essentials essentials = (Essentials) AlathraExtras.getInstance().getServer().getPluginManager().getPlugin("Essentials");
    private final Random random = new Random();

    public PlayerQuitListener() {
        listener = this;

        // Load normal leave messages from groups and register permission nodes
        final Map<String, List<String>> groupNames = cfg.getMapParameterized("Leaving.Messages");
        messagesLeave.putAll(groupNames);
        messagesLeave.forEach((groupName, messages) -> Bukkit.getPluginManager().addPermission(new Permission(( "alathraextras.leave.%s" ).formatted(groupName))));
    }

    /**
     * Unregister all listeners defined in the class
     */
    public static void unregister() {
        PlayerQuitEvent.getHandlerList().unregister(listener);
    }

    /**
     * Get the message prefix with a space after if prefix is set
     *
     * @return prefix
     */
    private String getMessagePrefix() {
        return ( !messagePrefix.isEmpty() ? ( "%s " ).formatted(messagePrefix) : "" );
    }

    /**
     * Get a random message for player
     *
     * @param p player
     * @param messages List of messages
     *
     * @return message
     */
    private String getRandomMessageFromList(Player p, List<String> messages) {
        return Helper.color(getMessagePrefix() + PlaceholderAPI.setPlaceholders(p, messages.get(random.nextInt(messages.size()))));
    }

    /**
     * Get messages for one of the players' groups
     *
     * @param p player
     *
     * @return List of messages or null
     */
    private List<String> getMessageFromPlayerGroup(Player p) {
        for (Map.Entry<String, List<String>> set : messagesLeave.entrySet()) {
            if (p.hasPermission(( "alathraextras.leave.%s" ).formatted(set.getKey()))) {
                return set.getValue();
            }
        }
        return null;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        final Player p = e.getPlayer();

        String msg = null;

        if (!essentialsLoaded || !essentials.getUser(p).isHidden()) { // Check vanish
            final List<String> messages = getMessageFromPlayerGroup(p);
            if (messages != null) {
                msg = getRandomMessageFromList(p, messages);
            }
        }

        e.setQuitMessage(msg);
    }
}
