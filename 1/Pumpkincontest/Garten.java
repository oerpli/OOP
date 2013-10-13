package Pumpkincontest;

import java.util.ArrayList;

public abstract class Garten {
	private static final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();
	private static final ArrayList<Pumpkin> F = new ArrayList<Pumpkin>();

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
		if (N < G.size())
			G.get(N).K().setKlima(l, w);
		else
			throw new PumpkinException("Kürbis nicht vorhanden/schon geerntet");
	}

	public static void closeDay() {
		for (Pumpkin k : G) {
			try {
				k.K().setKlima(0, 0);
			} catch (PumpkinException e) {
			}
			k.wachsen();
			Slug.eat(k);
		}
		Time.nextDay();
		harvest();
	}

	private static void harvest() {
		ArrayList<Pumpkin> f = new ArrayList<Pumpkin>();
		for (Pumpkin k : G)
			if (k.age() == 100)
				f.add(k);
		for (Pumpkin k : f) {
			G.remove(k);
			F.add(k);
		}
	}

	public static String String() {
		String s = "";
		for (Pumpkin k : F) {
			s += k.toString() + '\n';
		}
		return s;
	}
}
