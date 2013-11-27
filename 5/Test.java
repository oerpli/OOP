import java.util.Iterator;

import OOP5.*;

public class Test {
	public static void main(String[] args) {
	
		//1. Test
		System.out.println("1.Test");
		Prefixed pre1=new Prefixed("Test");
		Prefixed pre2=new Prefixed("Test1");
		Prefixed pre3=new Prefixed("Test2");
		SList<Prefixed> list=new SList<Prefixed>();
		list.add(pre1);
		list.add(pre2);
		list.add(pre3);
		
		Iterator<Prefixed>iter=list.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}
		pre3=new Prefixed("Test4");
		list.add(pre3);
		Iterator<Prefixed>iter1=list.iterator();
		while(iter1.hasNext()){
			System.out.println(iter1.next().toString());
		}
		
		//2.Test
		System.out.println("2.Test");
		String word=new String("wort");
		String word1=new String("wort1");
		String word2=new String("wort2");
		
		Integer[] asso=new Integer[2];
		asso[0]=2;
		asso[1]=2;
			
		Integer[] asso1=new Integer[1];
		asso1[0]=2;
				
		Integer[] asso2=new Integer[0];
		
		AList<String,Integer> list1=new AList<String,Integer>();
	
		list1.add(-1, word, asso);
		list1.add(-1, word1, asso1);
		list1.add(-1, word2, asso2);
				
		Iterable_Iterator it = list1.iterator();
		Iterator it2;
		while(it.hasNext())
		{
			it2 = it.iterator();
			System.out.println(it.next().toString());
			while(it2.hasNext())
			{
				System.out.println(it2.next().toString());
			}
			
		}
				
		
		CharCategory cc1 = new CharCategory('x');
		CharCategory cc2 = new CharCategory('y');
		CharCategory cc3 = new CharCategory('y');
		
		IntCategory ii1 = new IntCategory(1,4);
		IntCategory ii2 = new IntCategory(2,5);
		IntCategory ii3 = new IntCategory(3,6);
		
		CharCategory[] cca1 = new CharCategory[1];
		CharCategory[] cca2 = new CharCategory[2];
		CharCategory[] cca3 = new CharCategory[0];
		
		cca1[0]=cc3;
		cca2[0]=cc1;
		cca2[1]=cc2;
		
		
		System.out.println(cc1.dependsOn(cc2)); // == false

		DList<IntCategory, CharCategory> dl = new DList<>();
		dl.add(-1, ii1, cca1);
		dl.add(-1, ii2, cca2);
		dl.add(-1, ii3, cca3);
		System.out.println(dl.consistent()); // == false, weil min. ein dependsOn der Elemente true gegeben hat
		
	}
}
