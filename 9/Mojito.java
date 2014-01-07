import java.util.HashMap;

public class Mojito extends CocktailCold {
	public static final String name = "Mojito";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Rum", 200);
		reference.put("Soda", 400);
	}

	public Mojito() {
		super(name); // 210
		// Set<Entry<String, Integer>> a = reference.entrySet();//TODO
		// Statt Hashmap wäre irgendwie dieses entry set besser.
		// sollte man bei gelegenheit überarbeiten.
	}

	@Override
	protected int getIceAmount() {
		// TODO Auto-generated method stub
		return 120;
	}
}
