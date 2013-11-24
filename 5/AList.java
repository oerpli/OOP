import java.util.Iterator;


public class AList<E,T> extends SList<E> {
	 
	 transient Node<E,T> first;

	 transient Node<E,T> last;
	 
	    public void add(int index, E element,T[] asso) {
	    	
	    	SList<T> List = new SList<T>();
	    	
	    	for(int i=0;i < asso.length;i++)
	    	{
	    		List.add(asso[i]);	    		
	    	}
	        if (index == -1)
	            linkLast(element,List);
	        else if(index == 0)
	        {
	        	linkFirst(element,List);
	        }
	        else
	            linkBefore(element,List, node1(index));
	    }
	    
	    protected void linkFirst(E e,SList<T> list) {
	        final Node<E,T> f = first;
	        final Node<E,T> newNode = new Node<>(null, e, list, f);
	        first = newNode;
	        if (f == null)
	            last = newNode;
	        else
	            f.prev = newNode;
	        size++;
	    }

	    /**
	     * Links e as last element.
	     */
	    void linkLast(E e,SList<T> list) {
	        final Node<E,T> l = last;
	        final Node<E,T> newNode = new Node<>(l, e, list, null);
	        last = newNode;
	        if (l == null)
	            first = newNode;
	        else
	            l.next = newNode;
	        size++;
	    }

	    /**
	     * Inserts element e before non-null Node succ.
	     */
	    void linkBefore(E e,SList<T> list, Node<E,T> succ) {
	        // assert succ != null;
	        final Node<E,T> pred = succ.prev;
	        final Node<E,T> newNode = new Node<>(pred, e, list, succ);
	        succ.prev = newNode;
	        if (pred == null)
	            first = newNode;
	        else
	            pred.next = newNode;
	        size++;
	    }
	    Node<E,T> node1(int index) {
	        // assert isElementIndex(index);

	        if (index < (size >> 1)) {
	            Node<E,T> x = first;
	            for (int i = 0; i < index; i++)
	                x = x.next;
	            return x;
	        } else {
	            Node<E,T> x = last;
	            for (int i = size - 1; i > index; i--)
	                x = x.prev;
	            return x;
	        }
	    }

		 private static class Node<E,T> {
		        E item;
		        SList<T> asso;
		        Node<E,T> next;
		        Node<E,T> prev;

		        Node(Node<E,T> prev, E element,SList<T> asso, Node<E,T> next) {
		            this.item = element;
		            this.asso = asso;
		            this.next = next;
		            this.prev = prev;
		        }
		        
		        public SList<T> getAsso(){
		        	return asso;
		        }
		    }
		 @Override
			public Iterator<E> iterator() {
				return new Itr();
			}
			
			private class Itr implements Iterator<E> {
		        /**
		         * Index of element to be returned by subsequent call to next.
		         */
		        int cursor = 0;

		        /**
		         * Index of element returned by most recent call to next or
		         * previous.  Reset to -1 if this element is deleted by a call
		         * to remove.
		         */
		        int lastRet = -1;

		        public boolean hasNext() {
		            return cursor != size();
		        }

		        public E next() {
		            	int i = cursor;
		                E next = get(i);
		                lastRet = i;
		                cursor = i + 1;
		                return next;
		            }

		        public void remove() {
		                AList.this.remove(lastRet);
		                if (lastRet < cursor)
		                    cursor--;
		                lastRet = -1;
		                
		        }
		        
		        public Iterator<E> iterator(){ 
		        	return Node.this.getAsso().iterator();
					//return new Itr();
				}
			}
			
}
