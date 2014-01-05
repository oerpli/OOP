import java.util.HashMap;


public class CubaLibre extends CocktailCold {
	public static final String name = "Cuba Libre";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 20);
		reference.put("Cola", 100);
	}

	public CubaLibre() {
		super(name, 120);
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap wäre irgendwie dieses entry set besser.
		// sollte man bei gelegenheit überarbeiten.
	}
}
