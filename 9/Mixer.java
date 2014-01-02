class Mixer {
	private String name;
	
	public Mixer() {
		name = "Wunschpunsch";
	}
	
	/**
	 * Returns true if there are enough ressources for another cocktail
	 */
	public boolean oneMore() {
		return true;
	}
	
	public String toString() {
		String result = "";
		result += name;
		result += ": Eierlikör, Rum, Zitronensaft";
		return result;
	}
}
