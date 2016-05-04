package org.eda1.actividad02.ejercicio01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eda1.utilidades.Less;
import org.junit.Before;
import org.junit.Test;

public class HeapTestJUnit4 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHeap() {
		Less<Integer> less = new Less<Integer>();
    	Heap<Integer> heap = new Heap<Integer>(less);

    	Integer[ ] intArray = {17, 30, 15, 12, 9, 2, 8, 20, 7, 6, 5, 3};

		ArrayList<Integer> theArray = new ArrayList<Integer>();
		for (int i = 0; i < intArray.length; i++)
			theArray.add(intArray[i]);

    	for (int i = 0; i < theArray.size(); i++)
			heap.assign(i, theArray.get(i));

    	String content = heap.toString();
    	assertEquals(content, "[17, 30, 15, 12, 9, 2, 8, 20, 7, 6, 5, 3]");
    	
    	assertTrue(heap.isEmpty() == false);
    	assertTrue(heap.size() == 12);
    	assertTrue(heap.isHeap() == false);
    	
    	heap.makeHeap();
    	
    	assertTrue(heap.isHeap() == true);
    	
    	heap.add(21);
    	heap.add(1);
    	heap.add(45);
    	heap.add(4);

    	assertTrue(heap.isHeap() == true);
    	content = heap.toString();
    	assertEquals(content, "[1, 4, 2, 5, 6, 15, 3, 7, 12, 30, 9, 17, 21, 8, 45, 20]");
    	
    	assertTrue(heap.getMin() == (Integer)1);
    	
    	String c1 = heap.toString();
    	Integer minHeap = heap.removeMin();
    	heap.add(minHeap);
    	String c2  = heap.toString();
    	assertTrue(c1 != c2);
    	
     	heap.increaseKey(0, new Integer(9));
    	assertTrue(heap.isHeap() == true);
    	
    	assertFalse(heap.getMin() == (Integer)1);
    	
    	heap.decreaseKey(9, heap.getValue(9) - new Integer(1));
    	assertTrue(heap.isHeap() == true);
    	
    	assertTrue(heap.getMin() == (Integer)1);
    	
    	heap.replaceKey(1, new Integer(22));
    	assertTrue(heap.isHeap() == true);
    	
    	heap.delete(2);
    	assertTrue(heap.isHeap() == true);
    	assertTrue(heap.size() == 15);
    	
    	heap.replaceKey(0, new Integer(11));
    	assertTrue(heap.isHeap() == true);
    	assertTrue(heap.getMin() == (Integer)4);
    	
    	content = heap.toString();
    	assertEquals(content, "[4, 5, 8, 7, 6, 15, 10, 11, 12, 22, 9, 17, 21, 20, 45]");

    	content = heap.branchMinSum();
    	assertEquals(content, "<24> --- 9 6 5 4 ");
    	
	}

}
