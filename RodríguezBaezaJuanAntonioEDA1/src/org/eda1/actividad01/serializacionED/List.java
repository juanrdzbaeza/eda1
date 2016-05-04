/*
 * @(#)List.java
 */

package org.eda1.actividad01.serializacionED;

/**
 * A collection of elements that are stored by position (also known as a <i>sequence</i>).
 * The first element is at position (index) 0. The interface extends the <tt>Collection</tt>
 * interface and gives the user control over where in the list each element is inserted.
 * The user can access elements at their position (index) in the list and and
 * search for elements in the list. Unlike sets, lists typically allow duplicate
 * elements. More formally, lists typically allow pairs of elements obj1 and obj2 such
 * that obj1.equals(obj2).<p>
 *
 * The general list <tt>add</tt> inserts an element at the end of the sequence
 * with duplicate elements allowed. The interface provides four methods for indexed
 * access to the elements. Their implementations in the <tt>LinkedList</tt> class
 * have running time O(n) and so should be used with caution. All methods that access
 * a position that is out of range (index &lt; 0 || index &gt;= size()) throw
 * IndexOutOfBoundsException. However, the indexed <tt>add</tt> method
 * can insert an element at index size() in the sequence.<p>
 *
 * The <tt>List</tt> interface provides a special iterator, called a
 * <tt>ListIterator</tt>, that allows element insertion and replacement, and
 * bidirectional access in addition to the normal operations that the
 * <tt>Iterator</tt> interface provides.  A method is provided to obtain a
 * list iterator that starts at a specified position in the list.<p>
 */

public interface List<T> extends Collection<T>
{
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    int size();

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this list contains the specified
     * element and false otherwise.
     *
     * @param item element whose occurrence in the collection is checked
     * @return <tt>true</tt> if this collection contains the specified
     *         element
     */
    boolean contains(Object item);

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence.
     */
    Iterator<T> iterator();

    /**
     * Returns an array containing all of the elements in this list.
     * This allows array operations with a list
     *
     * @return an array containing all of the elements in this list
     */
    Object[] toArray();


    /**
     * Appends the specified element at the end of this list
     *
     * @param item element to be appended to this list.
     * @return <tt>true</tt>
     *
     */
    boolean add(T item);

     /**
     * Removes a first instance of the specified element from this
     * list, if it is present, Return true if the list is modified
     * false otherwise..
     *
     * @param item element to be removed from this list, if present.
     * @return <tt>true</tt> if this list is modified
     */
    boolean remove(Object item);

    /**
     * Removes all of the elements from this list
     *
     */
    void clear();

    // Index Access Method

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index
     * 		  &lt; 0 || index &gt;= size()).
     */
    T get(int index);

    /**
     * Replaces the element at the specified index in this list with the
     * specified element
     *
     * @param index index of element to replace.
     * @param element element to be stored at the specified index.
     * @return the element previously at the specified index.
     *
     * @throws    IndexOutOfBoundsException if the index is out of range
     *		  (index &lt; 0 || index &gt;= size()).
     */
    T set(int index, T element);

    /**
     * Inserts the specified element at the specified index in this list
     *
     * @param index index at which the specified element is to be inserted.
     * @param item element to be inserted.
     *
     * @throws    IndexOutOfBoundsException if the index is out of range
     *		  (index &lt; 0 || index &gt; size()).
     */
    void add(int index, T item);

    /**
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to removed.
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index
     *            &lt; 0 || index &gt;= size()).
     */
    T remove(int index);


    /**
     * Returns the index in this list of the first occurrence of the specified
     * element, or -1 if this list does not contain this element.
     *
     * @param item element to search for.
     * @return the index in this list of the first occurrence of the specified
     * 	       element, or -1 if this list does not contain this element.
     */
    int indexOf(Object item);


    /**
     * Returns a list iterator of the elements in this list.
     *
     * @return a list iterator of the elements in this list.
     */
    ListIterator<T> listIterator();

    /**
     * Returns a list iterator of the elements in this list, starting at the
     * specified position in this list.  The index is the location of the
     * first element that would be returned by an initial call to the
     * <tt>next</tt> method.  An initial call to the <tt>previous</tt> method
     * would return the element at position index-1.
     *
     * @param index position of the first element to be returned from the
     *		    list iterator (by a call to the <tt>next</tt> method).
     * @return a list iterator of the elements in this list starting at
     *          the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range (index
     *         &lt; 0 || index &gt; size()).
     */
    ListIterator<T> listIterator(int index);
}
