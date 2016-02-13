package kael.jea.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.RandomAccess;

/**
 * This is a simple class-wrapper for {@link ArrayList} , used to only get
 * elements from collection.
 * 
 * @author Kael
 * @since JEA1.0
 * @param <T>
 * @see java.util.ArrayList
 */
public class ReadOnlyArrayList<T> implements Iterable<T>, RandomAccess {
	/**
	 * Creates a instance of {@link ReadOnlyArrayList} with prepared
	 * {@link ArrayList} as input parameter.
	 * 
	 * @param prepeared
	 *            {@link ArrayList}
	 */
	public ReadOnlyArrayList(ArrayList<T> list) {
		this.list = list;
	}

	/**
	 * Creates empty instance of {@link ReadOnlyArrayList}
	 */
	public ReadOnlyArrayList() {
		this.list = new ArrayList<>(0);
	}

	private ArrayList<T> list;

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 *             - if the index is out of range (index < 0 || index >= size())
	 * @see ArrayList
	 */
	public T get(int index) {
		return list.get(index);
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 * @see ArrayList
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More
	 * formally, returns <tt>true</tt> if and only if this list contains at
	 * least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o
	 *            element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 * @see ArrayList
	 */
	public boolean contains(Object o) {
		return list.contains(o);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 * @see ArrayList
	 */
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return list.toString();
	}
}
