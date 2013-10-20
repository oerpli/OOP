package Pumpkins;

import Main.Pumpkin;

public class Aladdin extends Pumpkin {

	public Aladdin() {
		super(400, 3, 120);
	}

	public Pumpkin returnNew() {
		return new Aladdin();
	}
}
