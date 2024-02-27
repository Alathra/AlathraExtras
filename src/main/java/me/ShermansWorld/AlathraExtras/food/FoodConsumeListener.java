package me.ShermansWorld.AlathraExtras.food;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class FoodConsumeListener implements Listener {
    private List<PotionEffect> unchargedCopperMelonPotionEffects = List.of(
        new PotionEffect(PotionEffectType.NIGHT_VISION, minutesToTicks(15), 0),
        new PotionEffect(PotionEffectType.FAST_DIGGING, minutesToTicks(15), 2),
        new PotionEffect(PotionEffectType.WEAKNESS, minutesToTicks(15), 0)
    );
    private List<PotionEffect> chargedCopperMelonPotionEffects = List.of(
        new PotionEffect(PotionEffectType.NIGHT_VISION, minutesToTicks(30), 0),
        new PotionEffect(PotionEffectType.FAST_DIGGING, minutesToTicks(30), 3),
        new PotionEffect(PotionEffectType.WEAKNESS, minutesToTicks(30), 0)
    );

    @EventHandler
    public void ConsumeFruitEvent(PlayerItemConsumeEvent e){
        ItemStack i = e.getItem();
        if(i.getType()== Material.GOLDEN_APPLE){
            Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), () -> {
				Player p = e.getPlayer();
				List<PotionEffect> potionEffectList = new ArrayList<>();
					switch (i.getItemMeta().getCustomModelData()) {
                        case 420 -> { // Uncharged Silver Fruit
                            p.clearActivePotionEffects();
                            potionEffectList.addAll(unchargedCopperMelonPotionEffects);
                        }
                        case 421 -> { // Charged Silver Fruit
                            p.clearActivePotionEffects();
                            potionEffectList.addAll(chargedCopperMelonPotionEffects);
                            p.damage(4.0);
                        }
				    }
					if (!potionEffectList.isEmpty()) p.addPotionEffects(potionEffectList);
				}, 2L
            );
        }
    }

    private int minutesToTicks(int mins){
        return secondsToTicks(mins * 60);
    }
    private int secondsToTicks(int ticks){
        return 20 * ticks;
    }
}


