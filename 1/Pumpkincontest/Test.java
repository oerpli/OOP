package Pumpkincontest;

public class Test {
	public static Nursery garten = new Nursery();

	public static void main(String[] args) {
		if (!false) {
			Nursery G = new Nursery();
			int n = 10; // Anzahl Kürbisse
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

}
