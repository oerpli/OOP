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
	 * Ruft  die execute-Methode der passenden Task Subklasse auf.
	 * Überprüft die Argumente auf Richtigkeit.
	 */
	protected static boolean execute(User u, String Task, Pot p)
			throws CheatingException, BusyException, TaskException,
			SubmittedException {
		Task = Task.toLowerCase();
		// �berpr�ft ob der User Zeit hat
		//Wirft Exception falls nicht
		if (ContestManager.UserIsBusy(u)) {
			int freeIn = ContestManager.UserHasTimeIn(u);
			throw new BusyException(freeIn);
		}

		// �berpr�ft ob der User der Besitzer des K�rbis ist
		//Wirft Exception falls nicht
		if (!"plant".equals(Task) && !ContestManager.UserOwnsPot(u, p))
			throw new CheatingException();

		//�berpr�ft ob der K�rbis schon fertiggestellt wurde
		//Wirft Exception falls er schon fertig ist
		if (p.isFinished())
			throw new SubmittedException();

		//F�hre T�tigkeit aus
		//Wirft Exception falls Task nicht verf�gbar
		boolean success = false;
		try {
			success = Tasks.get(Task).execute(u, p);
		} catch (NullPointerException e) {
			throw new TaskException(Task);
		}

		//Setzt den User f�r einen vorgegeben Zeitraum(je nach T�tigkeit) auf besch�ftigt 
		//Macht einen Logeintrag
		//Gibt false zur�ck falls das ausf�hren nicht geklappt hat
		ContestManager.setUserBusy(u, Tasks.get(Task).expenditure());
		Log.finishEntry("successfully.", true);
		return success;
	}
}
