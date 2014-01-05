import java.util.HashMap;


public class Mojito extends CocktailCold {
	public static final String name = "Mojito";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 10);
		reference.put("Bier", 15);
		reference.put("Soda", 100);
	}

	public Mojito() {
		super(name, 125);
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap wäre irgendwie dieses entry set besser.
		// sollte man bei gelegenheit überarbeiten.
	}
}
