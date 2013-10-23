package Exceptions;

import Log.Log;

public class TaskException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskException(String task) {
		super();
		Log.finishEntry("but " + task + " is not allowed.", false);
	}
}
