package Pumpkincontest;

import java.util.HashSet;
import java.util.Random;

class Klima {
	private double[] Water = new double[100];
	private double CurrLight;
	private int sunDay = 0, rainDay = 0;
	private HashSet<Integer> sunny = new HashSet<Integer>();
	private Random r = new Random();
	private int last = 0;

	protected Klima() {
		Random r = new Random();
		while (sunny.size() < 20)
			sunny.add(r.nextInt(99));
	}

	protected double meanWater(int N) {
		double x = 0;
		for (int i = Time.day() - N; i < Time.day(); i++) {
			if (i > 0)
				x += this.Water(i);
		}
		return x / N;
	}

	protected void setKlima(double light, double water) throws PumpkinException {
		if (light + water > 1 || light < 0 || water < 0) {
			this.setKlima(0, 0);
			throw new PumpkinException("Someone tried cheating");
		}
		if (sunny.remove(Time.day())) {
			light = rainDay > 9 || r.nextFloat() < (10F - sunDay) / 20F ? 1 : 0;
			water = 1 - light;
		}
		if (light == 1)
			sunDay += 1;
		else if (water == 1)
			rainDay += 1;

		CurrLight = light;
		Water[Time.day()] = water;
		last = Time.day();
	}

	protected double Light() {
		return CurrLight;
	}

	protected double Water(int Day) {
		return Water[Day];
	}

	protected int getLightDay() {
		return sunDay;
	}

	protected int getWaterDay() {
		return rainDay;
	}
}
