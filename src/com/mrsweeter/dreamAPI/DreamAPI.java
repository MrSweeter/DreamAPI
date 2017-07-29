package com.mrsweeter.dreamAPI;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author MrSweeter
 *
 */
public class DreamAPI extends JavaPlugin implements Listener	{
	
	public void onEnable()	{
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
	
	public void onDisable()	{}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)	{
		
		
		
	}
}
