public class Pumpkin {
	private double Size = 1; // Gr��e
	public Klima K;
	int Day = 0;
	private final int N;
	private static int n = 1;

	public Pumpkin() {
		N = n++;
		K = new Klima();
	}

	public void Tag(double l, double w) {
		if (!this.K.setKlima(l, w)) {
			System.err.println("Zu viel Liebe f�r K�rbis Nummer " + N);
			return;
		}
		this.wachsen();
		Size *= Slug.eat(this);
		Day++;
	}

	private void wachsen() {
		double g = K.meanLight(1) * 0.05;
		if (K.meanWater(10) > 0.1) {
			g *= (K.meanWater(5) < 0.1) ? 1 : 0.5;
			Size *= 1 + g;
		}
	}

	public String toString() {
		return "K�rbis " + N + ", " + Day + " Tage alt, " + Size + " gro�.";
	}
}
