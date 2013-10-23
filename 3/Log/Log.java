package Log;

import java.util.ArrayList;

import Main.Pot;
import Main.User;

public abstract class Log {
	private static ArrayList<Entry> log = new ArrayList<Entry>();
	private static LogEntry last = null;
	private static Entry Last = null;
	public static boolean chatty = false;

	public static void addEntry(User u, String task, Pot p) {
		if (last == null) {
			last = new LogEntry(u, task, p);
			log.add(last);
		} else {// TODO Only here for debugging
			System.err.println(last);
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

	public static void print() {
		for (Entry entry : log)
			System.out.println(entry);
	}

	public static void addEntry(String msg) {
		Last = new Entry(msg);
		log.add(Last);
		if (chatty)
			System.out.println(Last);
		Last = null;
	}
}
