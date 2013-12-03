package lager;

public class Lager {
	private Lagerplatz[] lp = new Lagerplatz[4];

	/**
	 * Erzeugt neues Lager Objekt. Parameter ( alle >= 0) geben Anzahl der
	 * jeweiligen Lagerplaetze an.
	 * 
	 * @param L_30
	 * @param L_18
	 * @param L5
	 * @param L20
	 */
	public Lager(int L_30, int L_18, int L5, int L20) {
		assert L_30 >= 0;
		assert L_18 >= 0;
		assert L5 >= 0;
		assert L20 >= 0;
		this.lp[0] = new Lagerplatz(L_30, -30);
		this.lp[1] = new Lagerplatz(L_18, -18);
		this.lp[2] = new Lagerplatz(L5, 5);
		this.lp[3] = new Lagerplatz(L20, 20);
	}

	/**
	 * Lagert ware ein wenn moeglich. Ruft die storeIn Funktion der ware auf -
	 * die Ware sagt dann, in welches Lager sie bevorzugt will (über aufrufen
	 * der entsprechenden storeXX(Ware) Funktion.
	 * 
	 * @param ware
	 *            Einzulagerndes ware- objekt. Darf nicht null sein.
	 * @return gibt 1 bei Erfolg zurück (ware im richtigen Lager), 0 bei
	 *         Semierfolg (ware in einem nicht optimalen Lager) und -1 bei
	 *         Misserfolg (kein Platz für Ware)
	 */
	public int store(Ware ware) {
		assert ware != null;
		return ware.storeIn(this);
	}

	/**
	 * Entfernt Ware mit Nummer nr aus Lager und gibt Referenz zurueck. null
	 * wenn nr nicht vorhanden.
	 * 
	 * @param nr
	 * @return ware oder null
	 */
	public Ware remove(int nr) {
		assert nr > 0; // sollte >0 sein - sonst sicher nicht vorhanden.
		for (Lagerplatz LP : lp) {
			Ware w = LP.remove(nr);
			if (w != null)
				return w;
		}
		return null;
	}

	/**
	 * Listet Lagerinhalt auf.
	 * 
	 * @return Formatierter String
	 */
	public void inventar() {
		String out = "";
		for (int i = 0; i < lp.length; i++) {
			out += "Im " + lp[i].getType() + "-Lager:\n";
			out += lp[i].inv();
		}
		// Man koennte auch jede Zeile einzeln ausgeben anstatt den String
		// aufzubauen und auf einmal ausgeben. (ebenso bei utilization();)
		System.out.println(out);
	}

	/**
	 * Listet Lagerbelegung auf
	 * 
	 * @return Formatierter String
	 */
	public void utilization() {
		String out = "";
		int[][] res = new int[2][2];
		for (int i = 0; i < lp.length; i++) {
			res[0] = lp[i].util();
			out += "Belegt (" + lp[i].getType() + "):\t" + res[0][0] + '/'
					+ res[0][1] + '\n';
			res[1][0] += res[0][0];
			res[1][1] += res[0][1];
		}
		out += "Belegt (sum): \t" + res[1][0] + '/' + res[1][1];
		System.out.println(out);
	}

	/**
	 * Konkrete Implementierung für storeXX(Ware) Funktionen. int L gibt zwar
	 * den Typ an - dieser wird aber nicht überprüft weshalb das legitim ist
	 * (behaupte ich einfach mal). Könnte man auch einfach vermeiden indem man
	 * den Inhalt dieser Funktion in die storeXX(Ware) Funktionen verschiebt und
	 * jeweils den Parameter L fest wählt.
	 * 
	 * WICHTIGE ANMERKUNG: Dass Ware die bei -18 Grad gelagert werden soll auch
	 * bei -30 Grad gelagert (analog 20 und 5 Grad) werden darf wird in diesem
	 * Fall von der Lager Funktion implementiert - dies lässt sich damit
	 * begründen, dass das eine Richtlinie des Lagers und keine Eigenschaft der
	 * Ware ist.
	 * 
	 * @param w
	 * @param L
	 *            preferierte Lagernummer (0 -> 30°C, 1 -> 18°C,...) Waren mit
	 *            ungeraden Lagernummern (3,1) werden wenn der entsprechende
	 *            Platz nicht frei ist in das nächstniedrigere Lager verschoben
	 *            (2,0)
	 * @return Ware im richtigen Lager -> 1, Ware in suboptimalem Lager -> 0,
	 *         Ware nicht eingelagert -> -1
	 */
	private int store(Ware w, int L) {
		assert L < 4 && L >= 4;
		if (lp[L].store(w)) {
			return 1;
		} else if (L % 2 == 1 && lp[L - 1].store(w)) {
			return 0;
		} else
			return -1;
	}

	/**
	 * Für Visitor Pattern. Richtige Funktion wird von entsprechender Ware
	 * aufgerufen. Ruft allgemeine store(Ware,int) Funktion auf - dies sollte
	 * nicht in der Klasse Ware geschehen weil der Parameter int ein
	 * Implementierungsdetail dieser Klasse ist.
	 * 
	 * @param ware
	 * @return
	 */
	protected int store30(Ware ware) {
		return store(ware, 0);
	}

	protected int store18(Ware ware) {
		return store(ware, 1);
	}

	protected int store5(Ware ware) {
		return store(ware, 2);
	}

	protected int store20(Ware ware) {
		return store(ware, 3);
	}
}
