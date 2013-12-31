public class Bar {
	private HashMap<String, Mixer> mixers;
	
	public Bar() {
		// Mixer initialisieren und hinzufügen
		mixers = new HashMap<String, Mixer>();
		mixers.put(m1.getName(), m1);
	}
	
	public ArrayList<???> order(ArrayList<String>) {
		
	}

	@Override
	public String toString() {
		String result = "";
		for (String s: mixers.keySet()) {
			Mixer m = mixers.get(s);
			if (m.oneMore())
				result += m.toString() + System.getProperty("line.separator");
		}
	}
}
