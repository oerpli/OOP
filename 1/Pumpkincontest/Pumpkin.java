package Pumpkincontest;

class Pumpkin {
	protected final int N; // Kürbisnummer
	private double Size = 1; // Größe
	private final Clime K;
	private final int born;
	private static int n = 1;

	protected Pumpkin() {
		born = Nursery.day();
		N = n++;
		K = new Clime();
	}

	protected void grow() {
		double g = K.light() * 0.05;
		if (K.meanWater(10) > 0.1) {
			g *= (K.meanWater(5) < 0.1) ? 1 : 0.5;
			Size *= 1 + g;
		}
	}

	protected void slug() {
		if (K.meanWater(1) >= 0.5 || K.meanWater(2) >= 0.3
				|| K.meanWater(4) >= 0.1)
			Size *= 0.99;
	}

	protected int age() {
		return Nursery.day() - born;
	}

	public String toString() {
		return "Kürbis " + N + ", " + this.age() + " Tage alt, " + Size
				+ "KE groß, es gab" + " " + K.getSunny() + " Sonnentage"
				+ " und " + K.getRainy() + " Regentage.";
	}

	public void setKlima(double light, double water) throws Exception {
		try {
			this.K.setKlima(light, water);
		} catch (Exception e) {
			throw new Exception("Pumpkin Nr." + N + " tried cheating.");
		}
	}
}
