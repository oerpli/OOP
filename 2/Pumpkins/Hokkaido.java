package Pumpkins;

import Main.Pumpkin;

public class Hokkaido extends Pumpkin {
	public Hokkaido() {
		super(0.3, 0.5, 100);
	}

	@Override
	public Pumpkin returnNew() {
		return new Hokkaido();
	}
}
