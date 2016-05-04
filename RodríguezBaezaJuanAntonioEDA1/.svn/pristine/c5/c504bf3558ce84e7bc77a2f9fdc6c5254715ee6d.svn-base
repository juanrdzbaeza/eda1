/*
 * @(#)BSTree.java
 */

package org.eda1.actividad03.BS_AVL_RB_Tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.ConcurrentModificationException;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.Iterable;
import org.eda1.estructurasdedatos.Collection;
import org.eda1.estructurasdedatos.BinarySearchTree;
import org.eda1.estructurasdedatos.Iterator;
import org.eda1.utilidades.Less;





/**
 * This class implements the Collection interface using a binary search
 * tree as the underlying storage structure.
 */

public class BSTree<T> implements Collection<T>, Iterable<T>, Cloneable, BinarySearchTree<T> {
	// reference to tree root
	//transient
	private BSTNode<T> root;

	// number of elements in the tree
	private int treeSize;

	// increases whenever the tree changes. used by an iterator
	// to verify that it is in a consistent state
	transient private int modCount;
	

	// private method used by remove() and the iterator
	// remove() to delete a node
	private void removeNode(BSTNode<T> dNode)
	{
	   if (dNode == null)
	      return;

	   // dNode = reference to node D that is deleted
	   // pNode = reference to parent P of node D
	   // rNode = reference to node R that replaces D
	   BSTNode<T> pNode, rNode;

	   // assign pNode as a reference to P
	   pNode = dNode.parent;

	   // if D has a null child, the
	   // replacement node is the other child
	   if (dNode.left == null || dNode.right == null)
	   {
	      if (dNode.right == null)
	         rNode = dNode.left;
	      else
	         rNode = dNode.right;

	      if (rNode != null)
	         // the parent of R is now the parent of D
	         rNode.parent = pNode;

			// complete the link to the parent node.

			// deleting the root node. assign new root
			if (pNode == null)
				root = rNode;
			// attach R to the correct branch of P
			else if (((Comparable<T>)dNode.nodeValue).
					compareTo(pNode.nodeValue) < 0)
				pNode.left = rNode;
			else
				pNode.right = rNode;
	   }
	   // both children of dNode are non-null.
	   else
	   {
	      // find and unlink replacement node for D.
	      // starting at the right child of node D,
	      // find the node whose value is the smallest of all
	      // nodes whose values are greater than the value in D.
	      // unlink the node from the tree.

	      // pOfRNode is reference to parent of replacement node
	      BSTNode<T> pOfRNode = dNode;

			// first possible replacement is right child of D
			rNode = dNode.right;

			// descend down left subtree of the right child of D,
			// keeping a record of current node and its parent.
			// when we stop, we have found the replacement
			while(rNode.left != null)
			{
				pOfRNode = rNode;
				rNode = rNode.left;
			}

			// copy the value in R to D
			dNode.nodeValue = rNode.nodeValue;

			if (pOfRNode == dNode)
				dNode.right = rNode.right;
			else
				pOfRNode.left = rNode.right;

			// the parent of the right child of R is the
			// parent of R
			if (rNode.right != null)
				rNode.right.parent = pOfRNode;


			// we want to dispose of rNode
			dNode = rNode;
		}

		// make the reference to the deleted node null
		dNode = null;
	}

