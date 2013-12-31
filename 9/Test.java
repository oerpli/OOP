public class Test {
	public static void main(String [] args) {
		Bar bar = new Bar();
		// Gib aktuell verfügbare Cocktails aus
		System.out.println(bar.toString());
		
		ArrayList<String> order = new ArrayList<String>();
		order.add("Cuba Libre");
		order.add("Cuba Libre");
		order.add("Mojito");
		order.add("Swimming Pool");
		// Bestelle die Cocktails
		ArrayList<???> tray = bar.order(order);
	}
}
