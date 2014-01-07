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
		test();
		/**
		 * Beim naechsten Test gibt es zwar eine Zutat "Cola" - jedoch ist deren
		 * Fuellstand zu gering um einen Cocktail daraus zu mixen - serviert
		 * wird dasselbe wie zuvor.
		 */
		new Liquid("Cola", 0);
		test();
		Ingredient.refill("Cola", 1500);
		/**
		 * Da genug Cola vorhanden koennen Beer Coffee sowie Cuba Libre
		 * zubereitet werden. Da jedoch nicht mehr genug Soda vorhanden ist um
		 * einen Mojito zu kreiieren fehlt dieser bei diesem Test.
		 */
		test();
	}

	public static void test() {
		Order o = new Order(table++);
		o.add("Cuba Libre").add("Bier").add("Beer Coffee").add("Mojito");
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
		new Liquid("Soda", 0);
		new Liquid("Rum", 0.3);
		new Liquid("Vodka", 0.4);
		new Liquid("Bier", 0.04);
		new Liquid("MehrBier", 0.03);
		new Liquid("NochmehrBier?", 0.05);
		new Liquid("Gin", 0.1);
		new Liquid("Cider", 0.6);
		new Liquid("Water", 0);
		new Liquid("Coffee", 0);
		new Liquid("Zitronensaft", 0);
		Ingredient.refillAll(1000);
	}

}
