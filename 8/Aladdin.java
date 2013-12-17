@WorkedOnAnnotation(worker1 = "Maisriemler", comment1 = "Funktionalität", worker2 = "Schöberl", comment2 = "Grundstruktur")
class Aladdin extends Pumpkin {
	@Override
	public void simuRain() {
		waterLevel = waterLevel * 2;
		weight = weight * 2;
		System.out.println("Aladdin gets water");
	}

	@Override
	public void simuSun() {
		waterLevel = (int) (waterLevel * 0.5);
		System.out.println("Aladdin gets sun");
	}

	@Override
	public void simuWind() {
		waterLevel = (int) (waterLevel * 0.8);
		weight = (int) (weight * 0.8);
		System.out.println("Aladdin gets wind");
	}
}
