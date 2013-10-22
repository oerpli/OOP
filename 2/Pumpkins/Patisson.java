package Pumpkins;

import Main.Pumpkin;

public class Patisson extends Pumpkin {
	public Patisson() {
		super(0.05, 0.4, 100);
	}

	@Override
	public Pumpkin returnNew() {
		return new Patisson();
	}
}
