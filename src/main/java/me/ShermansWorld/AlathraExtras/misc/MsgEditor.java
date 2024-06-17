package me.ShermansWorld.AlathraExtras.misc;

import com.github.milkdrinkers.colorparser.ColorParser;
import net.ess3.api.events.PrivateMessagePreSendEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MsgEditor implements Listener {
    @EventHandler
    public void craftEvent(PrivateMessagePreSendEvent e) {
        // if the player has a nickname
        if (!e.getSender().getDisplayName().contains(e.getSender().getName())) {
            String recipientMsg = ColorParser.of("&7&o" + e.getSender().getName() + " has messaged you")
                .parseLegacy().build().toString();
            e.getRecipient().sendMessage(recipientMsg);
        }
    }
}	
