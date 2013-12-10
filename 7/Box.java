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
	
	/**
	 * true wenn in den Nachbarfeldern ein Pilz ist.
	 */
	public boolean nearFungus() {
		return false;
	}
	
	/**
	 * Übergibt das enthaltene Bakterium.
	 * Ist kein Bakterium enthalten, ist der Rückgabewert null.
	 */
	public Bacterium getBacterium() { // get Resident Methode?
		return bacterium;
	}
	
	/**
	 * Übergibt den enthaltenen Pilz.
	 * Ist kein Pilz enthalten, ist der Rückgabewert null.
	 */
	public Fungus getFungus() { // get Resident Methode?
		return fungus;
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
	
	public int isTakenBy() {
		if(this.bacterium!=null && this.fungus==null) return 2;
		else if(this.fungus!=null && this.bacterium==null) return 1;
		else return 0;
	}

}
