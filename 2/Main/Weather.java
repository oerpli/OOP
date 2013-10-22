package Main;

/**
 * Stellt Wetterdaten pro Tag bereit.
 */
class Weather {
	private int w = 1;
	static double light = 0;
	static double lightTime = -1;
	static double rain = 0;
	static double rainTime = -1;
	static double clouds = 0;
	static double cloudsTime = -1;

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
			clouds = Math.max(0, Math.sin(x / 24));
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
			light = result * (1 - getClouds(x));
			lightTime = x;
		}
		return light;
	}

	public static double getRain(int x) {
		if (x != rainTime) {
			rain = (1 + Math.sin(2 * x * Math.PI / 6 + 5)) / 2;
			rainTime = x;
		}
		return rain;
	}
}