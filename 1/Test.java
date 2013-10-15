import Pumpkincontest.Nursery;

public class Test {
	public static Nursery garten = new Nursery();

	public static void main(String[] args) {
		if (!true) {
			garten.plant(1);
			try {
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(50.0, 50.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(70.0, 30.0);
				System.out.println(garten.toString());
				feedKuerbis(70.0, 30.0);
				System.out.println(garten.toString());
				feedKuerbis(90.0, 10.0);
				System.out.println(garten.toString());
				feedKuerbis(90.0, 10.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
				feedKuerbis(100.0, 0.0);
				System.out.println(garten.toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if (!false) {
			Nursery G = new Nursery();
			int n = 100; // Anzahl Kürbisse
			double[][][] data = new double[n][100][2];
			for (int i = 0; i < n; i++)
				// Zufällige Testdaten
				for (int d = 0; d < 100; d++) {
					data[i][d][0] = Math.random() * 0.82;// 82+19 =102 =>
															// betrüger
					data[i][d][1] = Math.random() * 0.19;
				}

			G.plant(n);
			for (int d = 0; d < 100; d++) {
				for (int i = 0; i < n; i++) {
					try {
						G.petPumpkinNr(i, data[i][d][0], data[i][d][1]);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				G.closeDay();
			}
			System.out.println(G.toString());
		}
	}

	private static void feedKuerbis(double d, double e) {
		try {
			garten.petPumpkinNr(0, d / 100D, e / 100D);
			garten.closeDay();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
