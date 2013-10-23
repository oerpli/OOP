package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import Log.Log;

/**
 * Verwaltet alle  Teilnehmer.
 */
public abstract class ContestManager {
	private static int N = 0; // Anzahl der Teilnehmer
	private static HashMap<Integer, User> userList;
	private static HashMap<User, Integer> busyUntil;
	private static HashMap<Pot, User> userPots;
	private static ArrayList<Pot> finishedPots;

	static {
		userList = new HashMap<Integer, User>();
		busyUntil = new HashMap<User, Integer>();
		userPots = new HashMap<Pot, User>();
		finishedPots = new ArrayList<Pot>();
	}

	/**
	 * Ein neues User-Objekt wird erzeugt.
	 */
	public static User registerUser() {
		User u = new User(N);
		userList.put(N, u);
		busyUntil.put(u, -1);
		N++;
		return u;
	}

	// public static User getUser(int i) {
	// return userList.get(i);
	// }

	protected static void setUserBusy(User user, int hours) {
		busyUntil.put(user, Time.getTime() + hours);
	}

	public static boolean UserOwnsPot(User u, Pot p) {
		return userPots.get(p) == u;
	}

	// public static ArrayList<Pot> getPots(User user) {
	// return userPots.get(user);
	// }

	public static void addPotToUser(User u, Pot p) {
		userPots.put(p, u);
	}

	public static int UserHasTimeIn(User u) {
		return busyUntil.get(u) - Time.getTime();
	}

	public static boolean UserIsBusy(User u) {
		return busyUntil.get(u) > Time.getTime();
	}

	public static String getRanking() {
		String out = "";
		Collections.sort(finishedPots);
		int s = finishedPots.size();
		for (Pot p : finishedPots) {
			out += (s--) + ".: " + p.toString() + " from " + userPots.get(p)
					+ " (" + p.p.getWeight() + "kg)" + '\n';
		}
		return out;
	}

	protected static boolean addFinishedPot(Pot p) {
		// vergammelte kürbisse eventuell weglassen
		// evtl eine exception wenn userPots.get(p) nichts zurückgibt (wäre dann
		// betrug).
		if (!p.p.isRotten()) {
			Log.addEntry("The pumpkin submitted by " + userPots.get(p)
					+ " was accepted.");
			return finishedPots.add(p);
		} else {
			Log.addEntry("The pumpkin submitted by " + userPots.get(p)
					+ " was rejected because it was rotten.");
			return false;
		}
	}
}
