public class Test {
	public static void main(String[] args) {
			int[] time = { 30, 20, 10 };
			Playground pg = new Playground(50, 50, 5, time);
			Box bbox = pg.getBox(0, 0);
			Bacterium bac = new Bacterium(pg, bbox, 1);
			Bacterium[] bacArr = { bac };
			Box fbox = pg.getBox(25, 20);
			Fungus bmyk = new Fungus(pg, fbox, 1);
			Fungus[] mykArr = { myk };
			pg.start(bacArr, mykArr);
			pg.makeRandomCell();
			pg.makeRandomCell();
			pg.makeRandomCell();
			pg.makeRandomCell();
	}
}
