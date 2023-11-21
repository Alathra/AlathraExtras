package me.ShermansWorld.AlathraExtras.balancing;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import me.ShermansWorld.AlathraExtras.Helper;
import nl.rutgerkok.blocklocker.BlockLockerAPIv2;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class BlockLockerTownMayor implements Listener {

    public static Set<Material> signs = new HashSet<Material>();

    static {
        signs.add(Material.ACACIA_SIGN);
        signs.add(Material.ACACIA_WALL_SIGN);
        signs.add(Material.BAMBOO_SIGN);
        signs.add(Material.BAMBOO_WALL_SIGN);
        signs.add(Material.BIRCH_SIGN);
        signs.add(Material.BIRCH_WALL_SIGN);
        signs.add(Material.CHERRY_SIGN);
        signs.add(Material.CHERRY_WALL_SIGN);
        signs.add(Material.CRIMSON_SIGN);
        signs.add(Material.CRIMSON_WALL_SIGN);
        signs.add(Material.DARK_OAK_SIGN);
        signs.add(Material.DARK_OAK_WALL_SIGN);
        signs.add(Material.JUNGLE_SIGN);
        signs.add(Material.JUNGLE_WALL_SIGN);
        signs.add(Material.MANGROVE_SIGN);
        signs.add(Material.MANGROVE_WALL_SIGN);
        signs.add(Material.OAK_SIGN);
        signs.add(Material.OAK_WALL_SIGN);
        signs.add(Material.SPRUCE_SIGN);
        signs.add(Material.SPRUCE_WALL_SIGN);
        signs.add(Material.WARPED_SIGN);
        signs.add(Material.WARPED_WALL_SIGN);
    }

    @EventHandler()
    public static void onSignBreak(BlockBreakEvent e) {
        if (signs.contains(e.getBlock().getType())) {
            if (BlockLockerAPIv2.isProtected(e.getBlock())) {
                if (BlockLockerAPIv2.isOwner(e.getPlayer(), e.getBlock())) {
                    return;
                }
                //OfflinePlayer owner = BlockLockerAPIv2.getOwner(e.getBlock()).get();
                TownyAPI townyAPI = TownyAPI.getInstance();
                Town town = townyAPI.getTownOrNull(townyAPI.getTownBlock(e.getBlock().getLocation()));
                if (town != null) {
                    if (town.getMayor().equals(townyAPI.getResident(e.getPlayer()))) {
                        BlockLockerAPIv2.getPlugin().getProtectionUpdater().update(
                            BlockLockerAPIv2.getPlugin().getProtectionFinder().findProtection(e.getBlock()).get(),
                            false);
                        e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(),
                            new ItemStack(e.getBlock().getType(), 1));
                        e.getBlock().setType(Material.AIR);
                        e.getPlayer().sendMessage(
                            Helper.Chatlabel() + Helper.color("&eThe protection sign has been cleared"));
                    }
                }
            }
        }
    }

}
