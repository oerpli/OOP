public class Code {

	private ArrayList<String> lines;
	
	Code(String text) {
	
		lines = new ArrayList<String>();
		
		String[] separated = text.split(System.getProperty("line.separator"));
		
		for (int i = 0; i < separated.length; i++) {
			lines.add(separated[i]);
		}
	}
	
	public int size()
	{
		return lines.size();
	}
	
	public void addLine(int index, String text)
	{
		lines.add(index, text);
	}
	
	/*
	 * Searches all lines for the specified pattern and returns
	 * the indexes where the pattern is found in regular code within an array.
	 */
	public int[] search(String pattern)
	{
		int[] result;
		
		if (pattern == null || pattern.equals("")) return result;
		
		// TODO: alle Zeilen in denen pattern nicht als Kommentar vorkommt finden.
		
		return result;
	}
	
	public void toString()
	{
		String result = "";
	
		for (int i = 0; i < lines.size(); i++) {
			result += lines.get(i);
		}
		
		return result;
	}
}
