package Main;

import java.util.ArrayList;

import Exceptions.BusyException;
import Exceptions.CheatingException;
import Exceptions.PlantingException;
import Exceptions.SubmittedException;
import Exceptions.TaskException;
import Log.Log;

public class User {

	public final int ID;
	private ArrayList<Pot> pots; // Jeder Topf darf nur einmal vorkommen // Invariante, blöd, nur zur Demonstration

	/**
	 * Die übergebene ID ist einzigartig // Vorbedingung
	 */
	public User(int ID) {
	
		pots = new ArrayList<Pot>();
		this.ID = ID;
	}
	
	/**
	 * Ein Nutzer wird zur Liste hinzugefügt. // Nachbedingung
	 * Das neue Nutzerobjekt wird zurückgegeben. // Nachbedingung
	 */
	public static User register() {
		return ContestManager.registerUser();
	}

	/**
	 * Führt die gewählte Aufgabe am Topf durch. // Nachbedingung
	 * task ist der Name einer exisitierenden Aufgabe. // Vorbedingung, nicht nötig, da im Code geprüft wird.
	 * Der Rückgabewert ist False, falls die Aufgabe nicht durchgeführt werden konnte // Nachbedingung
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
	 * Ein neuer Topf wird für diesen Nutzer hinzugefügt. // Nachbedingung
	 * pType und sType sind die korrekten Namen für die Sorten. // Vorbedingung, nicht nötig, da im Code geprüft wird.
	 * Der Rückgabewert ist False, falls kein Topf hinzugefügt werden konnte. // Nachbedingung
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

	private boolean task(String task, Pot p) {
		try {
			return Task.execute(this, task.toLowerCase(), p);
			
		} catch (CheatingException | BusyException | TaskException
				| SubmittedException e) {
			return false;
		}
	}

	/**
	 * Ein neuer Topf wird zur Liste hinzugefügt. // Nachbedingung
	 */
	public void addPot(Pot p) {
		pots.add(p);
	}

	public String toString() {
		return "User" + ID;
	}
}
