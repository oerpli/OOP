package OOP5;
public class CharCategory extends Category<Character> {
	private char zeichen;

	public CharCategory(char zeichen) {
		this.zeichen = zeichen;
	}

	public String toString() {
		return "" + zeichen;
	}

	private char getChar() {
		return this.zeichen;
	}

	@Override
	protected boolean uncheckedDependsOn(Category<?> y) {
		char zeichen1 = ((CharCategory) y).getChar();
		if (this.getChar() == zeichen1)
			return true;
		return false;
	}

	@Override
	public boolean dependsOn(Character element) {
		return false;

	}

}