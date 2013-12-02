import OOP6.*;

public class Test {
	public static void main(String[] args) {
		Verwaltung x = new Verwaltung(2, 2, 2, 2);
		Ware[] waren = new Ware[10];
		int N = 0;
		waren[N++] = new W30("Fisch"); // 0
		waren[N++] = new W18("Eis"); // 1
		waren[N++] = new W5("Cola");// 2
		waren[N++] = new W20("Teppich");// 3
		waren[N++] = new W20("Glas");// 4
		waren[N++] = new W20("Cinnamon Chips");// 5 -- muss ins falsche Lager
		waren[N++] = new W20("Nagelzwicker");// 6 -- passt nicht mehr rein. :(
		System.out
				.println("Einlagern aller Gegenstände in Lager x."
						+ "\n Wenn Ware in richtigem Lager return == 1,"
						+ "\n wenn Waren in möglichem aber nicht optimalem Lager return == 0,"
						+ "\n wenn kein Lager frei return == 0");

		for (int i = 0; i < N; i++) {
			System.out.println(i + ": " + x.store(waren[i]));
		}
		System.out.println("Einlagern fertig.\n");
		System.out.println("Inventar:\n" + x.inventar());
		System.out.println(x.utilization());
		System.out.println("Entfernt: " + x.remove(2));
		
		// null (weil noch nicht eingelagert)
		System.out.println("Entfernt: " + x.remove(6));
		System.out.println(x.utilization());
		
		// jetzt wieder Platz im (nicht optimalem Lager):
		System.out.println(x.store(waren[6]));
	}
}
