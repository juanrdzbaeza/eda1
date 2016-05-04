/*
 * @(#)LinkedList.java
 */

package org.eda1.actividad01.serializacionED;

import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;
import java.io.*;

/**
 * The <tt>LinkedList</tt> class implements of the <tt>List</tt> interface using a
 * doubly-linked list as the underlying storage structure. In addition to
 * implementing the <tt>List</tt> interface, the class provides methods to add, remove,
 * an access elements at the ends of the list.<p>
 */

public class LinkedList<T>
   implements List<T>, Iterable<T>, Cloneable, java.io.Serializable
{
   // number of elements in the list
   private int listSize;
   // the doubly-linked list header node
   transient private DNode<T> header;

   // increases whenever the list changes. the class creates
   // iterators whose variable expectedModCount equals the current
   // value of modCount. for an iterator operation to be valid,
   // modCount must equal expectedModCount
   transient private int modCount;

    /**
     * Creates an empty list.
     */
	public LinkedList()
	{
		header = new DNode<T>();
		listSize = 0;
		modCount = 0;
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param item element to be appended to this list.
	 * @return <tt>true</tt>
	 */
	public boolean add(T item)
	{
		// insert item at the end of the sequence and increment
		// the list size
		addBefore(header,item);
		listSize++;
		// the list has changed
		modCount++;

		return true;
	}

    /**
     * Appends the given item to the end of this list.
     *
     * @param item the element to be inserted at the end of this list.
     */
   public void addLast(T item)
   {
      // insert item at the end of the sequence and increment
      // the list size
      addBefore(header,item);
      listSize++;
      modCount++;
   }

	 /**
	  * Inserts the specified item at the specified position in this
	  * list.
	  *
	  * @param index position at which the specified element is to be inserted.
	  * @param item element to be inserted.
	  * @throws    IndexOutOfBoundsException if index is out of range
	  *		  <tt>(index &lt; 0 || index &gt; size())</tt>.
	  */
   public void add(int index, T item)
   {
      DNode<T> p = null;

      if (index == listSize)
      	// adding to end of list
      	p = header;
      else
      	// get reference to node at index in list. throws
      	// IndexOutOfBoundsException if index is out of range
      	p = nodeAtIndex(index);

      // insert item before node p and increment the
      // list size
      addBefore(p, item);
      listSize++;
      modCount++;
   }

    /**
     * Inserts the given item at the beginning of this list.
     *
     * @param item the element to be inserted at the beginning of this list.
     */
   public void addFirst(T item)
   {
      // add item before header and increment
      // the list size
      addBefore(header.next,item);
      listSize++;
      modCount++;
   }

	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
   public void clear()
   {
      // replace each element of list by null so garbage
      // collection will kick in
      for (DNode<T> curr = header.next; curr != header; curr = curr.next)
         curr.nodeValue = null;

      // reset header reference to create empty list
      header.prev = header.next = header;

      // change list size to 0 and increment modCount
      listSize = 0;
      modCount++;
   }

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 *
	 * @param item element whose presence in this List is to be tested.
	 * @return  <tt>true</tt> if the specified element is present;
	 *		<tt>false</tt> otherwise.
	 */
	public boolean contains(Object item)
	{
		return indexOf(item) >= 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param  index position of the element to return.
	 * @return the element at the specified position in this list.
	 * @throws    IndexOutOfBoundsException if index is out of range <tt>(index
	 * 		  &lt; 0 || index &gt;= size())</tt>.
	 */
	public T get(int index)
	{
		// nodeAtIndex() calls rangeCheck() which may throw
		// an IndexOutOfBoundsException.
		// get the reference that identifies node at index
		DNode<T> p = nodeAtIndex(index);
		return p.nodeValue;
	}

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list.
     * @throws    NoSuchElementException if this list is empty.
     */
	public T getFirst()
	{
		if (listSize == 0)
			throw new NoSuchElementException();

		return header.next.nodeValue;
	}

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list.
     * @throws    NoSuchElementException if this list is empty.
     */
	public T getLast()
	{
		if (listSize == 0)
			throw new NoSuchElementException();

		return header.prev.nodeValue;
	}

	/**
	 * Searches for the first occurence of the given argument using
	 * the <tt>equals</tt> method.
	 *
	 * @param   item   an object.
	 * @return  the index of the first occurrence of the argument in this
	 *          list; returns <tt>-1</tt> if the object is not found.
	 */
	public int indexOf(Object item)
	{
		int index = 0;

		// search for item using equals()
		for (DNode<T> curr = header.next; curr != header; curr = curr.next)
		{
			if (item.equals(curr.nodeValue))    // success
				return index;
			index++;
		}

		// item is not in the list. return -1
		return -1;
	}

	/**
	 * Tests if this list has no elements.
	 *
	 * @return  <tt>true</tt> if this list has no elements;
	 *          <tt>false</tt> otherwise.
	 */
   public boolean isEmpty()
   {
      return listSize == 0;
   }

	/**
	* Returns an iterator over the elements in this list in the order
	* from front to back; the iterator initially references the first elementin the list.
	*
	* @return an <tt>Iterator</tt> positioned initially referencing the first element.
	*/
	public Iterator<T> iterator()
	{
		return new IteratorImpl();
	}

	/**
	* Returns a list iterator over the elements in this list in the order
	* from front to back; the iterator initially references the first elementin the list.
	*
	* @return a <tt>ListIterator</tt> positioned initially referencing the first element.
	*/
	public ListIterator<T> listIterator()
	{
		return new ListIteratorImpl(0);
	}

	/**
	* Returns a list iterator over the elements in this list in the order
	* from front to back; the list iterator initially references the element at
	* the specified index position.
   * @param index  initial position for the list iterator.
	* @return a <tt>ListIterator</tt> positioned at the specified index position.
	*/
	public ListIterator<T> listIterator(int index)
	{
		return new ListIteratorImpl(index);
	}

	/**
	 * Removes the first occurrence of the specified element from this
	 * list, if it is present. Returns <tt>true</tt> if the list is
	 * modified.<p>
	 *
	 * @param item element to be removed from this list, if present.
	 * @return <tt>true</tt> if the list contained the specified element.
	 */
	public boolean remove(Object item)
	{
		boolean retValue = false;
		DNode<T> curr;

		// search for item
		for (curr = header.next; curr != header; curr = curr.next)
			if (item.equals(curr.nodeValue))
				break;

		// we located item if curr is not header
		if (curr != header)
		{
			retValue = true;
			remove(curr);
			listSize--;
			modCount++;
		}

		return retValue;
	}

	/**
	 * Removes the element at the specified position in this list.
	 *
	 * @param index the position of the element to removed.
	 * @return the element that was removed from the list.
	 * @throws    IndexOutOfBoundsException if index out of range <tt>(index
	 * 		  &lt; 0 || index &gt;= size())</tt>.
	 */
	public T remove(int index)
	{
		// calls rangeCheck() which will throw an
		// IndexOutOfBoundsException if index is not a valid
		// index; otherwise, it returns a reference that
		// points to the node at position index
		DNode<T> p = nodeAtIndex(index);

		// save the return value
		T returnElement = p.nodeValue;

		// remove element at node p
		remove(p);

		// decrement list size
		listSize--;

		// we've made a modification
		modCount++;

		// return the value that was removed
		return returnElement;
	}

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list.
     * @throws    NoSuchElementException if this list is empty.
     */
	public T removeFirst()
	{
		if (listSize == 0)
			throw new NoSuchElementException("LinkedList removeFirst(): list empty");

		T first = header.next.nodeValue;

		remove(header.next);
		listSize--;

		return first;
	}


    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list.
     * @throws    NoSuchElementException if this list is empty.
     */
	public T removeLast()
	{
		if (listSize == 0)
			throw new NoSuchElementException("LinkedList removeLast(): list empty");

		T last = header.prev.nodeValue;

		remove(header.prev);
		listSize--;

		return last;
	}

	/**
	 * Replaces the element at the specified position in this list with
	 * the specified item.
	 *
	 * @param index position of the element to update..
	 * @param item new value to stored at the specified position.
	 * @return the element previously at the specified position.
	 * @throws    IndexOutOfBoundsException if index out of range
	 *		  <tt>(index &lt; 0 || index &gt;= size())</tt>.
	 */
	public T set(int index, T item)
	{
		// method calls rangeCheck() which may throw
		// an IndexOutOfBoundsException.
		// get the reference that identifies node at position index
		DNode<T> p = nodeAtIndex(index);

		// save the old value
		T previousValue = p.nodeValue;

		// assign item at position index
		p.nodeValue = item;

		// return the previous value
		return previousValue;
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return  the number of elements in this list.
	 */
   public int size()
   {
      return listSize;
   }

	/**
	 * Returns an array containing all of the elements in this list
	 * in postional-order.
	 *
	 * @return an array containing all of the elements in this list
	 * 	       in positional-order.
	 */
   public Object[] toArray()
   {
      // allocate a new array with listSize elements
      Object[] arr = new Object[listSize];
      DNode<T> curr = header.next;

      // copy the elements in listHeader to arr
      for (int i = 0; i < listSize; i++)
      {
         arr[i] = curr.nodeValue;
         curr = curr.next;
      }

      // return the new array
      return arr;
   }

   /**
    * Returns a string representation of this list. The
    * representation is a comma separated list in positional order from
    * 0 to size()-1, enclosed in square brackets.
    */
	public String toString()
	{
		Object[] arr = toArray();

		if (arr == null)
			return "null";
		else if (arr.length == 0)
			return "[]";

		// start with the left bracket
		String str = "[" + arr[0];

		// append all but the last element, separating items with a comma
		// polymorphism calls toString() for the array type
		for (int i = 1; i < arr.length; i++)
			str +=  ", " + arr[i];

		str += "]";

		return str;
	}

   // verify that index is in the range 0 <= index < listSize. if
   // not throw the IndexOutOfBoundsException exception
   private void rangeCheck(int index)
   {
      if (index < 0 || index >= listSize)
         throw new IndexOutOfBoundsException("Index " + index +
            " out of bounds. Should be in the range 0 to " +
            (listSize-1));
   }

   // return the DNode reference that points at an element
   // at position index
   private DNode<T> nodeAtIndex(int index)
   {
      // check if index is in range
      rangeCheck(index);

		// start at the header
		DNode<T> p = header;

		// go to index either by moving forward from the front
		// of the list. see Programming Exercise 10-17 for a way
		// to improve the performance of this method
		for (int j = 0; j <= index; j++)
         p = p.next;

      // return reference to node at position p
      return p;
   }

	// remove DNode referenced by curr
	private void remove(DNode<T> curr)
	{
		// return if the list is empty
		if (curr.next == curr)
			return;

		// declare references for the predecessor and successor nodes
		DNode<T> prevNode = curr.prev, succNode = curr.next;

		// update reference fields for predecessor and successor
		prevNode.next = succNode;
		succNode.prev = prevNode;
	}

	private DNode<T> addBefore(DNode<T> curr, T item)
	{
		// declare reference variables for new node and previous node
		DNode<T> newNode, prevNode;

		// create new DNode with item as initial value
		newNode = new DNode<T>(item);

		// assign prevNode the reference value of node before p
		prevNode = curr.prev;

		// update reference fields in newNode
		newNode.prev = prevNode;
		newNode.next = curr;

		// update curr and prevNode to point at newNode
		prevNode.next = newNode;
		curr.prev = newNode;

		return newNode;
	}

   private class IteratorImpl implements Iterator<T>
   {
      // set expectedModCount to the number of list changes
      // at the time of iterator creation
      int expectedModCount = modCount;

      // node whose value is returned a subsequent call to next()
      DNode<T> nextNode = header.next;
      // node of the last value returned by next() or header if that
      // value was deleted by the iterator method remove()
      DNode<T> lastReturned = header;

      // constructor. not strictly necessary
      IteratorImpl()
      {}

		// returns true if the collection being traversed
		// has more elements
		public boolean hasNext()
		{
			// elements remain if the next node is not the header
			return nextNode != header;
		}

		// returns the next element in the interation.
		// throws NoSuchElementException if the iteration
		// has no more elements
		public T next()
		{
			// check that the iterator is in a consistent state
			checkIteratorState();

			// check if the iteration has an another element
			// if not, throw NoSuchElementException
			if (nextNode == header)
				throw new NoSuchElementException(
						"Iteration has no more elements");

			// save current value of next as lastReturned
			// advance next and nextIndex
			lastReturned = nextNode;
			nextNode = nextNode.next;

			// return value of lastReturned
			return lastReturned.nodeValue;
		}

		// removes the last element returned by next(). this method
		// can be called only once per call to next(). throws IllegalStateException
		// if next() has not yet been called or remove() has already
		// been called after the last call to next()
		public void remove()
		{
			// check that the iterator is in a consistent state
			checkIteratorState();

			// check for a missing call to next()
			if (lastReturned == header)
				throw new IllegalStateException(
					"Iterator call to next() " +
					"required before calling remove()");

			LinkedList.this.remove(lastReturned);

			// list has been modified
			modCount++;
			expectedModCount = modCount;

			// we did a deletion. indicate this by setting lastReturned
			// to header
			lastReturned = header;
			listSize--;
		}

		void checkIteratorState()
		{
			if (expectedModCount != modCount)
				throw new ConcurrentModificationException(
					"Inconsistent iterator");
		}
   }

   private class ListIteratorImpl
      extends IteratorImpl implements ListIterator<T>
   {
		// create the iterator at position index in the list
		ListIteratorImpl(int index)
		{
			if (index < 0 || index > listSize)
				throw new IndexOutOfBoundsException(
							"Index: "+ index+ ", Size: "+ listSize);

			// go to index either by moving forward from the front
			// of the list. see Programming Exercise 12-7 for a way
			// to improve the performance of this constructor
			nextNode = header.next;
			for (int i=0; i < index; i++)
				nextNode = nextNode.next;
		}

		// removes the last element returned by next() or previous().
		// this method can be called only once per call to next() or previous().
		// throws IllegalStateException if remove() or add() have already been
		// called after the last call to next() or previous()
		public void remove()
		{
			// check that the iterator is in a consistent state
			checkIteratorState();

			// check for a missing call to next() or previous()
			if (lastReturned == header)
				throw new IllegalStateException(
					"ListIterator call to next() or previous() " +
					"required before calling remove()");

			LinkedList.this.remove(lastReturned);

			// lastReturned can equal nextNode if the ListIterator
			// method previous() was called. in this case, move
			// nextNode forward one node
			if (lastReturned == nextNode)
				nextNode = nextNode.next;

			// list has been modified
			modCount++;
			expectedModCount = modCount;

			// we did a deletion. indicate this by setting lastReturned
			// to header
			lastReturned = header;
			listSize--;
		}

      // inserts item into the list. it is inserted
      // immediately before the next value that would be
      // returned by next, if any, and after the next value
      // that would be returned by previous, if any. if the
      // list is empty, item becomes the sole value in
      // the list. a subsequent call to next is unaffected,
      // and a subsequent call to previous returns the new
      // element
		public void add(T item)
		{
			checkIteratorState();

			// insert item before nextNode
			addBefore(nextNode, item);
			modCount++;
			expectedModCount = modCount;

			// set lastReturned to header to invalidate a call to set()
			// without an intervening call to next() or previous()
			lastReturned = header;
			listSize++;
		}

		// returns true if the list being traversed has more
		// elements when moving in the backward direction
		public boolean hasPrevious()
		{
			return nextNode.prev != header;
		}

		// returns the previous element in the list. throws
		// NoSuchElementException if the iteration has no
		// previous element
		public T previous()
		{
			checkIteratorState();

			if (nextNode.prev == header)
				throw new NoSuchElementException(
					"Iteration has no more elements");

			// move backward one position
			lastReturned = nextNode = nextNode.prev;

			return lastReturned.nodeValue;
		}

		// replaces the last value returned by next() or previous()
		// with item. throws IllegalStateException if either
		// remove() or add() have been called after the last call to
		// next() or previous()
		public void set(T item)
		{
			if (lastReturned == header)
				throw new IllegalStateException(
					"Iterator call to next() or previous() " +
					"required before calling set()");

			checkIteratorState();

			lastReturned.nodeValue = item;
		}
   }

	/**
	 * Save the state of the <tt>LinkedList</tt> instance to a stream.
	 * @param out  serialize this instance to the specified ObjectOutputStream.
    * @serialData The size of the list (the number of elements it
    *		   contains) is emitted (int), followed by all of its elements
    *       (each an Object) in the proper order.
	 */
	private void writeObject(ObjectOutputStream out)
		throws java.io.IOException
	{
		out.writeInt(listSize); //Escribo el tamaño de la LinkedList en un entero.
		
		//Recorro la LinkedList escribiendo cada objeto.
		for(int i = 0; i < listSize; i++){
			out.writeObject(get(i));
		}

	}

	/**
	 * Reconstitute the <tt>LinkedList</tt> instance from a stream.
	 * @param in  reconstitute (deserialize) this instance from the ObjectInputStream.
	 */
	private void readObject(ObjectInputStream in)
		throws IOException, ClassNotFoundException
	{
		//Repito las líneas del constructor
		header = new DNode<T>();
		listSize = 0;

		//Creo una variable entera para leer el tamaño de la LinkedList
		int n = in.readInt();
		//Voy recorriendo, leyendo los objetos y añadiéndolos a la LinkedList.
		for(int i = 0; i < n; i++){
			T x = (T) in.readObject();
			add(x);
		}

	}

    /**
     * Returns a shallow copy of this <tt>LinkedList</tt>. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this <tt>LinkedList</tt> instance.
     */
	public Object clone()
	{
		LinkedList<T> copy = null;

		try
		{
			copy = (LinkedList<T>)super.clone();
		}
		catch (CloneNotSupportedException cnse)
		{ throw new InternalError(); }

		copy.header = new DNode<T>();
		copy.listSize= 0;
		copy.modCount = 0;


		DNode<T> curr = header.next;
		while (curr != header)
		{
			copy.add(curr.nodeValue);
			curr = curr.next;
		}

		// return the cloned object
		return copy;
	}

	private static class DNode<T>
	{
	   // the members of a DNode object are used for operations within a
	   // doubly-linked list
	   public T nodeValue;		// data value of the node
	   public DNode<T> prev;		// previous node in the list
	   public DNode<T> next;		// next node in the list


	   // default constructor. creates an object with the value set to null
	   // and whose references point to the node itself
	   public DNode()
	   {
	      nodeValue = null;
	      next = this;   // the next node is the current node
	      prev = this;   // the previous node is the current node
	   }

	   // creates object whose value is item and whose references
		// point to the node itself
	   public DNode(T item)
	   {
	      nodeValue = item;
	      next = this;   // the next node is the current node
	      prev = this;   // the previous node is the current node
	   }
	}
}
