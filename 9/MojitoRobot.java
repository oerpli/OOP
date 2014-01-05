import java.util.Map.Entry;

public class MojitoRobot extends Robot {
	public MojitoRobot() {
		super("Mojitorobot");
	}

	@Override
	protected Cocktail mixCocktail() {

		return null;
	}

	@Override
	protected boolean checkResources() {
		boolean stock = true;
		for (Entry<String, Integer> e : Mojito.reference.entrySet()) {
			stock &= Ingredient.get(e.getKey()).checkStock(e.getValue());
		}
		return stock;
	}
}
