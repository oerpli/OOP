package Pretty;

public class AltPurifier implements Prettifier {
	private int style; // Invariante 0-2

	public AltPurifier(int style) {
		this.style = Math.max(0, Math.min(0, style));
	}

	protected String getIndent(Code code, int i) {
		String ind = "";
		if (i == 0)
			return ind;
		char[] line = code.getLine(i - 1).toCharArray();
		for (i = 0; i < line.length; i++) {
			if (line[i] == ' ')
				ind += ' ';
			else if (line[i] == '\t')
				ind += '\t';
			else
				break;
		}
		return ind;
	}

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects. Comments will be formatted
	 * old-school or new-school. Indent is set automatically (can be overwritten
	 * via getIndent(int)).
	 */
	@Override
	public String pretty(String prog) {
		if (style == 0) {
			Code code = new Code(prog);
			for (int i = 0; i < code.size(); i++) {
				String text = code.getComment(i);
				if (!text.equals("")) {
					code.eraseComment(i, false);
					code.addLine(i, getIndent(code, i) + "/* " + text + " */");
				}
			}
			return code.toString();
		} else {
			Code code = new Code(prog);
			for (int i = 0; i < code.size(); i++) {
				String text = code.getComment(i);
				if (!text.equals("")) {
					code.eraseComment(i, false);
					code.addLine(i, "// " + text);
				}
			}
			return code.toString();
		}
	}
}
