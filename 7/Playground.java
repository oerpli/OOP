import java.util.ArrayList;

class Playground {
	private Box[][] boxes;
	private ArrayList<Thread> threadList;
	private int consum;
	private int[] time;
	
	/**
	 * @param width: Breite des Feldes. Zwischen 1 und 80
	 * @param height: Höhe des Feldes. Zwischen 1 und 80
	 * @param consumption: Nährlösungsverbrauch pro Teilung. Zwischen 0 und 100.
	 * @param prolifTime: Millisekunden pro Teilung für 25-50, 50-75 und 75-100 Prozent Nährlösung. Absteigend.
	 */
	public Playground(int width, int height, int consumption, int[] prolifTime) {
		boxes = new Box[width][height];
		threadList = new ArrayList<Thread>();
		time = prolifTime;
		consum = consumption;
	}
	
	public int getConsum() {
		return consum;
	}
	
	public int getTime(int index) {
		return time[index];
	}
	
	/**
	 * Paramter: Wo werden Bakterien und Pilze platziert? Wo wie viel Nährstoff?
	 */
	public void start() {
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				boxes[x][y] = new Box(75);
			}
		}
		
		Bacterium bac = new Bacterium(this, boxes[0][0], 1);
		boxes[0][0].setResident(bac);
		Fungus myk = new Fungus(this, boxes[boxes.length][boxes[0].length], 1);
		boxes[boxes.length][boxes[0].length].setResident(myk);
		Thread bT = new Thread(bac);
		bT.start();
		threadList.add(bT);
		Thread fT = new Thread(myk);
		fT.start();
		threadList.add(fT);
	}
	
	/**
	 * Alle Zellen werden über ihren Tod benachrichtigt.
	 */
	public void killAllCells() {
		for (Thread t: threadList) {
			t.interrupt();
		}
	}
	
	/*
	 * Die übergebene Zelle wird über ihren Tod benachrichtigt.
	 * Die übergebene Zelle wird aus ihrem Container gelöscht.
	 */
	public void killCell(Bacterium cell) {
		cell.getThread().interrupt(); // null testen?
		cell.getContainer().setResident((Bacterium)null);
	}
	
	/*
	 * Die übergebene Zelle wird über ihren Tod benachrichtigt.
	 * Die übergebene Zelle wird aus ihrem Container gelöscht.
	 */
	public void killCell(Fungus cell) {
		cell.getThread().interrupt();
		cell.getContainer().setResident((Fungus)null);
	}
	
	/*
	 * Die übergebene Zelle wird in einem neuen Thread belebt.
	 * Die übergebene Zelle wird in ihren Container platziert.
	 */
	public void createCell(Bacterium cell) {
		cell.getContainer().setResident(cell); // Bakterium wird in Box eingetragen
		Thread t = new Thread(cell); // Bakterium wird belebt
		t.start();
		threadList.add(t);
	}
	
	/*
	 * Die übergebene Zelle wird in einem neuen Thread belebt.
	 * Die übergebene Zelle wird in ihren Container platziert.
	 */
	public void createCell(Fungus cell) {
		cell.getContainer().setResident(cell); // Pilz wird in Box eingetragen
		Thread t = new Thread(cell); // Pilz wird belebt
		t.start();
		threadList.add(t);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if (boxes[x][y].isTakenBy()==0) {
					result += (boxes[x][y].getNutrient() / 10);
					result += " ";
				} else {
					if(boxes[x][y].isTakenBy()==1){
						result += "x ";}
					if(boxes[x][y].isTakenBy()==2){
						result += "o ";}
				}
			}
			result += System.getProperty("line.separator");
		}
		return result;
	}
}
