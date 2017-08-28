package com.mrsweeter.dreamAPI.exceptions;

public class InvalidConfigurationValueException extends RuntimeException	{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7583702881424091908L;
	
	/**
	 * Throw exception with custom message
	 * @param text The error message
	 */
	public InvalidConfigurationValueException(String text)	{
		super(text);
	}
}
