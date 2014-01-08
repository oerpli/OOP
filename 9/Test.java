public class Test {
	// debug gibt eine Meldung bei einem joinPoint in der Standardausgabe.
	public static boolean debug = false;
	static int table = 1;

	public static void main(String[] args) {
		initBar();
		Robot.menu();
		Ingredient.listStock();

		/**
		 * Beim ersten Aufruf gibt es noch keine Cola - dementsprechend kann
		 * Beer Coffee und Cuba Libre nicht produziert werden. Bier ist kein
		 * Cocktail in der Getraenkekarte (siehe ganz am Anfang der Ausgabe).
		 */
		System.out.println("\n\n******TEST 1******\n\n ");
		test();
		/**
		 * Beim naechsten Test gibt es zwar eine Zutat "Cola" - jedoch ist deren
		 * Fuellstand zu gering um einen Cocktail daraus zu mixen - serviert
		 * wird dasselbe wie zuvor.
		 */
		new Liquid("Cola", 0);
		System.out.println("\n\n******TEST 2******\n\n ");
		test();
		Ingredient.refill("Cola", 1500);
		/**
		 * Da genug Cola vorhanden koennen Beer Coffee sowie Cuba Libre
		 * zubereitet werden. Da jedoch nicht mehr genug Soda vorhanden ist um
		 * einen Mojito zu kreiieren fehlt dieser bei diesem Test.
		 */
		System.out.println("\n\n******TEST 3******\n\n ");
		test();
		Ingredient.refill("Soda", 500);
		System.out.println("\n\n******TEST 4******\n\n ");
		test2();
	}

	public static void test() {
		Order o = new Order(table++);
		o.add("Cuba Libre").add("Bier").add("Beer Coffee").add("Mojito")
				.add("LukeWarmToddy").add("HotToddy");
		Tray t = o.order();
		o.list();
		t.content();
	}

	public static void test2() {
		Order o = new Order(table++);
		o.add("Cuba Mojito");
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
		new HotToddyRobot();
		new LukeWarmToddyRobot();
		new CubaMojitoRobot();
		new Liquid("Soda", 0);
		new Liquid("Rum", 30);
		new Liquid("Vodka", 4);
		new Liquid("Bier", 4);
		new Liquid("MehrBier", 3);
		new Liquid("NochmehrBier?", 5);
		new Liquid("Gin", 40);
		new Liquid("Cider", 06);
		new Liquid("Water", 0);
		new Liquid("Coffee", 0);
		new Liquid("Zitronensaft", 0);
		for (int i = 1; i < 15; i++) {// >20 zutaten
			new Liquid("Filler" + i, 100 / i);
		}
		Ingredient.refillAll(1000);
	}

}
