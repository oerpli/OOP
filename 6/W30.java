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
}
