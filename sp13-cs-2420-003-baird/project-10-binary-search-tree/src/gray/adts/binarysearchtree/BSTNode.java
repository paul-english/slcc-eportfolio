package gray.adts.binarysearchtree;

/**
 * A Binary Search Tree is composed <tt>BSTNode</tt>'s.
 * The element stored in must be comparable with other
 * elements in the BST.
 */
public class BSTNode<E extends Comparable<? super E>> {
  protected BSTNode<E> parent;
  protected BSTNode<E> leftChild;
  protected BSTNode<E> rightChild;
  private E element;

  /**
   * Constructor. Create an instance of BSTNode storing data.
   * Parent and child links are null.
   * @param the data to store in this node
   * @throws IllegalArgumentException if data is null
   */
  public BSTNode( E data ) {
    if ( data == null ) {
      throw new java.lang.IllegalArgumentException();
    }

    this.setElement(data);
    this.parent = null;
    this.leftChild = null;
    this.rightChild = null;
  }

  /**
   * Constructor. Create an instance of BSTNode storing
   *  data. Parent and child links are set to the given
   * parameters.
   * @param data the data to store in this node
   * @param p the parent of this node
   * @param lChild the left child of this node
   * @param rChild the right child of this node
   * @throws IllegalArgumentException if data is <tt>null</tt>
   */
  public BSTNode( E data, BSTNode<E> p,
                  BSTNode<E> lChild, BSTNode<E> rChild ) {
    if ( data == null ) {
      throw new java.lang.IllegalArgumentException();
    }

    this.setElement(data);
    this.parent = p;
    this.leftChild = lChild;
    this.rightChild = rChild;
  }

public E getElement()
{
	return element;
}

public void setElement(E element)
{
	this.element = element;
}
}
