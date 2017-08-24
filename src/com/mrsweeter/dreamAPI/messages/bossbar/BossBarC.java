package com.mrsweeter.dreamAPI.messages.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mrsweeter.dreamAPI.messages.DisplayMessage;

/**
 * 
 * @author MrSweeter
 * 
 */
public class BossBarC extends DisplayMessage	{
	
	private BossBar bar;
	private JavaPlugin plugin;
	
	/**
	 * Creates BossBar with title
	 * @param text Text to display
	 * @param plugin Your plugin instance
	 */
	public BossBarC(String text, JavaPlugin plugin)	{
		this(text, BarColor.PURPLE, plugin);
	}
	
	/**
	 * Creates BossBar with specific color
	 * @param text Text to display
	 * @param color Color of the bar (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/boss/BarColor.html)
	 * @param plugin Your plugin instance
	 */
	public BossBarC(String text, BarColor color, JavaPlugin plugin)	{
		this(text, color, BarStyle.SOLID, plugin);
	}
	
	/**
	 * Creates BossBar with specific color and divides
	 * @param text Text to display
	 * @param color Color of the bar (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/boss/BarColor.html)
	 * @param style Style of the bar (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/boss/BarStyle.html)
	 * @param plugin Your plugin instance
	 */
	public BossBarC(String text, BarColor color, BarStyle style, JavaPlugin plugin)	{
		
		this.plugin = plugin;
				
		bar = Bukkit.createBossBar(text, color, style);
	}
	
	/**
	 * Show bossbar to player 10secondes
	 * @param player Player to view
	 */
	@Override
	public void showTo(Player player)	{
		showTo(player, 10);
	}
	
	/**
	 * Show bossbar to player online, for specific time
	 * @param player Player to view
	 * @param time Time to display in seconds
	 */
	public void showTo(Player player, int time)	{
		
		bar.addPlayer(player);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				bar.removePlayer(player);
			}
		}.runTaskLater(plugin, time*20);
	}
	
	/**
	 * Show bossbar to all players online, for specific time
	 * @param time Time to display in seconds
	 */
	public void showToAll(int time)	{
		for (Player player : Bukkit.getServer().getOnlinePlayers())	{
			showTo(player, time);
		}
	}
	
	/**
	 * Show bossbar to all players online, for 10 seconds
	 */
}
