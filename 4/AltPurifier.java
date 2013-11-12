public class AltPurifier implements Prettifier {
	private int style; // Invariante 0-2

	public AltPurifier(int style) {
		if (style > 2 || style < 0)
			style = 0; // Auswahl der Formatierung.
		this.style = style;
	}

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects. Comments will be formatted
	 * old-school or new-school. Indent is set automatically.
	 */
	@Override
	public String pretty(String prog) {
		Code code = new Code(prog);
		return code.toString();
	}
}
