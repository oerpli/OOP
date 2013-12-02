package OOP6;

public abstract class Ware {
	public final int number;
	public final String name;
	private static int N = 0;
	protected boolean verdorbenerfroren = false;

	Ware(String t) {
		this.number = N++;
		this.name = t;
	}

	protected abstract void setT(int T);

	// Visitor pattern
	protected abstract int storeIn(Lager l);

	public String toString() {
		return number + ":\t" + name
				+ (verdorbenerfroren ? " (vergammelt)" : "");
	}
}
