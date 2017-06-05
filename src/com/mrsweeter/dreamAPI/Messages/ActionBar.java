package com.mrsweeter.dreamAPI.Messages;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.EntityPlayer;
import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.PacketPlayOutChat;
import net.minecraft.server.v1_11_R1.PlayerConnection;
/**
 * 
 * @author MrSweeter
 *
 */
public class ActionBar {
	
	private String text;
	
	/**
	 * Create a new ActionBar
	 * @param pText The text to display
	 */
	public ActionBar(String pText)	{
		text = pText;
	}
	
	/**
	 * Create a new ActionBar (check FormatedChatComponent and ChatComponent)
	 * @param pChat The text to display with color set 
	 */
	public ActionBar(FormatedChatComponent pChat)	{
		text = pChat.getFormatText();
	}
	
	/**
	 * Display ActionBar for specific player
	 * @param player The player to display the message
	 */
	public void sendActionBar(Player player) {
		
		IChatBaseComponent chatComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', text) + "\"}");
		PacketPlayOutChat playOutChat = new PacketPlayOutChat(chatComponent, (byte) 2);
		EntityPlayer handle = ((CraftPlayer)player).getHandle();
		PlayerConnection connection = handle.playerConnection;
		
		connection.sendPacket(playOutChat);
		
	}
	
	/**
	 * Send ActionBar to all onlines players on the server
	 */
	public void sendActionBar()	{
		for (Player p : Bukkit.getServer().getOnlinePlayers())	{
			this.sendActionBar(p);
		}
	}
}
