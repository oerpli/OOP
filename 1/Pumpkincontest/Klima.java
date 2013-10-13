package Pumpkincontest;

class Klima {
	private double[] Water = new double[100];
	
	private double CurrLight;
	
	private int lightDay=0;
	private int waterDay=0;

	protected double Light()
	{
		return CurrLight;
	}
	protected double Water(int Day) {
		return Water[Day];
	}

	protected int getLightDay()
	{
		return lightDay;
	}
	
	protected int getWaterDay()
	{
		return waterDay;
	}
	
	protected double meanWater(int N) {
		double x = 0;
		for (int i = Time.day() - N; i < Time.day(); i++) {
			if (i > 0)
				x += this.Water(i);
		}
		return x / N;
	}

	protected boolean setKlima(double light, double water) throws PumpkinException {
		System.out.println(light+" "+water);
		if(light==1) lightDay+=1;
		
		if(water==1) waterDay+=1;
		
		if (light + water > 1)
			throw new PumpkinException("Someone tried cheating");
		if (light + water > 1 || light < 0 || water < 0)
			return false;
		CurrLight=light;
		Water[Time.day()] = water;
	
		return true;
	}
}
