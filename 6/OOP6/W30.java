package OOP6;

public class W30 extends Ware {
	public W30(String t) {
		super(t);
	}

	@Override
	protected void setT(int T) {
		if (T > -30) {
			this.verdorbenerfroren = true;
		}
	}

	@Override
	public int storeIn(Lager l) {
		assert l != null;
		return l.store(this, 0);
	}
}
