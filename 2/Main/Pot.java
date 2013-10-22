package Main;

import java.util.concurrent.CopyOnWriteArrayList;

public class Pot implements Comparable<Pot> {
	private static CopyOnWriteArrayList<Pot> Pots = new CopyOnWriteArrayList<Pot>();
	public final Pumpkin p;
	public final Soil s;
	private int nr;
	private boolean finished = false;

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

	public static void plant(Pot p) {
		Pots.add(p);
	}

	public static void Harvest() {
		for (Pot p : Pots) {
			if (p.p.harvest() == true) {// TODO das scheint mir blödsinn zu sein
				p.harvest();
			}
		}
	}

	public static void Time() {
		Evaporate();
		Percolate();
		Rain();
		Grow();
		Rot();
	}

	private static void Rain() {
		if (Weather.isRaining())
			for (Pot p : Pots) {
				p.s.absorbWater(0.1);
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

	public void waterize() {
		this.s.absorbWater(0.4);
	}

	public void fertilize() {
		this.s.absorbFertilizer(0.4);
	}

	public void weed() {
		this.s.weed();
	}

	public void harvest() {
		finished = true;
		Pots.remove(this);
		ContestManager.addFinishedPot(this);
	}

	public String toString() {
		return "Pot Nr. " + nr;
	}

	public boolean isFinished() {
		return finished;
	}

	@Override
	public int compareTo(Pot o) {
		return p.compareTo(o.p);
	}
}
