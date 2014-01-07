public abstract class CocktailHot extends Cocktail {
	public int temperature;

	protected CocktailHot(String N) {
		super(N);
	}

	protected abstract int getTemp();

	public String toString() {
		return super.toString() + " Achtung, HEISS: " + this.temperature + "°C";
	}
}
