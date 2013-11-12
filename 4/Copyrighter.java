import java.util.ArrayList;

public class Copyrighter extends Adder {

	private String text; // welcher Text wird von changeText verändert?
	private String info;
	private String date;
	private ArrayList<String> authors;
	
	public Copyrighter(String info, String date) {
	
		this.authors = new ArrayList<String>();
		this.info = info;
		this.date = date;
		
		updateText();
	}

	public void changeInfo(String info) {
	
		this.info = info;
		updateText();
	}
	
	public void changeDate(String date) {
	
		this.date = date;
		updateText();
	}

	public void addAuthor(String author) {
	
		authors.add(author);
		updateText();
	}

	public void removeAuthor(String author) {
	
		authors.remove(author);
		updateText();
	}
	
	private void updateText() { // Strings auf null überprüfen?
	
		String result = info;
		
		if (authors.size() > 0) {
			result += System.getProperty("line.separator");
			result += "@author ";
		}
		
		for (String s: authors) {
			result += (s + ", ");
		}
		
		if (authors.size() > 0) result = substring(0, result.length() - 2);
		
		if (date != "") {
			result += System.getProperty("line.separator");
			result += date;
		}
		
		changeText(result);
	}
	
	/*
	public void changeText(String text) {
	
		this.text = text;
	}
	*/
	
	/*
	 * Result corresponds to the Java program in prog, but with more comments.
	 * This method has no side-effects.
	 * Nachbedingung -> Nachbedingung im Untertyp strenger.
	 */
	@Override
	public String pretty(String prog) {
	
		if (text == null || text.equals(""))
			return prog;
	
		Code code = new Code(prog);
		Comment comment = new Comment(text, true);
		
		code.addLine(0, comment.toString());
		
		return code.toString();
	}
}
