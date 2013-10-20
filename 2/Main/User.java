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

	public void plant(String pType, String sType) throws PlantingException,
			CheatingException, BusyException, TaskException {
		pType = pType.toLowerCase();
		sType = sType.toLowerCase();
		Pot p = new Pot(Pumpkin.create(pType), Soil.create(sType));
		this.task("plant", p);
	}

	public void task(String task, int p) throws CheatingException,
			BusyException, TaskException {
		this.task(task, UserManager.getPots(this).get(p));
	}

	private void task(String task, Pot p) throws CheatingException,
			BusyException, TaskException {
		Task.execute(this, task, p);
	}

	public String toString() {
		return "User" + ID;
	}
}
