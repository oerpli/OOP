import java.util.Arrays;

class Bacterium implements Runnable {
	private Playground playground; /** Die Petrischale in der sich die Zelle befindet */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	private int prolifNum; /** Zwischen 1 und 32 */
	private Thread thread;
	
	public Bacterium(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
		thread = null;
	}
	
	@Override
	public void run() {
		thread = Thread.currentThread();
		while (!thread.isInterrupted()) {
			if (prolifNum == 32) {
				playground.killAllCells();
			} else if (container.getNutrient() < 25) {
				playground.killCell(this);
			} else if (container.getNutrient() >= 75) {
				try {
					Thread.sleep(playground.getTime(2));
					proliferate();
				} catch (InterruptedException e) {
					thread.interrupt();
				}
			} else if (container.getNutrient() >= 50) {
				try {
					Thread.sleep(playground.getTime(1));
					proliferate();
				} catch (InterruptedException e) {
					thread.interrupt();
				}
			} else { // zwischen 25 und 50
				try {
					Thread.sleep(playground.getTime(0));
					proliferate();
				} catch (InterruptedException e) {
					thread.interrupt();
				}
			}
		}
	}
	
	private void proliferate() {
		Box[] neighbors = playground.getNeighbors(container);
		playground.sort(neighbors); // nach Nährstoff absteigend sortieren
		for (Box b: neighbors) { // passendes Feld für Teilung finden:
			if (b.getNutrient() >= 25 && !playground.nearFungus(b) // Nachbar darf kein Pilz sein
				&& b.getBacterium() == null && b.getFungus() == null) { // Feld darf nicht besetzt sein
				playground.createCell(new Bacterium(playground,b, prolifNum));
				prolifNum++;
				container.consumNutrient(5); // Die Teilung verbraucht Nährstoff //5 Testwert um Programm ausf�hren zu k�nnen
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
	
	/**
         * Gibt den Thread zurück, in dem die Zelle lebt.
         * Wenn die Zelle noch nicht lebt, ist der Rückgabewert null.
         */
	public Thread getThread() {
		return thread;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
