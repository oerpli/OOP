package Log;

import Main.Pot;
import Main.Time;
import Main.User;

class LogEntry {
	final int time;
	final User u;
	final String task;
	final Pot p;
	String finish;
	boolean success;

	public LogEntry(User u, String task, Pot p) {
		this.time = Time.getTime();
		this.u = u;
		this.task = task;
		this.p = p;
	}

	public String toString() {
		return "Day " + time / 24 + ", " + time % 24 + ":00: " + u
				+ " tried to " + task + " " + p + " " + finish;
	}

	public void finish(String f, boolean s) {
		this.finish = f;
		this.success = s;
	}
}