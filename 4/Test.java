/*
 * AltPurifier ist kein Untertyp von DeepPurifier, auch wenn
 * die Zusicherungen bezgl. pretty(String) es erlauben würden.
 * DeepPurifier.changeIndent(int) mit der Nachbedingung würde
 * nicht zu der Beschreibung von AltPurifier aus der Angabe passen.
 * In die andere Richtung gibt es zwar das changeIndent Problem nicht,
 * aber pretty würde unvorhersehbares Verhalten aufweisen.
 */

/*
 * Purifier ist ein Untertyp von AltPurifier, da die Nachbedingungen
 * bezgl. pretty(String) die gleichen oder strenger sind. Der Konstruktor
 * wird nicht vererbt, ebenso die private Variable.
 * In die andere Richtung würde pretty unvorhersehbares Verhalten aufweisen.
 */

/*
 * Stripper ist ein Untertyp von Eraser, da die Nachbedingung "no comments"
 * strenger ist als "less comments". Kronstruktor und private wird nicht vererbt.
 */

/*
 * Copyrighter ist ein Untertyp von Adder, da die Nachbedingungen
 * bezgl. pretty(String) die gleichen sind. Die Methode changeComment
 * wird vererbt und hat auch die gleichen Nachbedingungen. Die Beschreibung
 * erlaubt das: "Weitere Methoden [...] können auch vorhanden sein."
 */

public class Test {

	public static void main(String[] args) {

		// Test Comment Klasse
		String comTest = "Hallo Welt";
		System.out.println(Comment.format(comTest, true)); // modern
		System.out.println(Comment.format(comTest, false)); // alt
		comTest += System.getProperty("line.separator");
		comTest += "Servus Welt";
		System.out.println(Comment.format(comTest, false)); // mehrzeilig

		// Test Code Klasse
		String codeTest = "//Kommentar" + '\n' + "package Parser;" + '\n'
				+ "public class Parser {" + '\n'
				+ "	public String state = null;" + '\n' + '\n'
				+ "	public Document parse(/* bla */final String document) {"
				+ '\n' + "		String bla = \"/* \n bla */\";" + '\n'
				+ "		return null;" + '\n' + "	}" + '\n' + "}";
		Code code = new Code(codeTest);
		System.out.println(code.toString());
		System.out.println(code.search("bla"));
		// Test Copyrighter
		Copyrighter pretty = new Copyrighter("Copyright 2013", "11.11.2013");
		pretty.currentDate();
		pretty.addAuthor("Max Mustermann");
		pretty.addAuthor("Lisa Musterfrau");
		System.out.println(pretty.pretty(codeTest));

		// Test Adder, Copyrighter Untertypbeziehung (AddComment)
		AddComment addcomment = new Adder("Bottom Information", false);
		// adder.changeText("Bottom Information Changed");
		System.out.println(addcomment.pretty(codeTest));

		addcomment = new Copyrighter("Copyright 2013", "11.11.2013");
		// adder.changeText("Information Changed, unknown place");
		System.out.println(addcomment.pretty(codeTest));

		// Test Strippe
		System.out.println("Stripper & Eraser");

		Stripper stripper = new Stripper();
		System.out.println(stripper.pretty(codeTest));

		// Test Eraser und Ersetzbarkeit

		Eraser eraser = new Eraser(true);
		System.out.println(eraser.pretty(codeTest));

		eraser = new Stripper();
		System.out.println(eraser.pretty(codeTest));

		// Test Purifier
		Purifier purifier = new Purifier();
		System.out.println("Purifier");
		System.out.println(purifier.pretty(codeTest));

		// Test AltPurifier und Ersetzbarkeit
		System.out.println("AltPurifier");
		AltPurifier altPurifier = new AltPurifier(1);
		System.out.println(altPurifier.pretty(codeTest));

		altPurifier = new Purifier();
		System.out.println(altPurifier.pretty(codeTest));
	}
}
