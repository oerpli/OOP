import java.util.HashMap;

public class Soda extends CocktailNormal{

	public static final String name = "Soda";
	
	protected static final HashMap<String, Integer> reference = new HashMap<>();
	static {
		reference.put("Soda", 1000);
	}
	
	public Soda() {
		super(name);
	}

}