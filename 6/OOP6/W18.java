package OOP6;

public class W18 extends Ware {
	public W18(String t) {
		super(t);
	}

	@Override
	protected void setT(int T) {
		if (T > -18) {
			this.verdorbenerfroren = true;
		}
	}

	@Override
	public int storeIn(Lager l) {
		return l.store(this, 1);
	}
}
