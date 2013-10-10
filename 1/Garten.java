import java.util.ArrayList;
import java.util.HashMap;

public abstract class Garten {
	static int N = 0; // Teilnehmer
	static final ArrayList<Pumpkin> K = new ArrayList<Pumpkin>();
	static final HashMap<Pumpkin, Klima> PK = new HashMap<Pumpkin, Klima>();

	static void pflanzen() {
		Pumpkin p = new Pumpkin();
		K.add(p);
		PK.put(p, new Klima());
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

	static void pflanzen(int n) {
		for (int i = 0; i < n; i++)
			pflanzen();
	}

	public void Tag(double l, double w) {
		for (Pumpkin k : K) {
			try {
				PK.get(k).setKlima(l, w);
			} catch (PumpkinException e) {
				System.err.println("Owner of pumpkin nr. " + k.N
						+ " tried cheating");
			}
			k.wachsen();
			Slug.eat(k);
		}
		Time.Day++;
	}
}
