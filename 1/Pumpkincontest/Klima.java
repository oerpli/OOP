package Pumpkincontest;

class Klima {
	private double[] Water = new double[100];
	private double[] Light = new double[100];

	double Light(int Day) {
		return Light[Day];
	}

	double Water(int Day) {
		return Water[Day];
	}

	protected double meanLight(int n) {
		double x = 0;
		n = Math.max(Time.day(), n);
		for (int i = Time.day() - n; i < Time.day(); i++) {
			x += this.Light(i);
		}
		return x / n;
	}

	protected double meanWater(int N) {
		double x = 0;
		for (int i = Time.day() - N; i < Time.day(); i++) {
			if (i > 0)
				x += this.Water(i);
		}
		return x / N;

		// int n = 0; // First Day
		// int m = Time.Day; // Last Day
		// if ((Time.day() - N0) >= 0) {
		// n = (Time.day() - N0);
		// // m = Day; // unnötig
		// } else {
		// n = 0;
		// // m = (Math.min(Day, N0)); // sinnlos - kommt nur wenn Day < N0 ist
		// }
		// for (int i = n; i < Time.day(); i++) {
		// x += this.Water(i);
		// }
		// return x / (Math.min(Time.day(), N0));
	}

	protected boolean setKlima(double light, double water)
			throws PumpkinException {
		if (light + water > 1)
			throw new PumpkinException("Someone tried cheating");
		if (light + water > 1 || light < 0 || water < 0)
			return false;
		Light[Time.day()] = light;
		Water[Time.day()] = water;
		return true;
	}
}
