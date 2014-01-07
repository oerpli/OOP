class Ice extends Ingredient {
	protected Ice() {
		super("Ice");
	}

	@Override
	protected String getUnit() {
		return "g";
	}

	@Override
	protected void fillCocktail(Cocktail c, int qnt) {
		c.addIngredient(this.name, 0, qnt);
	}
}