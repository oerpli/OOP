import java.util.HashMap;
import java.util.Map.Entry;

public class Cocktail {
	private final String name;
	private final Ingredient[] ingredients;
	private final int ml;

	private static HashMap<String, Cocktail> collection = new HashMap<String, Cocktail>();

	// Zutaten (Strings) evtl durch
	public Cocktail(String N, int ML, Spirit[] spirits) {
		assert N != null && spirits[0] != null;// Z2,Z3 dürfen null sein
		assert ML > 0;
		this.ingredients = spirits;
		this.ml = ML;
		this.name = N;
		collection.put(N, this);
	}

	public String toString() {
		return name + "(" + ml + "ml)";
	}

	public static void menu() {
		System.out.println("Karte:");
		for (Entry<String, Cocktail> e : collection.entrySet()) {
			System.out.println(" " + e.getValue().toString());
		}
	}
}
