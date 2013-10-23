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
 * Zugriffs auf Kürbisse  (indirekt).
 */
public class User {

	public final int ID;
	private ArrayList<Pot> pots;

	public User(int ID) {
	
		pots = new ArrayList<Pot>();
		this.ID = ID;
	}
	
	/**
	 * Ein neuer Nutzer registriert sich.
	 */
	public static User register() {
		return ContestManager.registerUser();
	}

	/**
	 * Erledigt Pflegemaßnahmen.
	 */
	public boolean task(String task, int p) {
	
		Log.addEntry(this, task, new Pot(p));
		
		try {
			return this.task(task, pots.get(p));
			
		} catch (IndexOutOfBoundsException e) {
			Log.finishEntry("but he has not that many pots.", false);
			return false;
		}
	}

	/**
	 * Pflanzt neuen Kürbis.
	 */
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

	/**
	 * Gemeinsame Exceptionbehandlung der task-Methoden.
	 */
	private boolean task(String task, Pot p) {
		try {
			return Task.execute(this, task.toLowerCase(), p);
			
		} catch (CheatingException | BusyException | TaskException
				| SubmittedException e) {
			return false;
		}
	}

	/**
	 * Ein neuer Topf eines Nutzers wird hinzugefügt.
	 */
	public void addPot(Pot p) {
		pots.add(p);
	}

	public String toString() {
		return "User" + ID;
	}
}
