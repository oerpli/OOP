public class CharCategory<T> extends Category<T> {
	
	private char zeichen;
	
	public CharCategory(char zeichen){
		this.zeichen=zeichen;
	}
	protected boolean uncheckedDependsOn(Category that)
	  {
	    char zeichen1=((CharCategory)that).getChar();
	    if(this.getChar()==zeichen1)return true;
		return false;
	  }

	@Override
	public boolean dependsOn(T element) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString()
	{
		return ""+zeichen;
	}
	
	private char getChar(){
		return this.zeichen;
	}
	

}