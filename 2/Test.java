import Log.Log;
import Main.ContestManager;
import Main.User;

public class Test {
	public static void main(String[] args) {
		User me = User.register();
		User you = User.register();
		Log.chatty = true; // feedback nach jedem task

		me.task("plant", "hokkaido", "sand"); // Pflanzen braucht 1h
		you.task("plant", "Aladdin", "humus"); // Pflanzen braucht 1h
		me.task("plant", "hokkaido", "clay"); // Pflanzen braucht 1h
		// Plague.getPlague();
		// me.task("water", 1);
		// me.task("water", 0);
		// me.nextDay();
		// me.nextDay();
		// me.task("harvest", 1);
		// me.task("harvest", 0);
		// you.task("harvest", 0);
		// System.out.println(ContestManager.getRanking());
		for (int i = 0; i < 1000; i++) {
			me.task("water", 1);
			me.task("water", 0);
			you.task("water", 0);
		}
		me.task("harvest", 1);
		me.task("harvest", 0);
		you.task("harvest", 0);
		System.out.println(ContestManager.getRanking());
	}
}
