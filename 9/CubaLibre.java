import java.util.HashMap;

public class CubaLibre extends CocktailCold {
	public static final String name = "Cuba Libre";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 80);
		reference.put("Cola", 100);
	}

	protected CubaLibre() {
		super(name);// 150
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap wäre irgendwie dieses entry set besser.
		// sollte man bei gelegenheit überarbeiten.
	}

	/**
	 * Sollte eigentlich static sein - da static Klassen in java aber nicht
	 * abstract sein können ist es stattdessen eine Funktion einer Instanz.
	 * 
	 */
	protected int getIceAmount() {
		return 30;
	}
}
