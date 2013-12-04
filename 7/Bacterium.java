class Bacterium implements Runnable {
	private int prolifNum; /** Zwischen 1 und 32 */
	private Box container;
	
	public Bacterium(Box container, int prolifNum) {
		this.container = container;
		this.prolifNum = prolifNum;
	}
	
	@Override
	public void run() {
		
	}
	
	private void proliferate() {
		Box[] neighbors = container.getNeighbors();
		neighbors.sort(); // nach Nährstoff absteigend sortieren
		for (Box b: neighbors) { // passendes Feld für Teilung finden:
			if (b.getNutrient >= 25 && !b.nearFungus() // Nachbar darf kein Pilz sein
				&& !b.isFungus() && !b.isBacterium()) { // Feld darf nicht besetzt sein
				prolifNum++;
				Bacterium child = Bacterium(b, prolifNum);
				
				// TODO: Bacterium in Box eintragen
			}
		}
	}
}
