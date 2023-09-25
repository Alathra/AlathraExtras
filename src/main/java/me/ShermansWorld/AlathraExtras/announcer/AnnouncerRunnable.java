package me.ShermansWorld.AlathraExtras.announcer;

import com.earth2me.essentials.Essentials;
import com.github.milkdrinkers.colorparser.ColorParser;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class AnnouncerRunnable extends BukkitRunnable {
    private final List<String> messages;
    private final boolean essentialsEnabled;
    private final Essentials essentials;
    private int lastMessageIndex;

    AnnouncerRunnable() {
        messages = Announcer.getConfig().getStringList("Announcer.Announcements");
        lastMessageIndex = -1;

        essentialsEnabled = AlathraExtras.getInstance().getServer().getPluginManager().isPluginEnabled("Essentials");
        essentials = (Essentials) AlathraExtras.getInstance().getServer().getPluginManager().getPlugin("Essentials");
    }

    private String randomMessage() {
        final int size = messages.size();
        final int value = new Random().nextInt(size);

        if (value != lastMessageIndex || size <= 1) {
            lastMessageIndex = value;
            return messages.get(value);
        } else {
            return randomMessage();
        }
    }

    @Override
    public void run() {
        if (!AlathraExtras.getInstance().getServer().getOnlinePlayers().isEmpty() && !messages.isEmpty()) {
            announce(randomMessage());
        }
    }

    private void announce(String message) {
        for (Player p : AlathraExtras.getInstance().getServer().getOnlinePlayers()) {
            if ((!essentialsEnabled || !essentials.getUser(p).isAfk()))
                p.sendMessage(
                    new ColorParser(message)
                        .parsePAPIPlaceholders(p)
                        .build()
                );
        }
    }
}
