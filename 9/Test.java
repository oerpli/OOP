public class Test {
	public static boolean debug = false;
	static int table = 1;

	public static void main(String[] args) {
		initBar();
		test();
		new Liquid("Cola", 0);
		test();
		Ingredient.refill("Cola", 1500);
		test();
		Ingredient.refillAll(1500);
		test();
		Robot.menu();
	}

	public static void test() {
		Order o = new Order(table++);
		o.add("Mojito").add("Cuba Libre").add("Bier").add("Beer Coffee");
		Tray t = o.order();
		o.list();
		t.content();
	}

	public static void initBar() {
		IceRobot.get();
		HeatRobot.get();
		new Ice();
		new MojitoRobot();
		new CubaLibreRobot();
		new BeerCoffeeRobot();
		new Liquid("Soda",0);
		new Liquid("Rum", 0.3);
		new Liquid("Vodka", 0.4);
		new Liquid("Bier", 0.04);
		new Liquid("MehrBier", 0.03);
		new Liquid("NochmehrBier?", 0.05);
		new Liquid("Gin", 0.1);
		new Liquid("Cider", 0.6);
		new Liquid("Water", 0);
		new Liquid("Coffee", 0);
		Ingredient.refillAll(1000);
		Ingredient.listStock();
	}



}
