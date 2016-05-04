/*
 * Graph.java
 */

package org.eda1.estructurasdedatos;

import java.util.Set;

/**
 * An interface that defines access and update methods for the vertices
 * and edges in a direct weighted graph.
 */

public interface Graph<T> {
	/**
	 * Returns the number of vertices in this graph.
	 * @return the number of vertices in this graph.
	 */
	public int numberOfVertices();

	/**
	 * Returns the number of edges in this graph.
	 * @return the number of edges in this graph.
	 */
	public int numberOfEdges();

	/**
	 * Returns <tt>true</tt> if this graph has not vertices or edges.
	 * @return <tt>true</tt> if this graph has not vertices or edges.
	 */
	public boolean isEmpty();

	/**
	 * Returns the weight of the edge connecting vertex v1 to v2.
	 * If the edge (v1,v2) does not exist, return -1.
	 * @param v1 source vertex of the edge.
	 * @param v2 destination vertex of the edge.
	 * @return the weight of the edge connecting vertex v1 to v2 or
	 *         <tt>-1</tt> if it does not exist.
	 * @throws IllegalArgumentException if v1 or v2 is not a vertex in this graph.
	 */
	public double getWeight(T v1, T v2);

	/**
	 * If edge (v1, v2) is in the graph, update the weight of
	 * the edge and return the previous weight; otherwise, return
	 * <tt>-1</tt>.
	 * @param v1 source vertex of the edge.
	 * @param v2 destination vertex of the edge.
	 * @param w weight assigned to the edge.
	 * @return the original weight of the edge or <tt>-1</tt> if the edge does not exist.
	 * @throws IllegalArgumentException if v1 or v2 is not a vertex in this graph.
	 */
	public double setWeight(T v1, T v2, double w);

	/**
	 * Returns the vertices that are adjacent to vertex v in a
	 * <tt>Set</tt> object.
	 * @param v vertex in the graph.
	 * @return the set of vertices that are adjacent to vertex v.
	 * @throws IllegalArgumentException if v is not a vertex in this graph.
	 */
	public Set<T> getNeighbors(T v);

	/**
	 * If edge (v1, v2) is not in the graph, add the edge with weight
	 * w and return <tt>true</tt>; return <tt>false</tt> if the edge
	 * is already in the graph.
	 * @param v1 source vertex of the new edge.
	 * @param v2 destination vertex of the new edge.
	 * @param w weight assigned to the edge.
	 * @return <tt>true</tt> if a new edge is added.
	 * @throws IllegalArgumentException if v1 or v2 is not a vertex in this graph.
	 */
	public boolean addEdge(T v1, T v2, double w);

	/**
	 * If vertex v is not in the graph, add it to the graph and return
	 * <tt>true</tt>; otherwise return <tt>false</tt>.
	 * @param v vertex in the graph.
	 * @return <tt>true</tt> if a new vertex is added.
	 */
	public boolean addVertex(T v);

	/**
	 * If edge (v1, v2) is in the graph, remove the edge and return
	 * <tt>true</tt>; otherwise return <tt>false</tt>
	 * @param v1 source vertex of the edge.
	 * @param v2 destination vertex of the edge.
	 * @return <tt>true</tt> if an edge is removed.
	 * @throws IllegalArgumentException if v1 or v2 is not a vertex in this graph.
	 */
	public boolean removeEdge(T v1, T v2);

	/**
	 * If vertex v is in the graph, remove it and return
	 * <tt>true</tt>; otherwise return <tt>false</tt>.
	 * @param v vertex in the graph.
	 * @return <tt>true</tt> if a vertex is removed.
	 */
   public boolean removeVertex(T v);

	/**
	 * Removes all of the vertices and edges from the graph.
	 */
	public void clear();

    /**
     * Returns a set view of the vertices in this graph.  The set is
     * backed by the graph, so changes to the graph are reflected in the set, and
     * vice-versa.  If the map is modified while an iteration over the set is
     * in progress
     *
     * @return a set view of the vertices in this graph.
     */
	public Set<T> vertexSet();

	/**
	 * Returns <tt>true</tt> if v is a vertex in this graph and
	 * <tt>false</tt> otherwise.
	 * @param v vertex in the graph.
	 * @return <tt>true</tt> if v is a vertex in this graph.
	 */
	public boolean containsVertex(T v);

	/**
	 * Returns <tt>true</tt> if there is an edge from v1 to v2 and
	 * <tt>false</tt> otherwise.
	 * @param v1 source vertex of the edge.
	 * @param v2 destination vertex of the edge.
	 * @return <tt>true</tt> if there is an edge from v1 to v2.
	 * @throws IllegalArgumentException if v1 or v2 is not a vertex in this graph.
	 */
	public boolean containsEdge(T v1, T v2);
}
