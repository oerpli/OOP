import java.util.ArrayList;

/**
 * Repr�sentiert eine Bestellung. Jeder bestellte Gegenstand ist ein String in
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

	public Order add(String cocktail) {
		assert cocktail != null;
		drinks.add(cocktail);
		return this; // f�r Chaining
	}

	public void list() {
		System.out.println("Bestellte Getr�nke (Tisch " + nr + "):");
		for (String s : drinks) {
			System.out.println("-" + s);
		}
	}
}
