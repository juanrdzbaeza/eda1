/*
 * @(#)Stack.java
 *
 */

package org.eda1.actividad03.AVLTree;

/**
 * A collection designed for holding elements prior to their execution.  The collection
 * stores elements with a last-in-first-out (LIFO) order. The interface defines methods
 * for  insertion (push), extraction (pop) and inspection (peek).<p>
 * The remove() method removes and returns the element at the top of the stack or throws
 * an exception if the stack is empty. The peek() method returns the value of the
 * element at the top of the stack, but does not remove it.<p>
 * A stack implementation may use a dynamically expanding storage structure that
 * allows for an unlimited number of element or fixed-length ("bounded") stack.
 * see ALStack
 */

public interface Stack<T>
{
   /**
    * Insert item at the top of the stack.
    * @param item  insert item at the top of the stack
    */
    public void push(T item);

   /**
    * Remove the element at the top of the stack and return its value.
    * @return value of the element removed from the top of the stack
    * @throws <tt>EmptyStackException</tt> if the stack is empty.
    */
   public T pop();

   /**
    * Return the value of the element at the top of the stack.
    * @return value of element at the top of the stack
    * @throws <tt>EmptyStackException</tt> if the stack is empty.
    */
   public T peek();

   /**
    * Return a boolean value that indicates whether the stack is empty. return
    * true if empty and false if not empty.
    * @return true if the stack is empty and false otherwise.
    */
   public boolean isEmpty();

   /**
    * Return the number of elements currently on the stack.
    * @return number of elements on the stack.
    */
   public int size();
}
