package Pumpkincontest;

class Pumpkin {
	private double Size = 1; // Gr��e
	public final Klima K;
	private final int born;
	final int N;
	private static int n = 1;

	protected Pumpkin() {
		born = Time.day();
		N = n++;
		K = new Klima();
	}

	protected void wachsen() {
		double g = K.Light() * 0.05;
		if (K.meanWater(10) > 0.1) {
			g *= (K.meanWater(5) < 0.1) ? 1 : 0.5;
			Size *= 1 + g;
		}
	}

	private int age() {
		return Time.day() - born;
	}

	public String toString() {
		return "K�rbis " + N + ", " + this.age() + " Tage alt, " + Size
				+ "KE gro�, es gab"+" "+K.getLightDay()+" Sonnentage"+" und "+K.getWaterDay()+" Regentage.";
	}
}
