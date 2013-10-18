import java.util.ArrayList;

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
	private boolean dailyLimit; // Pflegemaßnahme nur einmal pro Tag

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
		if (!dailyLimit) { }
		
		dailyLimit = true;
	}
	
	/**
	 * Jäten des Kürbisses mit dem gewählten Index.
	 */
	public void weed(int index)
	{
		if (!dailyLimit) { }
		
		dailyLimit = true;
	}
	
	/**
	 * Gießen des Kürbisses mit dem gewählten Index.
	 */
	public void water(int index)
	{
		if (!dailyLimit) { }
		
		dailyLimit = true;
	}
}
