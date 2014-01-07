import java.util.Map.Entry;
import java.util.Set;

class LukeWarmToddyRobot extends Robot {
	protected LukeWarmToddyRobot() {
		super(LukeWarmToddy.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return LukeWarmToddy.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		return new LukeWarmToddy();
	}

}
