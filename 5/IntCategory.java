public class IntCategory extends Category {
	private int a;
	private int b;

	public IntCategory(int a, int b) {
		this.a = a;
		this.b = b;
	}

	protected boolean uncheckedDependsOn(Category that) {
		IntCategory y = (IntCategory) that;
		return false;
	}

	@Override
	public boolean dependsOn(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		return "" + "a= " + a + "\n" + "b= " + b;
	}
}
