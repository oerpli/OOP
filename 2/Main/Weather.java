package Main;

/**
 * Stellt Wetterdaten pro Tag bereit.
 */
class Weather {
	private int w;
	static double light = 0;
	static double lightTime = -1;
	static double rain = 0;
	static double rainTime = -1;

	public static double getRain(int w) {
		return Math.max(0,
				Math.sin(2 * w * Time.getHour() * Math.PI / 24 / 5 * 20 + 5));
	}

	public static double getRain() {
		if (Time.getTime() > rainTime)
			rain = getRain(Time.getTime());
		return rain;
	}

	public static double getLight(int x) {
		double rotation = Math.max(0, Math.sin(Math.PI * x / 12));
		double ecliptic = Math.sin(x / 24 / 365 * 2 * Math.PI);
		double result = Math.cos(Math.PI / 4 + 0.4 * ecliptic) * rotation;
		return result * calcClouds(x);
	}

	public static double getLight() {// wird oft gebraucht - nur 1x/h berechnet
		if (Time.getTime() > lightTime)
			light = getLight(Time.getTime());
		return light;
	}

	public static boolean isRaining() {
		return getRain(Time.getTime()) > 0.5;
	}

	public static double calcClouds(int x) {
		double result = Math.max(0, Math.sin(2 * x * Math.PI / 24 / 5 * 20));
		return Math.max(1, result * 2);
	}

}
