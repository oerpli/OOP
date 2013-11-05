public class Comment {

	private ArrayList<String> Lines;
	private boolean format;
	
	Comment(String text, boolean format) {
	
		Lines = new ArrayList<String>();
		this.format = format;
		
		String[] separated = text.split(System.getProperty("line.separator"));
		
		for (int i = 0; i < separated.length; i++) {
			Lines.add(separated[i]);
		}
	}
	
	public String toString()
	{
	
		String result;
	
		if (format)
		{
			// Gibt Kommentar in moderner Form zurück
		}
		else
		{
			// Gibt Kommentar in alter Form zurück
			// Mehrzeilige Kommentare werden immer in moderner Form zurückgegeben
		}
	}
}
