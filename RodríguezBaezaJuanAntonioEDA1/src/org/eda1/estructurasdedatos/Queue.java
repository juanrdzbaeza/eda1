/*
 * @(#)Queue.java
 *
 */

package org.eda1.estructurasdedatos;

/**
 * A collection designed for holding elements prior to their execution.  The collection
 * stores elements with a first-in-first-out (FIFO) order. The interface defines methods
 * for  insertion (push), extraction (pop) and inspection (peek).<p>
 * The remove() method removes and returns the element at the front of the stack or throws
 * an exception if the queue is empty. The peek() method returns the value of the
 * element at the front of the queue, but does not remove it.<p>
 * A queue implementation may use a dynamically expanding storage structure that
 * allows for an unlimited number of element or fixed-length ("bounded") queue.
 * @see LinkedQueue
 * @see BQueue
 */


public interface Queue<T>
{
   /**
    * Insert item at the back of the queue.
    * @param item  insert item at the back of the queue
    */
   public void push(T item);

   /**
    * Remove the element at the front of the queue and return its value.
    * @return value of the element removed from the front of the queue.
    * @throws <tt>NoSuchElementException</tt> if the queue is empty.
    */
   public T pop();

   /**
    * Return the value of the element at the front of the queue.
    * @return value of element at the front of the queue.
    * @throws <tt>NoSuchElementException</tt> if the queue is empty.
    */
   public T peek();

   /**
    * Return a boolean value that indicates whether the queue is empty. Return
    * true if empty and false if not empty.
    * @return true if the queue is empty and false otherwise.
    */
   public boolean isEmpty();

   /**
    * Return the number of elements currently in the queue.
    * @return number of elements in the queue.
    */
   public int size();
}
