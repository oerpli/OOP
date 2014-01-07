import java.util.Map.Entry;
import java.util.Set;

public class HotToddyRobot extends Robot {
	public HotToddyRobot() {
		super(HotToddy.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return HotToddy.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		HotToddy td = new HotToddy();
		HeatRobot.get().heatUp(td, td.getTemp());
		return td;
	}

}
