package OOP5;

import java.util.Iterator;

public class DList<A extends Dependent<? super A>, B> extends AList<A, B> {

	public boolean dependsOn(A element) {

		return this.dependsOn(element);

	}

	public boolean consistent() {
		Iterator<A> iter = this.iterator();
		Iterator<A> iter1 = this.iterator();
		Boolean bool;
		A f = null;
		for (int i = 0; i < this.size(); i++) {
			if(iter1.hasNext()) f=iter1.next();
			while (iter.hasNext()) {
				A k = iter.next();
				if(k.dependsOn(f)) return false;
			}
		}
		return true;

	}

}
