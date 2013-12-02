package lager;

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
		assert l != null;
		return l.store18(this);
	}
}
