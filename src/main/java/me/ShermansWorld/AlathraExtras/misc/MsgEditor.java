package me.ShermansWorld.AlathraExtras.misc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.ShermansWorld.AlathraExtras.Helper;
import net.ess3.api.events.PrivateMessagePreSendEvent;

public class MsgEditor implements Listener {
	@EventHandler
	public static void craftEvent(PrivateMessagePreSendEvent e) {
		// if the player has a nickname
		if (!e.getSender().getDisplayName().contains(e.getSender().getName())) {
			String recipientMsg = Helper.color("&6[&f" + e.getSender().getName() + " &6-> &cme&6]");
			e.getRecipient().sendMessage(recipientMsg);
		}
	}
}	
