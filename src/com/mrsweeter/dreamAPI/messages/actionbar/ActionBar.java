package com.mrsweeter.dreamAPI.messages.actionbar;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mrsweeter.dreamAPI.messages.DisplayMessage;
import com.mrsweeter.dreamAPI.messages.chat.FormatedChatComponent;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.ChatMessageType;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import net.minecraft.server.v1_12_R1.PlayerConnection;
/**
 * 
 * @author MrSweeter
 *
 */
public class ActionBar extends DisplayMessage	{
	
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
	
	@Override
	public void showTo(Player player) {
		
		IChatBaseComponent chatComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', text) + "\"}");
		PacketPlayOutChat playOutChat = new PacketPlayOutChat(chatComponent, ChatMessageType.GAME_INFO);
		EntityPlayer handle = ((CraftPlayer)player).getHandle();
		PlayerConnection connection = handle.playerConnection;
		
		connection.sendPacket(playOutChat);
		
	}
}
