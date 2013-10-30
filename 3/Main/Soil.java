package Main;
//GUT:Klassenzusammenhalt: Soil enthält ausschließlich Methoden die mit dem Boden zusammenhängen
//Schlecht:Objektkopplung:Mehrere getter Methoden

import java.util.HashMap;

import Exceptions.PlantingException;
import Interfaces.Soils;
import Soils.*;


/**
 * Stellt dem KÃ¼rbis das Wasser und die NÃ¤hrstoffe bereit.
 */
public abstract class Soil implements Soils {
	private static HashMap<String, Soil> types = new HashMap<String, Soil>();
	static {
		types.put("clay", new Clay());
		types.put("sand", new Sand());
		types.put("humus", new Humus());
	}

	// GrundsÃ¤tzliche Eigenschaften des Drecktyps
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


	//Erstellt eine neue Erde
	//Es dürfen nur tatsächlich vorhandene Typen verwendet werden , wird im Code überprüft
	
	protected static Soil create(String Type) throws PlantingException {
		try {
			return types.get(Type.toLowerCase()).getClass().getConstructor()
					.newInstance();
		} catch (Exception e) {
			throw new PlantingException(Type);
		}
	}

	//berechnet den neuen Wasserstand
	//waterLevel <=1 //Invariante
	protected void absorbWater(double water) {
		waterLevel = Math.min(1, waterLevel + water);
	}
	//berechnet den neuen Düngerstand
	//fertiLevel <=1 //Invariante
	protected void absorbFertilizer(double amount) {
		fertiLevel = Math.min(1, fertiLevel + amount);
	}

	//berechnet die Verdunstung von Wasser und Dünger anhand des aktuellen Sonnenstandes und des jeweiligen Bodens
	void evaporate() {
		this.waterLevel *= this.evaporationSpeed() - 0.01 * Weather.getLight();
		this.fertiLevel *= 0.95;
	}

	//berechnet die Versickerung anhand des jeweiligen Bodens
	void percolate() {
		this.waterLevel *= 0.5 + 0.5 * this.percolationSpeed();
	}

	//Unkraut jäten
	//weed wird dabei um den übergebenen Wert reduziert
	//0 < weed < 1
	void weed(double amount) {
		weed -= amount;
		weed = Math.max(0, Math.min(1, weed));
	}

	//Unkraut wächst je nach Boden 
	//0 < weed < 1
	void growWeed() {
		weed += 0.05 * this.getWeedFactor();
		weed = Math.max(0, Math.min(1, weed));
	}

}
