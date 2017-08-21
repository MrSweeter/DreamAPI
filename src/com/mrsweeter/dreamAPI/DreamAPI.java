package com.mrsweeter.dreamAPI;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author MrSweeter
 *
 */
public class DreamAPI extends JavaPlugin implements Listener	{
	
	public static DreamAPI instance;
	
	public void onEnable()	{
		
		instance = this;
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
		
	public void onDisable()	{}
}
