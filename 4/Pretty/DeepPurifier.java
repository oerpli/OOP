package Pretty;

public class DeepPurifier extends AltPurifier {
	private int style; // Invariante 0-2
	private int indent;

	public DeepPurifier(int style) {
		super(style);
		this.indent = 0;
	}

	/*
	 * From now on the new indent replaces the old one.
	 */
	public void changeIndent(int indent) {
		this.indent = indent;
	}

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects. Comments will be formatted
	 * old-school or new-school. Indent is set manually or automatically.
	 */
	@Override
	public String pretty(String prog) {
		Code code = new Code(prog);
		for (int i = 0; i < code.size(); i++) {
			String text = "";
			text = code.getComment(i);
			code.addLine("/* " + text + " */");
		}
		return code.toString();
	}
}
