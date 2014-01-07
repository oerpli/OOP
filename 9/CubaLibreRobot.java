import java.util.Map.Entry;
import java.util.Set;

public class CubaLibreRobot extends Robot {
	public CubaLibreRobot() {
		super(CubaLibre.name);
	}

	@Override
	protected Set<Entry<String, Integer>> getRecipe() {
		return CubaLibre.reference.entrySet();
	}

	@Override
	protected Cocktail mix() {		
		CubaLibre cubaLibre=new CubaLibre();
		ColdRobot.useIce(CubaLibre.IceAmount,cubaLibre);
		return cubaLibre;
	}

}
