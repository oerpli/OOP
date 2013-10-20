package Main;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Pot {
	private static CopyOnWriteArrayList<Pot> Pots = new CopyOnWriteArrayList<Pot>();
	private static ArrayList<Pot> finishedPots = new ArrayList<Pot>();
	public final Pumpkin p;
	public final Soil s;

	Pot(Pumpkin p, Soil s) {
		this.p = p;
		this.s = s;
	}

	public static void plant(Pot p) {
		Pots.add(p);
	}

	public static void Harvest() {
		for (Pot p : Pots) {
			if (p.p.harvest() == true) {
				Pots.remove(p);
				finishedPots.add(p);
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
			p.s.grow();
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
}
