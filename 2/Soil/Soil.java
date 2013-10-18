package Soil;

public abstract class Soil
{
	private double fertiLevel; // aktuelles Düngerlevel des Bodens
	private double waterLevel; // aktuelles Wasserlevel des Bodens
	
	public void absorbWater(double water)
	{
		int w = waterLevel + water;
		
		waterLevel = Math.min(100, w); // Das maximale Wasserlevel ist 100
	}
	
	public void absorbFertilizer(double fertilizer)
	{
		int f = fertiLevel + fertilizer;
		
		fertiLevel = Math.min(100, w); // Das maximale Düngerlevel ist 100
	}
}
