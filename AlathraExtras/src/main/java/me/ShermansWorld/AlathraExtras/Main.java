package me.ShermansWorld.AlathraExtras;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.ShermansWorld.AlathraExtras.balancing.CureListener;
import me.ShermansWorld.AlathraExtras.balancing.RiptideListener;
import me.ShermansWorld.AlathraExtras.crafting.CraftingRecipes;
import me.ShermansWorld.AlathraExtras.crafting.FurnaceRecipes;
import me.ShermansWorld.AlathraExtras.crafting.SmithingTableListener;
import me.ShermansWorld.AlathraExtras.freeop.FreeOpCommand;
import me.ShermansWorld.AlathraExtras.misc.CommandListener;
import me.ShermansWorld.AlathraExtras.misc.CraftingEvent;
import me.ShermansWorld.AlathraExtras.misc.ItemFrameListener;
import me.ShermansWorld.AlathraExtras.towny.TownyListener;
import me.ShermansWorld.AlathraExtras.tutorialbook.AnvilListener;
import me.ShermansWorld.AlathraExtras.tutorialbook.GiveTutorialBookCommand;
import me.ShermansWorld.AlathraExtras.tutorialbook.PlayerClickHelpBook;
import me.ShermansWorld.AlathraExtras.tutorialbook.PlayerFirstJoin;
import me.ShermansWorld.AlathraExtras.voting.VotingListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static Main instance;
	public static ItemStack recycledLeather;

	public static Economy economy = null;

	public static Random rand;

	public static Main getInstance() {
		return Main.instance;
	}

	public static AlathraExtrasLogger logger;

	public static void initRecipeItems() {
		recycledLeather = new ItemStack(Material.LEATHER, 1);
		ItemMeta meta = recycledLeather.getItemMeta();
		meta.setDisplayName(Helper.color("&aRecycled Leather"));
		recycledLeather.setItemMeta(meta);
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		economy = rsp.getProvider();
		return economy != null;
	}

	public static void initLogs() {
		File logsFolder = new File("plugins" + File.separator + "AlathraExtras" + File.separator + "logs");
		if (!logsFolder.exists()) {
			logsFolder.mkdirs();
		}
		File log = new File(
				"plugins" + File.separator + "AlathraExtras" + File.separator + "logs" + File.separator + "log.txt");
		if (!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				Bukkit.getLogger().warning("[AlathraExtras] Encountered error when creating log file!");
			}
		}
		logger = new AlathraExtrasLogger();

	}

	@Override
	public void onEnable() {
		Main.instance = this;

		getConfig().options().copyDefaults();
		saveConfig();
		TownyListener.initTownyChat();

		this.getServer().getPluginManager().registerEvents((Listener) new CommandListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new TownyListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new VotingListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerClickHelpBook(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new CraftingEvent(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new AnvilListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerFirstJoin(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerListeners(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new SmithingTableListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new CureListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new RiptideListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new ItemFrameListener(), (Plugin) this);
		initRecipeItems();
		FurnaceRecipes furnaceRecipes = new FurnaceRecipes();
		furnaceRecipes.rottenFleshtoLeather();
		CraftingRecipes craftingRecipes = new CraftingRecipes();
		craftingRecipes.saddleRecipe();
		craftingRecipes.charcoalBlock();
		craftingRecipes.redDyeRecipe();
		craftingRecipes.redSandRecipe();
		craftingRecipes.bellRecipe();
		craftingRecipes.blackDyeRecipe1();
		craftingRecipes.blackDyeRecipe2();
		craftingRecipes.beetRootPouchRecipe();
		craftingRecipes.carrotPouchRecipe();
		setupEconomy();
		logger = new AlathraExtrasLogger();
		new FreeOpCommand(this);
		new GiveTutorialBookCommand(this);
		rand = new Random();
		initLogs();
	}

	@Override
	public void onDisable() {
	}

}
