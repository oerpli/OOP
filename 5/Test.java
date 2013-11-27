import java.util.Iterator;

import OOP5.*;

public class Test {
	public static void main(String[] args) {
	
		//1. Test
		System.out.println("1.Test \n");
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
		System.out.println("\n 2.Test \n");
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

		asso2=new Integer [3];
		asso2[0]=4;
		asso2[1]=3;
		asso2[2]=2;
		list1.add(-1, word2, asso2);
		
		Iterable_Iterator it1 = list1.iterator();
		Iterator it21;
		while(it1.hasNext())
		{
			it21 = it1.iterator();
			System.out.println(it1.next().toString());
			while(it21.hasNext())
			{
				System.out.println(it21.next().toString());
			}
			
		}
		
		
		//Test3
		System.out.println("\n 3.Test \n");
		CharCategory cc1 = new CharCategory('x');
		CharCategory cc2 = new CharCategory('y');
		CharCategory cc3 = new CharCategory('z');
		
		IntCategory ii1 = new IntCategory(0,5);
		IntCategory ii2 = new IntCategory(1,1);
		IntCategory ii3 = new IntCategory(0,7);
		
		CharCategory[] cca1 = new CharCategory[1];
		CharCategory[] cca2 = new CharCategory[2];
		CharCategory[] cca3 = new CharCategory[0];
		
		cca1[0]=cc3;
		cca2[0]=cc1;
		cca2[1]=cc2;
		
		DList<IntCategory, CharCategory> dl = new DList<>();
		dl.add(-1, ii1, cca1);
		dl.add(-1, ii2, cca2);
		dl.add(-1, ii3, cca3);
		
		Iterable_Iterator it11 = dl.iterator();
		Iterator it211;
		while(it11.hasNext())
		{
			it211 = it11.iterator();
			System.out.println(it11.next().toString());
			while(it211.hasNext())
			{
				System.out.println(it211.next().toString());
			}
			
		}
		
	
		System.out.println(dl.consistent()); // == false, weil min. ein dependsOn der Elemente true gegeben hat
		
		ii3 = new IntCategory(0,0);
		dl.add(-1, ii3, cca3);
		System.out.println(dl.consistent());
		
		
		//Test5
		System.out.println("\n 5.Test \n");
		
		IntCategory ii4 = new IntCategory(11,79);
		IntCategory ii5 = new IntCategory(15,78);
		IntCategory ii6 = new IntCategory(18,75);
		dl.add(-1,ii4);
		dl.add(-1,ii5);
		dl.add(-1,ii6);
		
		
		Iterable_Iterator it111 = dl.iterator();

		while(it111.hasNext())
		{
			System.out.println(it111.next().toString());
		}

		//Test6
				System.out.println("\n 6.Test \n");
				
		DList<Category, Object> dl1 = new DList<>();
		
		Iterable_Iterator<IntCategory,CharCategory> it1111 = dl.iterator();
		Iterator<CharCategory> it2111;
		while(it1111.hasNext())
		{
			it2111 = it1111.iterator();
			Category cat = it1111.next();
			Object[] obj = new Object[2];
			String type =cat.toString();
			Integer num = new Integer(cat.uses());
			obj[0]=type;
			obj[1]=num;
			dl1.add(-1, cat, obj);
			while(it2111.hasNext())
			{
				cat = it2111.next();
				obj = new Object[2];
				type =cat.toString();
				num = new Integer(cat.uses());
				obj[0]=type;
				obj[1]=num;
				dl1.add(-1, cat, obj);
			}
			
		}
		
		Iterable_Iterator it3 = dl1.iterator();
		Iterator it31;
		
		while(it3.hasNext())
		{
			it31 = it3.iterator();
			System.out.println(it3.next().toString());
			while(it31.hasNext())
			{
				System.out.println(it31.next().toString());
			}
			
		}
		System.out.println("Const: "+dl1.consistent());
		
	}
}
