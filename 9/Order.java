import java.util.ArrayList;

/**
 * Repräsentiert eine Bestellung. Jeder bestellte Gegenstand ist ein String in
 * einer ArrayList - dieser Input wird nicht ueberprueft - wenn ein Gegenstand
 * nicht vorhanden ist wird beim Behandeln der Bestellung ein Fehler ausgegeben.
 * 
 * @author oerpli
 * 
 */
public class Order {
	protected ArrayList<String> drinks = new ArrayList<String>();
	protected final int nr;

	public Order(int tablenr) {
		this.nr = tablenr;
	}

	public void add(String cocktail) {
		assert cocktail != null;
		drinks.add(cocktail);
	}

	public Tray aufgeben() {
		return Bar.order(this);
	}

	public void list() {
		System.out.println("Bestellte Getränke (Tisch " + nr + "):");
		for (String s : drinks) {
			System.out.println(" " + s);
		}
	}
}
