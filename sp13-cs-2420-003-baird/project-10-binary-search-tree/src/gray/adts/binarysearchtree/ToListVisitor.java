package gray.adts.binarysearchtree;

import java.util.List;
import java.util.ArrayList;

/**
 * A Visitor class for converting a tree into a <tt>List</tt>.
 *
 * The order in which the elements of the tree are placed
 * in the list is determined by the tree traversal used. This
 *  class implements the Visitor Design Pattern.
 */
public class ToListVisitor<E extends Comparable<? super E>>
    implements Visitor<E> {
  // The list type is mandated by the type stored in each
  // BSTNode, which is <Comparable<? super E>
  private List<E> list;

  /**
   * Create an empty list into which <tt>visit</tt> will
   * append the tree's elements.
   */
  public ToListVisitor() {
    list = new ArrayList<E> ();
  }

  /**
   * Return the list of elements.
   * @return A list of the elements from a tree.
   */
  public List<E> list() {
    return this.list;
  }

  /**
   * Appends the specified node to the end of the list.
   * @param node the node from the BST we are visiting
   */
  public void visit( BSTNode<E> node ) {
    list.add( node.getElement() );
  }
}
