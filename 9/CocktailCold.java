public class CocktailCold extends Cocktail {
	private final int ice;

	public CocktailCold(String N, int ML, int ice) {
		super(N, ML);
		assert ice > 0;
		this.ice = ice;
	}
}
