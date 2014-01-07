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
	static protected Ingredient get(String n) {
		if (shelf.containsKey(n))
			return shelf.get(n);
		else {
			System.out.println("+Zutat " + n + " nicht vorhanden!");
			return null;
		}
	}

	protected Ingredient(String N) {
		this.name = N;
		assert N != null;
		shelf.put(N, this);
	}

	static protected boolean checkStock(String n, int qnt) {
		if (shelf.containsKey(n)) {
			if (shelf.get(n).amount < qnt) {
				System.out.println("+Nicht genug " + n + " vorhanden.");
			} else {
				return true;
			}
		} else {
			System.out.println("+Zutat " + n + " nicht vorhanden!");
		}
		return false;

	}

	// Bestimmte Sorte nachfüllen und aktuellen Lagerbestand zurückgeben
	protected int refill(int qnt) {
		this.amount += qnt;
		return amount;
	}

	static protected void refill(String i, int qnt) {
		Ingredient.get(i).refill(qnt);
	}

	/* um initialisieren einfacher zu machen */
	static protected void refillAll(int qnt) {
		for (Ingredient i : shelf.values())
			i.refill(qnt);
	}

	public String toString() {
		return name;
	}

	private String invString() {
		return this.toString() + " - " + amount + getUnit();
	}

	/**
	 * Listet Inventar auf.
	 */
	static protected void listStock() {
		System.out.println("Inventar:");
		for (Ingredient i : shelf.values()) {
			System.out.println("-" + i.invString());
		}
	}

	/**
	 * Gramm oder Milliliter
	 * 
	 * @return
	 */
	abstract protected String getUnit();

	/**
	 * Konkrete Umsetzung des einschenkens der jeweiligen Zutat.
	 * 
	 * @param c
	 * @param qnt
	 */
	protected abstract void fillCocktail(Cocktail c, int qnt);

	/**
	 * Vorrat der Zutat "this" wird reduziert und in Cocktail geleert.
	 * 
	 * @param c
	 * @param qnt
	 * @return
	 */
	protected boolean fillInto(Cocktail c, int qnt) {
		if (amount >= qnt) {
			amount -= qnt;
			fillCocktail(c, qnt);
			return true;
		} else
			return false;// evtl exception stattdessen
	}
}
