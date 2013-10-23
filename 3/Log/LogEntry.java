package Log;

import Main.Pot;
import Main.Time;
import Main.User;

class LogEntry extends Entry {
	final int time;
	final User u;
	final String task;
	final Pot p;
	boolean success;

	public LogEntry(User u, String task, Pot p) {
		super();
		this.time = Time.getTime();
		this.u = u;
		this.task = task;
		this.p = p;
	}

	public String toString() {
		return "Day " + time / 24 + ", " + time % 24 + ":00: " + u
				+ " tried to " + task + (p != null ? " " + p : "") + " "
				+ finish;
	}

	public void finish(String f, boolean s) {
		this.finish = f;
		this.success = s;
	}
}
