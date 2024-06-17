package me.ShermansWorld.AlathraExtras;

import com.github.milkdrinkers.colorparser.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerListeners implements Listener {

    @EventHandler
    public void cancelRiptide(PlayerMoveEvent event) {
        if (event.getPlayer().isRiptiding() && event.getPlayer().getWorld().getName().equals("event_world")) {
            event.getPlayer().setVelocity(new Vector(0, 0, 0));
        }
    }

    @EventHandler @SuppressWarnings("deprecation")
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
            e.setMessage(e.getMessage().replace("o_o", ColorParser.of("&9&lO_O&r").parseLegacy().build().toString()));
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
            e.setMessage(e.getMessage().replace("<3", ColorParser.of("&c❤&r").parseLegacy().build().toString()));
        }
        if (e.getMessage().toLowerCase().contains("<>")) {
            e.setMessage(e.getMessage().replace("<>", ColorParser.of("&a♢&r").parseLegacy().build().toString()));
        }
        if (e.getMessage().toLowerCase().contains("^up")) {
            e.setMessage(e.getMessage().toLowerCase().replace("^up", "⬆"));
        }
        if (e.getMessage().toLowerCase().contains("<>")) {
            e.setMessage(e.getMessage().replace("<>", ColorParser.of("&a♢&r").parseLegacy().build().toString()));
        }
        if (e.getMessage().toLowerCase().contains("o==")) {
            e.setMessage(e.getMessage().replace("o==", ColorParser.of("&b☄&r").parseLegacy().build().toString()));
        }
        if (e.getMessage().toLowerCase().contains("nigga")) {
            e.setMessage(e.getMessage().replace("nigga", ColorParser.of("[Racial Slur]").build().toString()));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + e.getPlayer().getName() + " 3d Auto-banned for racial slur");
            Bukkit.broadcast(ColorParser.of(Helper.Chatlabel() + e.getPlayer().getName() + " was banned for saying a racial slur in chat").parseLegacy().build());
        }
        if (e.getMessage().toLowerCase().contains("nigger")) {
            e.setMessage(e.getMessage().replace("nigger", ColorParser.of("[Racial Slur]").build().toString()));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + e.getPlayer().getName() + " Auto-banned for racial slur");
            Bukkit.broadcast(ColorParser.of(Helper.Chatlabel() + e.getPlayer().getName() + " was banned for saying a racial slur in chat").parseLegacy().build());
        }
        if (e.getMessage().toLowerCase().contains("chink")) {
            e.setMessage(e.getMessage().replace("chink", ColorParser.of("[Racial Slur]").build().toString()));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + e.getPlayer().getName() + " Auto-banned for racial slur");
            Bukkit.broadcast(ColorParser.of(Helper.Chatlabel() + e.getPlayer().getName() + " was banned for saying a racial slur in chat").parseLegacy().build());
        }
    }
}
