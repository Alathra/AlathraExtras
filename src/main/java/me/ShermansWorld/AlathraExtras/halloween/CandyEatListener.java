package me.ShermansWorld.AlathraExtras.halloween;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CandyEatListener implements Listener {

    @EventHandler
    public void onCandyEat(PlayerItemConsumeEvent e) {
        if (!e.getItem().hasItemMeta()) {
            return;
        }
        if (e.getItem().getType().equals(Material.COOKIE)) {
            switch (e.getItem().getItemMeta().getCustomModelData()) {
                // candy candy
                case 14700:
                    // 5 seconds of night vision 1
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 0));
                    break;
                // lollipop candy
                case 14701:
                    // 2 seconds of jump boost 2
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 2));
                    break;
                // chocolate candy
                case 14702:
                    // 2 seconds of jump boost 2
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 4));
                    break;
                default:
                    break;
            }
        } else {
            return;
        }
    }
}
