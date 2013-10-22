package Main;

import java.util.HashMap;

import Exceptions.PlantingException;
import Interfaces.Soils;
import Soils.*;

public abstract class Soil implements Soils {
	private static HashMap<String, Soil> types = new HashMap<String, Soil>();
	static {
		types.put("clay", new Clay());
		types.put("sand", new Sand());
		types.put("humus", new Humus());
	}

	// Grunds�tzliche Eigenschaften des Drecktyps
	private final double percolationSpeed, evaporationSpeed, vulnerability;
	// Eigenschaften von Instanz von Dreck
	private double fertiLevel = 0, waterLevel = 0, weed = 0;

	public Soil(double pSpeed, double eSpeed, double vulnerability) {
		this.percolationSpeed = pSpeed;
		this.evaporationSpeed = eSpeed;
		this.vulnerability = vulnerability;
	}

	public double getFertilizer() {
		return fertiLevel;
	}

	public double getWater() {
		return waterLevel;
	}

	public double getWeed() {
		return weed;
	}

	// create(type) w�re vom code her logischer
	// buy("Sand") o.�. von der benutzung her.
	public static Soil create(String Type) throws PlantingException {
		try {
			return types.get(Type.toLowerCase()).getClass().getConstructor()
					.newInstance();
		} catch (Exception e) {
			throw new PlantingException(Type);
		}
	}

	public void absorbWater(double water) {
		waterLevel = Math.min(1, waterLevel + water);
	}

	public void absorbFertilizer(double amount) {
		fertiLevel = Math.min(1, fertiLevel + amount);
	}

	public double percolationSpeed() {
		return percolationSpeed;
	}

	public double evaporationSpeed() {
		return evaporationSpeed;
	}

	// public static void Percolate() {
	// for (Soil s : soils)
	// s.percolate();
	// }
	//
	// public static void Evaporate() {
	// for (Soil s : soils)
	// s.evaporate();
	// }

	void evaporate() {
		this.waterLevel *= this.evaporationSpeed() - 0.01 * Weather.getLight();
		this.fertiLevel *= 0.95;
	}

	void percolate() {
		this.waterLevel *= 0.5 + 0.5 * this.percolationSpeed();
	}

	void weed(double amount) {
		weed -= amount;
		weed = Math.max(0, Math.min(1, weed));
	}

	void growWeed() {
		weed += 0.05 * this.getWeedFactor();
		weed = Math.max(0, Math.min(1, weed));
	}

	private double getWeedFactor() {
		return vulnerability;
	}

}
