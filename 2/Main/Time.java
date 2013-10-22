package Main;

// Vorschlag: Zeitdauer sind ~258 Tage, jeden Tag gibt es EIN Wetter.

public abstract class Time {
	private static int h = 0;
	public static final int Dauer = (16 + 30 + 31 + 30 + 31 + 31 + 30 + 31);
	public static final int maxTime = 24 * Dauer;

	public static void nextHour() {
		h++;
		Pot.Time();// invoke time related static functions
		if (h == maxTime) {
			Pot.Harvest(); // am ende des bewerbes werden alle kürbisse
							// geerntet.
		}
	}

	public static void nextDay() {
		for (int i = 0; i < 24; i++)
			nextHour();
	}

	public static int getTime() {
		return h;
	}

	public static int getHour() {
		return h % 24;
	}

	public static int getDay() {
		return h / 24;
	}
}
