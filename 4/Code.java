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
		int[] result;
		
		if (pattern == null || pattern.equals("")) return result;
		
		// TODO: alle Zeilen in denen pattern nicht als Kommentar vorkommt finden.
		
		return result;
	}
	
	/*
	 * Erases all comments from the line with the specified index.
	 */
	public void eraseComment(int index)
	{
		// TODO: alle Kommentare aus dieser Zeile löschen.
	}
	
	@Override
	public void toString()
	{
		String result = "";
	
		for (int i = 0; i < lines.size(); i++) {
			result += lines.get(i);
		}
		
		return result;
	}
}
