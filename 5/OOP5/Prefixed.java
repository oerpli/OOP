package OOP5;
public class Prefixed implements Dependent<Prefixed> {
	private String string;

	public Prefixed(String test) {
		assert string != null;
		this.string = test;
	}

	public boolean dependsOn(Prefixed element) {
		return string.startsWith(element.string);
	}
}
