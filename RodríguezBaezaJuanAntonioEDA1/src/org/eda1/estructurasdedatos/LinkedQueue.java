/*
 * @(#)LinkedQueue.java
 */

package org.eda1.estructurasdedatos;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.io.*;

/**
 * This class implements the Queue interface using a LinkedList object
 * by composition.
 */

public class LinkedQueue<T> implements Queue<T>
{
   private LinkedList<T> qlist = null;

   /**
    * Creates an empty queue that holds elements with the specified generic type T.
    */
   public LinkedQueue ()
   {
      qlist = new LinkedList<T>();
   }

   /**
    * Insert item at the back of the queue.
    * @param item  insert item at the back of the queue
    */
   public void push(T item)
   {
      // add item at the end of the LinkedList sequence
      qlist.add(item);
   }

   /**
    * Remove the element at the front of the queue and return its value.
    * @return value of the element removed from the front of the queue.
    * @throws <tt>NoSuchElementException</tt> if the queue is empty.
    */
   public T pop()
   {
      // if the queue is empty, throw  NoSuchElementException
      if (isEmpty())
         throw new
            NoSuchElementException ("LinkedQueue pop(): queue empty");

      // remove and return the first element in the list
      return qlist.removeFirst();
   }

   /**
    * Return the value of the element at the front of the queue.
    * @return value of element at the front of the queue.
    * @throws <tt>NoSuchElementException</tt> if the queue is empty.
    */
   public T peek()
   {
      // if the queue is empty, throw  NoSuchElementException
      if (isEmpty())
         throw new
            NoSuchElementException ("LinkedQueue front(): queue empty");

      // return the element at the front of the queue
      return qlist.getFirst();
   }

   /**
    * Return a boolean value that indicates whether the queue is empty. Return
    * true if empty and false if not empty.
    * @return true if the queue is empty and false otherwise.
    */
   public boolean isEmpty()
   {
      // return whether the list is empty
      return qlist.isEmpty();
   }

   /**
    * Return the number of elements currently in the queue.
    * @return number of elements in the queue.
    */
   public int size()
   {
      // return the number of elements in the linked list
      return qlist.size();
   }

   /**
    * Returns a string that displays the elements in the queue from
    * front to back. The description is a comma separated list of
    * elements enclosed in brackets.
    * @return string that contains the list of elements in the queue.
    */
   public String toString()
   {
	   return qlist.toString();
   }
}
