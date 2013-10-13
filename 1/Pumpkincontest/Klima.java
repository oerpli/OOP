package Pumpkincontest;

import java.util.HashSet;
import java.util.Random;

class Klima {
	private double[] Water = new double[100];
	private double CurrLight = 0;
	private int sunDay = 0, rainDay = 0;
	private HashSet<Integer> sunny = new HashSet<Integer>();
	private Random r = new Random();
	private int last = -1;

	protected Klima() {
		Random r = new Random();
		while (sunny.size() < 20)
			sunny.add(r.nextInt(99));
	}

	protected double meanWater(int N) {
		double x = 0;
		for (int i = Garten.day() - N + 1; i <= Garten.day(); i++)
			if (i >= 0)
				x += this.Water(i);
		return x / (double) N;
	}

	protected void setKlima(double light, double water) throws Exception {
		if (last == Garten.day()) {
			return;
		}
		if (light + water > 1 || light < 0 || water < 0) {
			this.setKlima(0, 0);
			throw new Exception("Someone tried cheating");
		}
		if (sunny.remove(Garten.day())) {
			light = rainDay > 9 || r.nextFloat() < (10F - sunDay) / 20F ? 1 : 0;
			water = 1 - light;
		}

		if (light == 1)
			sunDay += 1;
		else if (water == 1)
			rainDay += 1;

		CurrLight = light;
		Water[Garten.day()] = water;
		last = Garten.day();
	}

	protected double Light() {
		if (last != Garten.day())
			return 0;
		else
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
