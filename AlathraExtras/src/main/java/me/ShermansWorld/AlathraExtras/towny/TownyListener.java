package me.ShermansWorld.AlathraExtras.towny;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmergames.bukkit.TownyChat.Chat;
import com.palmergames.bukkit.TownyChat.channels.Channel;
import com.palmergames.bukkit.TownyChat.channels.ChannelsHolder;
import com.palmergames.bukkit.TownyChat.events.AsyncChatHookEvent;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.event.town.TownRuinedEvent;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;

public class TownyListener implements Listener {

	private static Chat tc;
	private static ChannelsHolder ch;
	private static Channel g;

	private static long delay = 20;
	private static final Set<Material> signs = new HashSet<Material>();

	static {
		signs.add(Material.ACACIA_SIGN);
		signs.add(Material.BIRCH_SIGN);
		signs.add(Material.DARK_OAK_SIGN);
		signs.add(Material.JUNGLE_SIGN);
		signs.add(Material.SPRUCE_SIGN);
		signs.add(Material.OAK_SIGN);
		signs.add(Material.CRIMSON_SIGN);
		signs.add(Material.WARPED_SIGN);
		signs.add(Material.MANGROVE_SIGN);
		signs.add(Material.ACACIA_WALL_SIGN);
		signs.add(Material.BIRCH_WALL_SIGN);
		signs.add(Material.DARK_OAK_WALL_SIGN);
		signs.add(Material.JUNGLE_WALL_SIGN);
		signs.add(Material.SPRUCE_WALL_SIGN);
		signs.add(Material.OAK_WALL_SIGN);
		signs.add(Material.CRIMSON_WALL_SIGN);
		signs.add(Material.WARPED_WALL_SIGN);
		signs.add(Material.MANGROVE_WALL_SIGN);

	}

	public static void deleteSignsInChunk(TownBlock townBlock, World w, long delay) {
		int x = townBlock.getX() * 16;
		int z = townBlock.getZ() * 16;
		for (int xx = x; xx < x + 16; xx++) {
			for (int zz = z; zz < z + 16; zz++) {
				for (int yy = -63; yy < 319; yy++) {
					Block b = w.getBlockAt(xx, yy, zz);
					if (!b.getType().isAir()) {
						if (signs.contains(b.getType())) { // if block is a sign
							b.setType(Material.AIR); // set to air, or delete sign
						}
					}
				}
			}
		}
	}

	@EventHandler
	public static void checkForSigns(TownRuinedEvent e) {
		Town town = e.getTown();
		final World w = town.getWorld();
		for (final TownBlock townBlock : town.getTownBlocks()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					deleteSignsInChunk(townBlock, w, delay);
				}
			}, delay); // 20 Tick (1 Second) delay before run() is called
			delay += 100; // 5 seconds
		}
	}

	public static void initTownyChat() {
		tc = JavaPlugin.getPlugin(Chat.class);
		ch = tc.getChannelsHandler();
		g = ch.getDefaultChannel();
	}

	public static boolean hasGeneralChatMuted(String playername) {
		return g.isAbsent(playername);
	}

	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (hasGeneralChatMuted(p.getName())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					p.sendMessage(Helper.Chatlabel() + Helper.color(
							"&5You are getting this notification because you have muted general chat. To see general chat again type &e/channel join general"));
				}
			}, 80L); // 20 Tick (3 second delay)
		}
	}

	@EventHandler
	public static void onChatMsg(AsyncChatHookEvent e) {
		switch (e.getChannel().getName()) {
			case "global":
				e.setMessage(Helper.color("&f" + e.getMessage()));
				break;
			case "local":
				e.setMessage(Helper.color("&5" + e.getMessage()));
				break;
			case "rp":
				e.setMessage(Helper.color("&9" + e.getMessage()));
				break;
			case "shout":
				e.setMessage(Helper.color("&c" + e.getMessage()));
				break;
			case "whisper":
				e.setMessage(Helper.color("&6" + e.getMessage()));
				break;
			case "town":
				e.setMessage(Helper.color("&b" + e.getMessage()));
				break;
			case "nation":
				e.setMessage(Helper.color("&6" + e.getMessage()));
				break;
			case "staff":
				e.setMessage(Helper.color("&c" + e.getMessage()));
				break;
			default:
				break;
		}

	}
	
	@EventHandler
	public static void onChatMsg(NewTownEvent e) {
		Town town = e.getTown();
		town.getAccount().deposit(500.0, "Town Creation");
		town.getMayor().getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&a$&c500 &ahas been deposited into your town bank. Towns use money each day or they fall into ruin. To put money in your town type &e/t deposit [amount]"));
	}

}