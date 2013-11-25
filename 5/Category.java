public abstract class Category<T> implements Dependent<T> {
	
	public boolean dependsOn(Category y)
	  {
	    return (this.getClass() == y.getClass()) && uncheckedDependsOn(y);
	  }

	  protected abstract boolean uncheckedDependsOn(Category that);

}
