package me.ShermansWorld.AlathraExtras.chat;

import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void chatReplace(AsyncPlayerChatEvent e) {
        if (e.getMessage().toLowerCase().contains("stoneworks")) {
            e.setMessage(e.getMessage().toLowerCase().replace("stoneworks", "rock function "));
        }
        if (e.getMessage().toLowerCase().contains("stone works")) {
            e.setMessage(e.getMessage().toLowerCase().replace("stone works", "rock function "));
        }
        if (e.getMessage().toLowerCase().contains("stonework")) {
            e.setMessage(e.getMessage().toLowerCase().replace("stonework", "rock function "));
        }
        if (e.getMessage().toLowerCase().contains(" sw ")) {
            e.setMessage(e.getMessage().toLowerCase().replace(" sw ", "rock function "));
        }
        if (e.getMessage().toLowerCase().contains("shears")) {
            e.setMessage(e.getMessage().toLowerCase().replace("shears", "✂"));
        }
        if (e.getMessage().toLowerCase().contains("o_o")) {
            e.setMessage(e.getMessage().replace("o_o", Helper.color("&9&lO_O&r")));
        }
        if (e.getMessage().toLowerCase().contains("->")) {
            e.setMessage(e.getMessage().replace("->", "➡"));
        }
        if (e.getMessage().toLowerCase().contains("<-")) {
            e.setMessage(e.getMessage().replace("<-", "⬅"));
        }
        if (e.getMessage().toLowerCase().contains(":)")) {
            e.setMessage(e.getMessage().replace(":)", "☺"));
        }
        if (e.getMessage().toLowerCase().contains(":(")) {
            e.setMessage(e.getMessage().replace(":(", "☹"));
        }
        if (e.getMessage().toLowerCase().contains("~~")) {
            e.setMessage(e.getMessage().replace("~~", "〰"));
        }
        if (e.getMessage().toLowerCase().contains("<3")) {
            e.setMessage(e.getMessage().replace("<3", Helper.color("&c❤&r")));
        }
        if (e.getMessage().toLowerCase().contains("<>")) {
            e.setMessage(e.getMessage().replace("<>", Helper.color("&a♢&r")));
        }
        if (e.getMessage().toLowerCase().contains("^up")) {
            e.setMessage(e.getMessage().toLowerCase().replace("^up", "⬆"));
        }
        if (e.getMessage().toLowerCase().contains("<>")) {
            e.setMessage(e.getMessage().replace("<>", Helper.color("&a♢&r")));
        }
        if (e.getMessage().toLowerCase().contains("o==")) {
            e.setMessage(e.getMessage().replace("o==", Helper.color("&b☄&r")));
        }
    }
}
