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
	
	public boolean isTaken() {
		if (bacterium == null && fungus == null) return false;
		return true;
	}
	
	public boolean nearFungus() {
		return false;
	}
	
	/**
	 * Gibt die umliegenden 3 - 8 Boxen als Array aus.
	 */
	public Box[] getNeighbors() {
		
	}
	
	/**
	 * Siedelt die übergebene Zelle in der Box an. Alte Zellen werden gelöscht.
	 * Der Übergabewert null leert die Box.
	 */
	public void setResident(Bacterium resident) {
		bacterium = resident;
		fungus = null;
	}
	
	/**
	 * Siedelt die übergebene Zelle in der Box an. Alte Zellen werden gelöscht.
	 * Der Übergabewert null leert die Box.
	 */
	public void setResident(Fungus resident) {
		fungus = resident;
		bacterium = null;
	}
}
