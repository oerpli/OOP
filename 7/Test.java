public class Test {
	public static void main(String[] args) throws InterruptedException {
			System.out.println("Test 1");
			int[] time ={ 30, 20, 10 };
			int[] time1={ 50, 30, 4 };
			int[] time2={ 50, 30, 4 };
			Playground pg = new Playground(5, 5, 5, time, 75);
			pg.createCell("Bacterium", 0, 0);
			pg.createCell("Bacterium", 1, 4);
			pg.createCell("Fungus", 2, 3);
			pg.createCell("Bacterium", 2, 2);
			pg.createCell("Bacterium", 3, 1);
			pg.createCell("Bacterium", 4, 5);
			
			Thread.sleep(2000);
			
			System.out.println("Test 2");
			
			pg = new Playground(10, 10, 15, time1, 50);
			pg.createCell("Bacterium", 1, 0);
			pg.createCell("Bacterium", 7, 7);
			pg.createCell("Fungus", 2, 5);
			pg.createCell("Bacterium", 4, 5);
			pg.createCell("Fungus", 8, 8);
			
			Thread.sleep(2000);
			
			System.out.println("Test 3");
			
			pg = new Playground(11, 11, 7, time2, 100);
			pg.createCell("Bacterium", 10, 10);
			pg.createCell("Bacterium", 9, 9);
			pg.createCell("Bacterium", 8, 8);
			pg.createCell("Fungus", 2, 5);
			pg.createCell("Bacterium", 7, 7);
			pg.createCell("Bacterium", 6, 6);
			pg.createCell("Bacterium", 4, 7);
			pg.createCell("Fungus", 1, 1);
			
			pg.killAllCells();
	}
}
