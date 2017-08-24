package com.mrsweeter.dreamAPI.configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.plugin.java.JavaPlugin;

import com.mrsweeter.dreamAPI.exceptions.NoKeyWithThisNameException;

public class DConfigurationCollection implements Iterable<DConfiguration> {
	
	private HashMap<String, DConfiguration> files;
	JavaPlugin plugin;
	
	/**
	 * Constructor
	 * @param plugin Your plugin instance
	 */
	public DConfigurationCollection(JavaPlugin plugin) {
		
		this.plugin = plugin;
		files = new HashMap<>();
		
	}
	
	/**
	 * Gets a specific DConfiguration with id
	 * @param id The id of the configuration
	 * @return DConfiguration
	 */
	public DConfiguration getConfig(String id)	{
		
		if (!this.files.containsKey(id))	{throw new NoKeyWithThisNameException();}
		return this.files.get(id);
	}
	
	/**
	 * 
	 * @param id Unique id for this configuration
	 * @param file The file to load
	 * @return DConfiguration
	 */
	public DConfiguration createConfigurationFile(String id, File file)	{
		return this.files.put(id, new DConfiguration(plugin, file));	
	}
	
	/**
	 * 
	 * @param id Unique id for this configuration
	 * @param pathFile The path to your file
	 * @return DConfiguration
	 */
	public DConfiguration createConfigurationFile(String id, String pathFile)	{
		return createConfigurationFile(id, pathFile, null);
	}
	
	/**
	 * 
	 * @param id Unique id for this configuration
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 * @return DConfiguration
	 */
	public DConfiguration createConfigurationFile(String id, String pathFile, String defaultPathFile)	{
		return createConfigurationFile(id, pathFile, defaultPathFile, true);
	}
	
	/**
	 * 
	 * @param id Unique id for this configuration
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 * @param inPluginFolder true to create file in plugins/YourPluginName, false to create file in pathFile
	 * @return DConfiguration
	 */
	public DConfiguration createConfigurationFile(String id, String pathFile, String defaultPathFile, boolean inPluginFolder)	{
		this.files.put(id, new DConfiguration(plugin, pathFile, defaultPathFile, inPluginFolder));
		return this.files.get(id);
	}
	
	/**
	 * Reload all configs
	 */
	public void reloadAll()	{
		Iterator<DConfiguration> iterator = iterator();
		DConfiguration file;
		while (iterator.hasNext())	{
			file = iterator.next();
			file.reload();
		}
	}
	
	@Override
	public Iterator<DConfiguration> iterator() {
		return files.values().iterator();
	}

}
