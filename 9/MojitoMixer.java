class MojitoMixer extends Mixer {
	private float ice;
	
	/**
	 * @param volumes: Int-Array of volumes of the Liquors in millilitres
	 * @param ice: Amount of available ice in milligrams
	 */
	public MojitoMixer(int[] volumes, float ice) {
		name = "Mojito";
		this.ice = ice;
		resources = Liquor[3];
		Liquor ron = new Liquor("Ron", 40.0, 700);
		resources[0] = ron;
		Liquor soda = new Liquor("Club Soda", 0.0, 1000);
		resources[1] = soda;
		Liquor lime = new Liquor("Lime Juice", 0.0, 1000);
		resources[2] = lime;
	}
	
	public Cocktail getCocktail() {
		Liquor[] ingredients = Liquor[3];
		// Zutaten ins Array schreiben und aufbrauchen
		ice -= 20.0;
		return new Cocktail(name, ingredients, 20.0, 0);
	}
}
