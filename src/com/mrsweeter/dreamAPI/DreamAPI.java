package com.mrsweeter.dreamAPI;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.mrsweeter.dreamAPI.configuration.DConfiguration;
import com.mrsweeter.dreamAPI.enchantments.GlowingEnchantment;

/**
 * 
 * @author MrSweeter
 *
 */
public class DreamAPI extends JavaPlugin implements Listener	{
	
	public static DreamAPI instance;
	DConfiguration configurationFile;
	
	public void onEnable()	{
		
		instance = this;
		
		unlockEnchantmentClass();
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		try {
			Enchantment.registerEnchantment(GlowingEnchantment.getEnchant());
		} catch (IllegalArgumentException e)	{
			getLogger().info("Registering of enchantment fail, duplicate value (this message can appear after a reload)");
		} catch (IllegalStateException e)	{
			getLogger().info("Registering of enchantment fail, registration isn't allowed");
		}
		
	}
	
	public void onDisable()	{}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)	{
		
	}
	
	private void unlockEnchantmentClass()	{
		try {
			Field field = Enchantment.class.getDeclaredField("acceptingNew");
			field.setAccessible(true);
			field.set(null, true);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)	{
			e.printStackTrace();
			DreamAPI.instance.getLogger().info("Error when unlocking enchantment class");
		}
	}
}