	// iteratively traverse a path from the root to the node
	// whose value is item; return a reference to the node
	// containing item or null if the search fails
	private BSTNode<T> findNode(Object item)
	{
	   // t is current node in traversal
	   BSTNode<T> t = root;
	   int orderValue;

	   // terminate on on empty subtree
	   while(t != null)
	   {
	      // compare item and the current node value
	      orderValue = ((Comparable<T>)item).compareTo(t.nodeValue);

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
     * Creates an empty binary search tree. All elements inserted into the
     * tree must implement the <tt>Comparable</tt> interface.
     */
	public BSTree()
	{
	   root = null;
	   modCount = 0;
	   treeSize = 0;
	}

    /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#add(T)
	 */
	@Override
	public boolean add(T item)
	{
		// t is current node in traversal, parent the previous node
		BSTNode<T> t = root, parent = null, newNode;
		int orderValue = 0;

		// terminate on on empty subtree
		while(t != null)
		{
			// update the parent reference.
			parent = t;

			// compare item and the current node value
			orderValue = ((Comparable<T>)item).compareTo(t.nodeValue);

			// if a match occurs, return false; otherwise, go left
			// or go right following search tree order
			if (orderValue == 0)
				return false;
			else if (orderValue < 0)
				t = t.left;
			else
				t = t.right;
		}

		// create the new node
		newNode = new BSTNode<T>(item,parent);

		if (parent == null)
			// this is the first node added. make it root
			root = newNode;
		else if (orderValue < 0)
			// attach newNode as the left child of parent
			parent.left = newNode;
		else
			// attach newNode as the right child of parent
			parent.right = newNode;

		// increment the tree size and modCount
		treeSize++;
		modCount++;

		// we added a node to the tree
		return true;
	}

    /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#clear()
	 */
	@Override
	public void clear()
   {
	  modCount++;
      treeSize = 0;
      root = null;
   }

    /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#contains(java.lang.Object)
	 */
   @Override
public boolean contains(Object item)
   {
      BSTNode<T> t = findNode(item);
      return (t == null) ? false : true;
   }

     /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#isEmpty()
	 */
   @Override
public boolean isEmpty()
   {
      return treeSize == 0;
   }

    /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#iterator()
	 */
   @Override
public Iterator<T> iterator()
   {
      return new TreeIterator();
   }

    /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object item)
	{
		// search tree for item
		BSTNode<T> dNode  = findNode(item);

		if (dNode == null)
			return false;

		removeNode(dNode);

		treeSize--;
		modCount++;

		return true;
	}


     /* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#size()
	 */
  	@Override
	public int size()
   {
      return treeSize;
   }

     /**
     * Returns an array containing all of the elements in this tree.
     * The order of elements in the array is the iterator order of elements
     * in the tree.
     *
     * @return an array containing all of the elements in this tree.
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
            //returnStr += ", ";
        	returnStr += "\n";		// *** MIO ***
      }
      returnStr += "]";

      // return the string
      return returnStr;
   }

	/* (non-Javadoc)
	 * @see org.eda.estructurasdatos.Tree#find(T)
	 */
	
	public T find(T item)
	{
		BSTNode<T> t = findNode(item);
		T value = null;

		if (t != null)
			value = t.nodeValue;

		return value;
	}

	private class TreeIterator implements Iterator<T>
	{
		// set expectedModCount to the number of list changes
		// at the time of iterator creation
		private int expectedModCount = modCount;
		// node of the last value returned by next() if that
		// value was deleted by the iterator method remove()
		private BSTNode<T> lastReturned = null;
		// node whose value is returned a subsequent call to next()
		private BSTNode<T> nextNode = null;

		// constructor
		TreeIterator()
		{
			nextNode = root;

			// if the tree is not empty, the first node inorder is the farthest node left from root
			if (nextNode != null)
				while (nextNode.left != null)
					nextNode = nextNode.left;
		}

		// returns true if the tree has more
		// unvisited elements
		public boolean hasNext()
		{
			// elements remain if nextNode is not null
			return nextNode != null;
		}

		
		public T current() {
			return lastReturned.nodeValue;			
		}
		
		
		// returns the next element in the iteration.
		// throws NoSuchElementException if the iteration
		// has no more elements
		//public T next()
		public T next()
		{
			// check that the iterator is in a consistent state.
			// throws ConcurrentModificationException if it
			// it is not
			checkIteratorState();

			// check if the iteration has an another element
			// if not, throw NoSuchElementException
			if (nextNode == null)
				throw new NoSuchElementException(
						"Iteration has no more elements");

			// save current value of next in lastReturned.
			lastReturned = nextNode;

			// set nextNode to the next node in order
			BSTNode<T> p;

			if (nextNode.right != null)
			{
				// successor is the furthest left node of
				// right subtree
				nextNode = nextNode.right;

				while (nextNode.left != null)
					nextNode = nextNode.left;
			}
			else
			{
				// have already processed the left subtree, and
				// there is no right subtree. move up the tree,
				// looking for a parent for which nextNode is a left child,
				// stopping if the parent becomes null. a non-null parent
				// is the successor. if parent is null, the original node
				// was the last node inorder
				p = nextNode.parent;

				while (p != null && nextNode == p.right)
				{
					nextNode = p;
					p = p.parent;
				}

				// if we were previously at the right-most node in
				// the tree, nextNode = null
				nextNode = p;
			}

			return lastReturned.nodeValue;
		}

      // removes the last element returned by next() from the
      // underlying collection. this method can be called only
      // once per call to next(). it is an error to modify
      // the underlying collection while the iteration is in
      // progress in any way other than by calling this method.
      // throws IllegalStateException if next() has not yet been
      // called,or remove() has already been called after the last
      // call to next()
      public void remove()
      {
         // check for a missing call to next() or previous()
         if (lastReturned == null)
            throw new IllegalStateException(
               "Iterator call to next() " +
               "required before calling remove()");

         // make sure our state is good
         checkIteratorState();

			// if lastReturned has two children, the replacement node
			// during deletion is nextNode. the value in nextNode
			// is copied to lastReturned. nextNode must be
			// lastReturned
			if (lastReturned.left != null && lastReturned.right != null)
				 nextNode = lastReturned;
         removeNode(lastReturned);

         // list has been modified
         modCount++;
         expectedModCount = modCount;

         // we did a deletion. indicate this by setting lastReturned
         // to null and decrementing treeSize
         lastReturned = null;
         treeSize--;
      }

      private void checkIteratorState()
      {
         if (expectedModCount != modCount)
            throw new ConcurrentModificationException(
               "Inconsistent iterator");
      }
   }

	/**
	 * Return a copy of this <tt>STree</tt> instance.
	 */
	public Object clone()
	{
		BSTree<T> copy = null;

		try
		{
			copy = (BSTree<T>)super.clone();
		}
		catch (CloneNotSupportedException cnse)
		{ throw new InternalError(); }

		copy.root = copyTree(root);
		// return the cloned object
		return copy;
	}

   /*
    * Uses the static method copyTree() in the class BinaryTree as a model
    * to create a duplicate of the tree with root <tt>t</tt> and returns
	* a reference to the root of the copied tree.  In this case, the elements
	* are STNode<T> objects
    */
	private static <T> BSTNode<T> copyTree(BSTNode<T> t)
	{
		// newNode points at a new node that the algorithm
		// creates. newLptr. and newRptr point to the subtrees
		// of newNode
		BSTNode<T> newLeft, newRight, newNode;

		// stop the recursive scan when we arrive at empty tree
		if (t == null)
			return null;

		// build the new tree from the bottom up by building the two
		// subtrees and then building the parent. at node t, make
		// a copy of the left subtree and assign its root node reference
		// to newLeft. make a copy of the right subtree and assign its
		// root node reference to newRight
		newLeft = copyTree(t.left);
		newRight = copyTree(t.right);

		// create a new node whose value is the same as the value in t
		// and whose children are the copied subtrees
		newNode = new BSTNode<T> (t.nodeValue, null);
		newNode.left = newLeft;
		newNode.right = newRight;
		if (newLeft != null)
			newLeft.parent = newNode;
		if (newRight != null)
			newRight.parent = newNode;

		// return a reference to the root of the newly copied tree
		return newNode;
	}

   /**
	* Returns a string that displays the elements in the binary tree using
	* the preorder (NLR) scan.  The description is a listing of
	* elements separated by two blanks.
	* @param t a <tt>TNode</tt> that designates the root of the tree.
	* @return string that contains the list of elements in the array.
	*/
	private static <T> String preorderDisplay(BSTNode<T> t)
	{
			// return value
			String s = "";

	      // the recursive scan terminates on a empty subtree
	      if (t != null)
	      {
	         s += t.nodeValue + "  ";  			// display the node
	         s += preorderDisplay(t.left);		// descend left
	         s += preorderDisplay(t.right);	// descend right
	      }

	      return s;
	   }

	public String preorderDisplay()
	{
			// return value
			String s = preorderDisplay(root);

	      return s;
	   }
	
	private static <T> String displayTree(BSTNode<T> t, int level)
	{
		  String s = "";

	      // the recursive scan terminates on a empty subtree
	      if (t != null)
	      {
	    	  if (t.right != null)
	    		  s += displayTree(t.right, level + 1);
	    	  for (int i = 0; i < level; i++)
	    		  s += "     ";
	    	  s += "(" + t.nodeValue.toString() + ")[" + level + "]\n";
	    	  if (t.left != null)
	    		  s += displayTree(t.left, level + 1);
	      }
	      
	      return s;
	   }

	public String displayTree() {
		
		  String s = displayTree(root, 0);
			
	      return s;
	   }
	
	
	// declares a binary search tree node object
	private static class BSTNode<T>
	{
		// STNode is used to implement the binary search tree class
		// making the data public simplifies building the class functions

		// node data
		T nodeValue;

		// child links and link to the node's parent
		BSTNode<T> left, right, parent;

		// constructor that initializes the value and parent fields and sets
		// the link fields left and right to null
		public BSTNode (T item, BSTNode<T> parentNode)
		{
			nodeValue = item;
			left = null;
			right = null;
			parent = parentNode;
		}
	}
	
	// Ejercicio03

	private int height(BSTNode<T> t) {
			if(t == null)
				return -1;
			return 1+Math.max(height(t.left),height(t.right));
		}
	
	/**
	 * Devuelve la altura del BSTree
	 * @return un int con la altura del BSTree
	 */
	public int height() {
		return height(this.root);
	}
	/**
	 * Devuelve el numero de hojas del BSTree
	 * @return un int con el numero de hojas
	 */
	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}
	
