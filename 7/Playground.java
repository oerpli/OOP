class Playground {
	private Box[][] boxes;
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
		time = new int[3];
		consum = consumption;
		time = prolifTime;
	}
	
	public int getConsum() {
		return consum;
	}
	
	public int[] getTime() {
		return time;
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
		
		Bacterium bac = new Bacterium(boxes[0][0], 1);
		boxes[0][0] = setResident(bac);
		Fungus myk = new Fungus(boxes[boxes.length][boxes[0].length], 1);
		boxes[boxes.length][boxes[0].length] = setResident(myk);
		Thread bT = new Thread(bac);
		bT.start();
		Thread fT = new Thread(myk);
		fT.start();
	}
	
	@Override
	public String toString() {
		return "";
	}
}
