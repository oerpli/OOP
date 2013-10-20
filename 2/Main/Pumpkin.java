package Main;

import java.util.HashMap;

import Exceptions.PlantingException;
import Log.Log;
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
		this.lifetime = lifetime;
		this.rot = false;
	}

	public static Pumpkin create(String Type) throws PlantingException {
		String t = Type.toLowerCase();
		try {
			return types.get(t).returnNew();
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
		double sun = Weather.getLight();
		double sunFactor = 1;
		double waterFactor = 1;
		double fertiFactor = 0;
		double growth = 0;

		if ((minSun - sun) < 0)
			sunFactor = 0;
		else if (minSun == sun)
			sunFactor = 1;
		else
			sunFactor = sun / minSun;

		if ((minWater - water) < 0)
			waterFactor = 0;
		else if (minWater == water)
			waterFactor = 1;
		else
			waterFactor = water / minWater;

		if (waterFactor > 2)
			waterFactor = 2;

		if (((getAge() / 24) > lifetime * 0.8)) {
			growth = 0;
		} else {
			growth = ((sunFactor + waterFactor + fertiFactor) / 3) - weedFactor;
		}
		if (growth < 1)

			weight = weight * growth;

		if (Log.debug > 3)
			System.out.println("growth: " + growth + " new weight: " + weight); // DEBUG!
	}

	public boolean harvest() {
		if ((getAge() / 24) >= lifetime)
			return true;
		return false;
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
		if (((getAge() / 24) > lifetime * 0.8)
				&& (fertiLevel * ((getAge() / 24) / lifetime) > 7)) {
			this.rot = true;
		}
	}

}
