import Pumpkincontest.*;

public class Test {
	public static Garten garten = new Garten();

	public static void main(String[] args) {
		if (!true) {
			garten.pflanzen(1);
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
			Garten G = new Garten();
			int n = 1000; // Anzahl K�rbisse
			double[][][] data = new double[n][100][2];
			for (int i = 0; i < n; i++)
				// Zuf�llige Testdaten
				for (int d = 0; d < 100; d++) {
					data[i][d][0] = Math.random() * 0.81;// 81+21 =102 =>
															// betr�ger
					data[i][d][1] = Math.random() * 0.20;
				}

			G.pflanzen(n);
			for (int d = 0; d < 100; d++) {
				for (int i = 0; i < n; i++) {
					try {
						boolean lazy = Math.random() < 0.1;
						if (!lazy)
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
