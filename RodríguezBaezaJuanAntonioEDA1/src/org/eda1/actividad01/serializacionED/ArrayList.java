/*
 * @(#)ArrayList.java
 */

package org.eda1.actividad01.serializacionED;

import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;
import java.io.*;

/**
 * An array-based implementation of the <tt>List</tt> interface. The index access
 * methods and the iterators run in constant time.  The <tt>add</tt> operation runs
 * in <i>amortized constant time</i>, that is, adding n elements requires O(n) time.<p>
 *
 * Each <tt>ArrayList</tt> instance uses an array as the underlying storage
 * strucutre having a <i>capacity</i> which is the size of the array used to store
 * the elements in the list. The capacity grows automatically as new elements are
 * added to the <tt>ArrayList</tt> collection. An application can increase the
 * capacity before adding a large number of elements using the <tt>ensureCapacity</tt>
 * operation. This may reduce the number of times the array is dynamically expaned.
 * The <tt>trim</tt> method allocates a new array that matches the size of the
 * collection. This may save unused capacity when storing an <tt>ArrayList</tt>
 * collection.<p>
 */

public class ArrayList<T>
      implements List<T>, Iterable<T>, Cloneable, java.io.Serializable
{
	 private static final long serialVersionUID = 0000000000000000003L;

   // number of elements in the list
   private int listSize;
   // the array holding list elements. the capacity
   // is listArr.length
   private T[] listArr;

   // increases whenever the list changes. the class creates
   // iterators whose variable expectedModCount equals the current
   // value of modCount. for an iterator operation to be valid,
   // modCount must equal expectedModCount
   private int modCount = 0;

	// verify that index is in the range 0 <= index <= upperBound. if
	// not throw the IndexOutOfBoundsException exception
	private void rangeCheck(int index, String msg, int upperBound)
	{
		if (index < 0 || index >= upperBound+1)
			throw new IndexOutOfBoundsException("\n" + msg + ": index " + index +
				" out of bounds. Should be in the range 0 to " +
				upperBound);
	}

	/**
	 * Creates an empty list with an initial capacity of ten.
	 */
	public ArrayList()
	{
	   listArr = (T[])new Object[10];
	   listSize = 0;
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
		// index == listSize is valid. append to the list
		rangeCheck(index, "ArrayList add()", listSize);

		// see if we need to reallocate more memory
		if (listSize == listArr.length)
			ensureCapacity(2*listArr.length);

		// insert item at location index by shifting
		// the elements at locations index+1 through
		// listSize-1 to the right. note that if
		// index == listSize the for loop does
		// nothing. we append to the list
		for (int j= listSize-1;j >= index;j--)
			listArr[j+1] = listArr[j];

		// insert item at location index and increment the
		// list size and modCount
		listArr[index] = item;
		listSize++;
		modCount++;
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
		// verify that index is in the proper range
		rangeCheck(index, "ArrayList remove()", listSize-1);

		// save the return value
		T returnElement = listArr[index];

		// shift elements at indices index+1 to listSize-1
		// left
		for (int j=index;j < listSize-1;j++)
			listArr[j] = listArr[j+1];

		// make former last entry a null reference, decrement
		// list size and increment modCount
		listArr[listSize-1] = null;
		listSize--;
		modCount++;

		// return the value that was removed
		return returnElement;
	}


	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param item element to be appended to this list.
	 * @return <tt>true</tt>
	 */
	public boolean add(T item)
	{
		// call method add() at an index to insert item at the
		// end of the list
		add(listSize, item);

		return true;
	}

	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
   public void clear()
   {
      // replace each element of listArr by null so garbage
      // collection will kick in
      for (int i=0;i < listSize;i++)
         listArr[i] = null;

      // change list size to 0
      listSize = 0;
      // list has changed
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
	 * Increases, if necessary, the capacity of this <tt>ArrayList</tt> instance
	 * so that it can hold at least the number of elements specified by the minimum
	 * capacity argument.
	 *
	 * @param   minCapacity   the desired minimum capacity.
	 */
	public void ensureCapacity (int minCapacity)
	{
		// get the current capacity
		int currentCapacity = listArr.length;

		// only take action if the requested capacity
		// is larger than the existing capacity
		if (minCapacity > currentCapacity)
		{
			// capture a reference to the old array
			T[] oldListArr = listArr;

			// create the new array with the new capacity
			listArr = (T[]) new Object[minCapacity];

			// copy the old data to the new array
			for (int i=0; i < listSize; i++)
				listArr[i] = oldListArr[i];

			// nullify reference to the old array. garbage
			// collection will recover the space
			oldListArr = null;
		}
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
      // verify that index is in the proper range
      rangeCheck(index, "ArrayList get()", listSize-1);

      return listArr[index];
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
      int i;

      // elem is not null. search for it using equals()
      for (i=0;i < listSize;i++)
      {
         if (item.equals(listArr[i]))
            // success
            return i;
      }

      // elem is not in the list. return -1
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
	* Returns an iterator over the elements in this list in the index order
	* 0 to size()-1; the iterator initially references the element at index 0.
	*
	* @return an <tt>Iterator</tt> positioned initially referencing the first element.
	*/
   public Iterator<T> iterator()
   {
      return new IteratorImpl();
   }

   /**
    * Returns a list iterator over the elements in this list in the index order
	 * 0 to size()-1; the list iterator initially references the element at index 0.
	 * @return a <tt>ListIterator</tt> positioned at the first element in the list.
    */
   public ListIterator<T> listIterator()
   {
      return new ListIteratorImpl(0);
   }

   /**
    * Returns a list iterator over the elements in this list int the index order
	* 0 to size()-1; the list iterator initially references the element at
	* the specified index.
    * @param index  initial position for the list iterator.
	* @return a <tt>ListIterator</tt> referencing the specified index position.
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
		int i = 0, j;
		boolean retValue = true;

		// use indexOf() to search for item
		if ((i = indexOf(item)) != -1)
			remove(i);
		else
			retValue = false;

		return retValue;
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
		// verify that index is in the proper range
		rangeCheck(index, "ArrayList set()", listSize-1);

		// save the element at listArr[index]
		T previousValue = listArr[index];

		// assign the new element at position index
		listArr[index] = item;

		// return the previous element
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
    * Returns a string representation of this list. The
    * representation is a comma separated list in index order from
    * 0 to size()-1, enclosed in square brackets.
    * @return string representation ofthe list.
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

	/**
	 * Trims the capacity of this <tt>ArrayList</tt> instance to be the
	 * list's current size.
	 */
   public void trimToSize()
   {
      int currentCapacity = listArr.length;

      if (listSize < currentCapacity)
      {
         T[] oldListArr = listArr;

         listArr = (T[])new Object[listSize];

         // copy the old data to the new array
         for (int i=0; i < listSize; i++)
            listArr[i] = oldListArr[i];

         // nullify reference to the old array. garbage
         // collection will recover the space
         oldListArr = null;
      }
   }

	/**
	 * Returns an array containing all of the elements in this list
	 * in index-order.
	 *
	 * @return an array containing all of the elements in this list
	 * 	       in index-order.
	 */
   public Object[] toArray()
   {
		Object[] returnArray = new Object[listSize];

		for (int i=0;i < listSize;i++)
			returnArray[i] = listArr[i];

		return returnArray;
	}

	/**
	 * Save the state of the <tt>ArrayList</tt> instance to a stream.
	 * @param out  serialize this instance to the specified ObjectOutputStream.
	 */
	private void writeObject(ObjectOutputStream out)
		throws java.io.IOException
	{

		out.writeInt(listSize);   //Escribo un nº entero que es el tamaño de la lista
		
		// Recorro la lista escribiendo cada objeto.
		for(int i = 0; i < listSize; i++)
			out.writeObject(listArr[i]);

	}

	/**
	 * Reconstitute the <tt>ArrayList</tt> instance from a stream.
	 * @param in  reconstitute (deserialize) this instance from the ObjectInputStream.
	 */
	private void readObject(ObjectInputStream in)
		throws IOException, ClassNotFoundException
	{
		listSize = in.readInt(); //Leo el tamaño del ArrayList
		listArr = (T[]) new Object[listSize]; //Creo un ArrayList de tipo T[] con dicho tamaño
		
		//Leo el ArrayList recorriéndolo
		for(int i = 0; i < listSize; i++){
			listArr[i] = (T) in.readObject();
		}

	}

	/**
	 * Return a copy of this <tt>ArrayList</tt> instance.
	 */
	public Object clone()
	{
		ArrayList<T> copy = null;

		try
		{
			copy = (ArrayList<T>)super.clone();
		}
		catch (CloneNotSupportedException cnse)
		{ throw new InternalError(); }

		// replace listArr in copy by a new reference to an array
		copy.listArr = (T[])new Object[listSize];

		// copy the elements from listArr to copy.listArr
		for (int i=0;i < listSize;i++)
			copy.listArr[i] = listArr[i];

		// return the cloned object
		return copy;
	}

   private class IteratorImpl implements Iterator<T>
   {
      // set expectedModCount to the number of list changes
      // at the time of iterator creation
      protected int expectedModCount = modCount;

      // index of the subsequent element that will be returned by next()
      protected int nextIndex = 0;
      // index of the last value returned by next() or -1 if that
      // value was deleted by the iterator method remove()
      protected int prevIndex = -1;

      // constructor. not strictly necessary
      IteratorImpl()
      {}

      // returns true if the collection being traversed
      // has more elements
      public boolean hasNext()
      {
         // elements remain if nextIndex has not reached
         // index listSize
         return nextIndex != listSize;
      }

      // returns the next element in the interation.
      // throws NoSuchElementException if the iteration
      // has no more elements
      public T next()
      {
         T retValue = null;

         // check that the iterator is in a consistent state
         checkIteratorState();

         // call get() to obtain retValue. the call may throw
         // an IndexOutOfBoundsException exception, so put
         // the code in a try block
         try
         {
            retValue = get(nextIndex);
            // we're ok. prevIndex is nextIndex and move
            // nextIndex forward
            prevIndex = nextIndex;
            nextIndex++;
         }
         catch(IndexOutOfBoundsException iobe)
         {
            // OOPS! nextIndex was invalid. throw
            // a NoSuchElementException exception as
            // required by the API
            // throw new NoSuchElementException("Iteration has no more elements");
            throw new NoSuchElementException("Iteration has no more elements");
         }

         return retValue;
      }

      // removes the last element returned by next() from the
      // underlying collection. this method can be called only
      // once per call to next(). the behavior of an iterator
      // is unspecified if the underlying collection is modified
      // while the iteration is in progress in any way other than
      // by calling this method. throws IllegalStateException
      // if next() has not yet been called,or remove() has already
      // been called after the last call to next()
      public void remove()
      {
         // check for a missing call to next() or previous()
         if (prevIndex == -1)
            throw new IllegalStateException(
               "Iterator call to next() or previous() " +
               "required before calling remove()");

         // make sure our state is good
         checkIteratorState();

         ArrayList.this.remove(prevIndex);

         // list modified by remove() and modCount incremented. update
         // expectedModCount
         expectedModCount = modCount;

         // since we shifted elements left. nextIndex is now prevIndex
         nextIndex = prevIndex;
         // we did a deletion. indicate this by setting index prevIndex
         // to -1
         prevIndex = -1;
      }

      // protected so ListIteratorImpl class can use it also
      protected void checkIteratorState()
      {
         if (expectedModCount != modCount)
            throw new ConcurrentModificationException("Inconsistent iterator");
      }
   }

   private class ListIteratorImpl
      extends IteratorImpl implements ListIterator<T>
   {
      // int nextIndex = 0 OBTAINED FROM THE SUPERCLASS
      // index of the subsequent element that will be returned by next()

      // int prevIndex = -1 OBTAINED FROM THE SUPERCLASS
      // index of element returned by most recent call to next() or
      // previous(). reset to -1 if this element is deleted by a call
      // to remove() or is a new element inserted by add()

      // constructor
      ListIteratorImpl(int index)
      {
			if (index < 0 || index > listSize)
				throw new IndexOutOfBoundsException(
							"Index: "+ index+ ", Size: "+ listSize);

			nextIndex = index;
		}

      // returns true if the list being traversed has more
      // elements when moving in the forward direction
      // public boolean hasNext() IMPLEMENTED IN THE SUPERCLASS

      // returns the next element in the list. throws
      // NoSuchElementException if the iteration has no more
      // elements
      // public Object next() IMPLEMENTED IN THE SUPERCLASS

      // removes the last element returned by next() or previous()
      // from the list. this method can be called only once per
      // call to next() or previous(). it can be made only if
      // add() has not been called after the last call to next()
      // or previous()
      // public void remove()  IMPLEMENTED IN THE SUPERCLASS

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

         // insert item at index nextIndex using the outer class
         // method add(). this call increments modCount
         ArrayList.this.add(nextIndex, item);
         expectedModCount = modCount;

         // increment nexIndex so next() will return the original
         // value. set preIndex = -1 to invalidate a call to set()
         // without an intervening call to next() or previous()
         nextIndex++;
         prevIndex = -1;
      }

      // returns true if the list being traversed has more
      // elements when moving in the backward direction
      public boolean hasPrevious()
      {
         return nextIndex > 0;
      }

      // returns the index of the element that would be returned
      // by a subsequent call to next(). returns list size if the
      // iterator is at the end of the list
      public int nextIndex()
      {
         return nextIndex;
      }

      // returns the previous element in the list. throws
      // NoSuchElementException if the iteration has no
      // previous element
      public T previous()
      {
         T retValue = null;

         checkIteratorState();

         // move backward one position
         nextIndex--;

         // call get() to obtain retValue. the call may throw
         // an IndexOutOfBoundsException exception if we
         // fall off the front of the list, so put
         // the code in a try block
         try
         {
            retValue = get(nextIndex);
            // we're ok. prevIndex is nextIndex
            prevIndex = nextIndex;
         }
         catch(IndexOutOfBoundsException iobe)
         {
            // OOPS! nextIndex was invalid. throw
            // a NoSuchElementException exception as
            // required by the API
            throw new NoSuchElementException("Iteration has no more elements");
         }
         return retValue;
      }

      // returns the index of the element that would be returned
      // by a subsequent call to previous(). returns -1 if the
      // iterator is at the beginning of the list
      public int previousIndex()
      {
         return nextIndex != 0 ? nextIndex-1 : -1;
      }

		// replaces the last value returned by next() or previous()
      // with item. throws IllegalStateException if neither
      // next() nor previous() have been called, or remove() or
      // add() have been called after the last call to next() or
      // previous()
      public void set(T item)
      {
         if (prevIndex == -1)
            throw new IllegalStateException(
               "Iterator call to next() or previous() " +
               "required before calling set()");

         checkIteratorState();

         // use outer class set() to place the new element at
         // position prevIndex
         ArrayList.this.set(prevIndex, item);
      }
   }
}
