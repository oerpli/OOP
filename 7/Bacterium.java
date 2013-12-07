class Bacterium implements Runnable {
	private Playground playground;
	private int prolifNum; /** Zwischen 1 und 32 */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	
	public Bacterium(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
		this.playground.increaseCellCounter();
	}
	
	@Override
	public void run() {
		boolean goOn = true;
		while (goOn) {
			if (prolifNum == 32) {
				playground.endAllThreads();
			} else if (container.getNutrient() < 25) {
				container.kill();
				goOn = false; // Ist der Prozess beendet?
			} else if (container.getNutrient() >= 75) {
				try {
					Thread.sleep(playground.getTime(2));
					proliferate();
				} catch (InterruptedException e) { }
			} else if (container.getNutrient() >= 50) {
				try {
					Thread.sleep(playground.getTime(1));
					proliferate();
				} catch (InterruptedException e) { }
			} else { // zwischen 25 und 50
				try {
					Thread.sleep(playground.getTime(0));
					proliferate();
				} catch (InterruptedException e) { }
			}
			
			if (playground.shouldEnd())
				goOn = false;
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
	
	@Override
	public String toString() {
		
	}
}
