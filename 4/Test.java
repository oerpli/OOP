public class Test {

	public static void main(String[] args) {
	
		// Teste Comment Klasse
		String comTest = "Hallo Welt";
		System.out.println(Comment.format(comTest, true)); // modern
		System.out.println(Comment.format(comTest, false)); // alt
		comTest += System.getProperty("line.separator");
		comTest += "Servus Welt";
		System.out.println(Comment.format(comTest, false)); // mehrzeilig
		
		// Teste Code Klasse
		String codeTest = "package Parser;" + '\n' + "public class Parser {" + '\n'
				+ "	public String state = null;" + '\n' + '\n'
				+ "	public Document parse(/* bla */final String document) {"
				+ '\n' + "		String bla = \"/* bla */\";" + '\n'
				+ "		return null;" + '\n' + "	}" + '\n' + "}";
		Code code = new Code(codeTest);
		System.out.println(code.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
