public class Bar {
	private HashMap<String, Mixer> mixers;
	
	public Bar() {
		// Mixer initialisieren und hinzufügen
		mixers = new HashMap<String, Mixer>();
		MojitoMixer m1 = new MojitoMixer();
		mixers.put(m1.getName(), m1);
	}
	
	/**
	 * Returns a tray containing the ordered cocktails if they are available
	 */
	public Tray getCocktails(Order order) {
		
	}

	@Override
	public String toString() { // gibt die Getränkekarte zurück
		String result = "";
		for (String s: mixers.keySet()) {
			Mixer m = mixers.get(s);
			if (m.oneMore())
				result += m.toString() + System.getProperty("line.separator");
		}
	}
}
