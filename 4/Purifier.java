public class Purifier extends AltPurifier {

	/*
	 * Result corresponds to the Java program in prog, but with prettier
	 * comments. This method has no side-effects.
	 * Comments will be formatted new-school.
	 * Indent is set automatically.
	 */
	@Override
	public String pretty(String prog) {
	
		Code code = new Code(prog);
		
		for (int i = 0; i < code.size(); i++)
		{
			String text = "";
			text = code.getComment(i);
			code.addLine("/* " + text + " */");
		}
		
		return code.toString();
	}

}
