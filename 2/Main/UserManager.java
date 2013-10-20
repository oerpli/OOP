package Main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Verwaltet alle Teilnehmer.
 */
public class UserManager {
	private static int N = 0; // Anzahl der Teilnehmer
	private static HashMap<Integer, User> userList;
	private static HashMap<User, Integer> busyUntil;
	private static HashMap<User, ArrayList<Pot>> userPots;

	static {
		userList = new HashMap<Integer, User>();
		busyUntil = new HashMap<User, Integer>();
		userPots = new HashMap<User, ArrayList<Pot>>();
	}

	public static void registerUser() {
		User u = new User(N);
		userList.put(N, u);
		busyUntil.put(u, -1);
		userPots.put(u, new ArrayList<Pot>());
		N++;
	}

	public static User getUser(int i) {
		return userList.get(i);
	}

	public static void setUserBusy(User user, int hours) {
		busyUntil.put(user, Time.getTime() + hours);
	}

	public static boolean UserOwnsPot(User u, Pot p) {
		return userPots.get(u).contains(p);
	}

	public static ArrayList<Pot> getPots(User user) {
		return userPots.get(user);
	}

	public static void plantPot(User u, Pot p) {
		userPots.get(u).add(p);
	}

	public static int UserHasTimeIn(User u) {
		return busyUntil.get(u) - Time.getTime();
	}

	public static boolean UserIsBusy(User u) {
		return busyUntil.get(u) > Time.getTime();
	}
}