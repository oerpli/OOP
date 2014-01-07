import java.util.HashMap;

class LukeWarmToddy extends CocktailNormal {
	public static final String name = "LukeWarmToddy";
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Gin", 10);
		reference.put("Zitronensaft", 10);
	}

	protected LukeWarmToddy() {
		super(name);
	}

}