	private int numberOfLeaves(BSTNode<T> t) {
		if(t == null)
			return 0;
		if(t.left == null && t.right == null)
			return 1;
		return numberOfLeaves(t.left) + numberOfLeaves(t.right);
	}
	
	/**
	 * Devuelve el valor minimo del BSTree. Metodo recursivo
	 * @return valor minimo(T)
	 */
	public T findMin() {
		return findMin(root).nodeValue;
	}
	
	private BSTNode<T> findMin(BSTNode<T> t) {
		if(t.left == null)
			return t;
		else
			return findMin(t.left);
	}
	
	/**
	 * Devuelve el valor minimo del BSTree. Metodo iterativo
	 * @return valor minimo(T)
	 */
	public T findMinIterative() {
		return findMinIterative(root).nodeValue;
	}
	
	private BSTNode<T> findMinIterative(BSTNode<T> t) {
		if(t.left == null)
			return t;
		while(t.left != null)
			t = t.left;
		return t;
	}
	/**
	 * Devuelve el valor maximo del BSTree. Metodo recursivo
	 * @return valor maximo(T)
	 */
	public T findMax() {
		return findMax(root).nodeValue;
	}
	
	private BSTNode<T> findMax(BSTNode<T> t) {
		if(t.right == null)
			return t;
		else
			return findMax(t.right);
	}
	
