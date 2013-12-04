class Box {
	private Playground playground; // Beste Weg für Zugriff auf Variablen?
	private int nutrient; /** Zwischen 0 und 100 */
	private Bacterium bacterium;
	private Fungus fungus; /** Eines von beiden immer Null */
	
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
	
	public boolean isTaken() {
		if (bacterium == null && fungus == null) return false;
		return true;
	}
	
	public boolean nearFungus() {
		return false;
	}
	
	public Box[] getNeighbors() {
		
	}
	
	public void setResident(Bacterium resident) {
		bacterium = resident;
		fungus = null;
	}
	
	public void setResident(Fungus resident) {
		fungus = resident;
		bacterium = null;
	}
}
