package com.mrsweeter.dreamAPI.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// Based on
// Logout400: https://www.spigotmc.org/threads/class-simple-custom-configs.51124/

/**
 * 
 * @author MrSweeter
 * @author Logout400
 *
 * @deprecated Use DConfiguration is recommended
 */
public class PluginConfiguration extends YamlConfiguration {
   
    private File file;
    private String defaults;
    private JavaPlugin plugin;
   
    /**
     * Creates new PluginFile, without defaults
     * @param plugin - Your plugin
     * @param fileName - Name of the file
     */
    public PluginConfiguration(JavaPlugin plugin, String fileName) {
        this(plugin, fileName, null, null);
    }
    
    /**
     * Creates new PluginFile, without defaults
     * @param plugin - Your plugin
     * @param fileName - Name of the file
     * @param folder - Name of the folder
     */
    public PluginConfiguration(JavaPlugin plugin, String fileName, String folder) {
        this(plugin, fileName, null, folder);
    }
   
    /**
     * Creates new PluginFile, with defaults
     * @param plugin - Your plugin
     * @param fileName - Name of the file
     * @param defaultsName - Name of the defaults
     * @param folder - Name of the folder
     */
    public PluginConfiguration(JavaPlugin plugin, String fileName, String defaultsName, String folder) {
    	
    	if (fileName != null && !fileName.contains(".yml"))	{fileName += ".yml";}
    	if (defaultsName != null && !defaultsName.contains(".yml"))	{defaultsName += ".yml";}
    	
        this.plugin = plugin;
        this.defaults = defaultsName;
        if (folder != null)	{
        	folder = "\\" + folder;
        	this.file = new File(plugin.getDataFolder() + folder, fileName);
        } else {
        	this.file = new File(plugin.getDataFolder(), fileName);
        }
        reload();
    }
    
   
    public PluginConfiguration(JavaPlugin pl, File file) {
		this.plugin = pl;
		this.file = file;
		reload();
	}

	/**
     * Reload configuration
     */
    public void reload() {
       
        createIfNotExists(file);
       
        try {
            load(file);
            
            if (defaults != null) {
                InputStreamReader reader = new InputStreamReader(plugin.getResource(defaults));
                FileConfiguration defaultsConfig = YamlConfiguration.loadConfiguration(reader);       
               
                setDefaults(defaultsConfig);
                options().copyDefaults(true);
               
                reader.close();
                save();
            }
       
        } catch (IOException exception) {
            exception.printStackTrace();
            plugin.getLogger().severe("Error while loading file " + file.getName());
           
        } catch (InvalidConfigurationException exception) {
            exception.printStackTrace();
            plugin.getLogger().severe("Error while loading file " + file.getName());
           
        }
       
    }
    
    private void createIfNotExists(File file)	{
    	
    	if (!file.exists()) {
            
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
               
            } catch (IOException exception) {
                exception.printStackTrace();
                plugin.getLogger().severe("Error while creating file " + file.getName());
            }
           
        }
    }
   
    /**
     * Save configuration
     */
    public void save() {
       
        try {
            options().indent(2);
            save(file);
           
        } catch (IOException exception) {
            exception.printStackTrace();
            plugin.getLogger().severe("Error while saving file " + file.getName());
        }
       
    }
   
}