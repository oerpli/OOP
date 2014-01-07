public class HeatRobot {
	/*singleton*/
	private static HeatRobot instance = null;

	private HeatRobot() {
	};

	protected static HeatRobot get() {
		if (instance == null) {
			instance = new HeatRobot();
		}
		return instance;
	}

	public void heatUp(CocktailHot cocktail, int temp) {
		// Grenzen waeren logisch sinnvoll - sind aber irgendwie arbitraer.
		// deshalb auskommentiert.
		// assert temp >= 0 && temp < 100;
		cocktail.temperature = temp;
	}
}
