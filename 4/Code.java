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

	public int size() {
		return lines.size();
	}

	public void addLine(int index, String text) {
		lines.add(index, text); // Achtung! Die eingefügte Zeile kann
								// Zeilenumbrüche enthalten!
	}

	/*
	 * / Searches all lines for the specified pattern and returns within an
	 * array the indexes where the pattern is found in regular code.
	 */
	public ArrayList<Integer> search(String pattern) {
		int comment = -1, commentend = -1;
		ArrayList<Integer> matched = new ArrayList<Integer>();
		if (pattern == null || pattern.equals(""))
			return matched;
		else {
			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);
				// mehrzeilige kommentare
				comment = line.indexOf("/*");
				if (line.substring(comment).indexOf("*/") == -1) {
					comment = 0;
					continue;
				} else {
					line = line.substring(comment, commentend);
					commentend = -1;
					comment = -1;
				}
				//
				int pat = lines.indexOf(pattern);
				if (pat >= 0) {
					if (countChar('"', line.substring(0, pat)) % 2 == 0)
						if (line.indexOf("//") < 0 || line.indexOf("//") > pat)
							matched.add(i);
				}
			}
		}
		return matched;
	}

	private int countChar(char c, String s) {
		int i = 0;
		for (char x : s.toCharArray()) {
			if (x == c)
				i++;
		}
		return i;
	}

	/*
	 * Erases all comments from the line with the specified index. Returns true
	 * if the line ends on an open comment.
	 */
	public boolean eraseComment(int index) {
		if (index < 0 || index >= lines.size())
			return false;
		String line = lines.get(index);
		int oldCoSt = line.indexOf("//");
		if (oldCoSt != -1) {
			lines.set(index, line.substring(0, oldCoSt));
			return false;
		}
		int newCoSt = line.indexOf("/*");
		int newCoEnd = line.indexOf("*/");
		String newLine = "";
		if (newCoSt != -1) {
			newLine = line.substring(0, newCoSt);
			if (newCoEnd != -1) {
				newLine += line.substring(newCoEnd + 2, line.length());
			}
			lines.set(index, newLine);
		}
		return false;
	}

	/*
	 * Returns the text of a comment within the specified line.
	 */
	public String getComment(int index) {
		return null;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < lines.size(); i++) {
			result += lines.get(i);
			result += System.getProperty("line.separator");
		}
		return result;
	}
}
