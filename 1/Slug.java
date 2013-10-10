public abstract class Slug {

	/**
	 * @param args
	 * @author oerpli
	 */
	public static double eat(Pumpkin P) {
		Klima K = P.K;
		if (K.meanWater(1) >= 0.5 || K.meanWater(2) >= 0.3
				|| K.meanWater(4) >= 0.1)
			return 0.99;
		else
			return 1;

		// int W = 0;
		// W += K.meanWater(1) >= 0.5 ? 1 : 0;
		// W += K.meanWater(2) >= 0.3 ? 1 : 0;
		// W += K.meanWater(4) >= 0.1 ? 1 : 0;
		//
		// return Math.pow(0.99, W);
	}
}
