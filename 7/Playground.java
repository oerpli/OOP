class Playground {
	private Box[][] boxes;
	private int consum;
	private int[] time;
	
	/**
	 * @param width: Breite des Feldes. Zwischen 1 und 80
	 * @param height: Höhe des Feldes. Zwischen 1 und 80
	 */
	public Playground(int width, int height) {
		boxes = new Box[width][height];
		time = new int[3];
	}
	
	/**
	 * @param consumption: Nährlösungsverbrauch pro Teilung. Zwischen 0 und 100.
	 * @param prolifTime: Millisekunden pro Teilung für 25-50, 50-75 und 75-100 Prozent Nährlösung. Absteigend.
	 */
	public void run(int consumption, int[] prolifTime) {
		consum = consumption;
		time = prolifTime;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
