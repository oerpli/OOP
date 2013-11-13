public class Adder extends AddComment {
	public Adder(String text, String pattern) {
		super(text,pattern);
	}

	public Adder(String text, boolean top) {
		super(text, top);
	}

	/*
	 * From now on the new text-to-be-added replaces the old one.
	 */
	public void changeText(String text) {
		this.text = text;
	}
}
