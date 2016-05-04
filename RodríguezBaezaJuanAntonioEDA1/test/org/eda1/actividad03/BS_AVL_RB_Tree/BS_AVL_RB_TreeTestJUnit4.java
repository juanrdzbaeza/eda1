package org.eda1.actividad03.BS_AVL_RB_Tree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BS_AVL_RB_TreeTestJUnit4 {

	BSTree<Integer> treeBSTree;
	AVLTree<Integer> treeAVLTree;
	RBTree<Integer> treeRBTree;

	@Before
	public void setUp() throws Exception {
		treeBSTree = new BSTree<Integer>();
		treeAVLTree = new AVLTree<Integer>();
		treeRBTree = new RBTree<Integer>();		
	}

	@Test
	public void testpathHeightAllTrees() {

		ArrayList<Integer> aL = new ArrayList<Integer>();

  		// build the initial tree
		int numElements = 10000;
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

		for (int i = 0; i < aL.size(); i++)
			treeBSTree.add(aL.get(i));

		int countHeightBS = 0;
		for (int i = 0; i < aL.size(); i++)
			countHeightBS += treeBSTree.pathHeight(aL.get(i));
		double averageBS = (double)countHeightBS / (double)aL.size();
		
		assertTrue(treeBSTree.size() == 10000);
		assertTrue(treeBSTree.pathHeight(aL.get(aL.size() / 5)) == 2000);
		assertTrue(countHeightBS == 25004999);
		assertTrue(averageBS == 2500.4999);
		
		treeBSTree.clear();
		
		for (int i = 0; i < aL.size(); i++)
			treeAVLTree.add(aL.get(i));

		int countHeightAVL = 0;
		for (int i = 0; i < aL.size(); i++)
			countHeightAVL += treeAVLTree.pathHeight(aL.get(i));
		double averageAVL = (double)countHeightAVL / (double)aL.size();

		assertTrue(treeAVLTree.size() == 10000);
		assertTrue(treeAVLTree.pathHeight(aL.get(aL.size() / 5)) == 11);
		assertTrue(countHeightAVL == 116431);
		assertTrue(averageAVL == 11.6431);
		
		treeAVLTree.clear();
		
		for (int i = 0; i < aL.size(); i++)
			treeRBTree.add(aL.get(i));

		int countHeightRB = 0;
		for (int i = 0; i < aL.size(); i++)
			countHeightRB += treeRBTree.pathHeight(aL.get(i));
		double averageRB = (double)countHeightRB / (double)aL.size();

		assertTrue(treeRBTree.size() == 10000);
		assertTrue(treeRBTree.pathHeight(aL.get(aL.size() / 5)) == 11);
		assertTrue(countHeightRB == 114712);
		assertTrue(averageRB == 11.4712);
		
		treeRBTree.clear();
		
	}

}
