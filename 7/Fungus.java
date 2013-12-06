class Fungus implements Runnable {
	private int prolifNum; /** Zwischen 1 und 32 */
	private Box container; /** Die Box in der sich das Bakterium befindet */
	
	public Fungus(Box container, int prolifNum) {
		this.container = container;
		this.prolifNum = prolifNum;
	}
		
	@Override
	public void run() {
		
	}
}
