public aspect Counter {
	private int objects = 0;

	before() : initialization(*.new(..)) && !within(Counter){
		System.out.println(thisJoinPointStaticPart);
		objects++;
		System.out.println("pim");
	}

	after() : call(void Test.end()) && !within(Counter){
		System.out.println(thisJoinPointStaticPart);
		System.out.println("Seit dem letzten Aufruf von end() wurden " + objects + " Objekte erstellt");
		objects = 0;
	}
}