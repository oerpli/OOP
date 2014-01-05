import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public abstract class Robot {
	public final String name;
	private static HashMap<String, Robot> list = new HashMap<>();

	public Robot(String N) {
		this.name = N;
		list.put(name, this);
	}

	protected Tray addCocktail(Tray T) {
		if (checkResources()) {
			T.add(mixCocktail());
		} else {
			// TODO irgendwie einfügen was genau nicht gemacht werden kann
			// System.out.println("Not enough resources to mix XYZ");
			System.out.println(name + "kann sein Ding nicht mixen");// so vllt?
		}
		return T;
	}

	protected static void processOrder(Tray t, Order order) {
		for (String s : order.drinks) {
			if (list.containsKey(s)) {
				list.get(s).addCocktail(t);
			} else {
				System.out.println("Cocktail " + s + " ist unbekannt");
			}
		}
	}

	private Cocktail mixCocktail() {
		for (Entry<String, Integer> e : this.getRecipe()) {
			Ingredient.get(e.getKey()).use(e.getValue());
		}
		return this.mix();
	}

	private boolean checkResources() {
		boolean stock = true;
		for (Entry<String, Integer> e : this.getRecipe()) {
			stock &= Ingredient.get(e.getKey()).checkStock(e.getValue());
		}
		return stock;
	}

	protected abstract Set<Entry<String, Integer>> getRecipe();

	protected abstract Cocktail mix();
}
