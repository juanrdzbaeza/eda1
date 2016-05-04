package org.eda1.estructurasdedatos;

/**
 * An iterator is a generalized object to scan a collection.  Successive calls to the
 * <code>next</code> method return successive elements from the collection.
 */
public interface Iterator<T> extends java.util.Iterator<T>
{
    /**
     * Returns <tt>true</tt> if the iteration has more elements.
     *
     * @return <tt>true</tt> if the iterator has more elements.
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @throws NoSuchElementException if the iteration has no more elements.
     */
    T next();

    // To return the current element in the iteration
    T current();

    /**
     *
     * Removes from the underlying collection the last element returned by the
     * iterator.  This method can be called only after a call to <tt>next</tt>
     * has occurred.
     *
     * @throws IllegalStateException if the <tt>next</tt> method has not
     *		  yet been called, or the <tt>remove</tt> method has already
     *		  been called after the last call to the <tt>next</tt>
     *		  method.
     */
    void remove();
}
