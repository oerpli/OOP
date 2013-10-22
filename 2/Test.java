import java.util.Random;

import Log.Log;
import Main.ContestManager;
import Main.Time;
import Main.User;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		String[] soils = { "sand", "humus", "clay" };
		String[] sorts = { "hokkaido", "patisson", "aladdin" };
		String[] tasks = { "water", "weed", "fertilize" };

		User[] user = new User[25];
		for (int i = 0; i < user.length; i++)
			user[i] = User.register();

		Log.chatty = true; // feedback nach jedem task

		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(3)], soils[r.nextInt(3)]);
		Time.nextHour();
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(3)], soils[r.nextInt(3)]);

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
		while (Time.getDay() < Time.Tage) {
			user[24].task("fertilize", 0);
			Time.nextDay();
		}

		System.out.println(ContestManager.getRanking());
	}
}
