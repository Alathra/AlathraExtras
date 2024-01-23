package me.ShermansWorld.AlathraExtras.npcs;

import net.citizensnpcs.api.event.NPCSpawnEvent;
import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

public class NPCListener implements Listener {

    @EventHandler
    public void NPCSpawnListener(NPCSpawnEvent e) {
        if (e.getNPC().getId() == bossItemMerchantNPC.ID){
            bossItemMerchantNPC.teleportMerchant();
        }
    }
}
