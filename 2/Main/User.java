package Main;

import java.util.ArrayList;

import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.PlantingException;
import Exceptions.SubmittedException;
import Exceptions.TaskException;
import Log.Log;

/**
 * Verwaltet die Daten eines Teilnehmers. Stellt Methoden zur Aufzucht bereit.
 * Ermöglicht nur erlaubte Pflegemaßnahmen. Ist die einzige Möglichkeit des
 * Zugriffs auf Kürbisse (indirekt).
 */
public class User {
	public final int ID;
	private ArrayList<Pot> pots = new ArrayList<Pot>();

	public User(int ID) {
		this.ID = ID;
	}

	public boolean task(String task, int p) {
		Log.addEntry(this, task, new Pot(p));
		try {
			return this.task(task, pots.get(p));
		} catch (IndexOutOfBoundsException e) {
			Log.finishEntry("but he has not that many pots.", false);
			return false;
		}
	}

	public boolean task(String task, String pType, String sType) {
		Log.addEntry(this, "plant a " + pType + " in " + sType, null);
		Pot p;
		try {
			p = new Pot(Pumpkin.create(pType), Soil.create(sType), pots.size());
		} catch (PlantingException e) {
			return false;
		}
		this.task(task.toLowerCase(), p);
		return true;
	}

	private boolean task(String task, Pot p) {
		try {
			return Task.execute(this, task.toLowerCase(), p);
		} catch (CheatingException | BusyException | TaskException
				| SubmittedException e) {
			return false;
		}
	}

	public String toString() {
		return "User" + ID;
	}

	public void addPot(Pot p) {
		pots.add(p);
	}

	public static User register() {
		return ContestManager.registerUser();
	}
}
