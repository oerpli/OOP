package Main;

import java.util.HashMap;

import Tasks.*;
import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.SubmittedException;
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
		Tasks.put("poison", new Poison());
	}

	/**
	 * Eventuell sollte man alle Exceptions die hier entstehen direkt auffangen
	 * und nicht nach auﬂen geben. Ob etwas funktioniert hat oder nicht steht
	 * ohnehin im Log.
	 * 
	 * @throws SubmittedException
	 */
	public static boolean execute(User u, String Task, Pot p)
			throws CheatingException, BusyException, TaskException,
			SubmittedException {
		String t = Task.toLowerCase();
		// Checks if user has time
		if (ContestManager.UserIsBusy(u)) {
			int freeIn = ContestManager.UserHasTimeIn(u);
			throw new BusyException(freeIn);
		}

		// checks if user owns the pumpkin he wants to access
		if (!"plant".equals(t) && !ContestManager.UserOwnsPot(u, p)) {
			throw new CheatingException();
		}

		// checks if pumpkin is already submitted (finished)

		if (p.isFinished()) {
			throw new SubmittedException();
		}

		// execute task on pumpkin
		boolean success = false;
		try {
			success = Tasks.get(t).execute(u, p);
		} catch (NullPointerException e) {
			throw new TaskException(Task);
		}
		// set user busy until the task is finished
		ContestManager.setUserBusy(u, Tasks.get(t).expenditure());
		Log.finishEntry("successfully.", true);
		return success;
	}
}
