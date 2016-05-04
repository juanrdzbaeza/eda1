/*
 * @(#)Less.java
 */

package org.eda1.utilidades;

import java.util.Comparator;


/**
 * A Comparator that imposes a <tt>total ordering</tt> on objects that implement
 * <tt>Comparable</tt>; the comparison is the &quot&lt&quot relation where
 * the ordering of elements proceeds from smaller to larger.
 * An instance can be passed to
 * the <tt>Arrays.sort</tt> method to order the array in ascending order.  The instance
 * passed to the <tt>Heaps.heapsort</tt> method orders the array in descending order.
 * Create a minimum heap by calling the <tt>HeapPQueue</tt> class constructor with an
 * instance of Less as the Comparator argument.
 */

public class Less<T> implements Comparator<T>
{
    /**
     * Compares its two arguments by using the <tt>compareTo</tt> ordering.
     * for the argument type. The return value for <tt>compare</tt> is a negative,
     * integer, zero, or a positive integer indicating that the first argument is
     * less than, equal to, or greater than the second argument. Throws a
     * <tt>ClassCastException</tt> if the arguments are not comparable.
     *
     * @param x the first object to be compared.
     * @param y the second object to be compared.
     * @return  a negative, zero, or a positive integer indicating that the first
     *          argument is less than, equal to, or greater than the second argument
     * @throws   <tt>ClassCastException</tt> if the arguments are not comparable.
     */
   public int compare(T x, T y)
   {
      return ((Comparable<T>)x).compareTo(y);
   }
}
