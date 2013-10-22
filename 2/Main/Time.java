package Main;

// Vorschlag: Zeitdauer sind ~258 Tage, jeden Tag gibt es EIN Wetter.

public abstract class Time {
	private static int h = 0;
	private static int maxTime = 24 * (31 + 30 + 31 + 30 + 31 + 31 + 30 + 31);

	public static void nextHour() {
		h++;
		Pot.Time();// invoke time related static functions
		if (h == maxTime) {
			Pot.Harvest(); // am ende des bewerbes werden alle kürbisse geerntet.
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
}
