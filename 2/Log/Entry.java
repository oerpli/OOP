package Log;

public class Entry {
	String finish;

	public Entry(String s) {
		this.finish = s;
	}

	public Entry() {
		this.finish = "";
	}

	public String toString() {
		return this.finish;
	}
}
