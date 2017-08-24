package com.mrsweeter.dreamAPI.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author MrSweeter
 *
 */
public class DConfiguration extends YamlConfiguration	{
	
	private File file;
	private String defaultPathFile;	
	private JavaPlugin plugin;
	
	/**
	 * Load a File (.yml), no default file
	 * Usefull to load multiple yml file create by the user (.listFile())
	 * @param plugin Your plugin instance
	 * @param file The file to load
	 */
	public DConfiguration(JavaPlugin plugin, File file)	{
		
		this.file = file;
		this.plugin = plugin;
		this.defaultPathFile = null;
		
		reload();
	}
	
	/**
	 * Creates new YamlConfiguration, without default file
	 * @param plugin Your plugin instance
	 * @param pathFile The path to your file
	 */
	public DConfiguration(JavaPlugin plugin, String pathFile)	{
		
		this(plugin, pathFile, null);
		
	}
	
	/**
	 * Creates new YamlConfiguration with default file
	 * @param plugin Your plugin instance
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 */
	public DConfiguration(JavaPlugin plugin, String pathFile, String defaultPathFile)	{
		this(plugin, pathFile, defaultPathFile, true);
	}
	
	/**
	 * Creates new YamlConfiguration, in or out your plugin folder
	 * @param plugin Your plugin instance
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 * @param inPluginFolder true to create file in plugins/YourPluginName, false to create file in pathFile
	 */
	public DConfiguration(JavaPlugin plugin, String pathFile, String defaultPathFile, boolean inPluginFolder)	{
		
		this.plugin = plugin;
		
		if (!pathFile.endsWith(".yml"))	{pathFile += ".yml";}
		if (defaultPathFile != null && !defaultPathFile.endsWith(".yml"))	{defaultPathFile += ".yml";}
		
		this.defaultPathFile = defaultPathFile;
		
		if (inPluginFolder)	{
			this.file = new File(plugin.getDataFolder(), pathFile);
		} else {
			this.file = new File(pathFile);
		}
		
		reload();
	}
	
	/**
	 * Reload your configuration file
	 */
	public void reload()	{
		
		createIfNotExist();
		
		try	{
			
			load(file);
			
			if (defaultPathFile != null)	{
				
				InputStreamReader reader = new InputStreamReader(plugin.getResource(defaultPathFile));
				YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(reader);
				
				setDefaults(defaultConfiguration);
				options().copyDefaults(true);
				
				reader.close();
				save();
			}
			
		} catch (IOException e)	{
			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			plugin.getLogger().warning("Error while loading file " + file.getPath());
		}
	}
	
	/**
	 * Create a file if not exist
	 * @param file File to create
	 */
	private void createIfNotExist()	{
		
		if (!file.exists())	{
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				plugin.getLogger().warning("Error while creating file " + file.getPath());
			}
		}
	}
	
	/**
	 * Save configuration file, remove comments
	 */
	public void save()	{
		try {
			options().indent(2);
			save(file);
		} catch (IOException e) {
			e.printStackTrace();
			plugin.getLogger().warning("Error while saving file " + file.getPath());
		}
	}
}