import lager.*;

public class Test {
	public static void main(String[] args) {
		Ware[] waren = new Ware[10];
		int N = 0;
		waren[N++] = new W30("Yeti"); // 0 (Kommentare bezogen auf T==0)
		waren[N++] = new W18("Eis"); // 1
		waren[N++] = new W5("Cola");// 2
		waren[N++] = new W20("Teppich");// 3
		waren[N++] = new W20("Glas");// 4
		waren[N++] = new W20("Cinnamon Chips");// 5 -- muss ins suboptimale
												// Lager
		waren[N++] = new W20("Nagelzwicker");// 6 -- passt nicht mehr rein.
												// :(
		waren[N++] = new W18("Eiswuerfel"); // 7
		waren[N++] = new W18("Schnee"); // 8 -- muss ins suboptimale Lager
		waren[N++] = new W18("Fisch");// 9 -- passt nicht mehr rein.
		for (int T = 0; T < 3; T++) {
			Lager x = null;
			switch (T) {
			case 0:
				System.out.println("Teste Lager(2,2,2,2)");
				x = new Lager(2, 2, 2, 2);
				break;
			case 1:
				System.out.println("Teste Lager(4,1,2,1)");
				x = new Lager(4, 1, 2, 1);
				break;
			case 2:
				System.out.println("Teste Lager(5,5,5,5)");
				x = new Lager(5, 5, 5, 5);
				break;
			default:
				System.out.println("WTF");
			}

			System.out
					.println("Einlagern aller Gegenstaende in Lager x."
							+ "\n Wenn Ware in richtigem Lager return == 1,"
							+ "\n wenn Waren in moeglichem aber nicht optimalem Lager return == 0,"
							+ "\n wenn kein Lager frei return == 0");

			for (int i = 0; i < N; i++) {
				System.out.println(i + ": " + x.store(waren[i]));
			}
			System.out.println("Einlagern fertig.\n");
			System.out.println("Inventar:\n");
			x.inventar();
			x.utilization();
			System.out.println("Entfernt: " + x.remove(2));

			// null (weil noch nicht eingelagert)
			System.out.println("Entfernt: " + x.remove(6));
			x.utilization();

			// jetzt wieder Platz im (nicht optimalem Lager):
			System.out.println(x.store(waren[6]));
			System.out.println("Inventar:\n");
			x.inventar();
			x.utilization();
		}
	}
}
