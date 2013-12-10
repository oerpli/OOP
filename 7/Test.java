public class Test {
	public static void main(String[] args) {
			int[] time = { 30, 20, 10 };
			Playground pg = new Playground(50, 50, 5, time);
			pg.createCell("Bacterium", 0, 0);
			pg.createCell("Bacterium", 1, 8);
			pg.createCell("Bacterium", 2, 7);
			pg.createCell("Bacterium", 3, 6);
			pg.createCell("Bacterium", 4, 5);
			
			pg.createCell("Bacterium", 50, 50);

	}
}
