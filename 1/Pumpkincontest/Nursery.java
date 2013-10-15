package Pumpkincontest;

import java.util.ArrayList;

public class Nursery {
	private final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();
	// private final ArrayList<Pumpkin> F = new ArrayList<Pumpkin>();
	private static int Day = 0;

	protected static int day() {
		return Day;
	}

	public void petPumpkinNr(int N, double l, double w) throws Exception {
		if (N < G.size())
			G.get(N).setKlima(l, w);
		else
			throw new Exception("Kürbis nicht vorhanden/schon geerntet");
	}

	public void closeDay() {
		for (Pumpkin k : G) {
			k.grow();
			k.slug();
		}
		// harvest();
		nextDay();
	}

	// private void harvest() {// wäre auch mit HarvestException oder so möglich
	// // statt alle durchprobieren
	// ArrayList<Pumpkin> f = new ArrayList<Pumpkin>();
	// for (Pumpkin k : G)
	// if (k.age() == 100)
	// f.add(k);
	// for (Pumpkin k : f) {
	// G.remove(k);
	// F.add(k);
	// }
	// }

	public void plant(int n) {
		for (int i = 0; i < n; i++)
			plant();
	}

	private void plant() {
		Pumpkin p = new Pumpkin();
		G.add(p);
	}

	private static void nextDay() {
		Day++;
	}

	public String toString() {
		// Collections.sort(G);
		String s = "";
		if (G.size() > 0) {
			s += "Am Reifen (wie Turner):\n";
			for (Pumpkin k : G)
				s += k.toString() + '\n';
		}
		// if (F.size() > 0) {
		// s += "Fertig:\n";
		// for (Pumpkin k : F)
		// s += k.toString() + '\n';
		// }
		return s;
	}
}
