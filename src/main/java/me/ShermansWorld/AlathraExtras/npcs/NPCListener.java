package me.ShermansWorld.AlathraExtras.npcs;

import net.citizensnpcs.api.event.NPCSpawnEvent;
import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

public class NPCListener implements Listener {
    @EventHandler
    public void npcSpawnListener(NPCSpawnEvent e) {
        if (e.getNPC().getId() == BossItemMerchantNPC.ID){
            BossItemMerchantNPC.teleportMerchant();
        }
    }
}
