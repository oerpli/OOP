import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.PlantingException;
import Exceptions.TaskException;
import Log.Log;
import Main.Time;
import Main.UserManager;
import Main.User;

public class Test {
	public static void main(String[] args) {
		UserManager.registerUser();
		User me = UserManager.getUser(0);

		Log.chatty = true; // feedback nach jedem task

		try {
			me.plant("Hokkaido", "sand"); // Pflanzen braucht 1h
			// me.plant("Hokkaido", "sand"); // Pflanzen braucht 1h
			Time.nextDay();
			Time.nextDay();

			me.task("water", 0);

			// me.task("water", 0);// Funktioniert
			// Time.nextDay();
			// Time.nextDay();
			// Time.nextDay();
			// Time.nextDay();
			// Time.nextDay();
			// me.task("fertilize", 0);
			// System.out.println("OK");
			// Time.nextHour();
			// me.task("weed", 0);// Funktioniert nicht weil weed 2 stunden
			// braucht
		} catch (PlantingException e) {
			e.printStackTrace();
		} catch (CheatingException e) {
			e.printStackTrace();
		} catch (BusyException e) {
			e.printStackTrace();
		} catch (TaskException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) { // dirty
			System.out.println("Pumpkin not available");
		}
	}
}
