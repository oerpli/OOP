package Pretty;

/**
 * Eigentlich problematisch da AltPurifier immer einen fixen Einzug hat und
 * deshalb ein DeepPurifier Objekt mit Einzug X kommen könnte und das würde
 * Probleme bei Prüfung geben.
 * 
 * Aus Zeitgründen nicht mehr repariert (in eine Überklasse abstrahiert etc...)
 * 
 * @author oerpli
 * 
 */
public class DeepPurifier extends AltPurifier {
	private int indent;

	public DeepPurifier(int style) {
		super(style);
		this.indent = 0;
	}

	public DeepPurifier(int style, int indent) {
		super(style);
		if (indent >= 0)
			this.indent = indent;
	}

	/*
	 * From now on the new indent replaces the old one.
	 */
	public void changeIndent(int indent) {
		if (indent >= 0)
			this.indent = indent;
	}

	protected String getIndent(Code code, int i) {
		String ind = "";
		for (int j = 0; j < indent; j++) {
			ind += ' ';
		}
		String sind = super.getIndent(code, i);
		return ind + "" + sind;
	}
}
