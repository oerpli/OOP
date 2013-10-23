import java.util.Random;

//gebraucht wird eigentlich nur Main.User
import Log.Log;//um Log- verhalten zu steuern.
import Main.ContestManager;//Um ergebnisse am ende auszugeben
import Main.Time; // Um Zeit fuer Test zu manipulieren
import Main.User; // Benutzerinteraktion laeuft darueber

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		String[] soils = { "sand", "humus", "clay" };
		String[] sorts = { "hokkaido", "patisson", "aladdin", "Magic" };
		String[] tasks = { "water", "weed", "poison", "fertilize", "harvest" };
		String[] tasks1 = { "water", "weed", "poison", "harvest", "fertilize" };

		int users = 25;// 25 benutzer
		User[] user = new User[users];
		for (int i = 0; i < user.length; i++)
			user[i] = User.register();

		Log.chatty = false; // feedback nach jedem task on/off

		// jeweils 2 kuerbisse (zufaellige kombi) pro benutzer
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(4)], soils[r.nextInt(3)]);
		Time.nextHour();
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(4)], soils[r.nextInt(3)]);

		// die ersten 1500 stunden wird auch geduengt, dann nicht mehr
		for (int t = 0; t < 5300; t++) {
			for (int i = 0; i < user.length; i++) {
				if (t < 1500)
					user[i].task(tasks[r.nextInt(4)], r.nextInt(2));
				else
					user[i].task(tasks1[r.nextInt(4)], r.nextInt(2));
			}
			Time.nextHour();
		}

		while (Time.getDay() < Time.Tage) {
			Time.nextDay();
		}
		// ranking der nicht vergammelten kuerbisse
		System.out.println(ContestManager.getRanking());
	}
}
