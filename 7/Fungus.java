class Fungus implements Runnable {
	private Playground playground;
	private int prolifNum; /** Zwischen 1 und 32 */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	
	public Fungus(Playground playground, Box container, int prolifNum) {
		this.playground = playground;
		this.container = container;
		this.prolifNum = prolifNum;
	}
		
	@Override
	public void run() {
		
	}
}
