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

	public Tray order() {
		Tray t = new Tray(this.nr);
		Robot.processOrder(t, this);
		return t;
	}

	public Order add(String cocktail) {
		assert cocktail != null;
		drinks.add(cocktail);
		return this; // für Chaining
	}

	public void list() {
		System.out.println("Bestellte Getränke (Tisch " + nr + "):");
		for (String s : drinks) {
			System.out.println("-" + s);
		}
	}
}
