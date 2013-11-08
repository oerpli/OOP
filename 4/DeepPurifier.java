public class DeepPurifier implements Prettifier {

	private int style; // Invariante 0-2
	private int indent;

	public DeepPurifier() {
	
		if (style > 2 || style < 0) style = 0; // Auswahl der Formatierung.
		
		this.style = style;
		this.indent = 0;
	}
	
	/*
	 * From now on the new indent replaces the old one.
	 */
	public void changeIndent(int indent)
	{
		this.indent = indent;
	}

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects.
	 * Comments will be formatted old-school or new-school.
	 * Indent is set manually or automatically.
	 * // Nachbedingung -> Nachbedingung im Untertyp strenger.
	 */
	@Override
	public String pretty(String prog) {
		// TODO Auto-generated method stub
		return null;
	}
}
