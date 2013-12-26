class Recipe extends Cocktail {
	public Liquor[] liquorRecipe() {
		return ingredients;
	}
	
	public float iceRecipe() {
		return ice;
	}
	
	public int temperatureRecipe() {
		return temperature;
	}
}
