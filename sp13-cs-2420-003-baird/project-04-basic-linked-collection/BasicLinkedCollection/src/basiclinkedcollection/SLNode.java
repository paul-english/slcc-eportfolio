package basiclinkedcollection;

/**
 * The structure of a node in the simple singly-linked list introduced in the
 * chapter on Fundamental Data Structures.
 */
public class SLNode<E>
{

	private E element; // the data field
	private SLNode<E> successor; // the link to this node's successor

	/**
	 * Create an empty
	 * <code>SLNode</code> object.
	 */
	public SLNode()
	{
		this.element = null;
		this.successor = null;
	}

	/**
	 * Create an
	 * <code>SLNode</code> that stores
	 * <code>theElement</code> and whose successor is
	 * <code>theSuccessor</code>.
	 *
	 * @param theElement the element to store in this node
	 * @param theSuccessor this node's successor
	 */
	public SLNode(E theElement, SLNode<E> theSuccessor)
	{
		this.element = theElement;
		this.successor = theSuccessor;
	}

	/**
	 * Return the element stored in this
	 * <code>SLNode</code> object.
	 *
	 * @return the element stored in this node
	 */
	public E getElement()
	{
		return this.element;
	}

	/**
	 * Set the element field for this node.
	 *
	 * @param newElement the new element to be stored in this node
	 */
	public void setElement(E newElement)
	{
		this.element = newElement;
	}

	/**
	 * Return this node's successor.
	 *
	 * @return this node's successor
	 */
	public SLNode<E> getSuccessor()
	{
		return this.successor;
	}

	/**
	 * Set the successor to this node in the list.
	 *
	 * @param newSuccessor this node's new successor
	 */
	public void setSuccessor(SLNode<E> newSuccessor)
	{
		this.successor = newSuccessor;
	}
}
