class Portion implements Usable {

	private final Ingredient ingredient;
	private final int quantity;

	private Portion(Ingredient I, int Q) {
		this.ingredient = I;
		this.quantity = Q;
	}

	protected Portion getPortion(Ingredient I, int Q) {
		return (I.checkStock(Q) ? new Portion(I, Q) : null);
	}

	@Override
	public boolean use() {
		return ingredient.use(quantity);
	}
}
