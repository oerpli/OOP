class Hokkaido extends Pumpkin {
	@Override
	public void simuRain() {
		waterLevel=waterLevel*2;
		weight=weight*2;
		System.out.println("Hokkaido gets water");
	}
	
	@Override
	public void simuSun() {
		waterLevel=(int) (waterLevel*0.5);
		System.out.println("Hokkaido gets sun");
	}
	
	@Override
	public void simuWind() {
		waterLevel=(int) (waterLevel*0.8);
		weight=(int) (weight*0.8);
		System.out.println("Hokkaido gets wind");
	}
}
