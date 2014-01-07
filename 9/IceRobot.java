class IceRobot {
	/* singleton */
	private static IceRobot instance = null;

	private IceRobot() {
	};

	protected static IceRobot get() {
		if (instance == null) {
			instance = new IceRobot();
		}
		return instance;
	}

	protected boolean useIce(CocktailCold cocktail, int amount) {
		if (Ingredient.checkStock("Ice", amount)) {
			assert amount >= 0 && amount < 200;
			Ingredient.get("Ice").fillInto(cocktail, amount);
			cocktail.ice += amount;
			return true;
		}
		return false;
	}

}
