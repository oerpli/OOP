import Pumpkincontest.*;

public class Test {
	public static void main(String[] args) {
		int n = 100; // Anzahl Kürbisse
		double[][][] data = new double[n][100][2];
		for (int i = 0; i < n; i++)
			// Zufällige Testdaten
			for (int d = 0; d < 100; d++) {
				data[i][d][0] = Math.random() * 0.81;// 81+21 =102 => betrüger
				data[i][d][1] = Math.random() * 0.20;
			}

		Garten.pflanzen(n);
		for (int d = 0; d < 100; d++) {
			for (int i = 0; i < n; i++) {
				try {
					boolean lazy = Math.random() < 0.1;
					if (!lazy)
						Garten.petPumpkinNr(i, data[i][d][0], data[i][d][1]);
				} catch (PumpkinException e) {
					System.out.println(e.getMessage());
				}
			}
			Garten.closeDay();
		}
		System.out.println(Garten.String());
	}
}
