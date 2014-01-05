import java.util.HashMap;

public class Ingredient {
	public final String name;
	private int amount = 0;

	private static HashMap<String, Ingredient> shelf = new HashMap<String, Ingredient>();

	/**
	 * Primitive Form von Singleton Pattern. Erzeugen mehrerer Instanzen m�glich
	 * - jedoch ist nur die aktuellste (ohne Umwege) zug�nglich.
	 * 
	 * @param n
	 * @param vol
	 * @return true wenn diese Sorte vorher nicht vorhanden war. Sonst false.
	 */
	static boolean add(Ingredient z) {
		assert z != null;
		return shelf.put(z.name, z) == null;
	}

	/**
	 * Gibt eine Zutat zur�ck.
	 * 
	 * @param n
	 * @return
	 */
	static Ingredient get(String n) {
		if (shelf.containsKey(n))
			return shelf.get(n);
		else
			return null;
	}

	protected Ingredient(String N) {
		this.name = N;

		assert N != null;
	}

	public boolean use(int ml) {
		if (amount >= ml) {
			amount -= ml;
			return true;
		} else
			return false;// evtl exception stattdessen
	}

	// Bestimmte Sorte nachf�llen und aktuellen Lagerbestand zur�ckgeben
	public int refill(int ml) {
		this.amount += ml;
		return amount;
	}

	public String toString() {
		return name;
	}

}
