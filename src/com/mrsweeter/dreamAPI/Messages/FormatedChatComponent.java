package com.mrsweeter.dreamAPI.Messages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
/**
 * 
 * @author MrSweeter
 *
 */
public class FormatedChatComponent {
	
	private TextComponent text = new TextComponent("");
	
	/**
	 * Create new text with color specified with '&' (like Essentials)
	 * @param pText The text to set
	 */
	public FormatedChatComponent(String pText)	{
		text = new TextComponent(pText);
	}
	
	/**
	 * Send text to player
	 * @param p The player to display the text
	 */
	public void sendChatToPlayer(Player p)	{
		
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', getFormatText()));
	}
	
	/**
	 * Send text to all onlines players on server
	 */
	public void sendChatToPlayer()	{
		for (Player p : Bukkit.getServer().getOnlinePlayers())	{
			sendChatToPlayer(p);
		}
	}
	
	/**
	 * Get text
	 * @return The text set in constructor
	 */
	public String getFormatText()	{
		return text.toLegacyText();
	}
}
