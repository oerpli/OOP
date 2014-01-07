public aspect ACounter {
	private int objects = 0, prev = 0;

	// private Hashtable<Class, Integer> counters = new Hashtable<>();
	//
	// protected void incCounter(Class c) {
	// counters.put(c, new Integer(getCount(c) + 1));
	// }
	//
	// public Integer getCount(Class c) {
	// Integer count = counters.get(c);
	// return (count == null) ? 0 : count.intValue();
	// }
	//
	// protected void incCounters(Class c) {
	// incCounter(c);
	// }

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