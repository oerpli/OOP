import lager.*;

public class Test {
	public static void main(String[] args) {
		Lager x = new Lager(2, 2, 2, 2);
		Ware[] waren = new Ware[10];
		int N = 0;
		waren[N++] = new W30("Yeti"); // 0
		waren[N++] = new W18("Eis"); // 1
		waren[N++] = new W5("Cola");// 2
		waren[N++] = new W20("Teppich");// 3
		waren[N++] = new W20("Glas");// 4
		waren[N++] = new W20("Cinnamon Chips");// 5 -- muss ins falsche Lager
		waren[N++] = new W20("Nagelzwicker");// 6 -- passt nicht mehr rein. :(
		waren[N++] = new W18("Eiswuerfel"); // 7
		waren[N++] = new W18("Schnee"); // 8 -- muss ins -30�C Lager
		waren[N++] = new W18("Fisch");// 9 -- passt nicht mehr rein.
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
		
		// Test Lager 2
		x = new Lager(3, 0, 1, 1);
		waren = new Ware[6];
		N = 0;
		waren[N++] = new W30("Yeti"); // 0
		waren[N++] = new W30("Eis"); // 1
		waren[N++] = new W30("Cola");// 2
		waren[N++] = new W20("Cinnamon Chips");// 3
		waren[N++] = new W20("Teppich");// 4 - kein Lagerplatz -> gekühlt gelagert.
		waren[N++] = new W5("Glas");// 5 - kein Lagerplatz mehr für 5 Grad
		System.out.println("Einlagern aller Gegenstaende in Lager x."
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
		System.out.println("Entfernt: " + x.remove(0));
		
		// Test Lager 3
		x = new Lager(2, 2, 1, 0);
		waren = new Ware[5];
		N = 0;
		waren[N++] = new W30("Yeti"); // 0
		waren[N++] = new W18("Eis"); // 1
		waren[N++] = new W18("Haus"); // 2
		waren[N++] = new W18("Cola");// 3 - kein Lagerplatz -> bei -30 eingelagert.
		waren[N++] = new W30("Fahrrad");// 4 -> kein Lagerplatz für 30
		System.out.println("Einlagern aller Gegenstaende in Lager x."
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
		System.out.println("Entfernt: " + x.remove(3));
		
		System.out.println(x.store(waren[4]));
		System.out.println("Inventar:\n");
		x.inventar();
		x.utilization();
	}
}
