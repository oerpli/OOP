import java.util.HashMap;

public class HotToddy extends CocktailHot {
	public static final String name = "HotToddy";
	protected static final HashMap<String, Integer> reference = new HashMap<String, Integer>();
	static {
		reference.put("Gin", 40);
		reference.put("Zitronensaft", 100);
	}

	protected HotToddy() {
		super(name);
	}

	@Override
	protected int getTemp() {
		return 50;
	}

	protected int getAmount() {
		return 140;
	}

}