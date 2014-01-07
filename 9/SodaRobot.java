import java.util.Map.Entry;
import java.util.Set;

public class SodaRobot extends Robot {
	public SodaRobot() {
		super(Soda.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return Soda.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		Soda sd = new Soda();
		return sd;
	}

}
