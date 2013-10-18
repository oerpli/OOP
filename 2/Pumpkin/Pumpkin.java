package Pumpkin;
import Soil.*;
private abstract class Pumpkin
{
	private double weight;
	private int age; // Das Alter in Tagen.
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
	
	public double getWeight()
	{
		return weight;
	}
	
	public Soil getSoil()
	{
		return soil;
	}
	
	private void absorbLight(double light)
	{
	
	}
	
	private void absorbWater(double water)
	{
	
	}
}
