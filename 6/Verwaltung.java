public class Verwaltung {
	private Lager L;

	public Verwaltung(int L30, int L18, int L5, int L20) {
		this.L = new Lager(L30, L18, L5, L20);
	}

	public int store(W5 ware) {
		return L.store(ware);
	}

	public Ware remove(int nr) {
		return L.remove(nr);
	}

	public String inventar() {
		return L.inv();
	}

	public String utilization() {
		return L.util();
	}
}
