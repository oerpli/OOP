package OOP6;

class Lagerplatz {
	private Ware[] waren;
	private final String type;
	private final int temp;

	Lagerplatz(int size, String type, int temp) {
		this.temp = temp;
		waren = new Ware[size];
		this.type = type;
	}

	protected boolean store(Ware w) {
		assert w != null;
		for (int i = 0; i < waren.length; i++) {
			if (waren[i] == null) {
				waren[i] = w;
				waren[i].setT(temp);
				return true;
			}
		}
		return false;
	}

	protected Ware remove(int nr) {
		assert nr >= 0;
		for (int i = 0; i < waren.length; i++) {
			if (waren[i] != null && waren[i].number == nr) {
				Ware x = waren[i];
				waren[i] = null;
				return x;
			}
		}
		return null;
	}

	protected int[] util() {
		int[] x = { 0, waren.length };
		for (Ware w : waren) {
			if (w != null) {
				x[0] += 1;
			}
		}
		assert x[0] <= x[1]; // maximal N von N Pl�tzen belegt.
		return x;
	}

	protected String inv() {
		String out = "";
		for (Ware w : waren) {
			if (w != null)
				out += w.number + " \t" + w.name + '\n';
		}
		return out;
	}

	protected String getType() {
		return type;
	}
}
