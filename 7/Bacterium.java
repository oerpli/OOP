class Bacterium implements Runnable {
	private int prolifNum; /** Zwischen 1 und 32 */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	
	public Bacterium(Box container, int prolifNum) {
		this.container = container;
		this.prolifNum = prolifNum;
	}
	
	@Override
	public void run() {
		boolean goOn = true;
		while (goOn) {
			if (prolifNum == 32) {
				container.playground.killAll();
				goOn = false;
			} else if (container.getNutrient() < 25) {
				container.kill();
				goOn = false; // Ist der Prozess beendet?
			} else if (container.getNutrient() >= 75) {
				Thread.sleep(5);
				proliferate();
			} else if (container.getNutrient() >= 50) {
				Thread.sleep(5);
				proliferate();
			} else { // zwischen 25 und 50
				Thread.sleep(5);
				proliferate();
			}
		}
	}
	
	private void proliferate() {
		Box[] neighbors = container.getNeighbors();
		neighbors.sort(); // nach Nährstoff absteigend sortieren
		for (Box b: neighbors) { // passendes Feld für Teilung finden:
			if (b.getNutrient() >= 25 && !b.nearFungus() // Nachbar darf kein Pilz sein
				&& !b.isTaken() { // Feld darf nicht besetzt sein
				prolifNum++;
				Bacterium child = Bacterium(b, prolifNum);
				container.consumNutrient();
				// TODO: Bacterium in Box eintragen, Box Methoden schreiben
				return;
			}
		}
	}
}
