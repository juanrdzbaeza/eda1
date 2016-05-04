package org.eda1.actividad03.AVLTree;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//import org.eda1.estructurasdedatos.Iterator;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTestJUnit4 {

	String directorioEntrada;
	
	private AVLTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		Integer[] arr = {120, 87, 43, 65, 140, 99, 17, 130, 22, 150, 56, 100, 125, 145, 135};	    
		tree = new AVLTree<Integer>();

		for (int i = 0;i < arr.length; i++)
 			tree.add(arr[i]);
		
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + 
				"src" + File.separator + 
				"org" + File.separator + 
				"eda1" + File.separator + 
				"actividad03" + File.separator +
				"AVLTree" + File.separator;		
	}

	@Test
	public void testBuscar() {
		
		assertTrue(tree.size() == 15);
		assertTrue(tree.contains(140));
		assertFalse(tree.contains(1));
		
		assertTrue(tree.find(140).equals(140));
		
		assertNull(tree.find(1));
	}

	@Test
	public void testClear() {
		assertTrue(tree.size() == 15);
		tree.clear();
		assertTrue(tree.size() == 0);
	}

	@Test
	public void testContains() {
		assertTrue(tree.size() == 15);
		assertTrue(tree.contains(140));
		assertFalse(tree.contains(1));
	}

	
	@Test
	public void testIsEmpty() {
		assertTrue(tree.size() == 15);
		assertFalse(tree.isEmpty());
		tree.clear();
		assertTrue(tree.isEmpty());
	}
	
	@Test
	public void testIterator() {
		Iterator<Integer> iter = tree.iterator(); 
		
		try{
			iter.current();
			fail();	
		}catch (Exception e) {
			System.out.println(e);
			assertTrue(e instanceof NullPointerException);
		}
		
		assertEquals(iter.next(), new Integer(17));
		assertEquals(iter.current(), new Integer(17));
		
		assertEquals(iter.next(), new Integer(22));
		assertEquals(iter.current(), new Integer(22));	
	}

	@Test
	public void testRemove() {
		assertTrue(tree.size() == 15);
		assertTrue(tree.remove(140));
		assertFalse(tree.remove(1));
		assertTrue(tree.size() == 14);
		assertFalse(tree.remove(140));
	}

	@Test
	public void testSize() {
		assertTrue(tree.size() == 15);
		tree.clear();
		assertTrue(tree.size() == 0);
		tree.add(3);
		assertTrue(tree.size() == 1);
	}

	@Test
	public void testFind() {
		assertTrue(tree.find(140).equals(140));	
		assertNull(tree.find(1));
	}
	 
	@Test
	public void testMasiveRemove() {
		ArrayList<Integer> aL = new ArrayList<Integer>();
		tree.clear();

  		// build the initial tree
		int numElements = 1000000;
		for (int i = 0; i < numElements; i++)
 			aL.add(i);
		
		//Collections.shuffle(aL);
		for (int i = 0; i < aL.size() / 2; i++) {
			if (i % 2 == 0) {
				Integer temp = aL.get(i);
				aL.set(i, aL.get(aL.size() - i - 1));
				aL.set(aL.size() - i - 1, temp);
			}
		}		

		for (int i = 0; i < aL.size(); i++) {
			tree.add(aL.get(i));
		}

		assertTrue(tree.size() == 1000000);
		assertTrue(tree.height() == 24);

		for (int i = 0; i < aL.size(); i++)
			tree.remove(aL.get(i));

		assertTrue(tree.size() == 0);
		assertTrue(tree.height() == -1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testserializedAVLTree() throws FileNotFoundException, IOException, ClassNotFoundException {
	      String storeFile = directorioEntrada + "AVLTree.dat";

	      // object stream connected to file "storeFile" for output
	      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeFile));
	      
	      // send object and close down the output stream
	      oos.writeObject(tree);
	      oos.flush();
	      oos.close();

	      // object stream connected to file "storeFile" for output
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeFile));

	      // reconstruct object and allocate new current object
	  	  AVLTree<Integer> serializedAVLtree  = new AVLTree<Integer>();
	      serializedAVLtree = (AVLTree<Integer>)ois.readObject();
		
		  Iterator<Integer> iter = serializedAVLtree.iterator();
		  Integer currItem;
		  while (iter.hasNext()) {
			  currItem = iter.next();
			  assertTrue(tree.contains(currItem));
		  }
		  ois.close();
	}

}
