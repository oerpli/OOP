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
	 * From now on the new text-to-be-added replaces the old one.
	 */
	public void changeText(String text) {
		this.text = text;
	}
}
