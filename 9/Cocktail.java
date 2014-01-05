public abstract class Cocktail {
	private final String name;
	private final int ml;

	// private static HashMap<String, Cocktail> collection = new HashMap<String,
	// Cocktail>();

	public Cocktail(String N, int ML) {
		assert N != null;// braucht einen Name
		assert ML > 0;// ein leeres Glas freut den Kunden wohl kaum.
		this.ml = ML;
		this.name = N;
		// collection.put(name, this);
	}

	public String toString() {
		return name + "(" + ml + "ml)";
	}

	public static void bla() {
		int a = 1;
	}

	// public static void menu() {
	// System.out.println("Karte:");
	// for (Entry<String, Cocktail> e : collection.entrySet()) {
	// System.out.println(" " + e.getValue().toString());
	// }
	// }
}
