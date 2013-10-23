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

	// Grundsätzliche Eigenschaften des Drecktyps
	private final double percolationSpeed, evaporationSpeed, vulnerability;
	// Eigenschaften von Instanz von Dreck
	private double fertiLevel = 0, waterLevel = 0, weed = 0;

	protected Soil(double pSpeed, double eSpeed, double vulnerability) {
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

	public double percolationSpeed() {
		return percolationSpeed;
	}

	public double evaporationSpeed() {
		return evaporationSpeed;
	}

	private double getWeedFactor() {
		return vulnerability;
	}

	// create(type) wäre vom code her logischer
	// buy("Sand") o.Ä. von der benutzung her.
	protected static Soil create(String Type) throws PlantingException {
		try {
			return types.get(Type.toLowerCase()).getClass().getConstructor()
					.newInstance();
		} catch (Exception e) {
			throw new PlantingException(Type);
		}
	}

	protected void absorbWater(double water) {
		waterLevel = Math.min(1, waterLevel + water);
	}

	protected void absorbFertilizer(double amount) {
		fertiLevel = Math.min(1, fertiLevel + amount);
	}

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

}
