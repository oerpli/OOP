class Box {
	private int nutrient; /** Zwischen 0 und 100 */
	private Bacterium bac;
	private Fungus myk; /** Eines von beiden immer Null */
	
	public int getNutrient() {
		return nutrient;
	}
	
	public void consumNutrient() {
		nutrient = nutrient * 0.03; // TODO: richtigen Consum nach Voreinstellung
	}
	
	public void kill() {
		bac = null;
		myk = null;
		// TODO: Prozess beenden.
	}
}
