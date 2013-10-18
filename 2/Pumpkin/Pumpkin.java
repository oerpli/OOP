package Pumpkin;
import Soil.*;

public abstract class Pumpkin
{
	private double weight;
	private int age;
	private Soil soil; // Das zum Kürbis gehörende Boden-Objekt

	public Pumpkin(Soil soil)
	{
		this.age = 0;
		this.weight = 1.0;
		this.soil = soil;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void increaseAge()
	{
		age++;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public Soil getSoil()
	{
		return soil;
	}
	
	/**
	 * Verfügbare Menge Licht wird aufgenommen.
	 * Der User stellt das Licht bereit.
	 */
	private void absorbLight(double light)
	{
	
	}
	
	/**
	 * Verfügbare Menge Wasser wird aufgenommen.
	 * Der Boden stellt das Wasser bereit.
	 */
	private void absorbWater(double water)
	{
	
	}
}
