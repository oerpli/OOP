import java.util.HashMap;
import java.util.Map.Entry;

public abstract class Cocktail {
	private final String name;
	private int ml;
	private double vol;
	private HashMap<String, Integer> ingredients = new HashMap<>();

	protected Cocktail(String N) {
		assert N != null;// braucht einen Name
		this.name = N;
	}

	public String toString() {
		return name + "(" + ml + "ml, alc. " + vol + "% vol)";
	}

	protected void addIngredient(String name, double ivol, int qnt) {
		vol = vol * ml + ivol * qnt;
		ml += qnt;
		vol /= ml;
		if (ingredients.containsKey(name)) {
			ingredients.put(name, ingredients.get(name) + qnt);
		} else {
			ingredients.put(name, qnt);
		}
	}

	public void getIngredients() {
		System.out.print(name + ": ");
		for (Entry<String, Integer> e : ingredients.entrySet()) {
			System.out.print(e.getKey() + " - " + e.getValue() + ", ");
		}
	}
	protected abstract int getAmount();
}
