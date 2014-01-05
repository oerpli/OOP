import java.util.HashMap;

public class Bar {
	private static Bar instance;
	private HashMap<String, Robot> robots = new HashMap<String, Robot>();

	private Bar() {
		new Ice();
		new Liquid("Rum", 0.3);
		new Liquid("Vodka", 0.4);
		new Liquid("Bier", 0.04);
		new Liquid("MehrBier", 0.03);
		new Liquid("NochmehrBier?", 0.05);
		new Liquid("Gin", 0.1);
		new Liquid("Cider", 0.6);
		new Liquid("Water", 0);
		robots.put("Mojito", new MojitoRobot());

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

	public static Tray order(Order bestellung) {
		Tray T = new Tray(bestellung.nr);
		return T;
	}
}
