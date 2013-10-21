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

	public void task(String task, int p) throws CheatingException,
			BusyException, TaskException {	
		
		this.task(task, UserManager.getPots(this).get(p));
	}
	
	public void task(String task, String pType, String sType) throws PlantingException, CheatingException, BusyException,
			TaskException {
		Pot p;
		
		try {
			p = new Pot(Pumpkin.create(pType), Soil.create(sType));
		} catch (PlantingException e) {
			Log.addEntry(this, task, p);
			throw e;
		}
		
		this.task("plant", p);
	}

	private void task(String task, Pot p) throws CheatingException,
			BusyException, TaskException {
		Task.execute(this, task, p);
	}
	
	public void nextDay() {
		Time.nextDay();
	}

	public String toString() {
		return "User" + ID;
	}
	
	/*public void plant(String task, String pType, String sType)
			throws PlantingException, CheatingException, BusyException,
			TaskException {
		if (!"plant".equals(task.toLowerCase()))
			return;

		pType = pType.toLowerCase();
		sType = sType.toLowerCase();
		Pot p = new Pot(Pumpkin.create(pType), Soil.create(sType));
		this.task("plant", p);
	}*/
}
