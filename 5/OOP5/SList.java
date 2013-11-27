package OOP5;

import java.util.Iterator;

public class SList<E> implements Iterable<E> {
	protected int size = 0;

	/**
	 * Invariante: (first == null && last == null) || ((first.prev == null &&
	 * first.item != null)&&(last.next == null && last.item != null))
	 */
	protected Node<E> first;

	protected Node<E> last;

	public SList() {
	}

	protected void linkFirst(E e) {
		final Node<E> f = first;
		final Node<E> newNode = new Node<>(null, e, f);
		first = newNode;
		if (f == null)
			last = newNode;
		else
			f.prev = newNode;
		size++;
	}

	protected void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, e, null);
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
	protected void linkBefore(E e, Node<E> succ) {
		assert succ != null;
		final Node<E> pred = succ.prev;
		final Node<E> newNode = new Node<>(pred, e, succ);
		succ.prev = newNode;
		if (pred == null)
			first = newNode;
		else
			pred.next = newNode;
		size++;
	}

	/**
	 * Unlinks non-null first node f.
	 */
	private E unlinkFirst(Node<E> f) {
		assert f == first && f != null;
		final E element = f.item;
		final Node<E> next = f.next;
		first = next;
		if (next == null)
			last = null;
		else
			next.prev = null;
		size--;
		return element;
	}

	/**
	 * Unlinks non-null last node l.
	 */
	private E unlinkLast(Node<E> l) {
		assert l == last && l != null;
		final E element = l.item;
		final Node<E> prev = l.prev;
		last = prev;
		if (prev == null)
			first = null;
		else
			prev.next = null;
		size--;
		return element;
	}

	/**
	 * Unlinks non-null node x.
	 */
	private E unlink(Node<E> x) {
		assert x != null;
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
		}
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
		}
		size--;
		return element;
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 */
	public E removeFirst() {
		assert first != null;
		final Node<E> f = first;
		return unlinkFirst(f);
	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return the last element from this list
	 */
	public E removeLast() {
		assert last != null;
		final Node<E> l = last;
		return unlinkLast(l);
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * Returns the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	public E get(int index) {
		checkElementIndex(index);
		return node(index).item;
	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 */         
	public void add(int index, E element) {
		if (index == -1)
			linkLast(element);
		else if (index == 0) {
			linkFirst(element);
		} else
			linkBefore(element, node(index));
	}

	
	public boolean add(E e) {
		     linkLast(e);
		    return true;
		   }
	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 * 
	 * @param index
	 *            the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *           
	 */
	public E remove(int index) {
		checkElementIndex(index);
		return unlink(node(index));
	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	protected boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	/**
	 * Tells if the argument is the index of a valid position for an iterator or
	 * an add operation.
	 */
	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size;
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	protected void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * Returns the (non-null) Node at the specified element index.
	 */
	Node<E> node(int index) {
		assert isElementIndex(index);
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	protected static class Node<E> {
		E item;
		/**
		 * Invariante: Es gibt jeweils maximal 1 Node mit next == null und prev
		 * == null.
		 */
		Node<E> next, prev;

		Node(Node<E> prev, E element, Node<E> next) {
			assert item != null;
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}

	protected class Itr implements Iterator<E> {
		/**
		 * Index of element to be returned by subsequent call to next.
		 */
		int cursor = 0;

		/**
		 * Index of element returned by most recent call to next or previous.
		 * Reset to -1 if this element is deleted by a call to remove.
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
			SList.this.remove(lastRet);
			if (lastRet < cursor)
				cursor--;
			lastRet = -1;
		}
	}
}