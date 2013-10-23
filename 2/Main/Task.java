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

	protected static boolean execute(User u, String Task, Pot p)
			throws CheatingException, BusyException, TaskException,
			SubmittedException {
		Task = Task.toLowerCase();
		// Checks if user has time
		if (ContestManager.UserIsBusy(u)) {
			int freeIn = ContestManager.UserHasTimeIn(u);
			throw new BusyException(freeIn);
		}

		// checks if user owns the pumpkin he wants to access
		if (!"plant".equals(Task) && !ContestManager.UserOwnsPot(u, p))
			throw new CheatingException();

		// checks if pumpkin is already submitted (finished)
		if (p.isFinished())
			throw new SubmittedException();

		// execute task on pumpkin
		boolean success = false;
		try {
			success = Tasks.get(Task).execute(u, p);
		} catch (NullPointerException e) {
			throw new TaskException(Task);
		}

		// set user busy until the task is finished and finish log
		ContestManager.setUserBusy(u, Tasks.get(Task).expenditure());
		Log.finishEntry("successfully.", true);
		return success;
	}
}
