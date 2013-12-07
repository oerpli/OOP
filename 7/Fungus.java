class Fungus implements Runnable {
	private Playground playground; /** Die Petrischale in der sich die Zelle befindet */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	private int prolifNum; /** Zwischen 1 und 32 */
	
	public Fungus(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
	}
		
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (container.getNutrient() < 25) {
				return; // TODO: Da Nährlösung nicht steigen kann, kann der Thread beendet werden,
					// während die Zelle noch als lebendig gilt. Da Playground auf alle Threads
					// interrupt aufruft, könnte es zu einer Fehlermeldung kommen.
			} else {
				try {
					Thread.sleep(playground.getTime(0) * 3);
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
				playground.createCell(new Fungus(b, prolifNum));
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
