import java.util.ArrayList;

public class Bestellung {
	private ArrayList<String> drinks = new ArrayList<String>();
	private final int tisch;

	public Bestellung(int tisch) {
		this.tisch = tisch;
	}

	public void add(String cocktail) {
		assert cocktail != null;
		drinks.add(cocktail);
	}

	public Tray aufgeben() {
		return Bar.bestellen(this);
	}

	public void list() {
		System.out.println("Bestellte Getränke (Tisch " + tisch + "):");
		for (String s : drinks) {
			System.out.println(" " + s);
		}
	}
}
