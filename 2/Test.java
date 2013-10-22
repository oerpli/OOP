import java.util.Random;

//gebraucht wird eigentlich nur Main.User
import Log.Log;//um Log- verhalten zu steuern.
import Main.ContestManager;//Um ergebnisse am ende auszugeben
import Main.Time; // Um Zeit f�r Test zu manipulieren
import Main.User; // < Benutzerinteraktion l�uft dar�ber

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		String[] soils = { "sand", "humus", "clay" };
		String[] sorts = { "hokkaido", "patisson", "aladdin" };
		String[] tasks = { "water", "weed", "fertilize", "harvest" };

		User[] user = new User[25];
		for (int i = 0; i < user.length; i++)
			user[i] = User.register(); // 25 benutzer

		Log.chatty = false; // feedback nach jedem task on/off

		// jeweils 2 k�rbisse (zuf�llige kombi) pro benutzer
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(3)], soils[r.nextInt(3)]);
		Time.nextHour();
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(3)], soils[r.nextInt(3)]);

		// die ersten 1500 stunden wird auch ged�ngt, dann nicht mehr
		for (int t = 0; t < 5300; t++) {
			for (int i = 0; i < user.length; i++) {
				if (t < 1500)
					user[i].task(tasks[r.nextInt(3)], r.nextInt(2));
				else
					user[i].task(tasks[r.nextInt(2)], r.nextInt(2));
			}
			Time.nextHour();
		}

		Time.nextDay();
		user[1].task("fertilize", 0);
		while (Time.getDay() < Time.Tage) {// Nr. 24 d�ngt weiterhin
			user[24].task("fertilize", 0); // K�rbis wird vergammeln
			Time.nextDay();
		}
		// ranking der nicht vergammelten k�rbisse
		System.out.println(ContestManager.getRanking());
	}
}
