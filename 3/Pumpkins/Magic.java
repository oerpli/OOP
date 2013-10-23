package Pumpkins;

import java.util.Random;

import Main.Pumpkin;

public class Magic extends Pumpkin {
	/**
	 * Zufällige Mischung aus anderen Sorten. Bessere Implementierung wäre 2
	 * Kürbisse anderer Sorten zu erzeugen und die Werte anschließend mitteln
	 * oder ähnliches. kommt im Grunde aber auf ähnliches raus (wenn auch die
	 * hier verwendete Methode nicth erweiterbar ist).
	 */
	private static Random random = new Random();
	private static double[] mSun = new double[3];
	private static int[] lifetime = new int[3];
	private static double[] mWater = new double[3];
	private static double[] growth = new double[3];

	static {

		mSun[0] = 0.1;
		mSun[0] = 0.1;
		mSun[0] = 0.05;

		lifetime[0] = 120;
		lifetime[1] = 100;
		lifetime[2] = 100;

		mWater[0] = 0.4;
		mWater[0] = 0.5;
		mWater[0] = 0.4;

		growth[0] = 0.02;
		growth[0] = 0.025;
		growth[0] = 0.016;
	}

	public Magic() {
		super(mSun[random.nextInt(3)], mSun[random.nextInt(3)], lifetime[random
				.nextInt(3)], mSun[random.nextInt(3)]);
	}

	@Override
	public Pumpkin returnNew() {
		return new Magic();
	}

}
