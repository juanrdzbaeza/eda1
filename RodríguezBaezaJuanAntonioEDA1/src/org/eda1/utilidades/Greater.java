/*
 * @(#)Greater.java
 */

package org.eda1.utilidades;

import java.util.Comparator;

/**
 * A Comparator that imposes a <tt>total ordering</tt> on objects that
 * implement <tt>Comparable</tt>; the comparison is the &quot&gt&quot relation where
 * the ordering of elements proceeds from larger to smaller.
 * An instance can be passed to
 * the <tt>Arrays.sort</tt> method to order the array in descending order. An instance
 * passed to the <tt>Heaps.heapsort</tt> method orders the array in ascending order.
 * The <tt>HeapPQueue</tt> class uses a <tt>Greater</tt> comparator to create by
 * default a maximum heap.
 */

public class Greater<T>	implements Comparator<T>
{
    /**
     * Compares its two arguments by using the opposite of the <tt>compareTo</tt>
     * ordering for the argument type. The return value for <tt>compare</tt> is a
     * negative integer, zero, or a positive integer indicating that the first
     * argument is greater than, equal to, or less than the second argument. Throws
     * a <tt>ClassCastException</tt> if the arguments are not comparable.
     *
     * @param x the first object to be compared.
     * @param y the second object to be compared.
     * @return  a negative integer, zero, or a positive integer indicating that the
     *          first argument is greater than, equal to, or less than the second argument.
     * @throws   <tt>ClassCastException</tt> if the arguments are not comparable.
     */
   public int compare(T x, T y)
   {
      return -((Comparable<T>)x).compareTo(y);
   }
}
