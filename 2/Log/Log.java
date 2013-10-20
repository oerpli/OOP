package Log;

import java.util.ArrayList;

import Main.Pot;
import Main.User;

public abstract class Log {
	private static ArrayList<LogEntry> log = new ArrayList<LogEntry>();
	private static LogEntry last;
	public static boolean chatty = false;
	public static boolean debug=false;

	public static void addEntry(User u, String task, Pot p) {
		if (last == null) {
			last = new LogEntry(u, task, p);
			log.add(last);
		} else {// TODO Only here for debugging
			System.err.println("Last entry not finished yet");
		}
	}

	public static void finishEntry(String f, boolean s) {
		if (last != null) {
			last.finish(f, s);
			if (chatty)
				System.out.println(last);
			last = null;
		} else { // TODO Only here for debugging
			System.err.println("Entry already finished");
		}
	}

	public static void add(LogEntry logEntry) {
	}

	public static void print() {
		for (LogEntry entry : log)
			System.out.println(entry);
	}

}
