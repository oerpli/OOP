import java.util.ArrayList;

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
		lines.add(index, text); // Achtung! Die eingefügte Zeile kann Zeilenumbrüche enthalten!
	}
	
	/*
	 * Searches all lines for the specified pattern and returns within an array
	 * the indexes where the pattern is found in regular code.
	 */
	public int[] search(String pattern)
	{
		int[] result = new int[0];
		
		if (pattern == null || pattern.equals("")) return result;
		
		// TODO: alle Zeilen in denen pattern nicht als Kommentar vorkommt finden.
		
		return result;
	}
	
	/*
	 * Erases all comments from the line with the specified index.
	 * Returns true if the line ends on an open comment.
	 */
	public boolean eraseComment(int index)
	{
		if (index < 0 || index >= lines.size()) return false;
		 
		line = lines.get(index);
		
		int oldCoSt = line.indexOf("//");
		if (oldCoSt != -1)
		{
			lines.set(index, line.substring(0, oldCoSt));
			return false;
		}
			
		int newCoSt = line.indexOf("/*");
		String newLine = "";
		if (newCoSt != -1)
		{
			newLine = line.substring(0, newCoSt));
			
			lines.set(index, newLine);
		}
		
		return false;
	}
	
	/*
	 * Returns the text of a comment within the specified line.
	 */
	public String getComment(int index)
	{
		
	}
	
	@Override
	public String toString()
	{
		String result = "";
	
		for (int i = 0; i < lines.size(); i++) {
			result += lines.get(i);
			result += System.getProperty("line.separator");
		}
		
		return result;
	}
}
