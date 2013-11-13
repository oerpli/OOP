public abstract class AddComment implements Prettifier {
	protected String text;

	public AddComment(String text) {
		this.text = text;
	}

	/*
	 * From now on the new text-to-be-added replaces the old one.
	 */
	public void changeText(String text) {
		this.text = text;
	}
}
