package com.mrsweeter.dreamAPI.exceptions;

public class NoKeyWithThisNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4315227086812751204L;
	
	/**
	 * Throw exception
	 */
	public NoKeyWithThisNameException()	{
		super("[DreamAPI] - No id with this name");
	}
	
	/**
	 * Throw exception with custom message
	 * @param text The error message
	 */
	public NoKeyWithThisNameException(String text)	{
		super("[DreamAPI] - " + text);
	}
}
