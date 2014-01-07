public class Test {

	public static void main(String[] args) {
		initBar();
		test();
	}

	public static void test() {
		Order o = new Order(1);
		o.add("Mojito").add("Cuba Libre").add("Bier");
		Tray t = o.order();
		o.list();
		t.content();
	}

	public static void initBar() {
		new Ice();
		new MojitoRobot();
		new CubaLibreRobot();
		new IceRobot();
		new Liquid("Rum", 0.3);
		new Liquid("Vodka", 0.4);
		new Liquid("Bier", 0.04);
		new Liquid("MehrBier", 0.03);
		new Liquid("NochmehrBier?", 0.05);
		new Liquid("Gin", 0.1);
		new Liquid("Cider", 0.6);
		new Liquid("Water", 0);
		new Liquid("Soda", 0);
		Ingredient.refillAll(10000);
		Ingredient.listStock();
	}
}
