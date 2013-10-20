package Main;

import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.PlantingException;
import Exceptions.TaskException;

/**
 * Verwaltet die Daten eines Teilnehmers. Stellt Methoden zur Aufzucht bereit.
 * Ermöglicht nur erlaubte Pflegemaßnahmen. Ist die einzige Möglichkeit des
 * Zugriffs auf Kürbisse (indirekt).
 */
public class User {
	public final int ID;

	public User(int ID) {
		this.ID = ID;
	}

	public void plant(String task, String pType, String sType)
			throws PlantingException, CheatingException, BusyException,
			TaskException {
		if (!"plant".equals(task.toLowerCase()))
			return;

		pType = pType.toLowerCase();
		sType = sType.toLowerCase();
		Pot p = new Pot(Pumpkin.create(pType), Soil.create(sType));
		this.task("plant", p);
	}

	public void task(String task, int p) throws CheatingException,
			BusyException, TaskException {
		this.task(task, UserManager.getPots(this).get(p));
	}

	// public void taskWrapper() {
	/**
	 * TODO Alle aufgaben sollten �ber 1 funktion laufen in der vern�nftig
	 * geloggt werden kann. syntax etwa so:
	 * 
	 * user.task("plant custom aladdin hokkaido sand");
	 * 
	 * user.task("water 0");
	 * 
	 * user.task("harvest 0");
	 */
	// }

	private void task(String task, Pot p) throws CheatingException,
			BusyException, TaskException {
		Task.execute(this, task, p);
	}

	public String toString() {
		return "User" + ID;
	}
}
