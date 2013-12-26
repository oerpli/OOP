class Cocktail {
	protected String name;
	protected Liquor[] ingredients;
	protected float ice;
	protected int temperature;
	
	/**
	 * @param ingredients: Array of up to 3 Liquors
	 * @param ice: non negative amount of crushed ice
	 */
	public Cocktail(String name, Liquor[] ingredients, float ice, int temperature) {
		this.name = name;
		this.ingredients = ingredients;
		this.ice = ice;
		this.temperature = temperature;
	}
	
	/**
	 * Returns total volume of this Cocktail (millilitres)
	 * This calculation does not consider ice
	 */
	public int getVolume() {
		int result = 0;
		for (Liquor l: ingredients) {
			result += l.getVolume();
		}
		return result;
	}
	
	/**
	 * Returns alcohol concentration
	 * This calculation does not consider ice
	 */
	public float getAbV() {
		float result = 0.0f;
		for (Liquor l: ingredients) {
			result += l.getVolume() * (l.getAbV() / 100);
		}
		result = result / getVolume();
	}
}
