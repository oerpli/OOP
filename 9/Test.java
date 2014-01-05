public class Test {

	public static void main(String[] args) {
		System.err.println("start");
		Bar b = Bar.getInstance();
		Order o = new Order(1);
		o.add("Mojito").add("Cuba Libre").add("Bier");
		Tray t = b.order(o);
		o.list();
		t.content();
	}

}
