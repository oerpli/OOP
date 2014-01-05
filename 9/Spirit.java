/**
 * Alkohol einer bestimmten Sorte. Speichert Name, Alkoholgehalt sowie
 * verf�gbare Menge.
 * 
 * @author oerpli
 * 
 */
class Spirit extends Ingredient {
	public final double vol;// da man mit ml rechnet vol

	protected Spirit(String N, double V) {
		super(N);
		assert V >= 0 && V < 1;
		this.vol = V;
	}
}