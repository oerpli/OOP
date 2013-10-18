import java.util.HashMap;

/**
 * Verwaltet alle Teilnehmer.
 */
class UserManager {
	private static HashMap<String, User> userList;

	static {
		userList = new HashMap<String, User>();
	}

	public static void register(String name) {
		User u = new User();
		userList.put(name, u);
	}

	public static User getUser(String name) {
		return userList.get(name);
	}
}
