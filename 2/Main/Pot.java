package Main;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Pot implements Comparable<Pot> {
	private static CopyOnWriteArrayList<Pot> Pots = new CopyOnWriteArrayList<Pot>();
	public final Pumpkin p;
	public final Soil s;
	private int nr;
	private boolean finished = false;
	
	static Random random=new Random();

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
			p.harvest();
		}
	}

	public static void Time() {
		Evaporate();
		Percolate();
		Rain();
		Grow();
		Rot();
		Snail();
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

	public void waterize(double amount) {
		this.s.absorbWater(amount);
	}

	public void fertilize(double amount) {
		this.s.absorbFertilizer(amount);
	}

	public void weed(double amount) {
		this.s.weed(amount);
	}

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
	
	public void usePoison(){
		if(this.p.getPoisonUsed()==0)
			this.p.setPoisonUsed(Time.getHour());
	}
	
	private static void Snail() {

		if (Pots.size() > 0) {
			if (random.nextInt(10) > 5) {
				int index = random.nextInt(Pots.size());
				Pot randomItem = Pots.get(index);
				randomItem.p.snail();
			}
		}
	}
	@Override
	public int compareTo(Pot o) {
		return p.compareTo(o.p);
	}
}
