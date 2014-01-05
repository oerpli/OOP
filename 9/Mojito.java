import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Mojito extends CocktailCold {
	private static final String name = "Mojito";
	private static final HashMap<String, Integer> reference = new HashMap<>();
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
