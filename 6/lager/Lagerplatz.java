package lager;

/**
 * Verschiedene Temperaturen k�nnte man als Unterklassen Umsetzen. Diese L�sung
 * h�tte aber keinerlei Vorteile gegen�ber dieser Implementierung. (corr.: Wurde
 * inzw so implementiert. Vorteile: nicht vorhanden.)
 * 
 * Eine korrektere Umsetzung des realen Sachverhaltes w�re damit auch nicht
 * gegeben, da ein Lager im Grunde genauso ist wie jedes andere Lager. Dass man
 * keine Waren die tiefgefroren geh�ren in ein Lager mit 20 Grad (Celsius)
 * stellt ist Aufgabe der Lagerverwaltung (implementiert in Lager.java) und ist
 * daher auch dort implementiert.
 * 
 * @author oerpli
 * 
 */
class Lagerplatz {
	private Ware[] waren;
	private final int temp;

	Lagerplatz(int size, int temp) {
		this.temp = temp;
		waren = new Ware[size];
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
		return temp + "�C";
	}
}
