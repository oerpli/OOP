public class Test {

	public static void main(String[] args) {
		Bar b = Bar.getInstance();
		test(b);
	}

	public static void test(Bar b) {
		Order o = new Order(1);
		o.add("Mojito").add("Cuba Libre").add("Bier");
		Tray t = b.order(o);
		o.list();
		t.content();
	}
}
