public class IceRobot {

	public static boolean useIce(CocktailCold cocktail, int amount) {
		if (Ingredient.checkStock("Ice", amount)) {
			assert amount >= 0 && amount < 200;
			Ingredient.get("Ice").use(amount);
			cocktail.ice += amount;
			return true;
		}
		return false;
	}

}
