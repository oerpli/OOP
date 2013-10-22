package Main;

import java.util.HashMap;
import java.util.Random;

import Exceptions.PlantingException;
import Pumpkins.*;

public abstract class Pumpkin implements Comparable<Pumpkin> {
	// @Deprecated
	// private static ArrayList<Pumpkin> pumpkins = new ArrayList<Pumpkin>();
	private static HashMap<String, Pumpkin> types = new HashMap<String, Pumpkin>();
	static {
		types.put("patisson", new Patisson());
		types.put("hokkaido", new Hokkaido());
		types.put("aladdin", new Aladdin());
	}
	private double weight;
	private final int planted;
	private double minSun; // Sonne die zum Wachsen benötigt wird
	private double minWater;
	private int lifetime; // Wachstumszeit
	private double growSpeed;
	private boolean rot; // verfault ja/nein
	
	

	protected Pumpkin(double d, double minWater, int lifetime, double growSpeed) {
		// pumpkins.add(this);
		this.planted = Time.getTime();
		this.weight = 1.0;
		this.growSpeed = growSpeed;
		this.minSun = d;
		this.minWater = minWater;
		this.lifetime = lifetime * 24;
		this.rot = false;
	}

	public static Pumpkin create(String Type) throws PlantingException {
		try {
			if(Type.equals("Magic")) {return MagicCreation();}
			return types.get(Type.toLowerCase()).returnNew();
		} catch (NullPointerException e) {
			throw new PlantingException(Type);
		}
	}
	private static Pumpkin MagicCreation()
	{
		Random random=new Random();
		double [][] values=new double[5][5];
		values[0][1]=0.1;
		values[0][2]=0.4;
		values[0][3]=120;
		values[0][4]=0.02;
		
		values[1][1]=0.1;
		values[1][2]=0.5;
		values[1][3]=100;
		values[1][4]=0.025;
		
		values[2][1]=0.05;
		values[2][2]=0.4;
		values[2][3]=100;
		values[2][4]=0.016;
		
		return new Magic(values[random.nextInt(2)][1], values[random.nextInt(2)][2], (int)values[random.nextInt(2)][3], values[random.nextInt(2)][4]);
	}
	public abstract Pumpkin returnNew();

	public int getAge() {
		return Time.getTime() - this.planted;
	}

	public double getWeight() {
		return weight;
	}

	public void grow(double water, double ferti, double weedFactor) {
		double growth = growSpeed * (1 + 0.5 * ferti);
		growth *= Math.max(0, Weather.getLight() - minSun);
		growth *= Math.max(0, water - minWater);
		growth *= 1 - weedFactor * 0.5;
		if (Weather.isTempest())
			weight *= 0.99;
		weight *= 1 + growth;
	}

	@Override
	public int compareTo(Pumpkin X) {
		if (this.weight > X.weight)
			return 1;
		else if (this.weight == X.weight)
			return 0;
		else
			return -1;
	}

	public void rot(double ferti) {
		if ((getAge() > 0.8 * lifetime) && ferti > 0.5) {
			this.rot = true;
		}
	}

	public boolean isRotten() {
		return rot;
	}
}
