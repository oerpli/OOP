import java.util.ArrayList;

public class Adder extends AddComment {

	private final String pattern;
	private boolean topBot;

	public Adder(String text, String pattern) {
		super(text);
		this.pattern = pattern;
	}

	public Adder(String text, boolean topBot) {
		super(text);
		this.topBot = topBot;
		pattern = null;
	}

	/*
	 * Result corresponds to the Java program in prog, but with more comments.
	 * This method has no side-effects.
	 */
	@Override
	public String pretty(String prog) {
		if (text == null || text.equals(""))
			return prog;
		Code code = new Code(prog);
		Comment comment = new Comment(text, true);
		if (pattern == null) {
			if (topBot)
				code.addLine(0, comment.toString());
			if (!topBot)
				code.addLine(code.size(), comment.toString());
		} else {
			ArrayList<Integer> positions = code.search(pattern);
			for (int i = 0; i < positions.size(); i++) {
				code.addLine(positions.get(i), comment.toString()); // Nach der
				// gefunden
				// Zeile wird
				// eingefügt
			}
		}
		return code.toString();
	}
}
