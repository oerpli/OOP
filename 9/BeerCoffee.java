import java.util.HashMap;

public class BeerCoffee extends CocktailHot {
	public static final String name = "Beer Coffee";
	protected static final HashMap<String, Integer> reference = new HashMap<String,Integer>();
	static {
		reference.put("Bier", 750);
		reference.put("Cola", 50);
	}

	protected BeerCoffee() {
		super(name);// 760
	}

	/**
	 * Sollte eigentlich static sein - da static Klassen in java aber nicht
	 * abstract sein können ist es stattdessen eine Funktion einer Instanz.
	 * 
	 */
	@Override
	protected int getTemp() {
		return 500;// wer sowas trinken will hats verdient sich zu verbrennen.
	}
	
	protected int getAmount(){
		return 760;
	}
}
