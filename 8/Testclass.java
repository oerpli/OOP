import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
@Testcase({@SubTestcase(sammlung=ArrayList.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"}),
			@SubTestcase(sammlung=LinkedList.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"}),
			@SubTestcase(sammlung=Vector.class,PumpName={"Patisson","Aladdin","Hokkaido"},methodstocall={"simuWind","simuSun","simuRain"})})
@WorkedOnAnnotation(worker1="Maisriemler,Schöberl", comment1 = "", comment2 = "", worker2 = "")		
public class Testclass {
	
	private String[] Klassen={"Aladdin","Hokkaido","Patisson","Pumpkin","SubTestcase","Test","Testcase","Testclass","WorkedOnAnnotation"};

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
			String result="Klasse:\t\t Name:\t\t Arbeit: \t\n";
			for (int i = 0; i < Klassen.length; i++) {
				Annotation[] annotations = Class.forName(Klassen[i]).getAnnotations();
				for (Annotation annotation1 : annotations) {
					if (annotation1 instanceof WorkedOnAnnotation) {
						WorkedOnAnnotation myAnnotation = (WorkedOnAnnotation) annotation1;
						
								result+=""+Class.forName(Klassen[i]) + "\t" + myAnnotation.worker1() + " \t"
								+ myAnnotation.comment1()+ " \t" + myAnnotation.worker2() + " \t"
										+ myAnnotation.comment2()+"\n";

					}
				}
			}
			System.out.println(result);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	
}

