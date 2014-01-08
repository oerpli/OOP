import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Repraesentiert den ganzen Roboter der aus unterschiedlichen Teilrobotern
 * besteht. Die "KI" des Roboters ist im Grossen und Ganzen hier implementiert -
 * der "Hauptroboter" kann mit "Nebenrobotern" erweitert werden wobei jeder
 * dieser fuer einen Cocktail zustaendig ist. Wie genau dieser die Zutaten
 * ermittelt und diese anschlieﬂend zusammenmischt bleibt ihm ueberlassen.
 * Ressourcen
 */
public abstract class Robot {
	public final String name;
	private static HashMap<String, Robot> list = new HashMap<String, Robot>();
	private static ArrayList<String> menu = new ArrayList<String>();

	public static void menu() {
		System.out.println("Karte:");
		for (String s : menu) {
			System.out.println("-" + s);
		}
	}

	protected Robot(String N) {
		this.name = N;
		list.put(name, this);
		menu.add(N);
	}

	protected static void processOrder(Tray t, Order order) {
		for (String s : order.drinks) {
			if (list.containsKey(s)) {
				list.get(s).addCocktail(t);
			} else {
				System.out.println("+Cocktail " + s + " ist unbekannt");
			}
		}
	}

	private Cocktail mixCocktail() {
		Cocktail c = this.mix();
		for (Entry<String, Integer> e : this.getRecipe()) {
			Ingredient.get(e.getKey()).fillInto(c, e.getValue());
		}
		return c;
	}

	protected Tray addCocktail(Tray T) {
		if (checkResources()) {
			T.add(mixCocktail());
		} else {
			System.out.println("+" + name + "-Roboter kann " + name
					+ " nicht zubereiten.");// so
		}
		return T;
	}

	private boolean checkResources() {
		boolean stock = true;
		for (Entry<String, Integer> e : this.getRecipe()) {
			if (!Ingredient.checkStock(e.getKey(), e.getValue())) {
				stock = false;
			}
		}
		return stock;
	}

	protected abstract Set<Entry<String, Integer>> getRecipe();

	protected abstract Cocktail mix();
}
