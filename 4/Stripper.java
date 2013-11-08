public class Stripper extends Eraser {

	/*
	 * Result corresponds to the Java program in prog, but with no comments.
	 * This method has no side-effects.
	 * // Nachbedingung -> Nachbedingung im Untertyp strenger.
	 */
	@Override
	public String pretty(String prog) {
		
		Code code = new Code(prog);
		
		for (int i = 0; i < code.size(); i++) {
			code.eraseComment(i);
		}
		
		return code.toString();
	}
}
