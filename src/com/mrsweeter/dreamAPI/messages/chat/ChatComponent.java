package com.mrsweeter.dreamAPI.messages.chat;

import org.bukkit.entity.Player;

import com.mrsweeter.dreamAPI.messages.DisplayMessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
/**
 * 
 * @author MrSweeter
 *
 */
public class ChatComponent extends DisplayMessage	{
	
	private TextComponent text = new TextComponent("");
	
	/**
	 * Create text with ChatColor not specified char
	 * @param pText The text to create
	 * @param color Differents style to set
	 */
	public ChatComponent(String pText, ChatColor... color)	{
		addText(pText, color);
	}
	
	/**
	 * Create text with FormatedChatComponent
	 * @param chat instance of FormatedChatComponent
	 */
	public ChatComponent(FormatedChatComponent chat)	{
		text = new TextComponent(ChatColor.translateAlternateColorCodes('&', chat.getFormatText()));
	}
	
	/**
	 * Send text to player
	 * @param player The player to display text
	 */
	@Override
	public void showTo(Player player)	{
		player.spigot().sendMessage(text);
	}
	
	/**
	 * Add text with style to the setted text
	 * @param pText Text to add
	 * @param color The new style to set
	 */
	public void addText(String pText, ChatColor... color)	{
		TextComponent a = new TextComponent(pText);
		addStyle(a, color);
		text.addExtra(a);
	}
	
	/**
	 * Add text with clickEvent
	 * @param pText The text to set with clickEvent, if text is "" or null, the event will be set on current text
	 * @param event The specific Event
	 * @param color Differents style to set for the text
	 */
	public void addClickEvent(String pText, ClickEvent event, ChatColor... color)	{
		net.md_5.bungee.api.chat.ClickEvent.Action action = net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL;
		if (!(event instanceof ClickEvent))	{event = new ClickEvent(action, "https://google.com");}
		
		if (pText == null || pText.length() == 0)	{text.setClickEvent(event);}
		else {
			TextComponent b = new TextComponent(pText);
			addStyle(b, color);
			b.setClickEvent(event);
			text.addExtra(b);
		}
	}
	
	/**
	 * Add text with hoverEvent
	 * @param pText The text to set with hoverEvent, if text is "" or null, the event will be set on current text
	 * @param event The specific Event
	 * @param color Differents style to set for the text
	 */
	public void addHoverEvent(String pText, HoverEvent event, ChatColor... color)	{
		net.md_5.bungee.api.chat.HoverEvent.Action action = net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT;
		if (!(event instanceof HoverEvent))	{event = new HoverEvent(action, new ComponentBuilder("§6Dream§aAPI").create());}
		
		else {
			TextComponent b = new TextComponent(pText);
			addStyle(b, color);
			b.setHoverEvent(event);
			text.addExtra(b);
		}
	}
	
	/**
	 * Merge two ChatComponent
	 * @param textToAdd ChatComponent to merge with the instance
	 */
	public void addChatComponent(ChatComponent textToAdd)	{
		this.text.addExtra(textToAdd.text);
	}
	
	/**
	 * Convert an ChatComponent to FormatedChatComponent
	 * (ChatComponent use in chat, and convert to display in title per example)
	 * @return FormatedChatComponent Text with § for color
	 */
	public FormatedChatComponent toFormatedChat()	{
		return new FormatedChatComponent(text.toLegacyText());
	}
	
	private void addStyle(TextComponent text, ChatColor... color)	{
		for (ChatColor c : color)	{
			
			switch (c)	{
			case BOLD:
				text.setBold(true);
				break;
			case ITALIC:
				text.setItalic(true);
				break;
			case UNDERLINE:
				text.setUnderlined(true);
				break;
			case STRIKETHROUGH:
				text.setStrikethrough(true);
				break;
			case MAGIC:
				text.setObfuscated(true);
				break;
			default:
				if (!(c instanceof ChatColor))	{c = ChatColor.WHITE;}
				text.setColor(c);
				break;
			}		
		}
	}
}
