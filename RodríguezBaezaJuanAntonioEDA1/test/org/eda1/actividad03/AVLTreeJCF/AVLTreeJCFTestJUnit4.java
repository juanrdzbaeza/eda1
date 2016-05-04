package org.eda1.actividad03.AVLTreeJCF;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeJCFTestJUnit4 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAVLTreeJCF() {
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		ArrayList<Integer> aList = new ArrayList<Integer>();

        int amount = 10;
        for (int i = 0; i < amount; i++)
	        avlTree.add(i);

        for (int i = 0; i < amount / 2; i++)
	        aList.add(i);

		AVLTree<Integer> otherAVLTree = new AVLTree<Integer>(avlTree);
		AVLTree<Integer> newOtherAVLTree = new AVLTree<Integer>(avlTree);
				
		assertTrue(avlTree.equals(otherAVLTree));
		assertTrue(avlTree.equals(newOtherAVLTree));
		assertTrue(newOtherAVLTree.equals(otherAVLTree));
		
        avlTree.removeAll(aList);
        
        assertEquals(avlTree.toString(), "[5, 6, 7, 8, 9]");

		assertFalse(avlTree.equals(otherAVLTree));

		assertTrue(!(avlTree.containsAll(aList)));
		assertTrue(otherAVLTree.containsAll(aList));

		assertFalse(avlTree.containsAll(otherAVLTree));
		
		otherAVLTree.retainAll(avlTree);

        assertEquals(avlTree.toString(), otherAVLTree.toString());
		assertFalse(avlTree.equals(otherAVLTree));

		avlTree.addAll(aList);
		
        assertEquals(avlTree.toString(), newOtherAVLTree.toString());
		assertFalse(avlTree.equals(newOtherAVLTree));
		
		assertTrue(newOtherAVLTree.containsAll(otherAVLTree));
		
		newOtherAVLTree.removeAll(otherAVLTree);
		
        assertEquals(newOtherAVLTree.toString(), aList.toString());

		assertFalse(newOtherAVLTree.containsAll(otherAVLTree));
		
        otherAVLTree.retainAll(newOtherAVLTree);
        
        assertEquals(otherAVLTree.toString(), "[]");
        
		avlTree.retainAll(newOtherAVLTree);

        assertEquals(avlTree.toString(), newOtherAVLTree.toString());
		assertFalse(avlTree.equals(newOtherAVLTree));

	}

}
