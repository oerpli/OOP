import java.util.ArrayList;

public class Composer implements Prettifier {
	ArrayList<Prettifier> list;

	public Composer() {
		this.list = new ArrayList<Prettifier>();
	}

	public Composer(ArrayList<Prettifier> list) {
		this.list = list;
	}

	public boolean add(Prettifier elem, int i) {
		if (i <= list.size()) {
			list.add(i, elem);
			return true;
		} else
			return false;
	}

	public boolean remove(int index) {
		if (index < list.size()) {
			list.remove(index);
			return true;
		} else
			return false;
	}

	public String pretty(String prog) {
		String out = prog;
		for (Prettifier p : list)
			out = p.pretty(out);
		return out;
	}
}