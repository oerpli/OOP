public class Test {

	public static void main(String[] args) {
		Bar b = Bar.getInstance();
		end();
		test(b);
		end();
	}

	public static void test(Bar b) {
		Order o = new Order(1);
		o.add("Mojito").add("Cuba Libre").add("Bier");
		Tray t = b.order(o);
		o.list();
		t.content();
	}

	public static void end() {
	}

}
