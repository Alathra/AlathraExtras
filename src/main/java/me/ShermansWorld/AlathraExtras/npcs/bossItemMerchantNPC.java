package me.ShermansWorld.AlathraExtras.npcs;

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
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;


public class bossItemMerchantNPC{

    public static void teleportMerchant(){
        NPC merchant;
        final UUID merchantUUID = UUID.fromString("a0a0a0a0-a0a0-a0a0-a0a0-a0a0a0a0a0a0");

        // Location information
        final World world = Bukkit.getWorld("world");
        ArrayList<Location> locationHashSet = new ArrayList<>();
        locationHashSet.add(new Location(world, -14.5, 110, 157.5));
        locationHashSet.add(new Location(world, -66.5, 66, -95.5));
        locationHashSet.add(new Location(world, 105.5, 65, 298.5));
        final int MerchantID = 83;

        Random random = new Random();
        int newLocationIndex = random.nextInt(locationHashSet.size());

        CitizensAPI.getNPCRegistry().getById(83).teleport(locationHashSet.get(newLocationIndex), PlayerTeleportEvent.TeleportCause.COMMAND);


    }



}
