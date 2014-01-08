import java.util.HashMap;

class LukeWarmToddy extends Cocktail {
	public static final String name = "LukeWarmToddy";
	protected static final HashMap<String, Integer> reference = new HashMap<String, Integer>();
	static {
		reference.put("Gin", 10);
		reference.put("Zitronensaft", 110);
	}

	protected LukeWarmToddy() {
		super(name);
	}

	protected int getAmount() {
		return 120;
	}

}