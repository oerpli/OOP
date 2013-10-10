public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pumpkin K = new Pumpkin();
		p(K);
		K.Tag(0.4, 0.5);
		K.Tag(0.4, 0.5);
		K.Tag(0.4, 0.5);
		K.Tag(0.4, 0.5);
		K.Tag(0.4, 0.5);
		K.Tag(0, 1);
		K.Tag(0.4, 0.5);

		p(K);
		System.out.println(K.K.meanWater(4));
		p(K);

	}

	public static void p(Object o) {
		System.out.println(o.toString());
	}

}
