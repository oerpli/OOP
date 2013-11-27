package OOP5;
public class IntCategory extends Category {
	private int a;
	private int b;

	public IntCategory(int a, int b) {
		this.a = a;
		this.b = b;
	}

	protected boolean uncheckedDependsOn(Category that) {
		IntCategory y = (IntCategory) that;
		if ((this.getA() == y.getA())&&(this.getB() >= y.getB())){
			return true;
		}
		return false;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public String toString() {
		return "" + "a= " + a + "\n" + "b= " + b;
	}
}
