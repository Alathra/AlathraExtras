package me.ShermansWorld.AlathraExtras.chat;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.ShermansWorld.AlathraExtras.Helper;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class ChatListener implements Listener {
    private static final PlainTextComponentSerializer plainText = PlainTextComponentSerializer.plainText();
    private static final Map<String, String> replacements;
    static {
        replacements = new HashMap<>();
        replacements.put("(?i)stoneworks", "rock function ");
        replacements.put("(?i)stone works", "rock function ");
        replacements.put("(?i)stonework", "rock function ");
        replacements.put("(?i)\\ssw\\s", "rock function ");
        replacements.put("(?i)shears", "✂");
        replacements.put("(?i)o_o", Helper.color("&9&lO_O&r"));
        replacements.put("->", "➡");
        replacements.put("<-", "⬅");
        replacements.put(":\\)", "☺");
        replacements.put(":\\(", "☹");
        replacements.put("~~", "〰");
        replacements.put("<3", Helper.color("&c❤&r"));
        replacements.put("(?i)\\^up", "⬆");
        replacements.put("<>", Helper.color("&a♢&r"));
        replacements.put("(?i)o==", Helper.color("&b☄&r"));
    }
    
    @EventHandler
    public void chatReplace(AsyncChatEvent e) {
        String msg = plainText.serialize(e.message());

        for (String s : replacements.keySet()) {
            msg = msg.replaceAll(s, replacements.get(s));
        }

        e.message(plainText.deserialize(msg));
    }
}
