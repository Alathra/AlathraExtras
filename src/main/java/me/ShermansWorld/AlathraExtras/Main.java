package me.ShermansWorld.AlathraExtras;

import me.ShermansWorld.AlathraExtras.anitblockclimb.BlockPlaceListener;
import me.ShermansWorld.AlathraExtras.announcer.Announcer;
import me.ShermansWorld.AlathraExtras.balancing.CureListener;
import me.ShermansWorld.AlathraExtras.balancing.GrindstoneListener;
import me.ShermansWorld.AlathraExtras.balancing.RiptideListener;
import me.ShermansWorld.AlathraExtras.chatitem.ShowItemCommand;
import me.ShermansWorld.AlathraExtras.cm.CMTabCompleter;
import me.ShermansWorld.AlathraExtras.cm.CMVoteCommands;
import me.ShermansWorld.AlathraExtras.cm.CMVoteData;
import me.ShermansWorld.AlathraExtras.crafting.CraftingRecipes;
import me.ShermansWorld.AlathraExtras.crafting.FurnaceRecipes;
import me.ShermansWorld.AlathraExtras.crafting.FurnaceRecipesListener;
import me.ShermansWorld.AlathraExtras.crafting.SmithingTableListener;
import me.ShermansWorld.AlathraExtras.enderchersblock.EnderChestBlockListener;
import me.ShermansWorld.AlathraExtras.endermanexp.EndermanExpDropListener;
import me.ShermansWorld.AlathraExtras.freeop.FreeOpCommand;
import me.ShermansWorld.AlathraExtras.items.ItemsListener;
import me.ShermansWorld.AlathraExtras.joinleavemessages.JoinLeaveMessages;
import me.ShermansWorld.AlathraExtras.misc.CommandListener;
import me.ShermansWorld.AlathraExtras.misc.CraftingListener;
import me.ShermansWorld.AlathraExtras.misc.ItemFrameListener;
import me.ShermansWorld.AlathraExtras.misc.MsgEditor;
import me.ShermansWorld.AlathraExtras.playtime.PlaytimeCommand;
import me.ShermansWorld.AlathraExtras.playtime.PlaytimeTabCompleter;
import me.ShermansWorld.AlathraExtras.puke.HopperListener;
import me.ShermansWorld.AlathraExtras.puke.PukeCommand;
import me.ShermansWorld.AlathraExtras.roll.RollCommand;
import me.ShermansWorld.AlathraExtras.towny.TownyListener;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownManager;
import me.ShermansWorld.AlathraExtras.tpacooldown.listener.essentialsx.PreTeleportListener;
import me.ShermansWorld.AlathraExtras.tpacooldown.listener.essentialsx.TeleportRequestResponseListener;
import me.ShermansWorld.AlathraExtras.tpacooldown.listener.player.PlayerCommandPreprocessListener;
import me.ShermansWorld.AlathraExtras.tpacooldown.listener.player.PlayerJoinListener;
import me.ShermansWorld.AlathraExtras.tpacooldown.listener.player.PlayerQuitListener;
import me.ShermansWorld.AlathraExtras.tutorialbook.AnvilListener;
import me.ShermansWorld.AlathraExtras.tutorialbook.GiveTutorialBookCommand;
import me.ShermansWorld.AlathraExtras.tutorialbook.PlayerClickHelpBook;
import me.ShermansWorld.AlathraExtras.tutorialbook.PlayerFirstJoin;
import me.ShermansWorld.AlathraExtras.voting.VotingListener;
import me.ShermansWorld.AlathraExtras.disablespawners.DisableSpawners;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main extends JavaPlugin {

	public static Main instance;
	public static ItemStack recycledLeather;

	public static Economy economy = null;
	public static Random rand;
	
	public static CMVoteData cmVoteData;


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
	
	private void initData() {
		cmVoteData = new CMVoteData(this);
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
	public void onLoad() {
		Main.instance = this;
		JoinLeaveMessages.getInstance().onLoad();
		Announcer.getInstance().onLoad();
	}

	@Override
	public void onEnable() {

		getConfig().options().copyDefaults();
		saveConfig();
		TownyListener.initTownyChat();

		this.getServer().getPluginManager().registerEvents((Listener) new AnvilListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new BlockPlaceListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new CommandListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new CraftingListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new CureListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new EnderChestBlockListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new EndermanExpDropListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new DisableSpawners(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new FurnaceRecipesListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new GrindstoneListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new HopperListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new ItemFrameListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new ItemsListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new MsgEditor(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerClickHelpBook(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerCommandPreprocessListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerFirstJoin(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerJoinListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerListeners(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PlayerQuitListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PreTeleportListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new RiptideListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new SmithingTableListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new TeleportRequestResponseListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new TownyListener(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new VotingListener(), (Plugin) this);

		initRecipeItems();
		initData();
		FurnaceRecipes furnaceRecipes = new FurnaceRecipes();
		furnaceRecipes.rottenFleshtoLeather();
		furnaceRecipes.mossyCobbletoAndesite();

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
		craftingRecipes.potatoPouchRecipe();
		craftingRecipes.dioriteRecipe1();
		craftingRecipes.dioriteRecipe2();
		craftingRecipes.dioriteRecipe3();
		craftingRecipes.greenDyeRecipe();

		setupEconomy();
		logger = new AlathraExtrasLogger();
		new RollCommand(this);
		new FreeOpCommand(this);
		new PukeCommand(this);
		new GiveTutorialBookCommand(this);
		new CMVoteCommands(this);
		new AlathraExtrasCommands(this);
		new PlaytimeCommand(this);
		new ShowItemCommand(this);
		getCommand("cmvote").setTabCompleter(new CMTabCompleter());
		getCommand("alathraextras").setTabCompleter(new AlathraExtrasTabCompleter());
		getCommand("playtime").setTabCompleter(new PlaytimeTabCompleter());
		rand = new Random();
		if (instance.getServer().getPluginManager().isPluginEnabled("Essentials")) CooldownManager.getInstance();
		JoinLeaveMessages.getInstance().onEnable();
		Announcer.getInstance().onEnable();
		initLogs();
	}

	@Override
	public void onDisable() {
		if (instance.getServer().getPluginManager().isPluginEnabled("Essentials")) CooldownManager.onDisable();
		JoinLeaveMessages.getInstance().onDisable();
		Announcer.getInstance().onDisable();
	}

}
