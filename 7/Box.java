class Box {
	private int nutrient; /** Zwischen 0 und 100 */
	private Bacterium bacterium;
	private Fungus fungus; /** Eines von beiden immer Null */
	
	public Box(int nutrient) {
		this.nutrient = nutrient;
		bacterium = null;
		fungus = null;
	}
	
	public int getNutrient() {
		return nutrient;
	}
	
	public void consumNutrient(int consumption) {
		nutrient = (int)(nutrient - (nutrient * (consumption / 100.0)));
	}
	
	public void kill() {
		bacterium = null;
		fungus = null;
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
