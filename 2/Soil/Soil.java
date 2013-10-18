package Soil;

import java.util.ArrayList;

public abstract class Soil {
	private static ArrayList<Soil> soils = new ArrayList<Soil>();

	private double fertiLevel; // aktuelles Düngerlevel des Bodens
	protected double waterLevel; // aktuelles Wasserlevel des Bodens

	public Soil() {
		soils.add(this);
	}

	public void absorbWater(double water) {
		waterLevel = Math.min(100, waterLevel + water);
	}

	public void absorbFertilizer(double fertilizer) {
		fertiLevel = Math.min(100, fertiLevel + fertilizer);
	}

	public static void Percolate() {
		for (Soil s : soils)
			s.percolate();
	}

	private void percolate() {
		this.waterLevel *= this.percolationLevel();
	}

	abstract double percolationLevel();
}
