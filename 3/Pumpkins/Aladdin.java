package Pumpkins;

import Main.Pumpkin;

public class Aladdin extends Pumpkin {

	public Aladdin() {
		super(0.1, 0.4, 120, 0.02);
	}

	public Pumpkin returnNew() {
		return new Aladdin();
	}

	@Override
	protected void rot(double ferti) {
		//Aladdins dont rot.
	}
}
