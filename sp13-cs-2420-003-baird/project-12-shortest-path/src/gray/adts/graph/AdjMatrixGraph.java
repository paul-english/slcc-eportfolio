package gray.adts.graph;

/**
 * Adjacency Matrix implementation of an undirected >Graph>.
 */
public class AdjMatrixGraph<T> extends AdjMatrixDiGraph<T> {

  public AdjMatrixGraph() {
    super();
  }

  /**
   * Add an edge connecting vertex <code>v1</code> to
   *  <code>v2</code>. This edge is bidirectional.
   * @param v1 The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param v2 The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public void addEdge( Vertex<T> v1, Vertex<T> v2 ) {
    super.addEdge( v1, v2 );

    // if we get here, the superclass method completed
    // successfully and we can set edge from v2 to v1
    this.adjMatrix[v2Pos][v1Pos] = 1;
  }

  /**
   * Remove the edge from <code>v1</code> to <code>v2</code>
   * from this graph.
   * @param v1 The source vertex for the edge to remove; must
   * not be <code>null</code> and must be a vertex in this graph.
   * @param v2 The destination vertex for the edge to remove;
   * must not be <code>null</code> and must be a vertex in this
   * graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public void removeEdge( Vertex<T> v1, Vertex<T> v2 ) {
    super.removeEdge( v1, v2 );

    // if we get here, the superclass method completed
    // successfully and we can clear edge from v2 to v1
    this.adjMatrix[v2Pos][v1Pos] = 0;
  }

  /**
   * Remove vertex <code>v</code> and all edges incident on
   * <code>v</code> from this graph.
   * @param v The vertex to remove; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> is
   * <code>null</code> or is not in this graph.
   */
  public void removeVertex( Vertex<T> v ) {
    int numEdges = super.numberOfEdges;
    super.removeVertex( v );

    // if we get here, the superclass method completed
    // successfully and we can update the number of edges
    // For edge (v1, v2), the superclass removeVertex() will
    // decremented numberOfEdges twice.
    super.numberOfEdges = numEdges - ( numEdges -
                                       super.numberOfEdges ) / 2;
  }
}
