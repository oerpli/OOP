package Pumpkins;

import Main.Pumpkin;

public class Hokkaido extends Pumpkin {
	public Hokkaido() {
		super(0.1, 0.5, 100, 0.025);
	}

	@Override
	public Pumpkin returnNew() {
		return new Hokkaido();
	}
}
