public class Bar {
	private static Bar instance;
	static {
		Spirit.add("Rum", 0.3);
		Spirit.add("Vodka", 0.4);
		Spirit.add("Bier", 0.04);
	}

	private Bar() {
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

	public static Tray bestellen(Bestellung bestellung) {
		// TODO Auto-generated method stub
		return null;
	}

}
