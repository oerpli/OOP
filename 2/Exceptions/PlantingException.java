package Exceptions;

import Log.Log;

public class PlantingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlantingException(String s) {
		super(s);
		Log.finishEntry("but " + s + " was not available.", false);
	}
}
