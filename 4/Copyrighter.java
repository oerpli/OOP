import java.util.ArrayList;
import java.util.Date;

/**
 * @author oerpli
 */
public class Copyrighter extends Adder implements Prettifier {
	public Copyrighter() {
		super(generateComment(), 0);
	}

	private static ArrayList<String> authors = new ArrayList<String>();
	private static String informationen = "Informationen und so";
	private static Date d = new Date();

	public static boolean changeInfos(final String infos) {
		informationen = infos;
		return true;
	}

	public static boolean addAuthor(final String author) {
		return authors.add(author);
	}

	public static boolean removeAuthor(final String author) {
		return authors.remove(author);
	}

	private static String formatAuthors() {
		String out = "@author ";
		for (String s : authors)
			out += s + ", ";
		return out.substring(0, out.length() - 2);
	}

	private static String generateComment() {
		String out = informationen;
		out += "\n" + formatAuthors();
		out += "\n" + d;
		return out;
	}
}
