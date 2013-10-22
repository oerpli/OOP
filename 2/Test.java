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

		Log.chatty = false; // feedback nach jedem task

		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(2)], soils[r.nextInt(2)]);
		Time.nextHour();
		for (int i = 0; i < user.length; i++)
			user[i].task("plant", sorts[r.nextInt(2)], soils[r.nextInt(2)]);

		for (int t = 0; t < 5520; t++) {
			for (int i = 0; i < user.length; i++) {
				user[i].task(tasks[r.nextInt(2)], r.nextInt(2));
			}
			Time.nextHour();
		}
		System.out.println(ContestManager.getRanking());
	}
}
