public class Test {
	public static void main(String[] args) {
		for (int j = 0; j < 500; j++) {
			int[] time = { 30, 20, 10 };
			Playground pg = new Playground(10, 20, 5, time);
			pg.start();
			for (int i = 0; i < 700; i++) {
				pg.makeRandomCell();

			}
			for (int i = 0; i < 100; i++)
				//System.out.println(pg.toString());
			pg.killAllCells();
		}
	}
}
