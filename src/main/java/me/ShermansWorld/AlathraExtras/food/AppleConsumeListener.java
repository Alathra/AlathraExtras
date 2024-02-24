package me.ShermansWorld.AlathraExtras.food;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class AppleConsumeListener implements Listener {

    @EventHandler
    public void ConsumeAppleEvent(PlayerItemConsumeEvent e){
        if(e.getItem().getType()== Material.GOLDEN_APPLE){
            Player p = e.getPlayer();
            p.clearActivePotionEffects();
            List<PotionEffect> potionEffectList = new ArrayList<>();
            switch (e.getItem().getItemMeta().getCustomModelData()){
                case 420 -> { // Alathran Copper Apple
                    potionEffectList.add(new PotionEffect(PotionEffectType.ABSORPTION, secondsToTicks(120), 1));
                    potionEffectList.add(new PotionEffect(PotionEffectType.REGENERATION, secondsToTicks(7), 1));
                }
                case 421 -> { // Alathran Iron Apple
                    potionEffectList.add(new PotionEffect(PotionEffectType.ABSORPTION, secondsToTicks(180), 2));
                    potionEffectList.add(new PotionEffect(PotionEffectType.REGENERATION, secondsToTicks(15), 1));
                    potionEffectList.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, secondsToTicks(60), 0));
                }
                case 422 -> { // Alathran Gold Apple
                    potionEffectList.add(new PotionEffect(PotionEffectType.ABSORPTION, secondsToTicks(180), 3));
                    potionEffectList.add(new PotionEffect(PotionEffectType.REGENERATION, secondsToTicks(25), 1));
                    potionEffectList.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, secondsToTicks(300), 0));
                    potionEffectList.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, secondsToTicks(5), 0));
                }
            }
            if(!potionEffectList.isEmpty()) p.addPotionEffects(potionEffectList);
        }
    }

    private int secondsToTicks(int ticks){
        return 20 * ticks;
    }
}


