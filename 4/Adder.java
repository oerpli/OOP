public class Adder implements Prettifier {
	private String comment;
	private final int line;

	public Adder(String c, int i) {
		assert c != null;
		assert i >= 0;
		this.comment = c;
		this.line = i;
	}

	public boolean changeComment(final String c) {
		this.comment = c;
		return true;
	}

	@Override
	public String pretty(String prog) {
		String out = prog;
		if (line == 0) {
			// Benötigt noch Funktion zum generieren mehrzeiliger Kommentare
			out = "/* \n" + comment + "\n */ \n" + out;
		}
		return out;
	}
	/*
	 * Result corresponds to the Java program in prog, but with more, less or
	 * prettier comments. This method has no side-effects.
	 */
}
