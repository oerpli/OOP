import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CubaMojitoRobot extends Robot {
	protected CubaMojitoRobot() {
		super(CubaMojito.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		HashMap<String, Integer> x = CubaLibre.reference;
		x.putAll(Mojito.reference);
		// x.addAll(Mojito.reference.entrySet());
		return x.entrySet();
	}

	@Override
	protected Cocktail mix() {
		CubaMojito drink = new CubaMojito();
		IceRobot.get().useIce(drink, drink.getIceAmount());
		return drink;
	}

}
