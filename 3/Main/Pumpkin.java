package Main;

//GUT: Klassenzusammenhalt: Pumpkin enthält alle Methoden die zum Kürbis gehören
//Schlecht:Klassenzusammenhalt: Snail() passt nicht 100%ig zum Rest der Klasse
import java.util.HashMap;
import Exceptions.PlantingException;
import Pumpkins.*;

public abstract class Pumpkin implements Comparable<Pumpkin> {

	private static HashMap<String, Pumpkin> types = new HashMap<String, Pumpkin>();
	static {
		types.put("patisson", new Patisson());
		types.put("hokkaido", new Hokkaido());
		types.put("aladdin", new Aladdin());
		types.put("magic", new Magic());
	}
	protected double weight;
	private final int planted;
	private double minSun; // Sonne die zum Wachsen benÃ¶tigt wird
	private double minWater;
	private int lifetime; // Wachstumszeit
	private double growSpeed;
	private boolean rot; // verfault ja/nein
	protected double poison;

	protected Pumpkin(double minSun, double minWater, int lifetime,
			double growSpeed) {

		this.planted = Time.getTime();
		this.weight = 1.0;
		this.growSpeed = growSpeed;
		this.minSun = minSun;
		this.minWater = minWater;
		this.lifetime = lifetime * 24;
		this.rot = false;
		this.poison = 0;
	}

	public static Pumpkin create(String Type) throws PlantingException { // Vorbedinung:Sorte
																			// muss
																			// vorhanden
																			// sein
																			// sonst
																			// wird
																			// Exception
																			// geworfen
		assert Type != null;
		try {
			return types.get(Type.toLowerCase()).returnNew();
		} catch (NullPointerException e) {

			throw new PlantingException(Type);
		}
	}

	protected abstract Pumpkin returnNew();

	// Gibt aktuelles Alter zurück //Muss ein positiver Wert sein
	public int getAge() {
		return Time.getTime() - this.planted;
	}

	// gibt gewicht zurück
	public double getWeight() {
		return weight;
	}

	/**
	 * Berechnet das Wachstum.
	 */
	protected void grow(double water, double ferti, double weedFactor) {
		assert water >= 0;
		assert ferti >= 0;
		assert weedFactor >= 0;
		double growth = growSpeed * (1 + 0.5 * ferti); // Wachstum errechnet
														// sich aus dem
														// Düngerlevel und einer
														// Sortenkonstante
		growth *= Math.max(0, Weather.getLight() - minSun);
		growth *= Math.max(0, water - minWater);
		growth *= 1 - weedFactor * 0.5;
		if (Weather.isTempest()) // Falls ein Unwetter herrscht reduziere
									// Gewicht
			weight *= 0.99;
		weight *= 1 + growth; // Gewicht steigt oder bleibt gleich
	}

	@Override
	public int compareTo(Pumpkin X) {
		assert X != null;
		if (this.weight > X.weight)
			return 1;
		else if (this.weight == X.weight)
			return 0;
		else
			return -1;
	}

	/**
	 * Ab einem gewissen Alter und zu viel DÃ¼nger verrottet der KÃ¼rbis.
	 */
	protected void rot(double ferti) {
		assert ferti >= 0;
		if ((getAge() > 0.8 * lifetime) && ferti > 0.5) {
			this.rot = true;
		}
	}

	public boolean isRotten() {
		return rot;
	}

	// Ungeziefer reduziert das Gewicht des Kürbis, Wirkung wird durch Gift
	// reduziert, verbraucht Gift
	protected void snail() {
		weight *= 1 - (1 - poison) * 0.02;
		poison *= 0.9;
	}

	// Gift wird zugegeben
	// 0 <= poison <= 1 //Invariante
	protected void usePoison(double amount) {
		assert poison >= 0;
		this.poison += amount;
		poison = Math.min(1, Math.max(0, poison));
	}
}
