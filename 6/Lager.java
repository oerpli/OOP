class Lager {
	Lagerplatz[] lp = new Lagerplatz[4];

	Lager(int L_30, int L_18, int L5, int L20) {
		this.lp[0] = new Lagerplatz(L_30, "-30�C", -30);
		this.lp[1] = new Lagerplatz(L_18, "-18�C", -18);
		this.lp[2] = new Lagerplatz(L5, "5�C", 5);
		this.lp[3] = new Lagerplatz(L20, "20�C", 20);
	}

	private int store(Ware w, int L) {
		if (lp[L].store(w)) {
			return 1;
		} else if (L % 2 == 1 && lp[L - 1].store(w)) {
			return 0;
		} else
			return -1;
	}

	protected int store(W5 w) {
		return store(w, 2);
	}

	protected int store(W20 w) {
		return store(w, 3);
	}

	protected int store(W18 w) {
		return store(w, 1);
	}

	protected int store(W30 w) {
		return store(w, 0);
	}

	protected Ware remove(int nr) {
		for (Lagerplatz LP : lp) {
			Ware w = LP.remove(nr);
			if (w != null)
				return w;
		}
		return null;
	}

	protected String util() {
		String out = null;
		int[][] res = new int[2][2];
		for (int i = 0; i < lp.length; i++) {
			res[0] = lp[i].util();
			out += "Pl�tze (" + lp[i].getType() + "): \t" + res[0][0] + '/'
					+ res[0][1];
			res[1][0] += res[0][0];
			res[1][1] += res[0][1];
		}
		out += "Gesamt: \t" + res[1][0] + '/' + res[1][1];
		return out;
	}

	protected String inv() {
		String out = "";
		for (int i = 0; i < lp.length; i++) {
			out += "Im " + lp[i].getType() + "-Lager:\n";
			out += lp[i].inv();
		}
		return out;
	}
}
