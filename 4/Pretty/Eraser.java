package Pretty;
import java.util.ArrayList;

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
		
			if (topBot) code.eraseComment(0,false);
			if (!topBot) code.eraseComment(code.size(),false);
		} else {
		
			ArrayList<Integer> positions = code.search(pattern);
			
			for (int i = 0; i < positions.size(); i++) {
				code.eraseComment((positions.get(i) + 1),false);
			}
		}
		
		return code.toString();
	}


}
