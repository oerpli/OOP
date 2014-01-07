import java.util.HashMap;

class CubaLibre extends CocktailCold {
	public static final String name = "Cuba Libre";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 80);
		reference.put("Cola", 40);
	}

	protected CubaLibre() {
		super(name);// 150
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap w�re irgendwie dieses entry set besser.
		// sollte man bei gelegenheit �berarbeiten.
	}

	/**
	 * Sollte eigentlich static sein - da static Klassen in java aber nicht
	 * abstract sein k�nnen ist es stattdessen eine Funktion einer Instanz.
	 * 
	 */
	protected int getIceAmount() {
		return 30;
	}
}
