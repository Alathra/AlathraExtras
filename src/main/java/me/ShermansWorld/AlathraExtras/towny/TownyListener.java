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
import com.palmergames.bukkit.towny.event.NewNationEvent;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.event.town.TownRuinedEvent;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.AlathraExtras;

public class TownyListener implements Listener {

	private static Chat tc;
	private static ChannelsHolder ch;
	private static Channel g;

	private static long delay = 20;
	private static final Set<Material> signs = new HashSet<Material>();
	private static final Set<Character> approvedChars = new HashSet<Character>();

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
		
		approvedChars.add('1');
		approvedChars.add('2');
		approvedChars.add('3');
		approvedChars.add('4');
		approvedChars.add('5');
		approvedChars.add('6');
		approvedChars.add('7');
		approvedChars.add('8');
		approvedChars.add('9');
		approvedChars.add('a');
		approvedChars.add('b');
		approvedChars.add('c');
		approvedChars.add('d');
		approvedChars.add('e');
		approvedChars.add('f');
		approvedChars.add('g');
		approvedChars.add('h');
		approvedChars.add('i');
		approvedChars.add('j');
		approvedChars.add('k');
		approvedChars.add('l');
		approvedChars.add('m');
		approvedChars.add('n');
		approvedChars.add('o');
		approvedChars.add('p');
		approvedChars.add('q');
		approvedChars.add('r');
		approvedChars.add('s');
		approvedChars.add('t');
		approvedChars.add('u');
		approvedChars.add('v');
		approvedChars.add('w');
		approvedChars.add('x');
		approvedChars.add('y');
		approvedChars.add('z');
		approvedChars.add('A');
		approvedChars.add('B');
		approvedChars.add('C');
		approvedChars.add('D');
		approvedChars.add('E');
		approvedChars.add('F');
		approvedChars.add('G');
		approvedChars.add('H');
		approvedChars.add('I');
		approvedChars.add('J');
		approvedChars.add('K');
		approvedChars.add('L');
		approvedChars.add('M');
		approvedChars.add('N');
		approvedChars.add('O');
		approvedChars.add('P');
		approvedChars.add('Q');
		approvedChars.add('R');
		approvedChars.add('S');
		approvedChars.add('T');
		approvedChars.add('U');
		approvedChars.add('V');
		approvedChars.add('W');
		approvedChars.add('X');
		approvedChars.add('Y');
		approvedChars.add('Z');
		approvedChars.add('_');
		approvedChars.add(' ');
	}

	public void deleteSignsInChunk(TownBlock townBlock, World w, long delay) {
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
	public void checkForSigns(TownRuinedEvent e) {
		Town town = e.getTown();
		final World w = town.getWorld();
		for (final TownBlock townBlock : town.getTownBlocks()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), new Runnable() {
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
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (hasGeneralChatMuted(p.getName())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(AlathraExtras.getInstance(), new Runnable() {
				public void run() {
					p.sendMessage(Helper.Chatlabel() + Helper.color(
							"&5You are getting this notification because you have muted general chat. To see general chat again type &e/channel join general"));
				}
			}, 80L); // 20 Tick (3 second delay)
		}
	}
	
	@EventHandler
	public void onTownCreation(NewTownEvent e) {
		Town town = e.getTown();
		String townName = "";
		for (int i = 0; i < town.getName().length(); i++) {
			if (!approvedChars.contains(town.getName().charAt(i))) {
				town.getMayor().getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cInvalid character '" + String.valueOf(town.getName().charAt(i)) + "'. Character replaced with a '_'."));
				townName += "_";
			} else {
				townName += town.getName().charAt(i);
			}
		}
		town.setName(townName);
 		town.getAccount().deposit(500.0, "Town Creation");
		town.getMayor().getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&b$500 &chas been deposited into your town bank. Towns use money each day or they fall into ruin. To put money in your town type &e/t deposit [amount]"));
	}
	
	@EventHandler
	public void onNationCreation(NewNationEvent e) {
		Nation nation = e.getNation();
		nation.getAccount().deposit(2000.0, "Nation Creation");
		nation.getKing().getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&b$2000 &chas been deposited into your nation bank. Nations use money each day or they fall into ruin. To put money in your nation type &e/t deposit [amount]"));
	}
	
	

}