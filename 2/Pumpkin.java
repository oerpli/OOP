abstract class Pumpkin
{
	private double weight;
	private int age; // in Tagen gemessen

	public Pumpkin(double weight)
	{
		this.weight = weight;
		age = 0;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	private void absorbLight(double light)
	{
	
	}
	
	private void absorbWater(double water)
	{
	
	}
}
