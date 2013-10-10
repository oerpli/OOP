public class Klima {
	private double[] Water = new double[100];
	private double[] Light = new double[100];

	double Light(int Day) {
		return Light[Day];
	}

	private double Water(int Day) {
		return Water[Day];
	}

	public double meanLight(int n) {
		double x = 0;
		n = Math.max(Time.Day, n);
		for (int i = Time.Day - n; i < Time.Day; i++) {
			x += this.Light(i);
		}
		return x / n;
	}

	public double meanWater(int N0) {
		double x = 0;
		int n = 0; // First Day
		// int m = Time.Day; // Last Day
		if ((Time.Day - N0) >= 0) {
			n = (Time.Day - N0);
			// m = Day; // unnötig
		} else {
			n = 0;
			// m = (Math.min(Day, N0)); // sinnlos - kommt nur wenn Day < N0 ist
		}
		for (int i = n; i < Time.Day; i++) {
			x += this.Water(i);
		}
		return x / (Math.min(Time.Day, N0));
	}

	public boolean setKlima(double light, double water) throws PumpkinException {
		if (light + water > 1)
			throw new PumpkinException();
		if (light + water > 1 || light < 0 || water < 0)
			return false;
		Light[Time.Day] = light;
		Water[Time.Day] = water;
		return true;
	}
}
