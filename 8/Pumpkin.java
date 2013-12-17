abstract class Pumpkin {
	protected int weight;
	protected int waterLevel;
	
	public Pumpkin(){
		
	}
	
	public void simuRain() {
		System.out.println("asd");
	}
	
	public void simuSun() {
		System.out.println("asd");
	}
	
	public void simuWind() {
		System.out.println("asd");
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
