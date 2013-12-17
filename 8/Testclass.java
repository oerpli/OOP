import java.util.*;
@Testcase({@SubTestcase(sammlung=ArrayList.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"}),
			@SubTestcase(sammlung=LinkedList.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"}),
			@SubTestcase(sammlung=Vector.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"})})
@WorkedOnAnnotation(worker1="Maisriemler,Schöberl", comment1 = "", comment2 = "", worker2 = "")		
public class Testclass {

	public void test() {

		Testcase annotation = Testclass.class.getAnnotation(Testcase.class);
		try {
			for (int i = 0; i < annotation.value().length; i++) {
				SubTestcase test1 = annotation.value()[i];
				Collection<Pumpkin> collection = (Collection<Pumpkin>) test1.sammlung().newInstance();
				for (int j = 0; j < test1.PumpName().length; j++) {
					Pumpkin k = (Pumpkin) Class.forName(test1.PumpName()[j])
							.newInstance();
					collection.add(k);
				}

				String[] meth = test1.methodstocall();
				for (int j = 0; j < meth.length; j++) {
					if (meth[j].equals("simuWind")) {
						for (Pumpkin k : collection) {
							k.simuWind();
						}
					} if (meth[j].equals("simuRain")) {
						for (Pumpkin k : collection) {
							k.simuRain();
						}
					} if (meth[j].equals("simuSun")) {
						for (Pumpkin k : collection) {
							k.simuSun();
						}
					}

				}
			}			
			
			
		} catch (InstantiationException | IllegalAccessException |ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	
}

