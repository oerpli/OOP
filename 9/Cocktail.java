public abstract class Cocktail {
	private final String name;
	private final int ml;

	public Cocktail(String N, int ML) {
		assert N != null;// braucht einen Name
		assert ML > 0;// ein leeres Glas freut den Kunden wohl kaum.
		this.ml = ML;
		this.name = N;

	}

	public String toString() {
		return name + "(" + ml + "ml)";
	}
}
