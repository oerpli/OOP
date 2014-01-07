class CubaMojito extends CocktailCold {
	public static final String name = "Cuba Mojito";

	protected CubaMojito() {
		super(name);
	}

	/**
	 * Sollte eigentlich static sein - da static Klassen in java aber nicht
	 * abstract sein können ist es stattdessen eine Funktion einer Instanz.
	 * 
	 */
	protected int getIceAmount() {
		return 20;
	}
}
