/**
 * Alkohol einer bestimmten Sorte. Speichert Name, Alkoholgehalt sowie
 * verf�gbare Menge.
 * 
 * @author oerpli
 * 
 */
class Liquid extends Ingredient {
	public final double vol;// da man mit ml rechnet vol

	protected Liquid(String N, double V) {
		super(N);
		assert V >= 0 && V < 1;
		this.vol = V;
	}

	@Override
	protected String getUnit() {
		return "ml";
	}

	@Override
	protected void fillCocktail(Cocktail c, int qnt) {
		c.addIngredient(this.name, this.vol, qnt);
	}
}