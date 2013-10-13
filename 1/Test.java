import Pumpkincontest.*;

public class Test {
	private static double[][] testdata = new double[100][2];

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			testdata[i][1] = Math.random() * 0.51;
			testdata[i][0] = Math.random() * 0.51;
		}

		Garten.pflanzen(1);
		for (int i = 0; i < 100; i++) {
			try {
				Garten.Tag((testdata[i][0]), testdata[i][1]);
			} catch (PumpkinException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(Garten.String());
	}
}
