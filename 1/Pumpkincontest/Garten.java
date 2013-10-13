package Pumpkincontest;

import java.util.ArrayList;

public abstract class Garten {
	private static final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();

	private static void pflanzen() {
		Pumpkin p = new Pumpkin();
		G.add(p);
	}

	public static void pflanzen(int n) {
		for (int i = 0; i < n; i++)
			pflanzen();
	}

	public static void petPumpkinNr(int N, double l, double w)
			throws PumpkinException {
		G.get(N).K().setKlima(l, w);
	}

	public static void closeDay() {
		for (Pumpkin k : G) {
			k.wachsen();
			Slug.eat(k);
		}
		Time.nextDay();

	}

	public static String String() {
		String s = "";
		for (Pumpkin k : G) {
			s += k.toString() + '\n';
		}
		return s;
	}
}
