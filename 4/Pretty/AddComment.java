package Pretty;
import java.util.ArrayList;

public abstract class AddComment implements Prettifier {
	protected String text;
	private boolean top;
	private String pattern;

	public AddComment(String text) {
		this.text = text;
		top = true;
		pattern = null;
	}

	public AddComment(String text, boolean top) {
		this.text = text;
		this.top = top;
		pattern = null;
	}

	public AddComment(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		top = false;
	}

	/*
	 * Result corresponds to the Java program in prog, but with more comments.
	 * This method has no side-effects.
	 * Comments will be placed on top, bottom or within the code.
	 */
	public String pretty(String prog) {
		if (text == null || text.equals(""))
			return prog;
		Code code = new Code(prog);
		Comment comment = new Comment(text, true);
		if (pattern == null) {
			if (top)
				code.addLine(0, comment.toString());
			if (!top)
				code.addLine(code.size(), comment.toString());
		} else {
			ArrayList<Integer> positions = code.search(pattern);
			for (int i = 0; i < positions.size(); i++) {
				code.addLine(positions.get(i), comment.toString()); // Nach der
				// gefunden
				// Zeile wird
				// eingefuegt
			}
		}
		return code.toString();
	}
}
