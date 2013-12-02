package OOP6;

public class W20 extends Ware {
	public W20(String t) {
		super(t);
	}

	@Override
	protected void setT(int T) {
		if (T < 0) {
			this.verdorbenerfroren = true;
		}
	}

	@Override
	public int storeIn(Lager l) {
		assert l != null;
		return l.store(this, 3);
	}
}
