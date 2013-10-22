package Main;

import java.util.HashMap;

import Tasks.*;
import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.TaskException;
import Interfaces.Tasks;
import Log.Log;

public abstract class Task {
	private static HashMap<String, Tasks> Tasks = new HashMap<String, Tasks>();
	static {
		Tasks.put("plant", new Plant());
		Tasks.put("water", new Water());
		Tasks.put("fertilize", new Fertilize());
		Tasks.put("weed", new Weed());
		Tasks.put("harvest", new Harvest());
	}

	/**
	 * Eventuell sollte man alle Exceptions die hier entstehen direkt auffangen
	 * und nicht nach auﬂen geben. Ob etwas funktioniert hat oder nicht steht
	 * ohnehin im Log.
	 */
	public static void execute(User u, String Task, Pot p)
			throws CheatingException, BusyException, TaskException {
		String t = Task.toLowerCase();

		// Checks if user has time
		if (UserManager.UserIsBusy(u)) {
			int freeIn = UserManager.UserHasTimeIn(u);
			throw new BusyException(freeIn);
		}

		// checks if user owns the pumpkin he wants to access
		if (!"plant".equals(t) && !UserManager.UserOwnsPot(u, p)) {
			throw new CheatingException();
		}

		// execute task on pumpkin
		try {
			Tasks.get(t).execute(u, p);
		} catch (NullPointerException e) {
			throw new TaskException(Task);
		}
		// set user busy until the task is finished
		UserManager.setUserBusy(u, Tasks.get(t).expenditure());

		Log.finishEntry("successfully.", true);
	}

}
