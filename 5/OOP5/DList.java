package OOP5;

import java.util.Iterator;

public class DList<A extends Dependent<? super A>, B> extends AList<A, B> {

	public boolean dependsOn(A element) {

		return this.dependsOn(element);

	}

	public boolean consistent() {
		Iterator<A> iter = this.iterator();
		Boolean bool;
		for (int i = 0; i < this.size(); i++) {
			iter.next();
			//while (iter.hasNext()) {
			//	A k = iter.next();
			//	bool=k.dependsOn(f);
			//	if(bool==true) return false;
			//}
		}
		return true;

	}

}
