package me.ShermansWorld.AlathraExtras.chat;

import me.ShermansWorld.AlathraExtras.Helper;
import net.ess3.api.events.PrivateMessagePreSendEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EssentialsMsgEditor implements Listener {
    @EventHandler
    public void onEssentialsMsg(PrivateMessagePreSendEvent e) {
        // if the player has a nickname
        if (!e.getSender().getDisplayName().contains(e.getSender().getName())) {
            String recipientMsg = Helper.color("&7&o" + e.getSender().getName() + " has messaged you");
            e.getRecipient().sendMessage(recipientMsg);
        }
    }
}	
