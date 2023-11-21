package me.ShermansWorld.AlathraExtras;

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
        if (e.getMessage().toLowerCase().contains("nigga")) {
            e.setMessage(e.getMessage().replace("nigga", Helper.color("[Racial Slur]")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + e.getPlayer().getName() + " 3d Auto-banned for racial slur");
            Bukkit.broadcastMessage(Helper.Chatlabel() + e.getPlayer().getName() + " was bammed for saying a racial slur in chat");
        }
        if (e.getMessage().toLowerCase().contains("nigger")) {
            e.setMessage(e.getMessage().replace("nigger", Helper.color("[Racial Slur]")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + e.getPlayer().getName() + " Auto-banned for racial slur");
            Bukkit.broadcastMessage(Helper.Chatlabel() + e.getPlayer().getName() + " was bammed for saying a racial slur in chat");
        }
        if (e.getMessage().toLowerCase().contains("chink")) {
            e.setMessage(e.getMessage().replace("chink", Helper.color("[Racial Slur]")));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + e.getPlayer().getName() + " Auto-banned for racial slur");
            Bukkit.broadcastMessage(Helper.Chatlabel() + e.getPlayer().getName() + " was bammed for saying a racial slur in chat");
        }
    }
}
