package Main;

import java.util.ArrayList;
import java.util.Random;

/**
 * Stellt Wetterdaten pro Tag bereit.
 */
//GUT:Klassenzusammenhalt: Weather beeinhaltet alle Wetterreleveanten Methoden
//GUT:Objektkopplung: Methoden haben wenige Parameter
//Schlecht:Alle Methoden public
abstract class Weather {
	private static double[][] w = new double[Time.Tage][3];
	private static double light = 0;
	private static double lightTime = -1;
	private static double rain = 0;
	private static double rainTime = -1;
	private static double clouds = 0;
	private static double cloudsTime = -1;
	private static Random random = new Random();
	private static ArrayList<Integer> tempestDays = new ArrayList<Integer>();

	// KÃ¶nnte sonst der Benutzer konfigurieren - ist in dem fall aber einfach
	// random.
	//Berechnet zufällige Wetterdaten
	//Daten sind in den jeweiligen Speichern //Nachbedinung
	static {
		int hailDays = random.nextInt(10);
		for (int i = 0; i < hailDays; i++)
			tempestDays.add(random.nextInt(Time.Tage));

		for (int i = 0; i < Time.Tage; i++) {
			for (int j = 0; j < 3; j++) {
				// faktoren fÃ¼r wolken/sonne und regen
				w[i][j] = random.nextDouble() * 0.5 + 0.5;
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
	//Geben den Lichtgrad /Bewölkung an zur Stunde x an //Invariante: x darf nicht kleiner 0 werden (-> negative Zeit )
	//Gibt Wert zwischen 0 und 1 zurück //Nachbedinung
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
	//Überprüft ob Stunde x ein Spezieller Wettertag ist
	public static boolean isTempest() {
		return tempestDays.contains(Time.getDay());
	}

	public static boolean isTempest(int x) {
		return tempestDays.contains(x / 24);
	}
}
