import Log.Log;
import Main.ContestManager;
import Main.Time;
import Main.User;

public class Test {
	public static void main(String[] args) {
		User me = User.register();
		User you = User.register();
		Log.chatty = true; // feedback nach jedem task

		me.task("plant", "hokkaido", "sand"); // Pflanzen braucht 1h
		you.task("plant", "patisson", "sand"); // Pflanzen braucht 1h
		Time.nextHour();
		you.task("plant", "aladdin", "sand"); // Pflanzen braucht 1h

		for (int i = 0; i < 100; i++) {
			me.task("water", 0);
			you.task("water", 0);
			you.task("water", 1);
			Time.nextDay();
		}
		System.out.println(you.task("harvest", 1));
		Time.nextHour();
		System.out.println(you.task("harvest", 0));
		System.out.println(me.task("harvest", 0));
		System.out.println(ContestManager.getRanking());
	}
}
