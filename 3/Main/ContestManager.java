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

	//Verwaltet besch�ftigte User
	//busyUntil speichert den User + den Zeitpunkt wie lange er besch�ftigt ist
	protected static void setUserBusy(User user, int hours) {
		busyUntil.put(user, Time.getTime() + hours);
	}

	//Ueberpr�ft ob Topf dem User geh�rt
	//gibt false zur�ck falls dem User der Topf nicht geh�rt
	public static boolean UserOwnsPot(User u, Pot p) {
		return userPots.get(p) == u;
	}

	//Speichert die Zugeh�rigkeit eines Topfes zu einem User
	public static void addPotToUser(User u, Pot p) {
		userPots.put(p, u);
	}

	//Gibt zur�ck wie lange der User noch besch�ftigt ist
	//Falls er nicht mehr besch�ftigt ist w�rde zur�ckgegeben wie lange er das schon nicht mehr ist
	public static int UserHasTimeIn(User u) {
		return busyUntil.get(u) - Time.getTime();
	}

	//�berpr�ft ob der User besch�ftigt ist
	//gibt false zurueck wenn der User besch�ftigt ist
	public static boolean UserIsBusy(User u) {
		return busyUntil.get(u) > Time.getTime();
	}

	//Listet alle fertigen Toepfe auf
	//gibt einen String mit allen fertigen Toepfen aus
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

	//Ueberprueft ob der Kuerbis vergammelt ist und gibt false zur�ck falls dem so ist
	//gibt true zurueck wenn der Kuerbis nicht vergammelt ist und erfolgreich zu 
	//finishedPots hinzugefuegt wurde
	protected static boolean addFinishedPot(Pot p) {
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
