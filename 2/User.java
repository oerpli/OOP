import java.util.ArrayList;
import Pumpkin.*;
import Soil.*;

/**
 * Verwaltet die Daten eines Teilnehmers. Stellt Methoden zur Aufzucht bereit.
 * Ermöglicht nur erlaubte Pflegemaßnahmen. Ist die einzige Möglichkeit des
 * Zugriffs auf Kürbisse (indirekt).
 */
class User {
	private ArrayList<Pumpkin> pumps;

	private int lastAction; // Tag der letzten Aktion (damit die zeitliche
							// Abfolge stimmt.)

	public User() {
		pumps = new ArrayList<Pumpkin>();
	}

	/**
	 * Ein neuer Kürbis wird erzeugt und zur Liste hinzugefügt. Die Klasse des
	 * Attributs spezifiziert die Kürbissorte und den Bodentyp. Bei Auftritt
	 * eines Fehlers wird -1 zurückgegeben.
	 */
	public int plant(Pumpkin p, int day) {
		if (day < lastAction)
			return -1;

		try {
			Soil s = p.getSoil();
			Soil t;
			Pumpkin q;

			// Erzeugt eine leere Kopie des übergebenen Objekts (gegen
			// Schummeln)
			t = s.getClass().getConstructor().newInstance();
			q = p.getClass().getConstructor(Soil.class).newInstance(t);

			pumps.add(q);
		} catch (Exception e) {
			return -1;
		}

		return pumps.size() - 1;
	}

	/**
	 * Düngen des Kürbisses mit dem gewählten Index.
	 */
	public void fertilize(int index) {
		if (index >= 0 && index < pumps.size()) {
			Pumpkin p = pumps.get(index);
			applyWeather(p);

			p.getSoil().absorbFertilizer(20.0);
		}
	}

	/**
	 * Jäten des Kürbisses mit dem gewählten Index.
	 */
	public void weed(int index) {
		if (index >= 0 && index < pumps.size()) {
			Pumpkin p = pumps.get(index);
			applyWeather(p);
		}
	}

	/**
	 * Gießen des Kürbisses mit dem gewählten Index.
	 */
	public void water(int index) {
		if (index >= 0 && index < pumps.size()) {
			Pumpkin p = pumps.get(index);
			applyWeather(p);

			p.getSoil().absorbWater(50.0);
		}
	}

	/**
	 * Den Kürbis mit dem gewählten Index altern lassen.
	 */
	public void skipDays(int index, int days) {
		if (index >= 0 && index < pumps.size()) {
			Pumpkin p = pumps.get(index);

			for (int i = 0; i < days; i++) {
				applyWeather(p);
			}
		}
	}

	/**
	 * Wendet die täglichen Klimaverhältnisse auf Kürbis und Boden an. Wird
	 * von Pflegemethoden aufgerufen. Kürbis altert um ein Jahr.
	 */
	private void applyWeather(Pumpkin p) {
		p.increaseAge();
	}
}
