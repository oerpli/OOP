import java.util.HashMap;

class Mojito extends CocktailCold {
	public static final String name = "Mojito";
	protected static final HashMap<String, Integer> reference = new HashMap<String, Integer>();
	static {
		reference.put("Rum", 200);
		reference.put("Soda", 400);
	}

	protected Mojito() {
		super(name); // 210
	}

	@Override
	protected int getIceAmount() {
		return 120;
	}

	protected int getAmount() {
		return 210;
	}
}
