package com.mrsweeter.dreamAPI.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author MrSweeter
 *
 */
public class ConfigurationCollection {
	
	Map<String, PluginConfiguration> configs;
	JavaPlugin pl;
	
	/**
	 * Create your collection of PluginConfiguration
	 * @param main instance of your plugin
	 */
	public ConfigurationCollection(JavaPlugin main)	{
		pl = main;
		configs = new HashMap<>();
	}
	
	/**
	 * Get specific configuration with name
	 * @param fileName The name of researched file, without extension
	 * @return The PluginConfiguration, if file doesn't exist, it will be created
	 */
	public PluginConfiguration getConfigByName(String fileName)	{
		if (!this.configs.containsKey(fileName))	{
			addFileConfiguration(fileName);
		}
		return this.configs.get(fileName);
	}
	
	/**
	 * Create a new empty file in specific folder (plugins/YourPlugin/folderName/fileName.yml)
	 * @param fileName The name to set for the new file
	 * @param folderName The name to set for the new folder
	 */
	public void addFolderedConfiguration(String fileName, String folderName)	{
		this.configs.put(folderName+fileName, new PluginConfiguration(pl, fileName+".yml", folderName));
	}
	
	/**
	 * Create a new default file (plugins/YourPlugin/fileName.yml), using a default file in your plugin
	 * Create new empty file, if you haven't put "fileName.yml" in your plugin
	 * @param fileName The name to set for the new file
	 */
	public void addExistingConfiguration(String fileName)	{
		try {
			this.configs.put(fileName, new PluginConfiguration(pl, fileName+".yml", fileName+".yml", null));
		} catch (NullPointerException exception)	{
			addFileConfiguration(fileName);
		}
	}
	
	/**
	 * Create a new empty file (plugins/YourPlugin/ffileName.yml)
	 * @param fileName The name to set for the new file
	 */
	public void addFileConfiguration(String fileName)	{
		this.configs.put(fileName, new PluginConfiguration(pl, fileName+".yml"));
	}
	
	/**
	 * Reload all file
	 */
	public void reloadAll()	{
		Collection<PluginConfiguration> c = configs.values();
		Iterator<PluginConfiguration> it = c.iterator();
		PluginConfiguration config;
		while (it.hasNext())	{
			config = it.next();
			config.reload();
		}
	}
}
