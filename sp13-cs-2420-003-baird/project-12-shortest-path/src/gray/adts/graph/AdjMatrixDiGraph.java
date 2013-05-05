package gray.adts.graph;

import java.util.*;

/**
 * An implementation of the <code>Graph</code> interface for a
 * directed graph using an adjacency matrix to indicate the
 * presence/absence of edges connecting vertices in the graph.
 */
public class AdjMatrixDiGraph<T> implements Graph<T> {

  protected int numberOfVertices;
  protected int numberOfEdges;

  /**
   * adjMatrix[i][j] = 1; an edge exists FROM vertex i TO vertex j
   * adjMatrix[i][j] = 0; NO edge exists from vertex i to vertex j
   */
  protected int[][] adjMatrix;

  /**
   * Stores the vertices that are part of this graph. There is no
   * requirement that the vertices be in adjacent cells of the
   * array; as vertices are deleted, some gaps may appear.
   */
  protected Vertex<T>[] vertices;

  /**
   * v1Pos and v2Pos represent a position in adjMatrix. This
   * class and subclasses use it to access an edge.
   */
  protected int v1Pos, v2Pos;

  protected static int SIZE = 14;

  /**
   * Constructor. Create an empty instance of a directed graph.
   */
  public AdjMatrixDiGraph() {
    this.numberOfVertices = 0;
    this.numberOfEdges = 0;
    this.adjMatrix = new int[this.SIZE][this.SIZE];
    this.vertices = new Vertex[this.SIZE];
  }

  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. This edge must not already be in the graph.
   * In an undirected graph, this edge is bidirectional.
   * @param v1 The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param v2 The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code>, are not in this
   * graph or if the edge already exists in the graph.
   */
  public void addEdge( Vertex<T> v1, Vertex<T> v2 ) {
    v1Pos = getVerticesIndexFor( v1 );
    v2Pos = getVerticesIndexFor( v2 );

    if ( v1Pos == -1 || v2Pos == -1 ) {
      throw new IllegalArgumentException( "vertex not found" );
    }
    // avoid adding duplicate edges
    if ( this.adjMatrix[v1Pos][v2Pos] == 0 ) {
      this.adjMatrix[v1Pos][v2Pos] = 1;
      this.numberOfEdges++;
    }
    else {
      throw new IllegalArgumentException( "duplicate edge "
                                          + v1 + " " + v2 );
    }
  }

  /**
   * Remove the edge from <code>v1</code> to <code>v2</code> from
   * this graph.
   * @param v1 The source vertex of the edge to remove; must not
   * be <code>null</code> and must be a vertex in this graph.
   * @param v2 The destination vertex of the edge to remove; must
   * not be <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code>, are not in this
   * graph, or the edge doesn't exist.
   */
  public void removeEdge( Vertex<T> v1, Vertex<T> v2 ) {
    v1Pos = getVerticesIndexFor( v1 );
    v2Pos = getVerticesIndexFor( v2 );

    if ( v1Pos == -1 || v2Pos == -1 ) {
      throw new IllegalArgumentException( "vertex not found" );
    }
    if ( this.adjMatrix[v1Pos][v2Pos] == 1 ) {
      this.adjMatrix[v1Pos][v2Pos] = 0;
      this.numberOfEdges--;
    }
    else {
      throw new IllegalArgumentException( "edge not found" );
    }
  }

  /**
   * Remove vertex <code>v</code> and all edges incident
   * on <code>v</code> from this graph.
   * @param v The vertex to remove; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code>
   * is <code>null</code> or is not in this graph.
   */
  public void removeVertex( Vertex<T> v ) {
    int pos = getVerticesIndexFor( v );
    if ( pos == -1 ) {
      throw new IllegalArgumentException( "vertex not found" );
    }

    this.numberOfVertices--;
    this.vertices[pos] = null;

    // now we need to go through the adjacency matrix and
    // remove all edges incident on v. We do this by walking g
    // alon the row and column for v in the adjacency matrix
    for ( int i = 0; i < vertices.length; i++ ) {
      if ( this.adjMatrix[pos][i] == 1 ) { // row check
        this.adjMatrix[pos][i] = 0;
        this.numberOfEdges--;
      }
      if ( this.adjMatrix[i][pos] == 1 ) { // column check
        this.adjMatrix[i][pos] = 0;
        this.numberOfEdges--;
      }
    }
  }

  /**
   * Insert Vertex <code>v</code> into this graph.
   * @param v The <code>Vertex</code> to add to the graph;
   * can't already be in the graph
   * @throws IllegalArgumentException if <code>v</code> is
   * already in the graph
   */
  public void addVertex( Vertex<T> v ) {
    int posNeighborVertex = getVerticesIndexFor( v );

    if ( posNeighborVertex != -1 ) {
      throw new IllegalArgumentException(
          "duplicate vertex " + v );
    }
    int posNewVertex = getFreeVertexPosition();
    vertices[posNewVertex] = v;
    this.numberOfVertices++;
  }

  /**
   * Get the neighbors of Vertex <code>v</code> in this graph.
   * @param v Vertex The vertex whose neighbors we want; must not
   * be <code>null</code> and must be a vertex in this graph.
   * @return Collection The vertices incident on <code>v</code>
   * @throws IllegalArgumentException if <code>element</code> is
   * already in the graph or if <code>neighbor</code> is
   * <code>null</code>.
   */
  public List<Vertex<T>> getNeighbors( Vertex<T> v ) {
    int pos = getVerticesIndexFor( v );
    if ( pos == -1 ) {
      throw new IllegalArgumentException( "vertex not found" );
    }

    List<Vertex<T>> neighbors = new ArrayList<Vertex<T>> ();
    for ( int i = 0; i < vertices.length; i++ ) {
      if ( this.adjMatrix[pos][i] == 1 ) {
        neighbors.add( vertices[i] );
      }
    }

    return neighbors;
  }

  /**
   * Get the number of edges in this graph.
   * @return int The number of edges in this graph
   */
  public int getNumberOfEdges() {
    return this.numberOfEdges;
  }

  /**
   * Get the number of vertices in this graph.
   * @return int The number of vertices in this graph
   */
  public int getNumberOfVertices() {
    return this.numberOfVertices;
  }

  /**
   * Find the first free position in vertices.
   * @return int Index of the the first free position in
   * vertices or -1 if there are none.
   */
  protected int getFreeVertexPosition() {
    for ( int i = 0; i < vertices.length; i++ ) {
      if ( vertices[i] == null ) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Return the position of v in vertices.
   * @param v Vertex Get <code>v</code>'s index in the
   * vertices array.
   * @return int The position of v in vertices, or -1 if
   * it isn't there.
   */
  protected int getVerticesIndexFor( Vertex<T> v ) {
    if ( v == null ) {
      throw new IllegalArgumentException( "null vertex" );
    }
    for ( int i = 0; i < vertices.length; i++ ) {
      if ( vertices[i] != null && vertices[i].equals( v ) ) {
        return i;
      }
    }
    return -1;
  }
}
