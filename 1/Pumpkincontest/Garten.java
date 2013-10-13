package Pumpkincontest;

import java.util.ArrayList;

public class Garten {
	private final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();
	private final ArrayList<Pumpkin> F = new ArrayList<Pumpkin>();
	private static int Day = 0;

	public static int day() {
		return Day;
	}

	private static void nextDay() {
		Day++;
	}

	private void pflanzen() {
		Pumpkin p = new Pumpkin();
		G.add(p);
	}

	public void pflanzen(int n) {
		for (int i = 0; i < n; i++)
			pflanzen();
	}

	public void petPumpkinNr(int N, double l, double w) throws Exception {
		if (N < G.size())
			G.get(N).K().setKlima(l, w);
		else
			throw new Exception("Kürbis nicht vorhanden/schon geerntet");
	}

	public void closeDay() {
		for (Pumpkin k : G) {
			k.wachsen();
			Slug.eat(k);
		}
		harvest();
		nextDay();
	}

	private void harvest() {// wäre auch mit HarvestException oder so möglich
							// statt alle durchprobieren
		ArrayList<Pumpkin> f = new ArrayList<Pumpkin>();
		for (Pumpkin k : G)
			if (k.age() == 100)
				f.add(k);
		for (Pumpkin k : f) {
			G.remove(k);
			F.add(k);
		}
	}

	public String toString() {
		String s = "";
		if (G.size() > 0) {
			s += "Am Reifen (wie Turner):\n";
			for (Pumpkin k : G)
				s += k.toString() + '\n';
		}
		if (F.size() > 0) {
			s += "Fertig:\n";
			for (Pumpkin k : F)
				s += k.toString() + '\n';
		}
		return s;
	}
}
