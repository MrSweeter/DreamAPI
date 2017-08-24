package com.mrsweeter.dreamAPI.messages.title;

import org.bukkit.entity.Player;

import com.mrsweeter.dreamAPI.messages.DisplayMessage;

/**
 * 
 * @author MrSweeter
 * 
 */
public class Title extends DisplayMessage	{
	
	private String title;
	private String subTitle;
	private int fadeIn = 20, stay = 40, fadeOut = 20;
	
	/**
	 * Creates new title
	 * @param title The title to display
	 */
	public Title(String title)	{
		this(title, "");
	}
	
	/**
	 * Creates new title with subtitle
	 * @param title The title to display, can be "" or null
	 * @param subTitle The subtitle to display, can be "" or null
	 */
	public Title(String title, String subTitle)	{
		this(title, subTitle, 1, 2, 1);
	}
	
	/**
	 * Creates title with subtitle, and manage delay
	 * @param title The title to display, can be "" or null
	 * @param subTitle The subtitle to display can be "" or null
	 * @param fadeIn time to appear, in seconds
	 * @param stay time to display, fix, in seconds
	 * @param fadeOut time to disappear, in seconds
	 */
	public Title(String title, String subTitle, int fadeIn, int stay, int fadeOut)	{
		
		if (title == null && subTitle == null)	{throw new IllegalArgumentException("Title and subtitle can't be null");}
		
		if (title == null)	{title = "";}
		if (subTitle == null)	{subTitle = "";}
		
		this.title = title;
		this.subTitle = subTitle;
		this.fadeIn = fadeIn*20;
		this.fadeOut = fadeOut*20;
		this.stay = stay*20;
		
	}
	
	/**
	 * Show title to player
	 * @param player Player to view
	 */
	@Override
	public void showTo(Player player)	{
		player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
	}
}
