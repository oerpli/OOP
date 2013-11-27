package OOP5;

import java.util.Iterator;

public class DList<A extends Dependent<? super A>, B> extends AList<A, B> {

	public boolean dependsOn(A element) {

		return this.dependsOn(element);

	}

	public boolean consistent() {
		Iterator<A> iter = this.iterator();
		Boolean bool=true;
		Boolean bool1=false;
		Boolean bool2=false;
		A f = null;
		A k = null;
		for (int i = 0; i < this.size(); i++) {
			bool1=false;
			if(iter.hasNext()) f=iter.next() ;
					else break;
			Iterator<A> iter1 = this.iterator();
			if(iter1.hasNext())k=iter1.next(); 
			while(true){
				if(!(k.equals(f))&&!bool1&&iter1.hasNext()) k=iter1.next();
				else if(k.equals(f)&&!bool1) {
					bool1=true;
					if(iter1.hasNext())k=iter1.next();
				}
				else if(!(k.equals(f))&&bool1) break;
				else if(k.equals(f)&&bool1&&!iter1.hasNext()){
					bool2=true;
					break;
				};
			}
			if(!bool2){
			if(f.dependsOn(k)) return false;
			
			while (iter1.hasNext()) {
				k = iter1.next();
				if(f.dependsOn(k)) return false;
			}
			}
		}
		return true;

	}


}
