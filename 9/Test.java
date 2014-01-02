public class Test {
	public static void main(String [] args) {
		Bar bar = new Bar();
		// Gib aktuell verfügbare Cocktails aus
		System.out.println(bar.toString());
		
		String[] order = String[4];
		order.add("Cuba Libre");
		order.add("Cuba Libre");
		order.add("Mojito");
		order.add("Swimming Pool");
		// Bestelle die Cocktails
		Cocktail[] tray = bar.order(order);
	}
}
