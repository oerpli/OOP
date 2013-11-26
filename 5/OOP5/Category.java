package OOP5;
public abstract class Category implements Dependent<Category> {
	/**
	 * Invariante: used >= 0;
	 */
	private int used = 0;

	public int uses() {
		assert used >= 0;
		return used;
	}

	public boolean dependsOn(Category y) {
		this.used++;
		y.used++;
		return (this.getClass() == y.getClass()) && this.uncheckedDependsOn(y);
	}
	protected abstract boolean uncheckedDependsOn(Category that);
}
