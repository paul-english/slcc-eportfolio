package basiclinkedcollection;

/**
 * A simple singly-linked list introduced in the chapter on Fundamental Data
 * Structures.
 */
public class SinglyLinkedList<E>
{

	private int length; // # elements in the linked list
	private SLNode<E> head; // access point to the linked list
	private SLNode<E> tail;

	/**
	 * Create an empty
	 * <code>SinglyLinkedList</code>.
	 */
	public SinglyLinkedList()
	{
		this.length = 0;
		this.tail = new SLNode<E>(); // the tail dummy node
		this.head = new SLNode<E>(null, this.tail); // the head dummy node
	}

	/**
	 * Return the length of this singly linked list.
	 *
	 * @return the number of elements in this singly linked list
	 */
	public int getLength()
	{
		return this.length;
	}

	/**
	 * Add a new element at the beginning of the linked list.
	 *
	 * @param e the element to add
	 */
	public void add(E e)
	{
		SLNode<E> newnode = new SLNode<E>(e, null);
		newnode.setSuccessor(this.head.getSuccessor());
		this.head.setSuccessor(newnode);
		this.length++;
	}

	/**
	 * Add element
	 * <code>e</code> at position
	 * <code>p</code> in this singly linked list.
	 *
	 * @param e the element to add
	 * @param p position to insert <code>e</code>; must be in the range 0 	 * to <code>this.size()</code>.
	 * @throws IndexOutOfBoundsException if <code>p</code> is outside the
	 * range 0 to <code>this.length()</code>.
	 */
	public void add(E e, int p)
	{
		// verify that index p is valid
		if ((p < 0) || (p > this.length))
		{
			throw new IndexOutOfBoundsException("index " + p
							    + " is out of range: 0 to "
							    + this.length);
		}
		SLNode<E> newnode = new SLNode<E>(e, null);
		SLNode<E> cursor = this.head;
		for (int i = 0; i < p; i++)
		{
			cursor = cursor.getSuccessor();
		}
		addAfter(cursor, newnode);
		this.length++;
	}

	/**
	 * Remove the node at position
	 * <code>p</code> and return its element field.
	 *
	 * @param p the position whose element we are to return
	 * @return the element in position <code>p</code>
	 * @throws IndexOutOfBoundsException if <code>p</code> is outside the
	 * range 0 to length() - 1</code>
	 */
	public E remove(int p)
	{
		if ((p < 0) || (p >= this.length))
		{
			throw new IndexOutOfBoundsException("index " + p
							    + " is out of range: 0 to "
							    + (this.length - 1));
		}
		SLNode<E> cursor = head; // good for p == 0
		if (p > 0)
		{
			cursor = find(p - 1); // get target's predecessor
		}

		SLNode<E> target = cursor.getSuccessor(); // get the node to remove

		// link target to cursor's successor
		cursor.setSuccessor(target.getSuccessor());

		// PE NOTE there was a bug here, it would delete the element in
		// cursor (not desired) and not our target. Instead I'm saving
		// the element so we can return it, and I'm then deleting the
		// targets element.
		E element = target.getElement();
		target.setSuccessor(null);
		target.setElement(null);

		this.length--;
		return element;
	}

	/**
	 * Return the element stored in the node at position
	 * <code>p</code>.
	 *
	 * @param p the position whose element we want
	 * @return the element from position <code>p</code> of this linked list
	 * @throws IndexOutOfBoundsException if the index p is outside the range
	 * 0 to <code>length - 1</code>.
	 */
	public E getElementAt(int p)
	{
		SLNode<E> node = this.find(p);
		return node.getElement();
	}

	// PRIVATE UTILITY METHODS

	/* addAfter - add newnode after node p
	 PRECONDITIONS NOT CHECKED!
	 pre: p and newnode are not null
	 post: newnode is inserted after p
	 */
	private void addAfter(SLNode<E> p, SLNode<E> newnode)
	{
		newnode.setSuccessor(p.getSuccessor());
		p.setSuccessor(newnode);
	}

	/**
	 * find - find the first node containing target, return null if target
	 * is not found
	 */
	private SLNode<E> find(E target)
	{
		SLNode<E> cursor = head.getSuccessor();

		while (cursor != tail)
		{
			if (cursor.getElement().equals(target))
			{
				return cursor; // success
			}
			else
			{
				cursor = cursor.getSuccessor();
			}
		}
		return null; // failure
	}

	/* find - find the  node at position p
	 * throw an exception if the index p is outside the range 0 to this.length - 1
	 */
	private SLNode<E> find(int p)
	{
		if ((p < 0) || (p >= this.length))
		{
			throw new IndexOutOfBoundsException();
		}

		SLNode<E> cursor = head.getSuccessor();
		int i = 0;

		while (i != p)
		{
			cursor = cursor.getSuccessor();
			i++;
		}

		return cursor;
	}
}
