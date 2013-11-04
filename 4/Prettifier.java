public interface Prettifier {
	String pretty(String prog);
	/*
	 * Result corresponds to the Java program in prog, but with more, less or
	 * prettier comments. This method has no side-effects.
	 */
}