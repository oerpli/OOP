public class Test {

	public static void main(String[] args) {
		String file = "package Parser;" + '\n' + "public class Parser {" + '\n'
				+ "	public String state = null;" + '\n' + '\n'
				+ "	public Document parse(/* bla */final String document) {"
				+ '\n' + "		String bla = \"/* bla */\";" + '\n'
				+ "		return null;" + '\n' + "	}" + '\n' + "}";
		// System.out.println(file);

		Copyrighter c = new Copyrighter();
		Copyrighter.addAuthor("bla");
		Copyrighter.addAuthor("blu");
		System.out.println(c.pretty(file));
	}
}
