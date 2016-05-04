/*
 * @(#)AVLTree.java
 */

package org.eda1.actividad03.AVLTree;

import java.util.NoSuchElementException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;

/**
 * This class is a balanced binary tree that implements the Collection interface AVL
 * tree single and double rotation methods.
 * @see	    RBTree
 */

public class AVLTree<T>
	implements Collection<T>, Iterable<T>, BinarySearchTree<T>, Serializable
{
    private static int LEFTHEAVY = 1;
    private static int BALANCED = 0;
    private static int RIGHTHEAVY = -1;
   // reference to tree root
   private AVLNode<T> root;

   // number of elements in the tree
   private int treeSize;

   // increases whenever the tree changes. used by an iterator
   // to verify that it is in a consistent state
   private int modCount;

    // delete the tree with a postorder scan of the nodes
    private void deleteTree(AVLNode<T> t)
    {
      // if current root node is not null, delete its left
      // subtree, its right subtree and then set the node to null
      if (t != null)
      {
         deleteTree(t.left);
         deleteTree(t.right);
         t = null;
      }
    }

    // iteratively traverse a path from the root to the node
    // whose value is item; return a reference to the node
    // containing item or null if the search fails
    private AVLNode<T> findNode(Object item)
    {
        // t is current node in traversal
        AVLNode<T> t = root;
        int orderValue;

        // terminate on on empty subtree
        while(t != null)
        {
            // compare item and the current node value
            orderValue =
            	((Comparable<T>)item).compareTo(t.nodeValue);

            // if a match occurs, return true; otherwise, go left
            // or go right following search tree order
            if (orderValue == 0)
                 return t;
            else if (orderValue < 0)
                 t = t.left;
            else
                 t = t.right;
        }
        return null;
    }

    /**
     * Constructs an empty AVL tree. All elements inserted into the
     * tree must implement the <tt>Comparable</tt> interface.
     */
    public AVLTree()
    {
        root = null;
        modCount = 0;
        treeSize = 0;
    }

    /**
     * Adds the specified item to this tree if it is not already present.
     *
     * @param item element to be added to this tree.
     * @return <tt>true</tt> if the tree did not already contain the specified
     *         element.
     */
	public boolean add(T item)
	{
		try
		{
			root = addNode(root, item);
		}

		catch (IllegalStateException ise)
		{ return false; }

		// increment the tree size and modCount
		treeSize++;
		modCount++;

		// we added a node to the tree
		return true;
	}

	private AVLNode<T> addNode(AVLNode<T> t, T item)
	{
		if( t == null )
			t = new AVLNode<T>(item);
		else if (((Comparable<T>)item).compareTo(t.nodeValue) < 0)
		{
			t.left = addNode( t.left, item);

			if (height(t.left) - height(t.right) == 2 )
				if (((Comparable<T>)item).compareTo
							(t.left.nodeValue) < 0)
					t = singleRotateRight(t);
				else
					t = doubleRotateRight(t);
		}
		else if (((Comparable<T>)item).compareTo
							(t.nodeValue) > 0 )
		{
			t.right = addNode(t.right, item );

			if (height(t.left) - height(t.right) == -2)
				if (((Comparable<T>)item).compareTo
							(t.right.nodeValue) > 0)
					t = singleRotateLeft(t);
				else
					t = doubleRotateLeft(t);
		}
		else
			// duplicate; throw IllegalStateException
			throw new IllegalStateException();

		t.height = max( height(t.left), height(t.right) ) + 1;

		return t;
	}

	public boolean remove(Object item) {
		
        if (item == null) {
            return false;
        }

        try {
            root = remove(root, (T)item);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;		
	}

	private AVLNode<T> remove(AVLNode<T> t, T item) {
		
        if (t == null) {
            throw new IllegalArgumentException("Element " + item + " is not present.");
        }

        int cmp = ((Comparable<T>)item).compareTo(t.nodeValue);

        if (cmp < 0) {
            t.left = remove(t.left, item);

            if (height(t.right) - height(t.left) == 2) {
                if (height(t.right.right) >= height(t.right.left)) {
                    t = singleRotateLeft(t);
                } else {
                    t = doubleRotateLeft(t);
                }
            }
        } else if (cmp > 0) {
            t.right = remove(t.right, item);

            if (height(t.left) - height(t.right) == 2) {
                if (height(t.left.left) >= height(t.left.right)) {
                    t = singleRotateRight(t);
                } else {
                    t = doubleRotateRight(t);
                }
            }
        } else {
            return removeNode(t);
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;

        return t;
	}

    private AVLNode<T> removeNode(AVLNode<T> removalNode) {

    	AVLNode<T> replacementNode;

        if (removalNode.left != null && removalNode.right != null) {
            replacementNode = findMin(removalNode.right);

            removalNode.right = removeMin(removalNode.right);

            replacementNode.left = removalNode.left;
            replacementNode.right = removalNode.right;

            if (height(replacementNode.left) - height(replacementNode.right) == 2) {
                if (height(replacementNode.left.left) >= height(replacementNode.left.right)) {
                    replacementNode = singleRotateRight(replacementNode);
                } else {
                    replacementNode = doubleRotateRight(replacementNode);
                }
            }

            replacementNode.height = Math.max(height(replacementNode.left), height(replacementNode.right)) + 1;
        } else {
            replacementNode = (removalNode.left != null) ? removalNode.left : removalNode.right;

            treeSize--;
        }

        removalNode.left = null;
        removalNode.right = null;

        return replacementNode;
    }

    private AVLNode<T> removeMin(AVLNode<T> t) {

        if (t == null) {
            return null;
        }

        if (t.left == null) {
            treeSize--;

            return t.right;
        }

        t.left = removeMin(t.left);

        if (height(t.right) - height(t.left) == 2) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = singleRotateLeft(t);
            } else {
                t = doubleRotateLeft(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;

        return t;
    }
	
    private AVLNode<T> findMin(AVLNode<T> t) {

        if (t.left == null) {
            return t;
        }

        return findMin(t.left);
    }
	
	 private static <T> int height(AVLNode<T> t)
	 {
	     if (t == null)
	        return -1;
	   else
	     return t.height;
	 }

    private static int max(int a, int b)
    {
        if (a > b)
            return a;
        else
            return b;
    }


	// perform a single right rotation for parent p
	private static <T> AVLNode<T> singleRotateRight(AVLNode<T> p)
	{
		AVLNode<T> lc = p.left;

		p.left = lc.right;
		lc.right = p;
		p.height = max( height( p.left ), height( p.right ) ) + 1;
		lc.height = max( height( lc.left ), lc.height ) + 1;

		return lc;
	}

	// perform a single left rotation for parent p
	private static <T> AVLNode<T> singleRotateLeft(AVLNode<T> p)
	{
		AVLNode<T> rc = p.right;

		p.right = rc.left;
		rc.left = p;
		p.height = max(height(p.left), height(p.right)) + 1;
		rc.height = max(height(rc.right), rc.height) + 1;

		return rc;
	}

	// perform a double right rotation for parent p
	private static <T> AVLNode<T> doubleRotateRight(AVLNode<T> p)
	{
		p.left = singleRotateLeft(p.left);
		return singleRotateRight(p);
	}

	// perform a single left rotation for parent p
	private static <T> AVLNode<T> doubleRotateLeft(AVLNode<T> p)
	{
		p.right = singleRotateRight(p.right);
		return singleRotateLeft(p);
	}

    /**
     * Removes all of the elements from this tree. The resulting tree is empty
     * after the method executes.
     */
	public void clear()
	{
		deleteTree(root);
		root = null;
		treeSize = 0;
	}

    /**
     * Returns <tt>true</tt> if this tree contains the specified element.
     *
     * @param item the object to be checked for containment in this tree.
     * @return <tt>true</tt> if this tree contains the specified element.
     */
    public boolean contains(Object item)
    {
      AVLNode<T> t = findNode(item);
      return (t == null) ? false : true;
    }

      /**
     * Returns <tt>true</tt> if this tree contains no elements.
     *
     * @return <tt>true</tt> if this tree contains no elements.
     */
   public boolean isEmpty()
    {
      return treeSize == 0;
    }

    /**
     * Returns an iterator over the elements in this tree.  The elements
     * are returned in ascending order.
     *
     * @return an iterator over the elements in this tree.
     */
    public Iterator<T> iterator()
    {
      return new TreeIterator(root);
    }

     /**
     * Returns the number of elements in this tree.
     *
     * @return the number of elements in this tree.
     */
		public int size()
		{ return treeSize; }

     /**
     * Returns an array containing all of the elements in this tree.
     * The order of elements in the array is the iterator order of elements
     * in the tree
     *
     * @return an array containing all of the elements in this tree
     */
		public Object[] toArray()
		{
			Object[] arr = new Object[treeSize];
			Iterator iter = iterator();
			int i = 0;

			while (iter.hasNext())
			{
				arr[i] = iter.next();
				i++;
			}

			return arr;
		}


   /**
    * Returns a string representation of this tree. The
    * representation is a comma separated list in iterator order
    * enclosed in square brackets.
    */
    public String toString()
    {
        int i;

        // create the return string object
        String returnStr = "[";
        Iterator iter = this.iterator();

        // output values separated by commas
        for (i = 0; i < treeSize; i++)
        {
            returnStr += iter.next();
            if (i < treeSize - 1)
                returnStr += ", ";
        }
        returnStr += "]";

        // return the string
        return returnStr;
    }

	/**
	 * Searches for the specified item in the tree and returns
	 * the value of the node that matches item as a key.
	 *
	 * @param   item   serves as a key to locate an element in the tree..
	 * @return  the value of the node that corresponds to item as a key
	 *          or <tt>null</tt> if the element is not found.
	 */
	public T find(T item)
	{
		AVLNode<T> t = findNode(item);
		T value = null;

		if (t != null)
			value = t.nodeValue;

		return value;
	}
    
    private class TreeIterator implements Iterator<T>
    {
        private ALStack<AVLNode<T>> stack = null;
        private AVLNode<T> curr = null;
        private AVLNode<T> lastReturned = null;

        // set expectedModCount to the number of list changes
        // at the time of iterator creation
        private int expectedModCount = modCount;

        // go far left from t, pushing all the nodes with left
        // children on stack
        private AVLNode<T> goFarLeft(AVLNode<T> t)
        {
            if (t == null)
                 return null;
            while (t.left != null)
            {
                 stack.push(t);
                 t = t.left;
            }
            return t;
        }

        public TreeIterator(AVLNode<T> root)
        {
            stack = new ALStack<AVLNode<T>>();
            curr = goFarLeft(root);
        }

        public boolean hasNext()
        {
            return curr != null;
        }

		public T current() {
			return lastReturned.nodeValue;			
		}

        public T next()
        {
            // check that the iterator is in a consistent state.
            // throws ConcurrentModificationException if not
            checkIteratorState();

            if (curr == null)
                 throw new NoSuchElementException(
                 		"No elements remaining");

            // capture the value in the node
            T returnValue = (T)curr.nodeValue;
            
			lastReturned = curr;

            if (curr.right != null)	// have a right subtree
                 // stack nodes on left subtree
                 curr = goFarLeft(curr.right);
            else if (!stack.isEmpty())
                 // no right subtree there are other nodes
                 // to visit. pop the stack
                 curr = (AVLNode<T>)stack.pop();
            else
                 curr = null;	// end of tree; set curr to null

            return returnValue;
        }

        public void remove()
        {
            // no implementation
        }

      // protected so MiniListIteratorImpl class can use it also
      private void checkIteratorState()
      {
         if (expectedModCount != modCount)
            throw new ConcurrentModificationException(
               "Inconsistent iterator");
      }
    }
    
    
	// declares a binary search tree node object
	private static class AVLNode<T>
	{
		// node data
		public T nodeValue;

		// child links and link to the node's parent
		public AVLNode<T> left, right;

		// public int height;
		public int height;

		// constructor that initializes the value, balance factor
		// and parent fields and sets the link fields left and
		// right to null
		public AVLNode(T item)
		{
			nodeValue = item;
			left = null;
			right = null;
			height = 0;
		}
	}
	
	/***************
	 * actividad03 *
	 ***************/
	
	//ejercicio 10
	private void writeObject(ObjectOutputStream out) throws java.io.IOException {
		// out.defaultWriteObject();
		// write out the necessary elements of the collection (out.writeObject(…))
		out.writeInt(treeSize);
		out.writeObject(out.toString());
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// in.defaultReadObject();
		// read the elements of the collection (using in.readObject())
		treeSize = in.readInt();
		in.readObject();
		
	}
	
	public int height() {
		return height(root);
	}

}//fin de la clase