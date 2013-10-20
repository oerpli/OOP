package Main;

/**
 * Stellt Wetterdaten pro Tag bereit.
 */
class Weather {
	static double flux = 0;
	static double fluxTime = -1;

	public int getSunHours(int day) {
		return day;
	}

	public double getRain(int day) {
		return day;
	}

	public double getMinTemp(int day) {
		return day;
	}

	public double getMaxTemp(int day) {
		return day;
	}

	public static double getLight(int x) {
		double rotation = Math.max(0, Math.sin(Math.PI * x / 12));
		double ecliptic = Math.sin(x / 24 / 365 * 2 * Math.PI);
		return Math.cos(Math.PI / 4 + 0.4 * ecliptic) * rotation;
	}

	public static double getLight() {
		int x = Time.getTime();
		if (x > fluxTime) {
			flux = getLight(Time.getTime());
		}
		return flux;

	}

	public static int getSunHours() {
		return 0;
	}

	public static double getRain() {
		return 0;
	}

	public static double getMinTemp() {
		return 0;
	}

	public static double getMaxTemp() {
		return 0;
	}

	public static boolean isRaining() {
		return false;
	}

}
