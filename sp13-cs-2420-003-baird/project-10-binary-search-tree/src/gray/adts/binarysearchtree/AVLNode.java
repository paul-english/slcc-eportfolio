package gray.adts.binarysearchtree;

public class AVLNode<E extends Comparable<? super E>> extends BSTNode<E> {
  /**
   * The balance of a node is an indication of the relative
   * heights of its two subtrees. Balance is calculated as
   * height of left subtree - height of right subtree. So:
   * <UL>
   * <LI>If balance is 0, the subtees are balanced (have
   * the same height relative to this node.
   * <LI>If balance is -1, the left subtree is deeper than
   * the right subtree by 1 level.
   * <LI>If balance is 1, the right subtree is deeper than
   * the left subtree by 1 level.
   * </UL>
   */
  protected int balance;
  protected int height;

  /**
   * Constructor. Create an instance of BSTNode storing data.
   * Parent and child links are null.
   * @pre data is not null
   * @param the data to store in this node
   * @throws IllegalArgumentException if data is null
   */
  public AVLNode( E data ) {
    super( data );

    this.balance = 0;
    this.height = 1;
  }

  public String toString() {
    return "Element: " + getElement() + " Balance: " + balance +
        " Height: " + height + "   Parent: " +
        ( this.parent != null ? this.parent.getElement() : "null" );
  }
}
