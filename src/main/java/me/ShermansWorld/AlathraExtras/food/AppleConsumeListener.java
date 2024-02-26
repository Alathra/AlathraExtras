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
                case 420 -> { // Uncharged Copper Apple
                    potionEffectList.add(new PotionEffect(PotionEffectType.NIGHT_VISION, minutesToTicks(15), 0));
                    potionEffectList.add(new PotionEffect(PotionEffectType.FAST_DIGGING, minutesToTicks(15), 2));
                    potionEffectList.add(new PotionEffect(PotionEffectType.WEAKNESS, minutesToTicks(15), 0));
                }
                case 421 -> { // Charged Copper Apple
                    potionEffectList.add(new PotionEffect(PotionEffectType.NIGHT_VISION, minutesToTicks(30), 0));
                    potionEffectList.add(new PotionEffect(PotionEffectType.FAST_DIGGING, minutesToTicks(30), 3));
                    potionEffectList.add(new PotionEffect(PotionEffectType.WEAKNESS, minutesToTicks(30), 0));
                    p.damage(2);
                }
			}
            if(!potionEffectList.isEmpty()) p.addPotionEffects(potionEffectList);
        }
    }

    //TODO: Write Listener for when uncharged copper apple is struck by lightning

    private int minutesToTicks(int mins){
        return secondsToTicks(mins * 60);
    }
    private int secondsToTicks(int ticks){
        return 20 * ticks;
    }
}


