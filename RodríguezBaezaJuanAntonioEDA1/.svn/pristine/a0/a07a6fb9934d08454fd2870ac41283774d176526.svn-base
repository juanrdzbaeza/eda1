package org.eda1.actividad02.ejercicio02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.eda1.utilidades.Less;
import org.eda1.utilidades.NumerosAleatorios;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTestJUnit4 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHeapSort() {
		Integer[] intArray = {59,  32,  46,  87, 44,  95,  17,  75,  40,  50};
		Integer integer1, integer2;
		int i;
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		ArrayList<Integer> scores2 = new ArrayList<Integer>();
		ArrayList<Integer> scores3 = new ArrayList<Integer>();
		for (i = 0; i < intArray.length; i++){
			scores1.add(intArray[i]);
			scores2.add(intArray[i]);
			scores3.add(intArray[i]);
		}
		
		assertTrue(intArray.length == scores1.size());
		assertTrue(intArray.length == scores2.size());
		assertTrue(intArray.length == scores3.size());
		Iterator<Integer> iterator1 = scores1.iterator();
		Iterator<Integer> iterator2 = scores2.iterator();
		for (; iterator1.hasNext(); ) {
			integer1 = (Integer) iterator1.next();
			integer2 = (Integer) iterator2.next();
			assertEquals(integer1, integer2);
		}
		
		Comparator<Integer> comp = new Less<Integer>();
		
		Collections.sort(scores3, comp);

		HeapSort.sortHeap(scores1, comp);

		HeapSort.heapSort(scores2, comp);

		assertEquals(scores1, scores2);

		assertEquals(scores1, scores3);
		assertEquals(scores2, scores3);
	}

	@Test
	public void testStabilitygHeapSort() {

		Entero[] array = new Entero[100];
		NumerosAleatorios aleatorio = new NumerosAleatorios();
		for (int i = 0; i < array.length; i++) {
			array[i] = new Entero(new Integer(aleatorio.randomInt(1, 10)), i);
		}

		ArrayList<Entero> scores1 = new ArrayList<Entero>();
		ArrayList<Entero> scores2 = new ArrayList<Entero>();
		for (int i = 0; i < array.length; i++){
			scores1.add(array[i]);
			scores2.add(array[i]);
		}
		
		Comparator<Entero> comp = new Less<Entero>();
		
		HeapSort.heapSort(scores1, comp);
		
		Collections.sort(scores2, comp);
		
		assertFalse(scores1.equals(scores2));
	}

}


class Entero implements Comparable<Entero> {

	Integer entero;
	int posicion;

	public Entero(Integer entero, int posicion) {
		super();
		this.entero = entero;
		this.posicion = posicion;
	}

	public int compareTo(Entero o) {
		return entero.compareTo(((Entero) o).entero);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		Integer ent = ((Entero) obj).entero;
		int pos = ((Entero) obj).posicion;
		if ((entero.equals(ent)) && (posicion == pos))
			return true;
		
		return false;
	}

	public String toString() {

		return "[" + entero + "," + posicion + "]";
	}

}

