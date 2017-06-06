package com.mrsweeter.dreamAPI.Scoreboard;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 * 
 * @author MrSweeter
 *
 */
public class SidebarDisplayer {
	
	private Scoreboard scoreboard;
	private Objective objective;
	private List<String> textDisplay;
	
	/**
	 * Constructor, create your SiderbarDisplayer
	 * @param name The name to display for the scoreboard
	 */
	public SidebarDisplayer(String name)	{
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		if (scoreboard.getObjective("msd-focus-040617") != null)	{scoreboard.getObjective("msd-focus-040617").unregister();}
		objective = scoreboard.registerNewObjective("msd-dream-040617", "dummy");
		textDisplay = Arrays.asList(new String[15]);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(name);
	}
	
	/**
	 * Set text to a specific lines
	 * @param text The text to display on the line [lines]
	 * @param lines The line where you want display [text], 1-15
	 */
	public void setLineText(String text, int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		if (textDisplay.contains(text))	{text += " ";}
		Score score = objective.getScore(text);
		score.setScore(100-lines);
		textDisplay.set(lines-1, text);
		
		if (lines != 1)	{
			setLineText("", lines-1);
		}
		
	}
	
	/**
	 * Reset/Remove display line
	 * @param lines The lines to remove, 1-15
	 */
	public void removeLine(int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		if (textDisplay.get(lines-1) instanceof String)	{
			scoreboard.resetScores(textDisplay.get(lines-1));
			textDisplay.set(lines-1, null);
		}
	}
	
	/**
	 * Change the text in display lines
	 * @param newText The new text to display in [lines]
	 * @param lines The line where you want change the text, 1-15
	 */
	public void changeLineText(String newText, int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		removeLine(lines);
		setLineText(newText, lines);
	}
	
	public String getTextLine(int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		return textDisplay.get(lines-1);
	}
	
	/**
	 * Get scoreboard-bukkit-spigot
	 * @return instance of org.bukkit.scoreboard.Scoreboard
	 */
	public Scoreboard getScoreboard()	{
		return scoreboard;
	}
	
	/**
	 * Get Objective-bukkit-spigot
	 * @return instance of org.bukkit.scoreboard.Objective
	 */
	public Objective getObjective()	{
		return objective;
	}
}
