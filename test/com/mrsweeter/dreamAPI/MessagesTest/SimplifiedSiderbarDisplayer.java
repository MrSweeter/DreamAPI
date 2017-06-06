package com.mrsweeter.dreamAPI.MessagesTest;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author MrSweeter
 *
 */
public class SimplifiedSiderbarDisplayer {
	
	private List<String> textDisplay;
	
	public SimplifiedSiderbarDisplayer(String name)	{
		textDisplay = Arrays.asList(new String[15]);
	}
	
	public void setLineText(String text, int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		if (textDisplay.contains(text))	{
			text += " ";
		}
		if (lines == 1 || textDisplay.get(lines-2) instanceof String)	{
			textDisplay.set(lines-1, text);
		} else {
			textDisplay.set(lines-1, text);
			setLineText("", lines-1);
		}
		
	}
	
	public void removeLine(int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		if (textDisplay.get(lines-1) instanceof String)	{
			textDisplay.set(lines-1, null);
		}
	}
	
	public String getTextLine(int lines)	{
		if (lines > 15 || lines <= 0)	{
			throw new IllegalArgumentException("The lines must superior to 0 and inferior to 16");
		}
		return textDisplay.get(lines-1);
	}
}
