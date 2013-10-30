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
	 * ÃœberprÃ¼ft die Argumente auf Richtigkeit.
	 */
	protected static boolean execute(User u, String Task, Pot p)
			throws CheatingException, BusyException, TaskException,
			SubmittedException {
		Task = Task.toLowerCase();
		// Überprüft ob der User Zeit hat
		//Wirft Exception falls nicht
		if (ContestManager.UserIsBusy(u)) {
			int freeIn = ContestManager.UserHasTimeIn(u);
			throw new BusyException(freeIn);
		}

		// Überprüft ob der User der Besitzer des Kürbis ist
		//Wirft Exception falls nicht
		if (!"plant".equals(Task) && !ContestManager.UserOwnsPot(u, p))
			throw new CheatingException();

		//Überprüft ob der Kürbis schon fertiggestellt wurde
		//Wirft Exception falls er schon fertig ist
		if (p.isFinished())
			throw new SubmittedException();

		//Führe Tätigkeit aus
		//Wirft Exception falls Task nicht verfügbar
		boolean success = false;
		try {
			success = Tasks.get(Task).execute(u, p);
		} catch (NullPointerException e) {
			throw new TaskException(Task);
		}

		//Setzt den User für einen vorgegeben Zeitraum(je nach Tätigkeit) auf beschäftigt 
		//Macht einen Logeintrag
		//Gibt false zurück falls das ausführen nicht geklappt hat
		ContestManager.setUserBusy(u, Tasks.get(Task).expenditure());
		Log.finishEntry("successfully.", true);
		return success;
	}
}
