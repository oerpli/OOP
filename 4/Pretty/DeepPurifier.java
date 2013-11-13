package Pretty;

public class DeepPurifier extends AltPurifier {
	private int indent;

	public DeepPurifier(int style) {
		super(style);
		this.indent = 0;
	}

	public DeepPurifier(int style, int indent) {
		super(style);
		if (indent > 0)
			this.indent = indent;
		else
			indent = 0;
	}

	/*
	 * From now on the new indent replaces the old one.
	 */
	public void changeIndent(int indent) {
		if (indent > 0)
			this.indent = indent;
	}

	/**
	 * Negative indents w�ren m�glich - wurden hier aber nicht implementiert, da
	 * man sonst eventuell \t in 4*' ' oder �hnlich umrechnen m�sste in
	 * super.getIndent() und das ist von Konventionen abh�ngig, wieviel ' ' es
	 * genau sind.
	 */
	protected String getIndent(Code code, int i) {
		String ind = super.getIndent(code, i);
		for (int j = 0; j < indent; j++) {
			ind += " ";
		}
		return ind;
	}
}
