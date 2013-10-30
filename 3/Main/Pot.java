package Main;
//GUT:Klassenzusammenhalt:Pot bietet alle Schnittstellen für Pots an
//Schlecht:Objektkopplung:Es werden viele Methoden in anderen Klassen aufgerufen 
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Pot implements Comparable<Pot> {
	private static CopyOnWriteArrayList<Pot> Pots = new CopyOnWriteArrayList<Pot>();
	public final Pumpkin p;
	public final Soil s;
	private int nr;
	private boolean finished = false;

	static Random random = new Random();

	Pot(Pumpkin p, Soil s, int nr) {
		this.p = p;
		this.s = s;
		this.nr = nr;
	}

	Pot(int p) {
		this.p = null;
		this.s = null;
		this.nr = p;
	}

	//Neuer Kürbistopf wird hinzugefügt
	public static void plant(Pot p) {
		Pots.add(p);
	}

	//Methode die Zeitabhängige Methoden aufruft
	public static void Time() {
		Evaporate();
		Percolate();
		Rain();
		Grow();
		Rot();
		Snail();
	}


	public static void Harvest() {
		for (Pot p : Pots) {
			p.harvest();
		}
	}

	private static void Rain() {
		for (Pot p : Pots) {
			p.s.absorbWater(Weather.getRain());
		}
	}

	private static void Grow() {
		for (Pot p : Pots) {
			p.p.grow(p.s.getWater(), p.s.getFertilizer(), p.s.getWeed());
			p.s.growWeed();
		}
	}

	private static void Percolate() {
		for (Pot p : Pots) {
			p.s.percolate();
		}
	}

	private static void Evaporate() {
		for (Pot p : Pots) {
			p.s.evaporate();
		}
	}
	private static void Rot() {
		for (Pot p : Pots) {
			p.p.rot(p.s.getFertilizer());
		}
	}

	private static void Snail() {
		for (Pot p : Pots)
			if (Math.random() < 0.001)
				p.p.snail();
	}

	public void waterize(double amount) {
		this.s.absorbWater(amount);
	}

	public void fertilize(double amount) {
		this.s.absorbFertilizer(amount);
	}

	public void weed(double amount) {
		this.s.weed(amount);
	}

	//Erntet den Topf
	//Gibt false zurueck falls ContestManager false zurueckgibt (im Falle einer Vergammellung)
	public boolean harvest() {
		finished = true;
		Pots.remove(this);
		return ContestManager.addFinishedPot(this);
	}

	public String toString() {
		return "Pot Nr. " + nr;
	}

	public boolean isFinished() {
		return finished;
	}

	public void usePoison(double amount) {
		this.p.usePoison(amount);
	}

	@Override
	public int compareTo(Pot o) {
		return p.compareTo(o.p);
	}
}
