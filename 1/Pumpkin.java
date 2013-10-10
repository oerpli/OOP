public class Pumpkin {
	private double Size = 1; // Größe
	public Klima K;
	int Day = 0;
	final int N;
	private static int n = 1;

	public Pumpkin() {
		N = n++;
		K = new Klima();
	}

	void wachsen() {
		double g = K.meanLight(1) * 0.05;
		if (K.meanWater(10) > 0.1) {
			g *= (K.meanWater(5) < 0.1) ? 1 : 0.5;
			Size *= 1 + g;
		}
	}

	public String toString() {
		return "Kürbis " + N + ", " + Day + " Tage alt, " + Size + " groß.";
	}
}
