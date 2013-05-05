package gray.adts.graph;

/**
 * A weighted graph is a graph that allows the edges to
 * have associated weights (costs). These weights must be >= 0.0.
 */
public interface WeightedGraph<T> extends Graph<T> {

  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. In an undirected graph, this edge is
   * bidirectional.
   * @param v1  The source vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @param weight The weight of this edge; must be >= 0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code>
   * or <code>v2</code> are <code>null</code> or are not in
   * this graph, or if <code>weight</code> < 0.0.
   */
  void addEdge( Vertex<T> v1, double weight, Vertex<T> v2 );

  /**
   * Get the weight of the edge from <code>v1</code> to
   * <code>v2</code>.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @return double The weight of the edge from <code>v1</code>
   * to <code>v2</code>.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  double getEdgeWeight( Vertex<T> v1, Vertex<T> v2 );

  /**
   * Reset the weight for the edge connecting vertex
   * <code>v1</code> to <code>v2</code>.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param newWeight The weight of this edge; must be >= 0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph, or if <code>weight</code> < 0.0.
   */
  void setEdgeWeight( Vertex<T> v1, double newWeight,
                      Vertex<T> v2 );
}
