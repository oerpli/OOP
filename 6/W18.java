public class W18 extends Ware {
	W18(String t) {
		super(t);
	}

	@Override
	protected void setT(int T) {
		if (T > -18) {
			this.verdorbenerfroren = true;
		}
	}
}