	/**
	 * Devuelve el valor maximo del BSTree. Metodo iterativo
	 * @return valor minimo(T)
	 */
	public T findMaxIterative() {
		return findMaxIterative(root).nodeValue;
	}
	
	private BSTNode<T> findMaxIterative(BSTNode<T> t) {
		while(t.right != null)
			t = t.right;
		return t;
	}
	/**
	 * Devuelve la informacion de todos los nodos del nivel pasado por parametro
	 * @param level nivel
	 * @return String con el contenido de los nodos
	 */
	public String toStringLevel(int level) {
		if(this.height() < level)
			return "";
		return toStringLevel(this.root,level);
	}

	private String toStringLevel(BSTNode<T> t, int level) {
		String aux = "";
		
		if(t != null){
			if(level == 0)
				aux += t.nodeValue.toString() + " ";
			else
				aux += toStringLevel(t.left,level-1)+toStringLevel(t.right,level-1);
		}
			
		return aux;
	}

	public String toStringIterativeInorder() {
		String aux = "";
		Iterator<T> iterador = new TreeIterator();
		while(iterador.hasNext())
			aux += iterador.next()+"  ";
		
		return aux;
	}
	
	public String toStringIterativePostorder() {
		return toStringIterativePostorder(root);
	}
	public static <T> String toStringIterativePostorder(BSTNode<T> t) {
		String aux = "";
		if(t == null)
			return aux;
		ALStack<BSTNode<T>> pila = new ALStack<BSTNode<T>>();
		ALStack<T> pilaValues = new ALStack<T>();
		BSTNode<T> nodo = t;
		pila.push(nodo);
		while(!pila.isEmpty()){
			nodo = pila.pop();
			if(nodo.left != null)
				pila.push(nodo.left);
			if(nodo.right != null)
				pila.push(nodo.right);
			pilaValues.push(nodo.nodeValue);
		}
		
		while(!pilaValues.isEmpty())
			aux += pilaValues.pop() + "  ";
		
		return aux;
	}
	
