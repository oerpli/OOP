import java.util.Map.Entry;
import java.util.Set;

class HotToddyRobot extends Robot {
	protected HotToddyRobot() {
		super(HotToddy.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return HotToddy.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		HotToddy bc = new HotToddy();
		HeatRobot.get().heatUp(bc, bc.getTemp());
		return bc;
	}

}
