package Pumpkincontest;

import java.util.ArrayList;

public class Nursery {
	private final ArrayList<Pumpkin> G = new ArrayList<Pumpkin>();
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
		nextDay();
	}

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
		String s = "";
		if (G.size() > 0) {
			for (Pumpkin k : G)
				s += k.toString() + '\n';
		}
		return s;
	}
}
