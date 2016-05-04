package org.eda1.actividad01.serializacionED;

 /**
 * An iterator for lists that allows the programmer
 * to traverse the list in either direction and modify
 * the list during iteration.
 */
public interface ListIterator<T> extends Iterator<T>
{
    /**
     * Returns <tt>true</tt> if this list iterator has more elements when
     * traversing the list in the reverse direction.  (In other words, returns
     * <tt>true</tt> if <tt>previous</tt> would return an element rather than
     * throwing an exception.)
     *
     * @return <tt>true</tt> if the list iterator has more elements when
     *	       traversing the list in the reverse direction.
     */
    boolean hasPrevious();

    /**
     * Returns the previous element in the list.  This method may be called
     * repeatedly to iterate through the list backwards, or intermixed with
     * calls to <tt>next</tt> to go back and forth.  (Note that alternating
     * calls to <tt>next</tt> and <tt>previous</tt> will return the same
     * element repeatedly.)
     *
     * @return the previous element in the list.
     *
     * @throws NoSuchElementException if the iteration has no previous
     *            element.
     */
    T previous();

    // Modification Operations

    /**
     * Replaces the last element returned by <tt>next</tt> or
     * <tt>previous</tt> with the specified element (optional operation).
     * This call can be made only if neither <tt>ListIterator.remove</tt> nor
     * <tt>ListIterator.add</tt> have been called after the last call to
     * <tt>next</tt> or <tt>previous</tt>.
     *
     * @param item the element with which to replace the last element returned by
     *          <tt>next</tt> or <tt>previous</tt>.
     */
    void set(T item);

    /**
     * Inserts the specified element into the list (optional operation).  The
     * element is inserted immediately before the next element that would be
     * returned by <tt>next</tt>, if any, and after the next element that
     * would be returned by <tt>previous</tt>, if any.  (If the list contains
     * no elements, the new element becomes the sole element on the list.)
     * The new element is inserted before the implicit cursor: a subsequent
     * call to <tt>next</tt> would be unaffected, and a subsequent call to
     * <tt>previous</tt> would return the new element.  (This call increases
     * by one the value that would be returned by a call to <tt>nextIndex</tt>
     * or <tt>previousIndex</tt>.)
     *
     * @param item the element to insert.
     */
    void add(T item);
}
