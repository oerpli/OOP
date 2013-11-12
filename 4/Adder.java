import java.util.ArrayList;

public class Adder implements Prettifier {

	protected String text;
	private final String pattern;
	private boolean topBot;

	public Adder(String text, String pattern) {
		if (pattern == null)
			pattern = "";
		this.pattern = pattern;
		this.text = text;
	}

	public Adder(String text, boolean topBot) {
		this.text = text;
		this.topBot = topBot;
		pattern = null;
	}

	/*
	 * From now on the new text-to-be-added replaces the old one.
	 */
	public void changeText(String text) {
		this.text = text;
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
