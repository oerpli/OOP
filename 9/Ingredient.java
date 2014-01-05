import java.util.HashMap;

/**
 * Abstrakte Klasse - Oberklasse aller Zutaten. Hat zusätzlich eine Methode um
 * eine Zutat gemäß ihrem Namen aus einem "Schrank" zu nehmen. Wenn Zutat nicht
 * vorhanden wird ein Fehler ausgegeben.
 * 
 * @author oerpli
 * 
 */
abstract class Ingredient {
	public final String name;
	private int amount = 0;// ml bei drinks, gr bei ice. etc.

	private static HashMap<String, Ingredient> shelf = new HashMap<String, Ingredient>();

	/**
	 * Gibt eine Zutat zurück.
	 * 
	 * @param n
	 * @return
	 */
	static Ingredient get(String n) {
		if (shelf.containsKey(n))
			return shelf.get(n);
		else {
			System.err.println("Zutat " + n + " nicht vorhanden!");
			return null;
		}
	}

	protected Ingredient(String N) {
		this.name = N;
		assert N != null;
		shelf.put(N, this);
	}

	protected boolean checkStock(int qnt) {
		return amount >= qnt;
	}

	protected boolean use(int qnt) {
		if (amount >= qnt) {
			amount -= qnt;
			return true;
		} else
			return false;// evtl exception stattdessen
	}

	// Bestimmte Sorte nachfüllen und aktuellen Lagerbestand zurückgeben
	protected int refill(int qnt) {
		this.amount += qnt;
		return amount;
	}

	/* um initialisieren einfacher zu machen */
	protected void refillAll(int qnt) {
		for (Ingredient i : shelf.values())
			i.refill(qnt);
	}

	public String toString() {
		return name;
	}

	public String invString() {
		return name + "(" + amount + getUnit() + ")";
	}

	/* WIRD AKTUELL NICHT MEHR BENÖTIGT */
	// /**
	// * Primitive Form von Singleton Pattern. Erzeugen mehrerer Instanzen
	// möglich
	// * - jedoch ist nur die aktuellste zugänglich.
	// *
	// * @param n
	// * @param vol
	// * @return true wenn diese Sorte vorher nicht vorhanden war. Sonst false.
	// */
	// static boolean add(Ingredient z) {
	// assert z != null;
	// return shelf.put(z.name, z) == null;
	// }

	abstract protected String getUnit();
}
