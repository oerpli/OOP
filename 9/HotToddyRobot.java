import java.util.Map.Entry;
import java.util.Set;

public class HotToddyRobot extends Robot {
	public HotToddyRobot() {
		super(BeerCoffee.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return BeerCoffee.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		BeerCoffee bc = new BeerCoffee();
		HeatRobot.get().heatUp(bc, bc.getTemp());
		return bc;
	}

}
