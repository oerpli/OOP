public class Bar {
	private static Bar instance;

	private Bar() {
		new Ice();
		new MojitoRobot();
		new CubaLibreRobot();
		new ColdRobot();
		new Liquid("Rum", 0.3);
		new Liquid("Vodka", 0.4);
		new Liquid("Bier", 0.04);
		new Liquid("MehrBier", 0.03);
		new Liquid("NochmehrBier?", 0.05);
		new Liquid("Gin", 0.1);
		new Liquid("Cider", 0.6);
		new Liquid("Water", 0);
		new Liquid("Soda", 0);
		new Liquid("Zitronensaft", 0);
		Ingredient.refillAll(10000);
		Ingredient.listStock();
	}

	/**
	 * Singleton
	 * 
	 * @return
	 */
	public static Bar getInstance() {
		if (instance == null) {
			instance = new Bar();
		}
		return instance;
	}

	public Tray order(Order order) {
		Tray t = new Tray(order.nr);
		Robot.processOrder(t, order);
		return t;
	}
}
