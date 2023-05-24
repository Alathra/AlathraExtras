package me.ShermansWorld.AlathraExtras.cm;

import java.io.IOException;
import java.io.InputStream;
import org.bukkit.configuration.Configuration;
import java.io.Reader;
import java.io.InputStreamReader;
import org.bukkit.configuration.file.YamlConfiguration;

import de.leonhard.storage.Config;
import me.ShermansWorld.AlathraExtras.Main;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

public class CMVoteData {
    private Main plugin;
    private FileConfiguration dataConfig;
    private File configFile;
    
    public CMVoteData(Main plugin) {
        dataConfig = null;
        configFile = null;
        this.plugin = plugin;
        saveDefaultConfig();
    }
    
    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "cmvotedata.yml");
        }
        dataConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(configFile);
        final InputStream defaultStream = plugin.getResource("cmvotedata.yml");
        if (defaultStream != null) {
            final YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration((Reader)new InputStreamReader(defaultStream));
            dataConfig.setDefaults((Configuration)defaultConfig);
        }
    }
    
    public FileConfiguration getConfig() {
        if (dataConfig == null) {
            reloadConfig();
        }
        return dataConfig;
    }
    
    public void saveConfig() {
        if (dataConfig == null || configFile == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveDefaultConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "cmvotedata.yml");
        }
        if (!configFile.exists()) {
            plugin.saveResource("cmvotedata.yml", false);
        }
    }
}