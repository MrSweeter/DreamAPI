package com.mrsweeter.dreamAPI.exceptions;

public class InvalidSectionException extends RuntimeException	{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2101595855597753138L;
	
	/**
	 * Throw exception
	 */
	public InvalidSectionException()	{
		super("[DreamAPI] - Invalid section for this task");
	}
	
	/**
	 * Throw exception with custom message
	 * @param text The error message
	 */
	public InvalidSectionException(String text)	{
		super("[DreamAPI] - " + text);
	}
}
