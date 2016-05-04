/*
 * @(#)ALStack.java
 */

package org.eda1.actividad03.AVLTree;

import java.util.ArrayList;
import java.util.EmptyStackException;     // for peek()/pop()
import java.io.*;

/**
 * An implemetation of the <tt>Stack</tt> interface using an <tt>ArrayList</tt> collection
 * as the underlying storage structure.
 */

public class ALStack<T> implements Stack<T>, Cloneable, java.io.Serializable

{
   transient private ArrayList<T> stackList = null;

   /**
    * Creates an empty stack that holds elements with the specified generic type T.
    */
   public ALStack()
   {
      stackList = new ArrayList<T>();
   }

   /**
    * Clear all of the elements in the stack.  The resulting stack is empty.
    */
   public void clear()
   {
      // clear the ArrayList
      stackList.clear();
   }

   /**
    * Insert item at the top of the stack.
    * @param item  insert item at the top of the stack
    */
   public void push(T item)
   {
      // add item at the end of the ArrayList
      stackList.add(item);
   }

   /**
    * Remove the element at the top of the stack and return its value.
    * @return value of the element removed from the top of the stack
    * @throws <tt>EmptyStackException</tt> if the stack is empty.
    */
   public T pop()
   {
      // if the stack is empty, throw EmptyStackException
      if (isEmpty())
         throw new EmptyStackException();

      // remove and return the last element in the ArrayList
      return stackList.remove(stackList.size()-1);
   }

   /**
    * Return the value of the element at the top of the stack.
    * @return value of element at the top of the stack
    * @throws <tt>EmptyStackException</tt> if the stack is empty.
    */
   public T peek()
   {
      // if the stack is empty, throw EmptyStackException
      if (isEmpty())
         throw new EmptyStackException();

      // return the element at the back of the ArrayList
      return stackList.get(stackList.size()-1);
   }

   /**
    * Return a boolean value that indicates whether the stack is empty. return
    * true if empty and false if not empty.
    * @return true if the stack is empty and false otherwise.
    */
   public boolean isEmpty()
   {
      // return whether the ArrayList is empty
      return stackList.isEmpty();
   }

   /**
    * Return the number of elements currently on the stack.
    * @return number of elements on the stack.
    */
   public int size()
   {
      // return the number of elements in the ArrayList
      return stackList.size();
   }

   /**
    * Returns a string that displays the elements on the stack from
    * top to bottom. The description is a comma separated list of
    * elements enclosed in brackets.
    * @return string that contains the list of elements on the stack.
    */
   public String toString()
   {
      // build the representation by appending to a
      // string buffer
      StringBuffer sb = new StringBuffer();
      int i;

 		if (stackList.isEmpty())
 			return "[]";

      // append the initial "["
      sb.append("[");

      // append "value of stackList[i],  " for size()-1 >= i >= 1
      for (i=stackList.size()-1; i >= 1; i--)
         sb.append(stackList.get(i).toString() + ", ");

      // append last element and the matching "]"
      sb.append(stackList.get(0).toString() + "]");

      // return the string
      return sb.toString();
   }

   	/**
	 * Save the state of the <tt>ALStack</tt> instance to a stream.
	 * @param out  serialize this instance to the specified ObjectOutputStream.
	 */
	private void writeObject(ObjectOutputStream out)
		throws java.io.IOException
	{
		// Write out internal serialization magic
		out.defaultWriteObject();

		// serialize stackList
		out.writeObject(stackList);
	}

	/**
	 * Reconstitute the <tt>ALStack</tt> instance from a stream.
	 * @param in  reconstitute (deserialize) this instance from the ObjectInputStream.
	 */
	private void readObject(ObjectInputStream in)
		throws IOException, ClassNotFoundException
	{
		// Read in internal serialization magic
		in.defaultReadObject();

		// deserialize stackList
		stackList = (ArrayList<T>)in.readObject();
	}

	/**
	 * Return a copy of this <tt>ALStack</tt> instance.
	 */
	public Object clone()
	{
		ALStack<T> copy = null;

		try
		{
			copy = (ALStack<T>)super.clone();
		}
		catch (CloneNotSupportedException cnse)
		{ throw new InternalError(); }

		// clone stackList
		copy.stackList = (ArrayList<T>)stackList.clone();

		// return the cloned object
		return copy;
	}

}
