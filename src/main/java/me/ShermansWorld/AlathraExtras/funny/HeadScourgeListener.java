package me.ShermansWorld.AlathraExtras.funny;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
Strikes fear righteous into their wretched hearts
 */
public class HeadScourgeListener implements Listener {
    private static final PlainTextComponentSerializer plainText = PlainTextComponentSerializer.plainText();
    private static final ArrayList<String> protectedHeads = new ArrayList<>(List.of(
        "darksaid98" // There's room for more heads here
    ));

    @EventHandler
    @SuppressWarnings("unused")
    public void onDrop(PlayerDropItemEvent e) {
        Item item = e.getItemDrop();

        if (!containsProtectedHead(item))
            return;

        Player p = e.getPlayer();

        if (p.getFireTicks() > 0)
            p.setFireTicks(0);

        p.removePotionEffect(PotionEffectType.DARKNESS);
        p.removePotionEffect(PotionEffectType.GLOWING);
        p.removePotionEffect(PotionEffectType.LEVITATION);

        if (!p.getGameMode().equals(GameMode.SURVIVAL))
            return;

        item.getScheduler().runAtFixedRate(AlathraExtras.getInstance(),
            (task) -> {
                final Location itemLocation = item.getLocation().clone();
                final Location lightningLocation = getRandomLocation(itemLocation, 5.0, 12.0);
                lightningLocation.setY(lightningLocation.getWorld().getHighestBlockYAt(lightningLocation));
                item.getWorld().strikeLightning(lightningLocation);
            },
            () -> {

            },
            120L,
            60L);
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void onPickup(EntityPickupItemEvent e) {
        Item item = e.getItem();

        if (!containsProtectedHead(item))
            return;

        if (!(e.getEntity() instanceof Player p))
            return;

        if (p.isDead())
            return;

        if (!p.getGameMode().equals(GameMode.SURVIVAL))
            return;

        final double percent = Math.random();

        if (percent > .6) { // Cook them
            p.setVelocity(p.getVelocity().add(new Vector(0, 100, 0))); // Yeet them
            p.setFireTicks(72000);
            p.addPotionEffects(
                List.of(
                    new PotionEffect(PotionEffectType.DARKNESS, PotionEffect.INFINITE_DURATION, 3, true, true, false) // More darker around
                )
            );
        } else if (percent > .0) { // Let there be light
            p.addPotionEffects(
                List.of(
                    new PotionEffect(PotionEffectType.GLOWING, PotionEffect.INFINITE_DURATION, 1, true, true, false),
                    new PotionEffect(PotionEffectType.LEVITATION, PotionEffect.INFINITE_DURATION, 4, true, true, false)
                )
            );

            final int runCountMax = new Random().nextInt(100, 150);
            AtomicInteger runCount = new AtomicInteger();
            Bukkit.getServer().getScheduler().runTaskTimer(AlathraExtras.getInstance(), (task) -> {
                runCount.getAndIncrement();

                if (!p.getInventory().contains(item.getItemStack())) {
                    task.cancel();
                    return;
                }

                if (runCount.get() >= runCountMax) {
                    task.cancel();
                    return;
                }

                p.getWorld().strikeLightning(p.getLocation());
            }, 60L, 160L);
        }
    }

    private static boolean containsProtectedHead(Item item) {
        if (!item.getItemStack().getType().equals(Material.PLAYER_HEAD))
            return false;

        final String itemName = plainText.serialize(item.getItemStack().displayName()).toLowerCase();
        for (String protectedName : protectedHeads) {
            if (itemName.contains(protectedName))
                return true;
        }
        return false;
    }

    private static Location getRandomLocation(Location origin, double minRange, double maxRange) {
        Random r = new Random();

        double randomRadius = r.nextDouble(minRange, maxRange);
        double theta = Math.toRadians(r.nextDouble() * 360);
        double phi = Math.toRadians(r.nextDouble() * 180 - 90);

        double x = randomRadius * Math.cos(theta) * Math.sin(phi);
        double y = origin.getY();
        double z = randomRadius * Math.cos(phi);

        return origin.add(x, y, z);
    }
}
