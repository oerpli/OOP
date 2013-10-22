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
		double sun = Weather.getLight();
		//System.out.println("sun: "+sun+"minsun: "+minSun);
		double sunFactor = 1;
		double waterFactor = 1;
		double fertiFactor = 0;
		double growth = 0;

		sunFactor = sun / minSun;

		if (sunFactor > 2)
			sunFactor = 2;
		
		waterFactor = water / minWater;

		if (waterFactor > 2)
			waterFactor = 2;

			growth = ((sunFactor + waterFactor + fertiFactor)) - Math.max(-0.5,Math.min(2,weedFactor));
		
			growth=Math.min(1.4,Math.max(1,growth));
			weight = weight * growth;
			//System.out.println(sunFactor+" "+waterFactor+" "+fertiFactor+" "+weedFactor);
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
