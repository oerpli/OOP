class HeatRobot {
	/* singleton */
	private static HeatRobot instance = null;

	private HeatRobot() {
	};

	protected static HeatRobot get() {
		if (instance == null) {
			instance = new HeatRobot();
		}
		return instance;
	}

	protected void heatUp(CocktailHot cocktail, int temp) {
		cocktail.temperature = temp;
	}
}
