import java.util.ArrayList;

public class Comment {

	private ArrayList<String> Lines;
	private boolean style;
	
	Comment(String text, boolean style) {
	
		Lines = new ArrayList<String>();
		this.style = stlye;
		
		String[] separated = text.split(System.getProperty("line.separator"));
		
		for (int i = 0; i < separated.length; i++) {
			Lines.add(separated[i]);
		}
	}
	
	@Override
	public String toString()
	{
	
		String result;
	
		if (style)
		{
			// Gibt Kommentar in moderner Form zurück
		}
		else
		{
			// Gibt Kommentar in alter Form zurück
			// Mehrzeilige Kommentare werden immer in moderner Form zurückgegeben
		}
	}
	
	public static String format(String text, boolean style) {
	
		Comment c = new Comment(text, style);
		return c.toString();
	}
}
