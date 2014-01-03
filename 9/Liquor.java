class Liquor {
	private String name;
	private float alcByVol;
	private int volume; // Milliliter
	
	public Liquor(String name, float AbV, int volume) {
		
	}
	
	public String getName() {
		return name;
	}
	
	public float getAbV() {
		return alcByVol;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void consum(int volume) {
		this.volume -= volume;
	}
}
