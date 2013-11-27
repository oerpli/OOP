import java.util.ArrayList;

class Lager {
	Lagerplatz[] listT20;
	Lagerplatz[] listT4;
	Lagerplatz[] listT_18;
	Lagerplatz[] listT_30;
	
	Lager(int T20, int T4, int T_18, int T_30) {
		listT20 = new Lagerplatz[T20];
		listT4 = new Lagerplatz[T4];
		listT_18 = new Lagerplatz[T_18];
		listT_30 = new Lagerplatz[T_30];
	}
}
