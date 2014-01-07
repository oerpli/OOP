public abstract class Cocktail {
	private final String name;
	private int ml;
	private double vol;

	public Cocktail(String N) {
		assert N != null;// braucht einen Name
		this.name = N;
	}

	public String toString() {
		return name + "(" + ml + "ml, alc. " + vol + "% vol)";
	}

	protected void addLiquid(Liquid i, int qnt) {
		vol = vol * ml + i.vol * qnt;
		ml += qnt;
		vol /= ml;
	}
}
