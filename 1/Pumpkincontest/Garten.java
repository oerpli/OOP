package Pumpkincontest;

import java.util.ArrayList;

public abstract class Garten {
	static int N = 0; // Teilnehmer
	static final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();

	private static void pflanzen() {
		Pumpkin p = new Pumpkin();
		G.add(p);
	}

	public static void pflanzen(int n) {
		for (int i = 0; i < n; i++)
			pflanzen();
	}

	public static void Tag(double l, double w) throws PumpkinException {
		for (Pumpkin k : G) {
			k.K.setKlima(l, w);
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
