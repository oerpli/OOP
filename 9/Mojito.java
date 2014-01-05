import java.util.HashMap;

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
	}

}
