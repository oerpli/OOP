package Pumpkincontest;

class Pumpkin {
	public final int N; // K�rbisnummer
	private double Size = 1; // Gr��e
	private final Klima K;
	private final int born;
	private static int n = 1;

	protected Pumpkin() {
		born = Garten.day();
		N = n++;
		K = new Klima();
	}

	protected Klima K() {
		return K;
	}

	protected void wachsen() {
		double g = K.Light() * 0.05;
		if (K.meanWater(10) > 0.1) {
			g *= (K.meanWater(5) < 0.1) ? 1 : 0.5;
			Size *= 1 + g;
		}
	}

	public int age() {
		return Garten.day() - born;
	}

	public String toString() {
		return "K�rbis " + N + ", " + this.age() + " Tage alt, " + Size
				+ "KE gro�, es gab" + " " + K.getLightDay() + " Sonnentage"
				+ " und " + K.getWaterDay() + " Regentage.";
	}
}
