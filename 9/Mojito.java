import java.util.HashMap;

public class Mojito extends CocktailCold {
	public static final String name = "Mojito";
	public static final int IceAmount = 100;
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 10);
		reference.put("Soda", 100);
	}

	public Mojito() {
		super(name, 210,100);
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap wäre irgendwie dieses entry set besser.
		// sollte man bei gelegenheit überarbeiten.
	}
}
