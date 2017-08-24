package com.mrsweeter.dreamAPI.messages.chat;

import org.bukkit.entity.Player;

import com.mrsweeter.dreamAPI.messages.DisplayMessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
/**
 * 
 * @author MrSweeter
 *
 */
public class FormatedChatComponent extends DisplayMessage	{
	
	private TextComponent text = new TextComponent("");
	
	/**
	 * Create new text with color specified with '&amp;' (like Essentials)
	 * @param pText The text to set
	 */
	public FormatedChatComponent(String pText)	{
		text = new TextComponent(pText);
	}
	
	/**
	 * Send text to player
	 * @param player The player to display the text
	 */
	@Override
	public void showTo(Player player)	{
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', getFormatText()));
	}
		
	/**
	 * Get text
	 * @return The text set in constructor
	 */
	public String getFormatText()	{
		return text.toLegacyText();
	}
}
