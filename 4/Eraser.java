public class Eraser implements Prettifier {

	private final String pattern;
	private boolean topBot;

	public Eraser(String pattern) {
	
		if (pattern == null) pattern = "";
		this.pattern = pattern;
	}
	
	public Eraser(boolean topBot) {
	
		this.topBot = topBot;
		pattern = null;
	}
	
	/*
	 * Result corresponds to the Java program in prog, but with less comments.
	 * This method has no side-effects.
	 */
	@Override
	public String pretty(String prog) {
		
		Code code = new Code(prog);
		
		if (pattern == null) {
		
			if (topBot) code.eraseComment(0);
			if (!topBot) code.eraseComment(code.size());
		} else {
		
			int[] positions = code.search(pattern);
			
			for (int i = 0; i < positions.length; i++) {
				code.eraseComment(positions[i]+1); // Nach der gefunden Zeile wird gelöscht
			}
		}
		
		return code.toString();
	}


}
