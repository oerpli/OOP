@WorkedOnAnnotation(worker1 = "Schöberl", comment1 = "", worker2 = "", comment2 = "")
abstract class Pumpkin {
	protected int weight;
	protected int waterLevel;

	public Pumpkin() {

	}

	public void simuRain() {

	}

	public void simuSun() {

	}

	public void simuWind() {

	}

	@Override
	public String toString() {
		String result = "";
		result += "Gewicht: ";
		result += weight;
		result += "; Wassergehalt: ";
		result += waterLevel;
		return result;
	}
}
