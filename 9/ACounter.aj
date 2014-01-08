public aspect ACounter {
	private int objects = 0, prev = 0;
	after() : initialization(*.new(..)) && !within(ACounter){
		if (Test.debug)
			System.out.println(thisJoinPointStaticPart.toString());
		objects++;
	}

	before() : call(void Test.test()) && !within(ACounter){
		System.out.println("+++Counting starts here!+++");
		prev += objects;
		objects = 0;
	}

	after() : call(void Test.test()) && !within(ACounter){
		System.out.println("In diesem Aufruf von test() wurden " + objects
				+ " Objekte erstellt. Insgesamt " + prev + ".");
	}
}