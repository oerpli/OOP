public abstract class CocktailCold extends Cocktail {
	public int ice;

	protected CocktailCold(String N) {
		super(N);
	}

	protected abstract int getIceAmount();

	public String toString() {
		return super.toString() + " mit " + getIceAmount() + "g Eis";
	}
}
