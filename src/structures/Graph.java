package structures;

/**
 * An interface for a graph.
 * 
 * @author WarrenGreen
 *
 * @param <V>
 * @param <E>
 */
public interface Graph<V, E> {

	/** Returns an iterable collection of all vertices in graph */
	public Iterable<VertexInt<V>> vertices();

	/** Returns an iterable collection of all edges in graph */
	public Iterable<EdgeInt<E>> edges();

	/** Returns an iterable collection of all edges incident upon vertex v */
	public Iterable<EdgeInt<E>> incidentEdges(VertexInt<V> v);

	/** Returns the endvertex of edge e distinct from vertex v; an error occurs 
	 * if e is not incident on Edge e 
	 * */
	public VertexInt<V> opposite(VertexInt<V> v, EdgeInt<E> e);

	/** Returns an array storing the end vertices of edge e */
	public VertexInt<V>[] endVertices(EdgeInt<E> e);

	/** Returns whether vertices v and w and adjacent */
	public boolean areAdjacent(VertexInt<V> v, VertexInt<V> u);

	/** Replace element of Vertex v with element x and return the old element */
	public V replace(VertexInt<V> v, V x);

	/** Replace element of Edge e with element x and return the old element */
	public E replace(EdgeInt<E> e, E x);

	/** Insert and return a new vertex storing element x */
	public VertexInt<V> insertVertex(V x);

	/** Insert and return a new undirected edge with end vertices v and w and 
	 * storing element x
	 */
	public EdgeInt<E> insertEdge(VertexInt<V> v, VertexInt<V> w, E x);

	/** Remove vertex v and all its incident edges and return the element stored at v */
	public V removeVertex(VertexInt<V> v);

	/** Remove edge e and return the element stored at e */
	public E removeEdge(EdgeInt<E> e);
}