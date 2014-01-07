public class Ice extends Ingredient {
	protected Ice() {
		super("Ice");
	}

	@Override
	protected String getUnit() {
		return "g";
	}

	@Override
	protected void fillInto(Cocktail c, int qnt) {
		c.addIngredient(0, qnt);
	}
}