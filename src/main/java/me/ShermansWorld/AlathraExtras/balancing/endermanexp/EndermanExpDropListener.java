package me.ShermansWorld.AlathraExtras.endermanexp;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EndermanExpDropListener implements Listener {
    @EventHandler()
    private static void onMobDeath(EntityDeathEvent e) {
        if (!e.getEntityType().equals(EntityType.ENDERMAN))
            return;

        if (!e.getEntity().getWorld().getEnvironment().equals(World.Environment.THE_END))
            return;

        e.setDroppedExp(0);
    }
}
