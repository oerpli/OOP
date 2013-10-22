package Pumpkins;

import Main.Pumpkin;

public class Aladdin extends Pumpkin {

	public Aladdin() {
		super(0.2, 0.4, 120);
	}

	public Pumpkin returnNew() {
		return new Aladdin();
	}
}
