package OOP6;

public class Verwaltung {
	private Lager L;

	public Verwaltung(int L30, int L18, int L5, int L20) {
		this.L = new Lager(L30, L18, L5, L20);
	}

	/**
	 * Lagert "ware" ein wenn möglich.
	 * 
	 * @param ware
	 * @return gibt 1 bei Erfolg zurück (ware im richtigen Lager), 0 bei
	 *         Semierfolg (ware in einem nicht optimalen Lager) und -1 bei
	 *         Misserfolg (kein Platz für Ware)
	 */
	public int store(Ware ware) {
		return ware.storeIn(L);
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
