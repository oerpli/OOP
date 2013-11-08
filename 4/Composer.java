public class Composer implements Prettifier {

	private ArrayList<Prettifier> list;
	
	public void add(Prettifier prettifier) {
	
		list.add(prettifier);
	}
	
	public void add(int index, Prettifier prettifier) {
	
		list.add(index, prettifier);
	}
	
	public void remove(int index) {
	
		list.remove(index);
	}

	/*
	 * Result corresponds to the Java program in prog, but with more, less or
	 * prettier comments. This method has no side-effects.
	 */
	@Override
	public String pretty(String prog) {
	
		
		
		return null;
	}
}
