package Pretty;
import java.util.ArrayList;
import java.util.Date;

/**
 * Spezielle Form von Adder - da die in Adder verwendeten Funktionen hier aber
 * nicht anwendbar sind keine Vererbung von dort. Gemeinsamkeiten (das sind
 * recht wenige) in AddComment ausgelagert.
 * 
 * @author oerpli
 * 
 */
public class Copyrighter extends AddComment {

	private String info;
	private String date;
	private ArrayList<String> authors;

	public Copyrighter(String info, String date) {
		super("");
		this.authors = new ArrayList<String>();
		this.info = info;
		this.date = date;
		updateText();
	}

	public Copyrighter(String info) {
		super("");
		this.authors = new ArrayList<String>();
		this.info = info;
		this.date = new Date().toString();
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

	public void currentDate() {
		this.date = new Date().toString();
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

	private void updateText() { // string == null ueberpruefen?
		String result = info;
		if (authors.size() > 0) {
			result += System.getProperty("line.separator");
			result += "@author ";
		}
		for (String s : authors) {
			result += (s + ", ");
		}
		if (authors.size() > 0)
			result = result.substring(0, result.length() - 2);
		if (date != "") {
			result += System.getProperty("line.separator");
			result += date;
		}
		this.text = result;
	}
}
