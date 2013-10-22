package Main;

import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.PlantingException;
import Exceptions.TaskException;
import Log.Log;

/**
 * Verwaltet die Daten eines Teilnehmers. Stellt Methoden zur Aufzucht bereit.
 * Ermöglicht nur erlaubte Pflegemaßnahmen. Ist die einzige Möglichkeit des
 * Zugriffs auf Kürbisse (indirekt).
 */
public class User {
	public final int ID;
	private int pots = 0;

	public User(int ID) {
		this.ID = ID;
	}

	public boolean task(String task, int p) {
		Log.addEntry(this, task, new Pot(p));
		try {
			Task.execute(this, task.toLowerCase(), UserManager.getPots(this)
					.get(p));
		} catch (IndexOutOfBoundsException e) {
			Log.finishEntry("but he has not that many pots.", false);
		} catch (CheatingException | BusyException | TaskException e) {
			return false;
		}
		return true;
	}

	public boolean task(String task, String pType, String sType) {
		Log.addEntry(this, "plant a " + pType + " in " + sType, null);
		try {
			Pot p = new Pot(Pumpkin.create(pType.toLowerCase()),
					Soil.create(sType.toLowerCase()), pots);
			Task.execute(this, task.toLowerCase(), p);
		} catch (PlantingException | CheatingException | BusyException
				| TaskException e) {
			return false;
		}
		pots++;
		return true;
	}

	private void task(String task, Pot p) throws CheatingException,
			BusyException, TaskException {
		Log.addEntry(this, task, p);
		Task.execute(this, task.toLowerCase(), p);
	}

	public void nextDay() {
		Time.nextDay();
	}

	public String toString() {
		return "User" + ID;
	}

	/*
	 * public void plant(String task, String pType, String sType) throws
	 * PlantingException, CheatingException, BusyException, TaskException { if
	 * (!"plant".equals(task.toLowerCase())) return;
	 * 
	 * pType = pType.toLowerCase(); sType = sType.toLowerCase(); Pot p = new
	 * Pot(Pumpkin.create(pType), Soil.create(sType)); this.task("plant", p); }
	 */
}
