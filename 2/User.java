import java.util.ArrayList;
import Pumpkin.*;
import Soil.*;

/**
 * Verwaltet die Daten eines Teilnehmers.
 * Stellt Methoden zur Aufzucht bereit.
 * Ermöglicht nur erlaubte Pflegemaßnahmen.
 * Ist die einzige Möglichkeit des Zugriffs auf Kürbisse (indirekt).
 */
class User
{
	private ArrayList<Pumpkin> pumps;
	
	private int lastDay; // Tag der letzten Aktion (damit die zeitliche Abfolge stimmt.)

	public User()
	{
		pumps = new ArrayList<Pumpkin>();
		dailyLimit = false;
	}
	
	/**
	 * Ein neuer Kürbis wird erzeugt und zur Liste hinzugefügt.
	 */
	public int plant(Pumpkin p)
	{
		try
		{
			Soil s = p.getSoil();
			Soil t;
			Pumpkin q;
			
			// Erzeugt eine leere Kopie des übergebenen Objekts (gegen Schummeln)
			t = s.getClass().getConstructor().newInstance();
			q = p.getClass().getConstructor(Soil.class).newInstance(t);
			
			
			pumps.add(q);
		}
		catch (Exception e) { }
		
		return pumps.size()-1;
	}
	
	/**
	 * Düngen des Kürbisses mit dem gewählten Index.
	 */
	public void fertilize(int index)
	{
		// Kürbis wird einen Tag älter (nur eine Pflege pro Tag)
	}
	
	/**
	 * Jäten des Kürbisses mit dem gewählten Index.
	 */
	public void weed(int index)
	{
		// Kürbis wird einen Tag älter (nur eine Pflege pro Tag)
	}
	
	/**
	 * Gießen des Kürbisses mit dem gewählten Index.
	 */
	public void water(int index)
	{
		// Kürbis wird einen Tag älter (nur eine Pflege pro Tag)
	}
	
	/**
	 * Den Kürbis mit dem gewählten Index altern lassen.
	 */
	public void skipDays(int index, int days)
	{
		// Kürbis wird älter ohne Pflege
	}
}
