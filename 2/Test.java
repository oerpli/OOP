import Log.Log;
import Main.ContestManager;
import Main.User;

public class Test {
	public static void main(String[] args) {
		ContestManager.registerUser();
		User me = ContestManager.getUser(0);

		Log.chatty = true; // feedback nach jedem task

		me.task("plant", "hokkaido", "sand"); // Pflanzen braucht 1h
		me.nextDay();
		me.task("plant", "hokkaido", "sand"); // Pflanzen braucht 1h

		me.nextDay();
		me.nextDay();
		// Plague.getPlague();
		me.task("water", 1);
		me.task("water", 0);
		me.nextDay();
		me.task("harvest", 0);
		me.nextDay();
		me.task("harvest", 1);
		System.out.println(ContestManager.getRanking());

		// me.task("water", 0);// Funktioniert
		// me.nextDay();
		// Time.nextDay();
		// Time.nextDay();
		// Time.nextDay();
		// Time.nextDay();
		// me.task("fertilize", 0);
		// System.out.println("OK");
		// Time.nextHour();
		// me.task("weed", 0);// Funktioniert nicht weil weed 2 stunden
		// braucht
	}
}
