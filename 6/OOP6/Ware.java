package OOP6;

public abstract class Ware {
	public final int number;
	public final String name;
	private static int N = 0;
	protected boolean verdorbenerfroren = false;

	/**
	 * Erzeugt neues Ware Objekt. t sollte nicht null sein (obwohl es zu keinen
	 * Fehlern fuhren sollte).
	 * 
	 * @param t
	 *            Name
	 */
	Ware(String t) {
		assert t != null;
		this.number = N++;
		this.name = t;
	}

	/**
	 * Temperatur T wird Objekt nach einlagern zugewiesen. Wenn Temperatur im
	 * Laufe des Produktlebens einmal nicht zu Objekt passt, wird bei der
	 * toString Methode automatisch ein "vergammelt" ergÃ¤nzt. -- fur
	 * Debugzwecke. Im Optimalfall macht es sich niemals bemerkbar.
	 * 
	 * @param T
	 *            Temperatur
	 */
	protected abstract void setT(int T);

	/**
	 * Visitor pattern. Lager wird übergeben und anschliessend in allen
	 * Untertypen mit der richtigen Funktion aufgerufen.
	 * 
	 * @param l
	 *            Lager in das eingelagert werden soll.
	 * @return 1 bei Erfolg, 0 bei suboptimalem Lagerplatz, -1 bei keinem Platz
	 */
	protected abstract int storeIn(Lager l);

	public String toString() {
		return number + ":\t" + name
				+ (verdorbenerfroren ? " (vergammelt)" : "");
	}
}
