package Main;

// Vorschlag: Zeitdauer sind ~258 Tage, jeden Tag gibt es EIN Wetter.

public abstract class Time {
	private static int h = 0;

	public static void nextHour() {
		h++;
		Pot.Time();// invoke time related static functions
		if (h % 24 == 0) {
			Pot.Harvest();// check pumpkins once a day for age
		}
		Weather.debug();
	}

	public static void nextDay() {
		for (int i = 0; i < 24; i++)
			nextHour();
	}

	public static int getTime() {
		return h;
	}
}
