package gray.adts.graph;

import java.util.*;

import gray.adts.priorityqueue.*;
import gray.adts.priorityqueue.PriorityQueue;
import gray.misc.*;

/**
 * A weighted, undirected graph stored in an adjacency matrix.
 *  The weights must be >= 0.
 */
public class WeightedAdjMatrixGraph<T> extends AdjMatrixGraph<T> implements
    WeightedGraph<T> {
  /**
   * The default weight for an edge in a weighted graph.
   */
  public double DEFAULT_WEIGHT = 1.0;

  /**
   * Store weight edges. The adjacency matrix storing
   * edges is in an ancestor class.
   */
  protected double[][] weights;

  public WeightedAdjMatrixGraph() {
    super();
    weights = new double[super.SIZE][super.SIZE];
  }

  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. In an undirected graph, this edge is
   * bidirectional.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param weight The weight of this edge; must be >= 0.0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph, or if <code>weight</code> is < 0.
   */
  public void addEdge( Vertex<T> v1, double weight,
                       Vertex<T> v2 ) {
    if ( weight < 0.0 ) {
      throw new IllegalArgumentException( "Edge weight " +
                                          " must be >= 0.0" );
    }

    super.addEdge( v1, v2 );

    // if we get here, method in superclass didn't throw
    // an exception and method preconditions are met
    this.setEdgeWeight( v1, weight, v2 );
  }

  /**
   * Get the weight of the edge from <code>v1</code> to
   * <code>v2</code>.
   * @param v1  The source vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @return double The weight of the edge from <code>v1</code>
   * to <code>v2</code>.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public double getEdgeWeight( Vertex<T> v1, Vertex<T> v2 ) {
    int v1Pos = super.getVerticesIndexFor( v1 );
    int v2Pos = super.getVerticesIndexFor( v2 );
    // if we get here, method in superclass didn't throw
    // an exception and method preconditions are met
    return weights[v1Pos][v2Pos];
  }

  /**
   * Reset the weight for the edge connecting vertex
   * <code>v1</code> to <code>v2</code>.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param newWeight The weight of this edge; must be >= 0.0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph, or if <code>weight</code> is < 0.
   */
  public void setEdgeWeight( Vertex<T> v1, double newWeight,
                             Vertex<T> v2 ) {
    if ( newWeight < 0.0 ) {
      throw new IllegalArgumentException( "Edge weight "
                                          + "must be >= 0.0" );
    }
    int v1Pos = super.getVerticesIndexFor( v1 );
    int v2Pos = super.getVerticesIndexFor( v2 );
    // if we get here, method in superclass didn't throw an
    // exception and method preconditions are met
    weights[v1Pos][v2Pos] = newWeight;
    weights[v2Pos][v1Pos] = newWeight;
  }

  // overloaded methods from AdjMatrixGraph
  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. The edge is bidirectional in an
   * undirected graph. The default weight for an edge
   * is <code>DEFAULT_WEIGHT</code>.
   * @param v1 The source vertex; must not be <code>null</code>
   *  and must be a vertex in this graph.
   * @param v2 The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public void addEdge( Vertex<T> v1, Vertex<T> v2 ) {
    this.addEdge( v1, DEFAULT_WEIGHT, v2 );
  }

  /**
   * Find a minimal cost path from <code>src</code> to
   * <code>dest</code> in this graph. Assumes edge weights
   * are positive.
   * @param src Vertex The first vertex in the path.
   * @param dest Vertex The last vertex in the path.
   * @return double The cost of the path or -1 if none is found.
   */
  public Tuple<ArrayList<Vertex<T>>, Double> minimalPath( Vertex<T> src, Vertex<T> dest ) 
	{
    ArrayList<Tuple<Pair<Vertex<T>>,Double>> verticesInPath = 
			new ArrayList<Tuple<Pair<Vertex<T>>, Double>> ();
    
		ArrayList<Vertex<T>> visitedVertices = new ArrayList<Vertex<T>> ();

    final Comparator pathCostComparator = new Comparator() {
      public int compare( Object o1, Object o2 ) {
        Double i1 = ( ( Tuple<Vertex<T>, Double> ) o1 ).
            getSecondElement();
        Double i2 = ( ( Tuple<Vertex<T>, Double> ) o2 ).
            getSecondElement();
        return i1.compareTo( i2 );
      }

      public boolean equals( Object obj ) {
        return false;
      }
    };

    PriorityQueue<Tuple<Pair<Vertex<T>>, Double>> pq
        = new HeapPriorityQueue<Tuple<Pair<Vertex<T>>, Double>> ( pathCostComparator );

    Tuple<Pair<Vertex<T>>, Double> pathTuple;

    // start with the source, which has a cost of 0 to get to itself
    pq.enqueue( new Tuple( new Pair( src, src ), 0.0 ) );

    while ( !pq.isEmpty() ) {
      // get cheapest path to a vertex seen so far
      pathTuple = pq.dequeue();

      // extract the fields of the tuple so we can work with them
      Pair<Vertex<T>> vertexPair = pathTuple.getFirstElement();
      Vertex<T> v = vertexPair.getSecondElement();
      double minCostToV = pathTuple.getSecondElement();

      visitedVertices.add( v );
      verticesInPath.add( pathTuple );

      // if v is the destination vertex, we are done
      if ( v.equals( dest ) ) {
        // extract and return only the vertices on the cheapest
        // path from src to dest
        ArrayList<Vertex<T>> path = getPath( verticesInPath, src, dest );
        return new Tuple<ArrayList<Vertex<T>>, Double> ( path, minCostToV );
      }

      // okay, not done yet; look at the vertices adjacent to v
      ArrayList<Vertex<T>> neighbors = ( ArrayList<Vertex<T>> )this.getNeighbors( v );
      while ( !neighbors.isEmpty() ) {
        Vertex<T> w = neighbors.remove( 0 );

        // if we has been visited, we don't need to consider it
        if ( !visitedVertices.contains( w ) ) {
          // get the total cost to vertex v
          double minCostToW = minCostToV + this.getEdgeWeight( v, w );

          pq.enqueue( new Tuple<Pair<Vertex<T>>,
                      Double> ( new Pair( v, w ), minCostToW ) );
        }
      }
    }

    return null; // failure!
  }

  private ArrayList<Vertex<T>> getPath(
      ArrayList<Tuple<Pair<Vertex<T>>, Double>> vertexPairs,
      Vertex<T> src,
      Vertex<T> dest ) 
	{
    ArrayList<Vertex<T>> path = new ArrayList<Vertex<T>> ();
    Vertex<T> successor = dest;
    Pair<Vertex<T>> tempPair = null;

    // trace the path backwards from the destination to the source by
    // finding each vertex's minimum cost predecessor in this path.
    while ( successor != src ) {
      double minCost = Double.MAX_VALUE; // assume the worst :-(

      // now find the predecessor on the cheapest path to successor
      for ( int i = 0; i < vertexPairs.size(); i++ ) {
        Tuple<Pair<Vertex<T>>, Double> tuple = vertexPairs.get( i );
        Pair<Vertex<T>> pair = tuple.getFirstElement();

        // got another candidate vertex tuple, see if this one
        // has a cheaper cost than another other path to successor
        // seen so far
        if ( pair.getSecondElement().equals( successor ) ) {

          // it is possible there are multiple "cheapest" paths
          // to successor; want to avoid adding duplicates
          if ( !path.contains( successor ) ) {
            path.add( successor );
          }
          double cost = tuple.getSecondElement();
          if ( cost < minCost ) {
            minCost = cost; // new lowest cost path to successor
            tempPair = pair;
          }

          // remove it so we never need to look at it again
          // assumes the caller isn't going to need this list
          // intact!
          vertexPairs.remove( i );
        }
      }

      // the predecessor for successor becomes the new successor,
      // as we move backward in the path from destination to source
      successor = tempPair.getFirstElement();
    }

    path.add( src );

    // vertices added in reverse order, fix that
    Collections.reverse( path );

    return path;
  }
}
