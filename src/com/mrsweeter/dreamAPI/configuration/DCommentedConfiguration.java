package com.mrsweeter.dreamAPI.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author MrSweeter
 *
 */
public class DCommentedConfiguration extends YamlConfiguration	{
	
	private File file;
	private JavaPlugin plugin;
	private String defaultPathFile;
	
	/**
	 * Creates new commented configuration file
	 * @param plugin Your plugin instance
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 */
	public DCommentedConfiguration(JavaPlugin plugin, String pathFile, String defaultPathFile)	{
		this(plugin, pathFile, defaultPathFile, true);
	}
	
	/**
	 * Creates new commented configuration file, in or out your plugin folder
	 * @param plugin Your plugin instance
	 * @param pathFile The path to your file
	 * @param defaultPathFile The path to your default file, the file in your .jar
	 * @param inPluginFolder true to create file in plugins/YourPluginName, false to create file in pathFile
	 */
	public DCommentedConfiguration(JavaPlugin plugin, String pathFile, String defaultPathFile, boolean inPluginFolder)	{
		
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
	 * Reload configuration file
	 */
	public void reload()	{
		
		createIfNotExist();
		
		try {
			load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			plugin.getLogger().warning("File not found " + file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
			plugin.getLogger().warning("Error while saving file " + file.getPath());
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			plugin.getLogger().warning("Invalid configuration for file " + file.getPath());
		}
	}
	
	/**
	 * Creates file if not exist
	 */
	private void createIfNotExist() {
		
		if (!file.exists())	{
			
			try	{
				
				if (!file.getParentFile().exists())	{
					file.getParentFile().mkdirs();
				}
				
				InputStream input = plugin.getResource(defaultPathFile);
				
				if (input != null)	{
					Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
					input.close();
				} else {
					file.createNewFile();
					plugin.getLogger().warning("No file found with " + defaultPathFile + ", empty file was created");
				}
			} catch (IOException e)	{
				e.printStackTrace();
				plugin.getLogger().warning("Error during creation of file " + file.getPath());
			}
		}
	}
}
