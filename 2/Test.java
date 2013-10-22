import Log.Log;
import Main.ContestManager;
import Main.Time;
import Main.User;

public class Test {
	public static void main(String[] args) {
		User me = User.register();
		User you = User.register();
		Log.chatty = true; // feedback nach jedem task
		// me.task("plant", "hokkaido", "sand"); // Pflanzen braucht 1h
		you.task("plant", "patisson", "humus"); // Pflanzen braucht 1h
		for (int i = 0; i < 5520; i++) {
			you.task("fertilize", 0);
			Time.nextHour();
			if (i > 230 * 24)
				break;
		}
		System.out.println(ContestManager.getRanking());
	}
}
