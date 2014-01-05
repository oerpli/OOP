import java.util.HashMap;

public abstract class Robot {
	public final String name;
	private static HashMap<String, Robot> list = new HashMap<>();

	public Robot(String N) {
		this.name = N;
		list.put(name, this);
	}

	protected abstract Tray mixCocktail(Tray T);
}
