public class Purifier extends AltPurifier {

	public Purifier() {
		super(0);
	}

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects. Comments will be formatted
	 * new-school. Indent is set automatically.
	 */
	@Override
	public String pretty(String prog) {
		Code code = new Code(prog);
		for (int i = 0; i < code.size(); i++) {
			String text = code.getComment(i);
			if (!text.equals("")) {
				code.eraseComment(i);
				code.addLine(i, "/* " + text + " */");
			}
		}
		return code.toString();
	}

}
