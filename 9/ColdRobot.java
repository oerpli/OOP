public class ColdRobot{

	public static boolean useIce(int amount,CocktailCold cocktail){
		if(Ingredient.checkStock("Ice",amount)){
			Ingredient.get("Ice").use(amount);
			cocktail.ice+=amount;
			return true;
		}
		return false;
	}

}
