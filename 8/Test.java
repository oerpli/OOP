import java.util.ArrayList;
import java.util.Collection;

class Test {
	public static void main(String[] args) {
		
		test();
		
	}
	
	public static void test(){
		@TypeAnnotation(sammlung = ArrayList.class)
		
		TypeAnnotation annotation = Test.class.getAnnotation(TypeAnnotation.class);
		try {
			Collection collection = annotation.sammlung().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ArrayList<Pumpkin> arrList = new ArrayList<Pumpkin>();
		Pumpkin[] arr = Pumpkin[6];
		Hashtable<Integer, Pumpkin> hashTable = new Hashtable<Integer, Pumpkin>();*/
	}
}
