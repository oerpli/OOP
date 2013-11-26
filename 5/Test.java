import OOP5.*;

public class Test {
	public static void main(String[] args) {
	
		CharCategory cc1 = new CharCategory('x');
		CharCategory cc2 = new CharCategory('y');
		System.out.println(cc1.dependsOn(cc2)); // == false

		DList<Category, Object> dl = new DList<Category, Object>();
		dl.add(-1, cc1, new Object[0]);
		dl.add(-1, cc2, new Object[0]);
		dl.consistent(); // == false, weil min. ein dependsOn der Elemente true gegeben hat
	}
}
