class Fungus implements Runnable {
	private Playground playground; /** Die Petrischale in der sich die Zelle befindet */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	private int prolifNum; /** Zwischen 1 und 32 */
	private Thread thread;
	
	public Fungus(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
		thread = null;
	}
		
	@Override
	public void run() {
		thread = Thread.currentThread();
		while (!thread.isInterrupted()) {
			if (container.getNutrient() < 25) {
				return; // TODO: Da Nährlösung nicht steigen kann, kann der Thread beendet werden,
					// während die Zelle noch als lebendig gilt. Da Playground auf alle Threads
					// interrupt aufruft, könnte es zu einer Fehlermeldung kommen.
			} else {
				try {
					Thread.sleep(playground.getTime(0) * 3);
					proliferate();
				} catch (InterruptedException e) {
					thread.interrupt();
				}
			}
		}
	}
	
	private void proliferate() {
		Box[] neighbors = container.getNeighbors();
		Arrays.sort(neighbors); // nach Nährstoff absteigend sortieren
		Box aim = null;
		for (Box b: neighbors) { // passendes Feld für Teilung finden:
			if (b.getFungus() == null && b.getNutrient() >= 25) {
				if (aim == null) {
					aim = b;
				} else if (aim.getBacterium() == null && b.getBacterium() != null) {
					aim = b;
				}
			}
		}
		if (aim != null) {
			playground.killCell(aim.getBacterium()); // null Testen???
			playground.createCell(new Fungus(aim, prolifNum));
			prolifNum++;
			container.consumNutrient(); // Die Teilung verbraucht Nährstoff
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
