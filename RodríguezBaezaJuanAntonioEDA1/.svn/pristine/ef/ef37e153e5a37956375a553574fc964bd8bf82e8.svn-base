package org.eda1.estructurasdedatos;

public interface BinarySearchTree<T> {

	/**
	 * Adds the specified item to this tree if it is not already present.
	 *
	 * @param item element to be added to this tree.
	 * @return <tt>true</tt> if the tree did not already contain the specified
	 *         element.
	 */
	public abstract boolean add(T item);

	/**
	 * Removes all of the elements from this tree. The resulting tree is empty
	 * after the method executes.
	 */
	public abstract void clear();

	/**
	 * Returns <tt>true</tt> if this tree contains the specified element.
	 *
	 * @param item the object to be checked for containment in this tree.
	 * @return <tt>true</tt> if this tree contains the specified element.
	 */
	public abstract boolean contains(Object item);

	/**
	 * Returns <tt>true</tt> if this tree contains no elements.
	 *
	 * @return <tt>true</tt> if this tree contains no elements.
	 */
	public abstract boolean isEmpty();

	/**
	 * Returns an iterator over the elements in this tree.  The elements
	 * are returned in ascending order.
	 *
	 * @return an iterator over the elements in this tree.
	 */
	public abstract Iterator<T> iterator();

	/**
	 * Removes the specified item from this tree if it is present.
	 *
	 * @param item object to be removed from this tree, if present.
	 * @return <tt>true</tt> if the tree contained the specified element.
	 */
	public abstract boolean remove(Object item);

	/**
	 * Returns the number of elements in this tree.
	 *
	 * @return the number of elements in this tree.
	 */
	public abstract int size();
	
	/**
	 * Searches for the specified item in the tree and returns
	 * the value of the node that matches item as a key.
	 *
	 * @param   item   serves as a key to locate an element in the tree..
	 * @return  the value of the node that corresponds to item as a key
	 *          or <tt>null</tt> if the element is not found.
	 */
	public T find(T item);


}