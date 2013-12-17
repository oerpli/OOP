import java.lang.reflect.Method;
import java.util.*;
@Testcase({@SubTestcase(sammlung=ArrayList.class,PumpName1="Patisson",PumpName2="Aladdin",PumpName3="Hokkaido"),
			@SubTestcase(sammlung=Arrays.class,PumpName1="Patisson",PumpName2="Aladdin",PumpName3="Hokkaido"),
			@SubTestcase(sammlung=List.class,PumpName1="Patisson",PumpName2="Aladdin",PumpName3="Hokkaido")})
		
public class Testclass {

	public void test() {

		Testcase annotation = Testclass.class.getAnnotation(Testcase.class);
		try {
			
			SubTestcase test1 = annotation.value()[0];
			Collection collection = (Collection) test1.sammlung().newInstance();
			String classname=test1.PumpName1();
			Class class1 = Class.forName(classname);
			Pumpkin k = (Patisson) class1.newInstance();
			collection.add(k);
			
			classname=test1.PumpName2();
			class1 = Class.forName(classname);
			Pumpkin k1 = (Aladdin) class1.newInstance();
			collection.add(k1);
			classname=test1.PumpName3();
			class1 = Class.forName(classname);
			Pumpkin k2 = (Hokkaido) class1.newInstance();
			collection.add(k2);
			
			for(Object o:collection){
				Pumpkin test=(Pumpkin)o;
				test.simuSun();
				test.simuRain();
				test.simuWind();
				
			}
			
			
			

			
			
			
		} catch (InstantiationException | IllegalAccessException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
}

