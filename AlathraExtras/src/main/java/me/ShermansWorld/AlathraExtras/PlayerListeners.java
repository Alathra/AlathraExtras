package me.ShermansWorld.AlathraExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class PlayerListeners implements Listener {

	@EventHandler
	public void cancelRiptide(PlayerMoveEvent event) {
		if (event.getPlayer().isRiptiding() && event.getPlayer().getWorld().getName().equals("event_world")) {
			event.getPlayer().setVelocity(new Vector(0, 0, 0));
		}
	}

	@EventHandler
	public void chatReplace(PlayerChatEvent e) {
		if (e.getMessage().toLowerCase().contains("stoneworks")) {
			e.setMessage(e.getMessage().toLowerCase().replace("stoneworks", "inferior Minecraft server"));
		}
		if (e.getMessage().toLowerCase().contains("stone works")) {
			e.setMessage(e.getMessage().toLowerCase().replace("stone works", "inferior Minecraft server"));
		}
		if (e.getMessage().toLowerCase().contains(" sw ")) {
			e.setMessage(e.getMessage().toLowerCase().replace(" sw ", " inferior Minecraft server "));
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
