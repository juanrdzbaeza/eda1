/*
 * @(#)Collection.java
 */

package org.eda1.actividad03.BSTree
;


/**
 * The root interface in the collection hierarchy. A collection represents a group
 * of objects, known as its elements. Some collections allow duplicate elements and
 * others do not. Some are ordered and others unordered. A <i>bag</i> is the model
 * for a Collection data structure.<p>
 * Most collection classes that implement Collection, implement more specific
 * subinterfaces like Set and List.
 * @see	    Set
 * @see	    List
 * @see	    Bag
 */

public interface Collection<T> extends Iterable<T>
{
     /**
     * Ensures that this collection contains the specified element.
     * Returns <tt>true</tt> if the operation inserts a new element in this
     * collection.Returns <tt>false</tt> if this collection already contains
     * the specified element and does not permit duplicates.
     *
     * @param item element that must occur at least once in this collection.
     * @return <tt>true</tt> if this collection is modified.
     *
     */
    boolean add(T item);

    /**
     * Removes all of the elements from this collection.
     * This collection will be empty after this method returns.
     */
    void clear();


    /**
     * Returns <tt>true</tt> if this collection contains the specified
     * element and false otherwise.
     *
     * @param item element whose occurrence in the collection is checked
     * @return <tt>true</tt> if this collection contains the specified
     *         element
     */
    boolean contains(Object item);

     /**
     * Returns <tt>true</tt> if this collection contains no elements.
     *
     * @return <tt>true</tt> if this collection contains no elements.
     */
    boolean isEmpty();

	  /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an <tt>Iterator</tt> over the elements in this collection
     */
    Iterator<T> iterator();

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present; Returns <tt>true</tt> if this collection is
     * modified.
     *
     * @param item element to be removed from this collection, if present.
     * @return <tt>true</tt> if this collection is modified
     */
    boolean remove(Object item);


	  /**
		* Returns the number of elements in this collection.
		*
		* @return the number of elements in this collection
		*/
	  int size();

    /**
     * Returns an array containing all of the elements in this collection.
     * This allows array operations with a collection
     *
     * @return an array containing all of the elements in this collection
     */
    Object[] toArray();
}