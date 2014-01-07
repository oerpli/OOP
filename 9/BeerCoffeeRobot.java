import java.util.Map.Entry;
import java.util.Set;

class BeerCoffeeRobot extends Robot {
	protected BeerCoffeeRobot() {
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
