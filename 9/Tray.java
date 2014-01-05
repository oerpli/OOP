import java.util.ArrayList;

public class Tray {
	private final int nr;
	private ArrayList<Cocktail> drinks = new ArrayList<>();

	public Tray(int tischnr) {
		this.nr = tischnr;
	}

	public void add(Cocktail mixCocktail) {
		drinks.add(mixCocktail);
	}

	public void content() {
		System.out.println("Tablett für Tisch" + nr + " enthaelt:");
		for (Cocktail c : drinks)
			System.out.println(" " + c);
	}

}
