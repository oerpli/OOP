public abstract class CocktailHot extends Cocktail {
	public int temperature;

	protected CocktailHot(String N) {
		super(N);
	}

	protected abstract int getTemp();
}
