package gray.adts.binarysearchtree;

public abstract class AbstractBinarySearchTree<E extends Comparable<? super E>>
		implements BinarySearchTree<E>
{

	class TreeIterator<E extends Comparable<? super E>> implements
			java.util.Iterator<E>
	{

		private final java.util.Stack<BSTNode<E>> stack;

		public TreeIterator()
		{
			this.stack = new java.util.Stack<BSTNode<E>>();
			// shouldn't have to do the following cast, but the
			// compiler complains otherwise. root() returns
			// BSTNode<E> and the compiler even points out they
			// are of EXACTLY the same type, but ...
			BSTNode<E> node = (BSTNode<E>) AbstractBinarySearchTree.this.root();
			while (node != null)
			{
				this.stack.push(node);
				node = node.leftChild;
			}
		}

		/**
		 * true is the stack is not empty, false otherwise
		 */
		@Override
		public boolean hasNext()
		{
			return !this.stack.isEmpty();
		}

		@Override
		public E next()
		{
			if (this.stack.isEmpty())
			{
				throw new java.util.NoSuchElementException();
			}

			BSTNode<E> node = this.stack.pop();
			BSTNode<E> n = node;
			E value = node.getElement();
			node = node.rightChild;
			while (node != null)
			{ // check for base case
				this.stack.push(node);
				node = node.leftChild;
			}
			// loop postcondition: base case met = found a null
			// left child
			return n.getElement(); // value
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	protected int size;

	/**
	 * Internal method to do the add. Called by add().
	 * 
	 * @throws SearchTreeException
	 *             if node is found in the tree
	 */
	protected abstract BSTNode<E> add(BSTNode<E> parent, BSTNode<E> node,
			E element);

	/**
	 * Add an element to the tree such that the BST properties
	 * are maintained.
	 * 
	 * @param element
	 *            the element to add to the tree; <tt>element</tt> should not be
	 *            <tt>null</tt> and should
	 *            not already be in the tree
	 * @throws SearchTreeException
	 *             if element is <tt>null</tt> or is already in the tree
	 */
	@Override
	public void add(E element)
	{
		if (element == null)
		{
			throw new SearchTreeException();
		}
		this.setRoot(this.add(null, this.root(), element));
		this.size++;
	}

	@Override
	public void clear()
	{
		this.setRoot(null);
		this.size = 0;
	}

	/**
	 * Recursive utility method to determine if the tree contains
	 * <tt>element</tt> in the
	 * tree rooted at <tt>node</tt>.
	 * 
	 * @param node
	 *            the node we are currently searching
	 * @param target
	 *            the element we are searching for; shouldn't be null
	 *            (not checked)
	 * @return <tt>true</tt> if the target was found, <tt>false</tt> otherwise
	 */
	protected boolean contains(BSTNode<E> node, E target)
	{
		if (node == null)
		{ // base case - failure
			return false;
		}

		int compareResult = target.compareTo(node.getElement());
		if (compareResult < 0)
		{ // recursive case - left
			return this.contains(node.leftChild, target);
		}
		else if (compareResult > 0)
		{ // recursive case - right
			return this.contains(node.rightChild, target);
		}
		else
		{
			return true; // base case - success
		}
	}

	@Override
	public boolean contains(E target)
	{
		if (target == null)
		{
			throw new SearchTreeException();
		}
		return this.contains(this.root(), target);
	}

	/**
	 * The recursive method for doing an inorder traversal of
	 * the tree rooted at
	 * node, applying visitor to each node of the tree.
	 * 
	 * @param node
	 *            the node to visit; not null (no check done)
	 * @param visitor
	 *            the code to apply to the node; is not null
	 *            (no check done)
	 */
	protected void doInOrderTraversal(BSTNode<E> node, Visitor<E> visitor)
	{
		if (node != null)
		{
			this.doInOrderTraversal(node.leftChild, visitor);
			visitor.visit(node);
			this.doInOrderTraversal(node.rightChild, visitor);
		}
	}

	protected void doPostOrderTraversal(BSTNode<E> node, Visitor<E> visitor)
	{
		if (node != null)
		{
			visitor.visit(node);
			this.doPostOrderTraversal(node.leftChild, visitor);
			this.doPostOrderTraversal(node.rightChild, visitor);
		}
	}

	// UTILITY METHODS

	/**
	 * Perform an in order traversal of this tree applying the
	 * Visitor to each node.
	 * 
	 * @param visitor
	 *            the visitor to apply to each node of
	 *            this tree
	 */
	public void inOrderTraversal(Visitor<E> visitor)
	{
		this.doInOrderTraversal(this.root(), visitor);
	}

	@Override
	public boolean isEmpty()
	{
		return this.size() == 0;
	}

	@Override
	public java.util.Iterator<E> iterator()
	{
		return new TreeIterator<E>();
	}

	public void postOrderTraversal(Visitor<E> visitor)
	{
		this.doPostOrderTraversal(this.root(), visitor);
	}

	protected abstract BSTNode<E> remove(BSTNode<E> node, E element);

	@Override
	public void remove(E element)
	{
		if (element == null)
		{ // ignore null elements
			return;
		}
		this.setRoot(this.remove(this.root(), element));
	}

	protected abstract BSTNode<E> root();

	protected abstract void setRoot(BSTNode<E> newRoot);

	@Override
	public int size()
	{
		return this.size;
	}

	protected BSTNode<E> successor(BSTNode<E> node)
	{
		node = node.rightChild;
		while (node.leftChild != null)
		{
			node = node.leftChild;
		}
		return node;
	}
}
