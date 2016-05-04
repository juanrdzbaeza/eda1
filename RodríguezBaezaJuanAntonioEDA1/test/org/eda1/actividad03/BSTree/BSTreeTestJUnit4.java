package org.eda1.actividad03.BSTree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

//import org.eda1.estructurasdedatos.Iterator;
import org.junit.Before;
import org.junit.Test;

public class BSTreeTestJUnit4 {

	private BSTree<Integer> tree;
	
	@Before
	public void setUp() throws Exception {
		Integer[] arr = {120, 87, 43, 65, 140, 99, 17, 130, 22, 150, 56, 100, 125, 145, 135};	    
		tree = new BSTree<Integer>();

		for (int i = 0;i < arr.length; i++)
 			tree.add(arr[i]);		
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
	public void testPreorderDisplay() {
		assertEquals(tree.toStringPreorder(), "120  87  43  17  22  65  56  99  100  140  130  125  135  150  145  ");
		assertEquals(tree.toStringPreorder(), tree.toStringIterativePreorder());
	}

	@Test
	public void testHeight() {
		assertTrue(tree.height() == 4);
	}
	
	@Test
	public void testNumberOfLeaves() {
		assertTrue(tree.numberOfLeaves() == 6);
	}

	@Test
	public void testFindMin_FindMax() {
		assertTrue(tree.findMin() == tree.findMinIterative());
		assertTrue(tree.findMax() == tree.findMaxIterative());
		assertTrue(tree.findMin() == 17);
		assertTrue(tree.findMinIterative() == 17);
		assertTrue(tree.findMax() == 150);
		assertTrue(tree.findMaxIterative() == 150);
	}
	
	@Test
	public void testtoStringLevel() {
		assertEquals(tree.toStringLevel(2), "43 99 130 150 ");
		assertEquals(tree.toStringLevel(0), "120 ");
		assertEquals(tree.toStringLevel(4), "22 56 ");
		assertEquals(tree.toStringLevel(1), "87 140 ");
		assertEquals(tree.toStringLevel(3), "17 65 100 125 135 145 ");
	}
	
	@Test
	public void testinOrder_PostOrder() {
		assertEquals(tree.toStringInorder(), "17  22  43  56  65  87  99  100  120  125  130  135  140  145  150  ");
		assertEquals(tree.toStringInorder(), tree.toStringIterativeInorder());
		assertEquals(tree.toStringPostorder(), "22  17  56  65  43  100  99  87  125  135  130  145  150  140  120  ");
		assertEquals(tree.toStringPostorder(), tree.toStringIterativePostorder());
	}

	@Test
	public void testaddBalanced() {
		ArrayList<Integer> aL = new ArrayList<Integer>();
		tree.clear();

  		// build the initial tree
		int numElements = 7;
		for (int i = 0; i < numElements; i++)
 			aL.add(i);
		
		Collections.shuffle(aL);
		
		tree.addBalanced(aL);

		assertEquals(tree.displayTree(), "          (6)[2]\n     (5)[1]\n          (4)[2]\n(3)[0]\n          (2)[2]\n     (1)[1]\n          (0)[2]\n");
	}

	@Test
	public void testbuildSimetricTree() {
		assertEquals(tree.toStringInorder(), "17  22  43  56  65  87  99  100  120  125  130  135  140  145  150  ");
		BSTree<Integer> simetricTree = new BSTree<Integer>();
		simetricTree = tree.buildSimetricTree();
		assertEquals(simetricTree.toStringInorder(), "150  145  140  135  130  125  120  100  99  87  65  56  43  22  17  ");
	}
	
	@Test
	public void testpathHeight() {
		assertTrue(tree.pathHeight(130) == 2);
		assertTrue(tree.pathHeight(21) == -1);
		assertTrue(tree.pathHeight(100) == 3);
		assertTrue(tree.pathHeight(120) == 0);
		assertTrue(tree.pathHeight(22) == 4);
		assertTrue(tree.pathHeight(140) == 1);
	}

}
