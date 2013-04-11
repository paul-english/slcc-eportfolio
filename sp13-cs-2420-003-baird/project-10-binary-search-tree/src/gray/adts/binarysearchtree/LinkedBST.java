package gray.adts.binarysearchtree;


public class LinkedBST<E extends Comparable<? super E>> extends
		AbstractBinarySearchTree<E>
{

	private BSTNode<E> root;

	public LinkedBST()
	{
		this.root = null;
		this.size = 0;
	}

	public LinkedBST(E element)
	{
		if (element == null)
		{
			throw new java.lang.IllegalArgumentException(
					"null element is illegal");
		}
		this.root = new BSTNode<E>(element);
		this.size = 1;
	}

	// UTILITY METHODS

	/**
	 * Recursive utility method to add a node to this tree.
	 * 
	 * @param <code>node</code> root of the subtree to which we are adding
	 *        <code>element</code>; when <code>node</code> is null, we have
	 *        found the insertion point
	 * @param <code>element</code> the element to insert into the tree
	 * @throws SearchTreeException
	 *             if node is found in the tree
	 */
	@Override
	protected BSTNode<E> add(BSTNode<E> parent, BSTNode<E> node, E element)
	{
		if (node == null)
		{ // base case
			node = new BSTNode<E>(element);
			node.parent = parent;
		}
		else
		{ // recursive case
			int compareResult = element.compareTo(node.getElement());
			if (compareResult < 0)
			{ // recursive case - left
				node.leftChild = this.add(node, node.leftChild, element);
			}
			else if (compareResult > 0)
			{ // recursive case - right
				node.rightChild = this.add(node, node.rightChild, element);
			}
			else
			{
				throw new SearchTreeException("Duplicate element: "
						+ element.toString());
			}
		}

		return node;
	}

	/**
	 * Recursive utility method to remove a node from this tree.
	 * 
	 * @param <code>node</code> root of the subtree from which we are removing
	 *        <code>target</code>; if <code>node</code> is null,
	 *        <code>target</code> isn't in the tree
	 * @param <code>target</code> the element to remove from the tree
	 */
	@Override
	protected BSTNode<E> remove(BSTNode<E> node, E target)
	{
		if (node == null)
		{ // element isn't in the tree : base case - failure
			return null;
		}

		// System.out.println("current node's element = " + node.element );

		int compareResult = target.compareTo(node.getElement());
		if (compareResult < 0)
		{
			node.leftChild = this.remove(node.leftChild, target); // recursive
																	// case -
																	// left
		}
		else if (compareResult > 0)
		{
			node.rightChild = this.remove(node.rightChild, target); // recursive
																	// case -
																	// right
		}
		else
		{ // found it! // base case - success
			this.size--;

			// handle the case of two children first
			if ((node.leftChild != null) && (node.rightChild != null))
			{
				BSTNode<E> replacement = this.successor(node);
				node.setElement(replacement.getElement());

				// now deal with removing the replacement
				BSTNode<E> newChild = replacement.leftChild == null ? replacement.rightChild
						: replacement.leftChild;
				if (replacement == replacement.parent.leftChild)
				{
					replacement.parent.leftChild = newChild;
				}
				else
				{
					replacement.parent.rightChild = newChild;
				}
			}
			else
			{ // Collapse the cases of no children and 1 child
				node = (node.leftChild == null) ? node.rightChild
						: node.leftChild;
			}
		}
		return node;
	}

	@Override
	protected BSTNode<E> root()
	{
		return this.root;
	}

	@Override
	protected void setRoot(BSTNode<E> newRoot)
	{
		this.root = newRoot;
	}
}
