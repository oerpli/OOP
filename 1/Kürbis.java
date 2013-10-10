public class K�rbis {
	private double G = 1; // Gr��e
	private Klima K;
	private int T = 0;
	private int N;
	private static int n = 0;

	public K�rbis() {
		N = n++;
		K = new Klima();
	}

	public void Tag(double l, double w) {
		if (!this.K.setKlima(T, l, w)) {
			System.err.println("Zu viel Liebe f�r K�rbis Nummer " + N);
			return;
		}
		this.wachsen();
		this.schnecken();
		T++;
	}

	private void wachsen() {
		double g = K.L(T) * 0.05;
		System.out.println(g);
		g *= (K.meanW(T, 5) < 0.1) ? 1 : 0.5;
		g *= (K.meanW(T, 10) < 0.1) ? 1 : 0;
		G *= 1 + g;
	}

	public void schnecken() {
		int W = 0;
		W += K.meanW(T, 1) > 0.5 ? 1 : 0;
		W += K.meanW(T, 2) > 0.3 ? 1 : 0;
		W += K.meanW(T, 4) > 0.1 ? 1 : 0;
		double s = Math.pow(0.99, W);
		G *= s;
	}

	public String toString() {
		return "K�rbis, " + T + " Tage alt, " + G + " gro�.";
	}
}
