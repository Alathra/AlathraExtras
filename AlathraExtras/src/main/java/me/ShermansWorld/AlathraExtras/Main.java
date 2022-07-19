package me.ShermansWorld.AlathraExtras;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	    public static Main instance;
	    public static ItemStack recycledLeather;
	    
	    public static Economy economy = null;
	    
	    public static Random rand;
	    
	    public static Main getInstance() {
	        return Main.instance;
	    }
	    
	    public static void initRecipeItems () {
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
	    
	    @Override
	    public void onEnable() {
	        Main.instance = this;
	        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDeathListener(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new CommandListener(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new TownyListener(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new VotingListener(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new PlayerClickHelpBook(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new CraftingEvent(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new AnvilListener(), (Plugin)this);
	        this.getServer().getPluginManager().registerEvents((Listener)new PlayerFirstJoin(), (Plugin)this);
	        initRecipeItems();
	        FurnaceRecipes furnaceRecipes = new FurnaceRecipes();
	        furnaceRecipes.rottenFleshtoLeather();
	        setupEconomy();
	        new FreeOpCommand(this);
	        new GiveTutorialBookCommand(this);
	        
	        rand = new Random();
	    }
	    
	    @Override
	    public void onDisable() {
	    }
}
