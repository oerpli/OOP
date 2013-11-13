import java.util.ArrayList;
import java.util.Scanner;

public class Comment {
	private ArrayList<String> lines;
	private boolean style;
	private Scanner scanner;
	Comment(String text, boolean style) {
		lines = new ArrayList<String>();
		this.style = style;

		System.out.println(text);
		scanner=new Scanner(text);
		while(scanner.hasNext()){
			lines.add(scanner.nextLine());
		}
		scanner.close();
	}

	@Override
	public String toString() {
		if (lines.size() > 1) {
			lines.add(0, "/*");
			for (int i = 1; i < lines.size(); i++) {
				lines.set(i, " * " + lines.get(i));
			}
			lines.add(" */");
		} else if (style) {
			lines.set(0, "/* " + lines.get(0) + " */");
		} else {
			lines.set(0, "// " + lines.get(0));
		}
		String result = "";
		for (int i = 0; i < lines.size(); i++) {
			result += lines.get(i);
			result += System.getProperty("line.separator");
		}
		return result;
	}

	public static String format(String text, boolean style) {
		Comment c = new Comment(text, style);
		return c.toString();
	}
}
