package gray.adts.binarysearchtree;

public abstract class
    AbstractBinarySearchTree<E extends Comparable<? super E>> implements
    BinarySearchTree<E> {

  protected int size;

  /**
   * Add an element to the tree such that the BST properties
   * are maintained.
   * @param element the element to add to the tree;
   *   <tt>element</tt> should not be <tt>null</tt> and should
   *    not already be in the tree
   * @throws SearchTreeException if element is <tt>null</tt>
   *   or is already in the tree
   */
  public void add( E element ) {
    if ( element == null ) {
      throw new SearchTreeException();
    }
    setRoot( add( null, this.root(), element ) );
    size++;
  }

  public void remove( E element ) {
    if ( element == null ) { // ignore null elements
      return;
    }
    setRoot( remove( this.root(), element ) );
  }

  public boolean contains( E target ) {
    if ( target == null ) {
      throw new SearchTreeException();
    }
    return contains( this.root(), target );
  }

  public java.util.Iterator<E> iterator() {
    return new TreeIterator<E> ();
  }

  /**
   * Perform an in order traversal of this tree applying the
   * Visitor to each node.
   * @param visitor the visitor to apply to each node of
   * this tree
   */
  public void inOrderTraversal( Visitor<E> visitor ) {
    doInOrderTraversal( this.root(), visitor );
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public int size() {
    return this.size;
  }

  public void clear() {
    setRoot( null );
    this.size = 0;
  }

  // UTILITY METHODS

  protected abstract void setRoot( BSTNode<E> newRoot );

  protected abstract BSTNode<E> root();

  /**
   * The recursive method for doing an inorder traversal of
   * the tree rooted at
   * node, applying visitor to each node of the tree.
   * @param node the node to visit; not null (no check done)
   * @param visitor the code to apply to the node; is not null
   *  (no check done)
   */
  protected void doInOrderTraversal( BSTNode<E> node,
                                     Visitor<E> visitor ) {
    if ( node != null ) {
      doInOrderTraversal( node.leftChild, visitor );
      visitor.visit( node );
      doInOrderTraversal( node.rightChild, visitor );
    }
  }

  /**
   * Internal method to do the add. Called by add().
   * @throws SearchTreeException if node is found in the tree
   */
  protected abstract BSTNode<E> add( BSTNode<E> parent,
                                     BSTNode<E> node,
                                     E element );

  /**
   * Recursive utility method to determine if the tree contains
   * <tt>element</tt> in the
   * tree rooted at <tt>node</tt>.
   * @param node the node we are currently searching
   * @param target the element we are searching for; shouldn't be null
   *      (not checked)
   * @return <tt>true</tt> if the target was found, <tt>false</tt> otherwise
   */
  protected boolean contains( BSTNode<E> node,
                              E target ) {
    if ( node == null ) { // base case - failure
      return false;
    }

    int compareResult = target.compareTo( node.element );
    if ( compareResult < 0 ) { // recursive case - left
      return contains( node.leftChild, target );
    }
    else if ( compareResult > 0 ) { // recursive case - right
      return contains( node.rightChild, target );
    }
    else {
      return true; // base case - success
    }
  }

  protected abstract BSTNode<E> remove( BSTNode<E> node,
                                        E element );

  protected BSTNode<E> successor( BSTNode<E> node ) {
    node = node.rightChild;
    while ( node.leftChild != null ) {
      node = node.leftChild;
    }
    return node;
  }

  class TreeIterator<E extends Comparable<? super E>> implements java.util.
      Iterator<E> {
    private java.util.Stack<BSTNode<E>> stack;

    public TreeIterator() {
      stack = new java.util.Stack<BSTNode<E>> ();
      // shouldn't have to do the following cast, but the
      // compiler complains otherwise. root() returns
      // BSTNode<E> and the compiler even points out they
      // are of EXACTLY the same type, but ...
      BSTNode<E> node = ( BSTNode<E> ) root();
      while ( node != null ) {
        stack.push( node );
        node = node.leftChild;
      }
    }

    /**
     * true is the stack is not empty, false otherwise
     */
    public boolean hasNext() {
      return!stack.isEmpty();
    }

    public E next() {
      if ( stack.isEmpty() ) {
        throw new java.util.NoSuchElementException();
      }

      BSTNode<E> node = stack.pop();
      BSTNode<E> n = node;
      E value = node.element;
      node = node.rightChild;
      while ( node != null ) { // check for base case
        stack.push( node );
        node = node.leftChild;
      }
      // loop postcondition: base case met = found a null
      //   left child
      return ( E ) n.element; // value
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
