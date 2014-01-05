import java.util.HashMap;

public abstract class Robot {
	public final String name;
	private HashMap<String, Robot> list = new HashMap<>();

	public Robot(String N) {
		this.name = N;
		list.put(name, this);
	}

	protected Tray addCocktail(Tray T) {
		if (checkResources()) {
			T.add(mixCocktail());
		} else {
			// TODO irgendwie einfügen was nicht gemacht werden kann
			System.out.println("Not enough resources to mix XYZ");
		}
		return T;
	}

	protected abstract boolean checkResources();

	protected abstract Cocktail mixCocktail();
}
