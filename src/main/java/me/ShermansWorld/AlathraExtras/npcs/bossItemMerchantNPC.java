package me.ShermansWorld.AlathraExtras.npcs;

import net.citizensnpcs.Citizens;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.SpawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.npc.CitizensNPC;
import net.citizensnpcs.npc.EntityController;
import net.citizensnpcs.npc.EntityControllers;
import net.citizensnpcs.trait.ShopTrait;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.*;
import java.util.random.RandomGenerator;

/**
 * Handles code for the boss item merchant, specifically the one for the nether update.
 */
public class bossItemMerchantNPC{

    /**
     * Teleports the merchant to one of their random locations
     */
    public static void teleportMerchant(){
        // Location information
        final World world = Bukkit.getWorld("world");
        ArrayList<Location> locationArrayList = new ArrayList<>();
        locationArrayList.add(new Location(world, -14.5, 110, 157.5));
        locationArrayList.add(new Location(world, -66.5, 66, -95.5));
        locationArrayList.add(new Location(world, 109.5, 65, 259.5));
        locationArrayList.add(new Location(world, 92.5, 122, 70.5));
        locationArrayList.add(new Location(world, 50.5, 101, 58.5));
        locationArrayList.add(new Location(world, 7.5, 119, 56.5));
        locationArrayList.add(new Location(world, 66.5, 112, 31.5));
        locationArrayList.add(new Location(world, 38.5, 122, 122.5));
        locationArrayList.add(new Location(world, 95.5, 67, -147.5));
        locationArrayList.add(new Location(world, -168.5, 65, 111.5));
        locationArrayList.add(new Location(world, -135.5, 74, 100.5));

        final int MerchantID = 83; //needs to match the value in NPCListener

        Random random = new Random();
        int newLocationIndex = random.nextInt(locationArrayList.size());

        CitizensAPI.getNPCRegistry().getById(MerchantID).teleport(locationArrayList.get(newLocationIndex), PlayerTeleportEvent.TeleportCause.COMMAND);

    }






}
