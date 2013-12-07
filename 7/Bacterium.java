class Bacterium implements Runnable {
	private Playground playground; /** Die Petrischale in der sich die Zelle befindet */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	private int prolifNum; /** Zwischen 1 und 32 */
	
	public Bacterium(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (prolifNum == 32) {
				playground.killAllCells();
			} else if (container.getNutrient() < 25) {
				playground.killCell(this, Thread.currentThread());
			} else if (container.getNutrient() >= 75) {
				try {
					Thread.sleep(playground.getTime(2));
					proliferate();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			} else if (container.getNutrient() >= 50) {
				try {
					Thread.sleep(playground.getTime(1));
					proliferate();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			} else { // zwischen 25 und 50
				try {
					Thread.sleep(playground.getTime(0));
					proliferate();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	private void proliferate() {
		Box[] neighbors = container.getNeighbors();
		neighbors.sort(); // nach Nährstoff absteigend sortieren
		for (Box b: neighbors) { // passendes Feld für Teilung finden:
			if (b.getNutrient() >= 25 && !b.nearFungus() // Nachbar darf kein Pilz sein
				&& !b.isTaken() { // Feld darf nicht besetzt sein
				playground.createCell(new Bacterium(b, prolifNum));
				prolifNum++;
				container.consumNutrient(); // Die Teilung verbraucht Nährstoff
				return; // Nur eine Teilung ist erlaubt
			}
		}
	}
	
	/**
         * Gibt die Box zurück, in der sich die Zelle befindet.
         */
	public Box getContainer() {
		return container;
	}
	
	@Override
	public String toString() {
		
	}
}
