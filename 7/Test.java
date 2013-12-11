public class Test {
	public static void main(String[] args) {
			int[] time = { 30, 20, 10 };
			Playground pg = new Playground(50, 50, 5, time);
			pg.createCell("Bacterium", 55, 55);
			pg.createCell("Bacterium", 0, 0);
			pg.createCell("Bacterium", 1, 8);
			pg.createCell("Fungus", 2, 5);
			pg.createCell("Bacterium", 2, 7);
			pg.createCell("Bacterium", 3, 6);
			pg.createCell("Bacterium", 4, 5);
			pg.createCell("Fungus", 40, 40);
			
			Thread.sleep(10000);
			
			time = { 50, 30, 4 };
			pg = new Playground(70, 70, 5, time);
			pg.createCell("Bacterium", 55, 55);
			pg.createCell("Bacterium", 1, 0);
			pg.createCell("Bacterium", 15, 32);
			pg.createCell("Fungus", 2, 5);
			pg.createCell("Bacterium", 50, 50);
			pg.createCell("Bacterium", 67, 67);
			pg.createCell("Bacterium", 4, 5);
			pg.createCell("Fungus", 10, 68);
			
			Thread.sleep(10000);
			
			time = { 50, 30, 4 };
			pg = new Playground(80, 80, 5, time);
			pg.createCell("Bacterium", 50, 50);
			pg.createCell("Bacterium", 79, 79);
			pg.createCell("Bacterium", 15, 32);
			pg.createCell("Fungus", 2, 5);
			pg.createCell("Bacterium", 10, 70);
			pg.createCell("Bacterium", 67, 47);
			pg.createCell("Bacterium", 4, 7);
			pg.createCell("Fungus", 50, 78);
	}
}
