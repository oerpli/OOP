package Main;

/**
 * Stellt Wetterdaten pro Tag bereit.
 */
abstract class Weather {
	static private double[][] w = new double[185][3];
	static double light = 0;
	static double lightTime = -1;
	static double rain = 0;
	static double rainTime = -1;
	static double clouds = 0;
	static double cloudsTime = -1;

	static {
		for (int i = 0; i < 185; i++) {
			for (int j = 0; j < 3; j++) {
				w[i][j] = Math.random() * 0.5 + 0.5;
			}
		}
	}

	public static double getRain() {// wird oft gebraucht - nur 1x/h berechnet
		return getRain(Time.getTime());
	}

	public static double getLight() {// wird oft gebraucht - nur 1x/h berechnet
		return getLight(Time.getTime());
	}

	public static double getClouds() {// wird oft gebraucht - nur 1x/h berechnet
		return getClouds(Time.getTime());
	}

	public static double getClouds(int x) {
		if (x != cloudsTime) {
			clouds = w[x / 24][0] * Math.max(0, Math.sin(x / 24));
			cloudsTime = x;
		}
		return clouds;
	}

	public static double getLight(int x) {
		if (x != lightTime) {
			double rotation = Math.max(0, Math.sin(Math.PI * x / 12));
			double ecliptic = Math.sin(x / 24 / 365 * 2 * Math.PI);
			double result = (1 + Math.cos(Math.PI / 4 + 0.4 * ecliptic)
					* rotation) / 2;
			light = w[x / 24][1] * result * (1 - getClouds(x));
			lightTime = x;
		}
		return light;
	}

	public static double getRain(int x) {
		if (x != rainTime) {
			rain = (1 + Math.sin(2 * x * Math.PI / 6 + 5)) / 2;
			rainTime = w[x / 24][2] * x;
		}
		return rain;
	}
}
