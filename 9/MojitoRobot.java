import java.util.Map.Entry;
import java.util.Set;

class MojitoRobot extends Robot {
	protected MojitoRobot() {
		super(Mojito.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return Mojito.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {
		Mojito mojito = new Mojito();
		IceRobot.get().useIce(mojito, mojito.getIceAmount());
		return mojito;
	}

}
