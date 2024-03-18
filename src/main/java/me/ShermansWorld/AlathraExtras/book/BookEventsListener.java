package me.ShermansWorld.AlathraExtras.book;

import com.github.alathra.siegeengines.libs.colorparser.ColorParser;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class BookEventsListener implements Listener {
    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent e) {
        if(e.isSigning()){
            BookMeta bookMeta = e.getPreviousBookMeta();
            List<Component> list = new java.util.ArrayList<>(Collections.emptyList());

            Calendar currentDate = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            TimeZone obj = TimeZone.getTimeZone("UTC");

            formatter.setTimeZone(obj);
            list.add(ColorParser.of("<white>Signed by %s</white>".formatted(e.getPlayer().getName())).build());
            list.add(ColorParser.of("<white>" + formatter.format(currentDate.getTime()) + " UTC</white>").build());
            bookMeta.lore(list);
            e.setNewBookMeta(bookMeta);
        }
    }
}
