package gray.adts.binarysearchtree;

/**
 * A binary tree with the property that for each node in the tree,
 * the value in the node's left child is less than the parent's
 * value, the value in the node's right child is greater than the
 * parent's value, and the left and right children are the roots
 * of a binary search tree.
 */
public interface BinarySearchTree<E extends Comparable<? super E>> extends java.
    lang.Iterable<E> {

  /**
   * Add an element to the tree such that the BST properties
   * are maintained.
   * @param element the element to add to the tree;
   *   <tt>element</tt> should not be <tt>null</tt> and should
   *    not already be in the tree
   * @throws SearchTreeException if element is <tt>null</tt>
   *   or is already in the tree
   */
  public void add( E element );

  /**
   * Remove element from the tree such that the BST properties
   * are maintained. If the target is not in the tree, nothing
   * happens. The tree is not changed.
   * @param element the element to remove from the tree
   */
  public void remove( E element );

  /**
   * Determine if <tt>target</tt> is in the tree.
   * @param target the element to look for; can't be
   *  <tt>null</tt>
   * @return <tt>true</tt> if found, <tt>false</tt> otherwise
   * @throws SearchTreeException if <tt>target</tt> is <tt>null</tt>
   */
  public boolean contains( E target );

  /**
   * Returns an iterator over the elements in this collection.
   *  This iterator provides this tree's element in an inorder
   * sequence.
   * @return an <tt>Iterator</tt> over the elements in this tree
   */
  public java.util.Iterator<E> iterator();

  /**
   * Determine if this tree is empty or not
   * @return true if there are no elements in this tree
   */
  public boolean isEmpty();

  /**
   * Return the number of nodes in this
   *  <tt>BinarySearchTree</tt>.
   * @return the number of nodes in this tree.
   */
  public int size();

  /**
   * Removes all the elements from this
   * <tt>BinarySearchTree</tt>.
   */
  public void clear();
}
