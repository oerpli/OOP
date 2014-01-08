import java.util.HashMap;

class CubaLibre extends CocktailCold {
	public static final String name = "Cuba Libre";
	protected static final HashMap<String, Integer> reference = new HashMap<String, Integer>();
	static {
		reference.put("Rum", 80);
		reference.put("Cola", 40);
	}

	protected CubaLibre() {
		super(name);// 150
	}

	/**
	 * Sollte eigentlich static sein - da static Klassen in java aber nicht
	 * abstract sein können ist es stattdessen eine Funktion einer Instanz.
	 * 
	 */
	protected int getIceAmount() {
		return 30;
	}

	protected int getAmount() {
		return 150;
	}
}
