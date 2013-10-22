package Main;

import java.util.HashMap;

import Exceptions.PlantingException;
import Pumpkins.*;

public abstract class Pumpkin implements Comparable<Pumpkin> {
	// @Deprecated
	// private static ArrayList<Pumpkin> pumpkins = new ArrayList<Pumpkin>();
	private static HashMap<String, Pumpkin> types = new HashMap<String, Pumpkin>();
	static {
		types.put("patisson", new Patisson());
		types.put("hokkaido", new Hokkaido());
		types.put("aladdin", new Aladdin());
	}
	private double weight;
	private final int planted;
	private double minSun; // Sonne die zum Wachsen ben�tigt wird , individuell
							// pro
							// Sorte
	private double minWater;
	private int lifetime; // Wachstumszeit
	private boolean rot; // verfault ja/nein

	// private Soil soil; // Das zum Kürbis gehörende Boden-Objekt

	protected Pumpkin(double d, double minWater, int lifetime) {
		// pumpkins.add(this);
		this.planted = Time.getTime();
		this.weight = 1.0;
		this.minSun = d;
		this.minWater = minWater;
		this.lifetime = lifetime * 24;
		this.rot = false;
	}

	public static Pumpkin create(String Type) throws PlantingException {
		try {
			return types.get(Type.toLowerCase()).returnNew();
		} catch (NullPointerException e) {
			throw new PlantingException(Type);
		}
	}

	public abstract Pumpkin returnNew();

	public int getAge() {
		return Time.getTime() - this.planted;
	}

	public double getWeight() {
		return weight;
	}

	public void grow(double water, double ferti, double weedFactor) {
		double growth = 1 * (1 + 0.5 * ferti);
		growth *= Math.max(0, Weather.getLight() - minSun);
		growth *= Math.max(0, water - minWater);
		growth *= 1 - weedFactor * 0.5;
		weight *= 1 + growth;
	}

	@Override
	public int compareTo(Pumpkin X) {
		if (this.weight > X.weight)
			return 1;
		else if (this.weight == X.weight)
			return 0;
		else
			return -1;
	}

	public void rot(double fertiLevel) {
		if ((getAge() > lifetime * 0.8)
				&& (fertiLevel * getAge() / lifetime) > 7) {
			this.rot = true;
		}
	}
}
