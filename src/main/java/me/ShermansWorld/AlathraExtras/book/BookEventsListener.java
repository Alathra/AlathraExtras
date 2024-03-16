package me.ShermansWorld.AlathraExtras.book;

import com.github.alathra.siegeengines.libs.colorparser.ColorParser;

import io.lumine.mythic.bukkit.utils.time.Time;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BookEventsListener implements Listener {

    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent e) {
        if(e.isSigning()){
            BookMeta bookMeta = e.getNewBookMeta();
            List<Component> bookLore = bookMeta.hasLore() ? bookMeta.lore() : Collections.emptyList();
            Component dateLore = ColorParser.of("<white>" + Date.from(Time.now()).toString() + "</white>").build();
            if(bookLore != null ) {
                bookLore.add(dateLore);
                bookMeta.lore(bookLore);
                e.setNewBookMeta(bookMeta);
            }
        }
    }
}
