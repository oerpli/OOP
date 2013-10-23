package Exceptions;

import Log.Log;

public class BusyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusyException(int freeIn) {
		super();
		Log.finishEntry("but he's busy for " + freeIn + " more hour"
				+ (freeIn > 1 ? "s." : "."), false);
	}
}
