package Exceptions;

import Log.Log;

public class CheatingException extends Exception {
	private static final long serialVersionUID = -5963689989680104831L;

	public CheatingException() {
		super();
		Log.finishEntry("but the Pot ain't his.", false);
	}
}
