class Box {
	private Playground playground; // Oder statisch und Boxen organisieren sich selbst?
	private int nutrient; /** Zwischen 0 und 100 */
	private Bacterium bac;
	private Fungus myk; /** Eines von beiden immer Null */
	
	public int getNutrient() {
		return nutrient;
	}
	
	public void consumNutrient() {
		nutrient = (int)(nutrient - (nutrient * (playground.getConsum() / 100.0)));
	}
	
	public void kill() {
		bac = null;
		myk = null;
		// TODO: Prozess beenden.
	}
}
