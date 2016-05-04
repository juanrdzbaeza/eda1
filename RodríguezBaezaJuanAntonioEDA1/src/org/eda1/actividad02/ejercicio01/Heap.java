package org.eda1.actividad02.ejercicio01;

import java.util.*;

public class Heap<T> {
	protected static final int DEFAULT_INITIAL_CAPACITY = 7;

	protected ArrayList<T> theHeap;

	protected Comparator<T> comparator;

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos que están ordenados por un objeto Comparator dado.
	 * 
	 * @param initialCapacity
	 *            - Capacidad inicial para el Heap.
	 * @param comp
	 *            - el objeto Comparator.
	 * 
	 */
	public Heap(int initialCapacity, Comparator<T> comp) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		theHeap = new ArrayList<T>(initialCapacity);
		comparator = comp;
	} // constructor con una capacidad inicial y un Comparator

	/**
	 * Inicializa el Heap con una capacidad inicial por defecto
	 * DEFAULT_INITIAL_CAPACITY y con elementos en una clase que implemente la
	 * interfaz Comparable
	 * 
	 */
	public Heap() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	} // constructor por defecto

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos en una clase que implementa la interface Comparable
	 * 
	 * @param initialCapacity
	 *            - la capacidad inicial del Heap.
	 * 
	 */
	public Heap(int initialCapacity) {
		this(initialCapacity, null);
	} // constructor con una capacidad inicial

	/**
	 * Inicializa el Heap a una capacidad inicial de initialCapacity, y con
	 * elementos comparados según el objeto Comparator comp.
	 * 
	 * @param comp
	 *            - el objeto Comparator utilizado para comparar elementos en el
	 *            Heap
	 * 
	 */
	public Heap(Comparator<T> comp) {
		this(DEFAULT_INITIAL_CAPACITY, comp);
	} // constructor con parámetro Comparator

	/**
	 * Inicializa este Heap con un objeto Heap pasado por parámetro Los
	 * elementos en este Heap se compararán como se especifiquen en el objeto
	 * Heap que se pasa como parámetro The worstTime(n) is O(n), donde n es el
	 * número de elementos en el Heap pasado como parámetro.
	 * 
	 * @param otherHeap
	 *            - el Heap que se va a copiar en en objeto heap actual
	 * 
	 */
	public Heap(Heap<T> otherHeap) {
		theHeap = new ArrayList<T>(otherHeap.theHeap);
		comparator = otherHeap.comparator;
	} // constructor copia

	/**
	 * Devuelve el número de elementos en el Heap
	 * 
	 * @return número de elementos que hay en este Heap.
	 * 
	 */
	public int size() {
		return theHeap.size();
	} // metodo size

	/**
	 * Determina si el Heap no tiene elementos (está vacio).
	 * 
	 * @return true - si el heap no tiene elementos, en otro caso false;
	 * 
	 */
	public boolean isEmpty() {
		return theHeap.isEmpty();
	} // método isEmpty

	/**
	 * Inserta un elemento en el Heap. The worstTime(n) is O(n) and
	 * averageTime(n) is constant.
	 * 
	 * @param element
	 *            - el elemento que va a ser insertado en el Heap
	 * 
	 */
	public void add(T element) {
		theHeap.add(element);
		siftUp();
	} // metodo add

	/**
	 * Restaura las propiedades del Heap, empezando desde el final hasta la raiz
	 * 
	 * The worstTime(n) is O(log n), and averageTime(n) is constant.
	 * 
	 */
	protected void siftUp() {
		int child = theHeap.size() - 1, parent;

		while (child > 0) {
			parent = (child - 1) >> 1;	// >> 1 is slightly faster than / 2
										// => parent = (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			child = parent;
		}
	} // metodo siftUp
	
	/**
	 * Restaura las propiedades del Heap, empezando desde el parametro que se le pasa
	 * 
	 * @param start
	 *            indice de inicio
	 */
	protected void siftUp(int start) {
		int child = start, parent;

		while (child > 0) {
			parent = (child - 1) >> 1; // >> 1 is slightly faster than / 2
										// => parent = (child - 1) / 2
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			child = parent;
		}
	} // metodo siftUp

	/**
	 * Compara dos elementos dados según Comparable o un objeto Comparator
	 * 
	 * @param element1
	 *            - uno de los elementos a comparar.
	 * @param element2
	 *            - el otro elemento a comparar.
	 * 
	 * @return un entero negativo, 0, o un entero positivo, dependiendo de si
	 *         element1 es menor que, igual a o mayor que element2.
	 * 
	 */
	
	protected int compare(T element1, T element2) {
		return (this.comparator == null ? ((Comparable<T>) element1).compareTo(element2) : comparator.compare(element1, element2));
	} // metodo compare

	/**
	 * Intercambia dos elementos del Heap (parent y child).
	 * 
	 * @param parent
	 *            - el índice del elemento padre (parent).
	 * @param child
	 *            - el índice del elemento hijo (child).
	 * 
	 */
	protected void swap(int parent, int child) {
		T temp = theHeap.get(parent);
		theHeap.set(parent, theHeap.get(child));
		theHeap.set(child, temp);
	} // metodo swap

	/**
	 * Devuelve el elemento con el menor valor del Heap.
	 * 
	 * @return el elemento con el menor valor del Heap.
	 * 
	 * @throws NoSuchElementException
	 *             - si el Heap está vacío.
	 * 
	 */
	public T getMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Heap removeMin(): empty heap");

		return theHeap.get(0); // preguntandoloooooooooooooooooooooo
	} // metodo getMin

	/**
	 * Elimina el elemento con el menor valor del Heap. The worstTime(n) is
	 * O(log n).
	 * 
	 * @return el elemento eliminado.
	 * 
	 * @throws NoSuchElementException
	 *             - si el Heap está vacío.
	 * 
	 */
	public T removeMin() {
		if (theHeap.isEmpty())
			throw new NoSuchElementException("Heap removeMin(): empty heap");

		T minElem = theHeap.get(0);
		theHeap.set(0, theHeap.get(theHeap.size() - 1));
		theHeap.remove(theHeap.size() - 1);
		siftDown(0);
		return minElem;
	} // metodo removeMin

	/**
	 * Restaura las propiedades del Heap (hundir) The worstTime(n) is O(log n).
	 * 
	 * @param start
	 *            - el índice del Heap donde va a empezar la restauración de la
	 *            propiedad.
	 * 
	 */
	protected void siftDown(int start) {
		int parent = start, child = (parent << 1) + 1;	// parent << 1 is
														// slightly faster than
														// parent * 2
														// => (2 * parent) + 1

		while (child < theHeap.size()) {
			if (child < theHeap.size() - 1
					&& compare(theHeap.get(child), theHeap.get(child + 1)) > 0)
				child++; // child is the right child (child = (2 * parent) + 2)
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	} // function siftDown
	/*
	 * metodos nuevos
	 */
	protected void siftDown() {
		int parent = 0, child = (parent << 1) + 1;// preguntar porque 0 y no 1
		
		while (child < theHeap.size()) {
			if (child < theHeap.size() - 1
					&& compare(theHeap.get(child), theHeap.get(child + 1)) > 0)
				child++; // child is the right child (child = (2 * parent) + 2)
			if (compare(theHeap.get(child), theHeap.get(parent)) >= 0)
				break;
			swap(parent, child);
			parent = child;
			child = (parent << 1) + 1; // => child = (2 * parent) + 1
		}
	} // function siftDown
	
	/**
	 * Metodo para asignar un elemento a un indice concretos
	 * 
	 * @param indice
	 * 			indice donde insertar el elemento
	 * @param element
	 * 			elemento a insertar
	 */
	
	public void assign(int indice, T element) {
		if (theHeap.size() == 0 || indice > theHeap.size()) {
			theHeap.add(element);
		} else {
			theHeap.add(indice, element);
		}
	}//function assing
	
	/**
	 * Metodo para comprobar si el monticulo esta ordenado. Recorrido Top-Down
	 * 
	 * @return true en caso de estar ordenado, false si esta desordenado
	 */
	public boolean isHeap() {
		int padre = 0, hijo;
		while (padre < (theHeap.size() >> 2)) {
			hijo = (padre << 1) + 1;
			if (hijo < theHeap.size() - 1
					&& compare(theHeap.get(hijo), theHeap.get(hijo + 1)) > 0)
				hijo++;
			if (compare(theHeap.get(hijo), theHeap.get(padre)) < 0)
				return false;
			padre++;
		}
		return true;
	}//function isHeap
	
	/**
	 * Metodo para comprobar si el monticulo esta ordenado. Recorrido Bottom-Up
	 * 
	 * @return true en caso de estar ordenado, false si esta desordenado
	 */
	public boolean isHeap2() {
		int child = theHeap.size() - 1, parent;

		while (child > 0) {
			parent = (child - 1) >> 1; 
			if (compare(theHeap.get(child), theHeap.get(parent)) < 0)
				return false;	
			child-- ;
		}
		return true;
	}
	
	/**
	 * Metodo para restablecer el orden en el heap.
	 */
	public void makeHeap() {
		//for (int i = (theHeap.size() >> 1) - 1; i >= 0; i--) {
		for (int i = (theHeap.size() - 1) >> 1; i >= 0; i--) {
			siftDown(i);
		}
	}
	
	/**
	 * Metodo que suma al elemento en la posicion i el parametro element
	 * 
	 * @param i
	 *            index de nodo heap a modificar
	 * @param element
	 *            cantidad a sumar al nodo i
	 */
	
	public boolean increaseKey(int i, int element) {
		if (i < 0 || i > theHeap.size() - 1) {
			return false;
		}
		if (element <= 0) {
			return false;
		}
		theHeap.set(i, (T) (Integer) ((Integer) theHeap.get(i) + element));
		siftDown(i);
		return true;
	}
	
	/**
	 * Devuelve el elemento con indice i
	 * 
	 * @param i
	 * 			indice del elemento a devolver
	 * @return elemento<T>
	 */
	public T getValue(int i) {
		return theHeap.get(i);
	}

	/**
	 * Metodo que resta al elemento en la posicion i el parametro element
	 * 
	 * @param i
	 * 			indice de nodo heap a modificar
	 * @param element
	 * 			cantidad a restar al nodo i
	 */

	public boolean decreaseKey(int i, Integer element) {
		if (i < 0 || i > theHeap.size() - 1) {
			return false;
		}
		if (element <= 0) {
			return false;
		}
		theHeap.set(i, (T) (Integer) ((Integer) theHeap.get(i) - element));
		siftUp(i);
		return true;
	}

	/**
	 * Metodo que replaza en elemento del indice i con el elemento nuevo element
	 * @param i
	 * 			indice de nodo heap a reemplazar
	 * @param element
	 * 			nuevo elemento 			
	 */

	public boolean replaceKey(int i, T element) {
		if (i < 0 || i > theHeap.size() - 1) {
			return false;
		}
		if ((Integer) element <= 0) {
			return false;
		}
		theHeap.set(i, (T) element);

		if (i != 0 && (compare(getValue((i - 1) >> 1), getValue(i)) > 0)) {
			siftUp();
		} else {
			siftDown(i);
		}
		return true;
	}

	/**
	 * Metodo que eliminta el elemento en el indice i
	 * 
	 * @param i
	 *            indice del elemnto a eliminar
	 */
	public boolean delete(int i) {
		if (i >= theHeap.size() || i < 0)
			return false;
		Integer minimo = (Integer) getValue(i) - (Integer) getMin() + 1;
		decreaseKey(i, minimo);
		removeMin();
		return true;
	}
	/**
	 * Devuelve la rama (desde la hoja hasta la raiz) con el valor minimo de la suma de valores de los nodos
	 * 
	 * @return string con el valor de la suma y los valores del recorrido
	 */
	public String branchMinSum() {
		if (theHeap.size() == 0)
			return "< 0 > ---  ";
		if (theHeap.size() == 1)
			return "<" + getMin() + "> --- " + getMin() + " ";

		int sum =0;
		String tracer = "";
		int hoja = theHeap.size() >> 1, tempSum, currentHoja;
		String aux;
		
		while (hoja < theHeap.size()) {
			currentHoja = hoja;
			tempSum = 0;
			aux = "";
			while (currentHoja != 0) {
				tempSum += (Integer) getValue(currentHoja);
				aux += getValue(currentHoja) + " ";
				currentHoja = (currentHoja - 1) >> 1;
			}
			tempSum += (Integer) getValue(currentHoja);
			aux += getValue(currentHoja) + " ";
			
			if(hoja == theHeap.size() >> 1){
				tracer = aux;
				sum = tempSum;
			}
			if(sum > tempSum){
				tracer = aux;
				sum = tempSum;
			}
			hoja++;
		}
		
		return "<"+sum+"> --- "+tracer;
	}

	public String toString() {
		return theHeap.toString();
	}
	
} // class Heap

