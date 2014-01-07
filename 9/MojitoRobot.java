import java.util.Map.Entry;
import java.util.Set;

public class MojitoRobot extends Robot {
	public MojitoRobot() {
		super(Mojito.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return Mojito.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		Mojito mojito=new Mojito();
		ColdRobot.useIce(mojito.IceAmount, mojito);
		return mojito;
	}

}
