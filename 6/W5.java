public class W5 extends Ware {
	public W5(String t) {
		super(t);
	}

	@Override
	protected void setT(int T) {
		if (T > 5 || T < 0) {
			this.verdorbenerfroren = true;
		}
	}
}
