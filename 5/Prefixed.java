public class Prefixed implements Dependent<T> {
	private String string1;

	public Prefixed(String test) {
		this.string1 = test;
	}

	public boolean dependsOn(Prefixed element) {
		return string1.startsWith(element.string1);
	}

	@Override
	public boolean dependsOn(T element) {
		// TODO Auto-generated method stub
		return false;
	}

}
