package me.ShermansWorld.AlathraExtras.npcs;

import net.citizensnpcs.api.CitizensAPI;
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
        locationHashSet.add(new Location(world, 22.5, 72, 123.5));



        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        EntityController entityController = EntityControllers.createForType(EntityType.PLAYER);
        merchant = new CitizensNPC(merchantUUID, 300, "Mysterious Merchant", entityController, registry);

        Random random = new Random();
        int newLocationIndex = random.nextInt(locationHashSet.size());

        merchant.spawn(locationHashSet.get(newLocationIndex));

        ShopTrait shopTrait = new ShopTrait();

        merchant.addTrait(shopTrait);


    }



}