	public String toStringIterativePreorder(){
		return toStringIterativePreorder(root);
	}
	
	private String toStringIterativePreorder(BSTNode<T> t){
		String aux="";
		ALStack<BSTNode<T>> pila=new ALStack<BSTNode<T>>();
		BSTNode<T> nodo;
		while(t!=null){
			pila.push(t);
			t=null;
			while(!pila.isEmpty()){
				nodo=pila.pop();
				aux+=nodo.nodeValue+"  ";
				if(nodo.right!=null)
					pila.push(nodo.right);
				if(nodo.left!=null)
					pila.push(nodo.left);
			}
		}

		return aux;
	}
	
	public String toStringPreorder(){
		return toStringPreorder(root);
	}
	
	private static <T> String toStringPreorder(BSTNode<T> t){
		String aux = "";
		if(t != null){
			aux += t.nodeValue + "  "; 		//display the node
			aux += toStringPreorder(t.left);	//descend left
			aux += toStringPreorder(t.right);	//descend right
		}
		return aux;
	}
	
	public String toStringInorder() {
		String s = toStringInorder(root); return s;
	}
	private static <T> String toStringInorder(BSTNode<T> t) {
		String aux = "";
		if (t != null) {
			aux += toStringInorder(t.left);	// descend left
			aux += t.nodeValue + "  ";		// display the node
			aux += toStringInorder(t.right);	// descend right
		}
		return aux;
	}

	public String toStringPostorder() {
		String s = toStringPostorder(root); return s;
	}
	private static <T> String toStringPostorder(BSTNode<T> t) {
		String aux = "";
		if (t != null) {
			aux += toStringPostorder(t.left);	// descend left
			aux += toStringPostorder(t.right);	// descend right
			aux += t.nodeValue + "  ";		// display the node
		}
		return aux;
	}

	
	
	/**
	 * Añade todos los elementos de un array al BSTree de forma balanceada.
	 * @param aL arrayList a añadir al BSTree
	 */
	public void addBalanced(ArrayList<T> aL) {
		Less<T> comp= new Less<T>();
		Collections.sort(aL,comp);
		addBalanced(aL, 0, aL.size() - 1);
	}
	private void addBalanced(ArrayList<T> aL, int left, int right) {
		int mid = 0;
		if(left <= right){
			mid = (left+right)/2;
			add(aL.get(mid));
			addBalanced(aL,left,mid-1);
			addBalanced(aL,mid+1,right);
		}
	}
	/**
	 * Devuelve un arbol simetrico respecto del que lo instancia.
	 * @return arbol simetrico
	 */
	public BSTree<T> buildSimetricTree() {
		BSTree<T> treeTemp = new BSTree<T>();
		if(root != null)
			treeTemp.root = buildSimetricTree(this.root);
		return treeTemp;
	}
	private BSTNode<T> buildSimetricTree(BSTNode<T> t) {
		BSTNode<T> raiz, izquierdo, derecho;
		raiz = t;
		if(raiz != null){
			izquierdo = buildSimetricTree(t.left);
			derecho = buildSimetricTree(t.right);
			raiz.left = derecho;
			raiz.right = izquierdo;
		}
		
		return raiz;
	}
	/**
	 * Devuelve la altura desde el nodo que contiene x, hasta la raiz.
	 * @param x valor del nodo a buscar
	 * @return altura desde el nodo a buscar hasta la raiz.
	 */
	public int pathHeight(T x){
		if(find(x) == null )
			return -1;
		int count = 0;
		BSTNode<T> nodo = findNode(x);
		while(nodo != this.root){
			count++;
			nodo = nodo.parent;
		}
			
	return count;
	}

}
