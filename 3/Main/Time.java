//GUT:Klassenzusammenhalt: Alle Zeit Methoden sind in dieser Klasse
//Schlecht:Objektkopplung:Alle Methoden sind public
package Main;

public abstract class Time {
	private static int h = 0;
	public static final int Tage = (16 + 30 + 31 + 30 + 31 + 31 + 30 + 31);
	public static final int maxTime = 24 * Tage;
	private static boolean lock = false;

	//Erhöht stunde(=h) um 1 , führt Zeit-Methoden in Pot aus 
	//Kann solange ausgeführt werden wie h<maxTime
	public static void nextHour() {
		if (!lock) {
			Pot.Time();// invoke time related static functions
			h++;
			if (h == maxTime) {
				Pot.Harvest(); // am ende des bewerbes werden alle kÃ¼rbisse
								// geerntet.
				lock = true;
			}
		}
	}

	//Führt nextHour() 24 mal aus
	public static void nextDay() {
		for (int i = 0; i < 24; i++)
			nextHour();
	}
	//Gibt akutelle Zeit zurueck
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
