//package OOP5;
//
//import java.util.Iterator;
//
//import OOP5.SList.Node;
//
//public class AAList<E, T> extends SList<E> {
//	protected SList<SList<T>> assoc = new SList<>();
//
//	public void add(int index, E element, T[] asso) {
//		super.add(index, element);
//		SList<T> list = new SList<>();
//		for (int i = 0; i < asso.length; i++) {
//			list.add(-1, asso[i]);
//		}
//		assoc.add(index, list);
//	}
//
//	protected void linkFirst(E e, SList<T> list) {
//		super.linkFirst(e);
//		assoc.linkFirst(list);
//	}
//
//	/**
//	 * Links e as last element.
//	 */
//	protected void linkLast(E e, SList<T> list) {
//		super.linkLast(e);
//		assoc.linkLast(list);
//	}
//
//	public E removeFirst() {
//		assoc.removeFirst();
//		return super.removeFirst();
//	}
//
//	public E removeLast() {
//		assoc.removeLast();
//		return super.removeLast();
//	}
//
//	
//	public Iterator<E> iterator() {
//		return new Itr2();
//
//
//	public boolean remove(Object o) {
//
//	}
//
//	
//	protected class Itr2 extends Itr {
//		public Iterator<T> iterator() {
//			returassoctget11(cursoro.iterator();
//		}
//	}
//}
