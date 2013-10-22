package Exceptions;

import Log.Log;

public class SubmittedException extends Exception {
	private static final long serialVersionUID = 1L;

	public SubmittedException() {
		super();
		Log.finishEntry("but it's already submitted to the commission", false);
	}
}
