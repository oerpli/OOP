public class Stripper extends Eraser {

	public Stripper() {
		super(true);
	}

	/*
	 * Result corresponds to the Java program in prog, but with no comments.
	 * This method has no side-effects.
	 */
	@Override
	public String pretty(String prog) {
		Code code = new Code(prog);
		boolean helper=false;
		for (int i = 0; i < code.size(); i++) {
			helper=code.eraseComment(i,helper);
		}
		return code.toString();
	}
}
