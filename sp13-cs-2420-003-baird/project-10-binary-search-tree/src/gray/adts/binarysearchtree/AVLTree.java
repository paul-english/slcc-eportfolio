package gray.adts.binarysearchtree;

public class AVLTree<E extends Comparable<? super E>> extends
    AbstractBinarySearchTree<E> {

  /**
   * The root of this AVL tree.
   */
  private AVLNode<E> root;

  /**
   * Constructor. Create an empty AVL tree.
   */
  public AVLTree() {
    this.root = null;
    this.size = 0;
  }

  /**
   * Constructor. Create an AVL tree with element as its root.
   * @param element The element to store in the root of this
   * new tree. Can't be <tt>null</tt>
   * @throws IllegalArgumentException if element is <tt>null</tt>
   */
  public AVLTree( E element ) {
    if ( element == null ) {
      throw new java.lang.IllegalArgumentException();
    }
    this.root = new AVLNode<E> ( element );
    this.size = 1;
  }

  // UTILITY METHODS
  /**
   * Make newRoot the root of this tree.
   * @param newRoot the new root of this tree. No check is done
   * on newRoot.
   * Method specified by AbstractBinarySearchTree.
   */
  protected void setRoot( BSTNode<E> newRoot ) {
    this.root = ( AVLNode<E> ) newRoot;
  }

  /**
   * Return the root of this tree.
   * Method specified by AbstractBinarySearchTree.
   */
  protected BSTNode<E> root() {
    return this.root;
  }

  /**
   * Remove element from this tree.
   * @param nodethe root of the subtree from which to remove
   *  element.
   * @param element the element to remove.
   */
  protected BSTNode<E> remove( BSTNode<E> node, E target ) {
    if ( node == null ) { // element isn't in the tree
      return null;
    }

    int compareResult = target.compareTo( node.getElement() );
    if ( compareResult < 0 ) {
      node.leftChild = remove( node.leftChild, target );
      node = fixSubtreeRootedAt( ( AVLNode<E> ) node );
    }
    else if ( compareResult > 0 ) {
      node.rightChild = remove( node.rightChild, target );
      node = fixSubtreeRootedAt( ( AVLNode<E> ) node );
    }
    else { // found the target!
      this.size--;

      // handle the case of two children first
      if ( ( node.leftChild != null ) &&
           ( node.rightChild != null ) ) {
        BSTNode<E> replacement = successor( node );
        node.setElement(replacement.getElement());

        // now deal with removing the replacement
        BSTNode<E> newChild =
            replacement.leftChild == null ?
            replacement.rightChild : replacement.leftChild;
        if ( replacement == replacement.parent.leftChild ) {
          replacement.parent.leftChild = newChild;
        }
        else {
          replacement.parent.rightChild = newChild;
        }

        // now fix the height/balance from the replacement's
        //   parent to node
        // if, along the way, we find a subtree unbalanced,
        //   rebalance it
        node = updatePath( ( AVLNode<E> ) node,
                           replacement.parent.getElement() );
      }
      else { // Collapse the cases of no children and 1 child
        node = ( node.leftChild == null ) ?
            node.rightChild : node.leftChild;
      }
    }

    return node;
  }

  /**
   * Add <tt>element</tt> to the tree.
   * @param parent parent of  <tt>node</tt>
   * @param node root of subtree to which element is to be added
   * @param element the element to be added to the tree
   * @throws SearchTreeException if node is found in the tree
   */
  protected BSTNode<E> add( BSTNode<E> parent, BSTNode<E> node,
                            E element ) {
    if ( node == null ) { // base case
      node = new AVLNode( element );
      node.parent = parent;
    }
    else { // recursive case
      int compareResult = element.compareTo( node.getElement() );
      if ( compareResult < 0 ) {
        node.leftChild = add( node, node.leftChild, element );
      }
      else if ( compareResult > 0 ) {
        node.rightChild =
            add( node, node.rightChild, element );
      }
      else {
        throw new SearchTreeException(
            "Duplicate element: " + element.toString() );
      }

      // now do height/balance updates and possible
      //  subtree fixes
      node = fixSubtreeRootedAt( ( AVLNode<E> ) node );
    }
    return node;
  }

  /**
   * Determines and returns the height of <tt>node</tt>.
   * @return the height of node
   */
  protected int height( AVLNode<E> node ) {
    if ( node == null ) {
      return 0;
    }
    if ( ( node.leftChild == null ) &&
         ( node.rightChild == null ) ) {
      return 1;
    }
    if ( node.leftChild == null ) {
      return ( ( AVLNode<E> ) node.rightChild ).height + 1;
    }
    if ( node.rightChild == null ) {
      return ( ( AVLNode<E> ) node.leftChild ).height + 1;
    }

    // there are two children, return larger of the two plus 1
    //  for this node
    return ( ( ( AVLNode<E> ) node.leftChild ).height >
             ( ( AVLNode<E> ) node.rightChild ).height ?
             ( ( AVLNode<E> ) node.leftChild ).height :
             ( ( AVLNode<E> ) node.rightChild ).height ) + 1;
  }

  /**
   * Make sure subtree rooted at <tt>node</tt> is an AVL tree.
   * @param node the root of the subtree to be fixed.
   * @return the root of the subtree. The root will be different
   * from <tt>node</tt> if the subtree required rebalancing.
   */
  private AVLNode<E> fixSubtreeRootedAt( AVLNode<E> node ) {
    updateBalanceAndHeight( node );
    if ( ( node.balance == 2 ) || ( node.balance == -2 ) ) {
      node = rebalance( node );
    }
    return node;
  }

  /**
   * Update the path from node down to the node containing
   * element. Since it is guaranteed there is a path between
   * these two arguments, node should never become null.
   * @param node the root of some subtree, originally the root
   *  of the subtree whose node was removed.
   * @param element the element stored at the end of the path
   * to be updated. This element was the parent to the value t
   * hat supplied the replacement value for a node during a
   * remove() operation.
   */
  private AVLNode<E> updatePath( AVLNode<E> node, E element ) {
    int compareResult = element.compareTo( node.getElement() );

    if ( compareResult == 0 ) { // reached the end of the path
      node = fixSubtreeRootedAt( node );
    }
    else if ( compareResult < 0 ) {
      node.leftChild = updatePath( ( AVLNode<E> ) node.leftChild,
                                   element );
      node = fixSubtreeRootedAt( node );
    }
    else if ( compareResult > 0 ) {
      node.rightChild = updatePath( ( AVLNode<E> ) node.rightChild,
                                    element );
      node = fixSubtreeRootedAt( node );
    }
    return node;
  }

  /**
   * Update the balance and height properties of <tt>node</tt>.
   */
  private void updateBalanceAndHeight( AVLNode<E> node ) {
    int leftHeight = height( ( AVLNode<E> ) node.leftChild );
    int rightHeight = height( ( AVLNode<E> ) node.rightChild );
    node.height = ( leftHeight > rightHeight ?
                    leftHeight : rightHeight ) + 1;
    node.balance = leftHeight - rightHeight;
  }

  /**
   * On entry, <tt>x</tt> is the root of a subtree that has
   * violated the balance properties of an AVL tree, so
   * requires rebalancing.
   * @param x the root of the tree to be rebalanced.
   * @return The new root of the balanced subtree.
   */
  private AVLNode<E> rebalance( AVLNode<E> x ) {
    AVLNode<E> newRoot = null; // new root of  balanced subtree

    // LL case - new node inserted into left subtree of
    //       last unbalanced node's left child
    if ( x.balance == 2 ) { // left subtree is unbalanced
      // Check for LL CASE
      if ( ( ( AVLNode<E> ) x.leftChild ).balance == 1 ) {
        newRoot = rightRotation( x );
      }
      else { // LR CASE
        x.leftChild =
            leftRotation( ( AVLNode<E> ) x.leftChild );
        newRoot = rightRotation( x );
      }
    }
    else
    if ( x.balance == -2 ) { // right subtree is unbalanced
      // Check for RR CASE
      if ( ( ( AVLNode<E> ) x.rightChild ).balance == -1 ) {
        newRoot = leftRotation( x );
      }
      else { // LR case
        x.rightChild =
            rightRotation( ( AVLNode<E> ) x.rightChild );
        newRoot = leftRotation( x );
      }
    }
    return newRoot;
  }

  /**
   * Perform a right (clockwise) rotation at <tt>x</tt>.
   * @param x the lowest unbalanced node found in this tree.
   * @return The new root of the balanced subtree.
   */
  private AVLNode<E> rightRotation( AVLNode<E> x ) {
    AVLNode<E> newRoot = ( AVLNode<E> ) x.leftChild;
    newRoot.parent = x.parent;
    x.parent = newRoot;
    x.leftChild = newRoot.rightChild;
    // newRoot is guaranteed to have a left child, but
    //  we can't be sure it has a right child
    if ( newRoot.rightChild != null ) {
      newRoot.rightChild.parent = x;
    }
    newRoot.rightChild = x;

    // lastly: do updates from the bottom up
    updateBalanceAndHeight( x );
    updateBalanceAndHeight( newRoot );
    return newRoot;
  }

  /**
   * Perform a left (counter-clockwise) rotation at <tt>x</tt>.
   * @param x the lowest unbalanced node found in this tree.
   * @return The new root of the balanced subtree.
   */
  private AVLNode<E> leftRotation( AVLNode<E> x ) {
    AVLNode<E> newRoot = ( AVLNode<E> ) x.rightChild;
    newRoot.parent = x.parent;
    x.parent = newRoot;
    x.rightChild = newRoot.leftChild;

    // newRoot is guaranteed to have a right child, but
    //  we can't be sure it has a left child
    if ( newRoot.leftChild != null ) {
      newRoot.leftChild.parent = x;
    }
    newRoot.leftChild = x;

    // lastly: do updates from the bottom up
    updateBalanceAndHeight( x );
    updateBalanceAndHeight( newRoot );
    return newRoot;
  }

  /**
   * Determine if this tree contains <tt>element</tt>.
   * @param element the element we are looking for in the tree.
   * @return <tt>true</tt> if <tt>element</tt> is found in this
   * tree, <tt>false</tt> otherwise.
   */
  protected boolean contains( BSTNode<E> node, E element ) {
    if ( node == null ) {
      return false;
    }

    int compareResult = element.compareTo( node.getElement() );
    if ( compareResult < 0 ) {
      return contains( node.leftChild, element );
    }
    else if ( compareResult > 0 ) {
      return contains( node.rightChild, element );
    }
    else {
      return true;
    }
  }

  /**
   * Get the successor of <tt>node</tt> in this tree.
   * @pre <tt>node</tt> has a right child.
   * @param node the node's whose successor we are searching for.
   * @return the successor node to <tt>node</tt>.
   */
  protected AVLNode<E> successor( AVLNode<E> node ) {
    node = ( AVLNode<E> ) node.rightChild;
    while ( node.leftChild != null ) {
      node = ( AVLNode<E> ) node.leftChild;
    }
    return node;
  }
}
