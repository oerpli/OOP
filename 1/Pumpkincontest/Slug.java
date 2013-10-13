package Pumpkincontest;

abstract class Slug {

	public static double eat(Pumpkin P) {
		Klima K = P.K();
		if (K.meanWater(1) >= 0.5 || K.meanWater(2) >= 0.3
				|| K.meanWater(4) >= 0.1)
			return 0.99;
		else
			return 1;
	}
}
