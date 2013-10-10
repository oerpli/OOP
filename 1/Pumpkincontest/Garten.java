package Pumpkincontest;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Garten {
	static int N = 0; // Teilnehmer
	static final ArrayList<Pumpkin> K = new ArrayList<Pumpkin>();

	// static final HashMap<Pumpkin, Klima> PK = new HashMap<Pumpkin, Klima>();

	public static void pflanzen() {
		Pumpkin p = new Pumpkin();
		K.add(p);
		// PK.put(p, new Klima());
	}

	// Wenn Kürbisse in Array
	// static boolean pflanzen(){
	// if (N < K.length) {
	// K[N++] = new Pumpkin();
	// return true;
	// } else {
	// System.err.println("Garten voll");
	// return false;
	// }
	// }

	public static void pflanzen(int n) {
		for (int i = 0; i < n; i++)
			pflanzen();
	}

	public void Tag(double l, double w) throws PumpkinException {
		for (Pumpkin k : K) {
			// PK.get(k).setKlima(l, w);
			k.K.setKlima(l, w);
			k.wachsen();
			Slug.eat(k);
		}
		Time.nextDay();
	}

	public static String String() {
		String s = "";
		for (Pumpkin k : K) {
			s += k.toString() + '\n';
		}
		return s;
	}
}
