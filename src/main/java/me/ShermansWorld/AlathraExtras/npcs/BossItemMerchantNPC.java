package me.ShermansWorld.AlathraExtras.npcs;

import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles code for the boss item merchant, specifically the one for the nether update.
 */
public class BossItemMerchantNPC {
    public static final int ID = 98;

    /**
     * Teleports the merchant to one of their random locations
     */
    public static void teleportMerchant(){
        // Location information
        final World world = Bukkit.getWorld("world");
        if (world == null) return;

        ArrayList<Location> locationArrayList = new ArrayList<>();
        locationArrayList.add(new Location(world, -14.5, 109, 157.5)); //
        locationArrayList.add(new Location(world, -66.5, 65, -95.5)); //
        locationArrayList.add(new Location(world, 109.5, 73, 259.5)); //
        locationArrayList.add(new Location(world, 92.5, 121, 70.5)); //
        locationArrayList.add(new Location(world, 50.5, 100, 58.5)); //
        locationArrayList.add(new Location(world, 7.5, 118, 56.5)); //
        locationArrayList.add(new Location(world, 66.5, 111, 31.5)); //
        locationArrayList.add(new Location(world, 38.5, 121, 122.5)); //
        locationArrayList.add(new Location(world, 95.5, 66, -147.5)); //
        locationArrayList.add(new Location(world, -168.5, 64, 111.5)); //
        locationArrayList.add(new Location(world, -135.5, 73, 100.5)); //
        locationArrayList.add(new Location(world, 95.5, 82, 71.5)); //

	    Random random = new Random();
        int newLocationIndex = random.nextInt(locationArrayList.size()); //Pick random location

        //Teleport the npc
        CitizensAPI.getNPCRegistry().getById(ID).teleport(locationArrayList.get(newLocationIndex), PlayerTeleportEvent.TeleportCause.COMMAND);
    }
}
