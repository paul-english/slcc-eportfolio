/**
 * Problem
 *
 * Create a BasicLinkedCollection class that uses a linked list as the backing
 * store.
 *
 * Specification
 *
 * 1. Extend AbstractCollection<E> from the Java API. 2. Use the
 * SinglyLinkedList<E> class provided in the text. 3. Override the following
 * optional methods inherited from AbstractCollection<E>: - add(E o):boolean -
 * addAll(Collection<? extends E> c):boolean - remove(Object o):boolean -
 * removeAll(Collection<?> c):boolean 4. Develop a test plan, and create a test
 * program using the JUnit framework, for your BasicLinkedCollection class. -
 * Use BasicCollectionTester.java as the model for your test program. 1. Make
 * the test program independent of your IDE (i.e. don't allow the IDE wizard to
 * create the program.) 2. The test program must have a main method so it can be
 * run independently from your IDE. - Make sure every method in
 * BasicLinkedCollection is tested.
 */
package basiclinkedcollection;

import java.util.Collection;
import java.util.Iterator;

/**
 * A collection represents a group of objects, known as its <i>elements</i>.
 * <code>BasicCollection</code> is a simple implementation of the
 * <code>java.util.Collection</code> interface and has the following
 * characteristics. It <UL> <li> allows duplicate elements</li> <li> disallows
 * <code>null</code> elements</li> <li> is unordered</li> <li> has no fixed
 * capacity</li> </UL>
 */
public class BasicCollection<E> extends java.util.AbstractCollection<E>
{

	/**
	 * The array buffer into which the elements are stored. The array is
	 * resized when an add() occurs and the capacity of the array has been
	 * reached.
	 */
	private SinglyLinkedList<E> collection;
	/**
	 * The number of elements contained in this collection.
	 */
	private int size = 0;
	/**
	 * The number of add and remove operations performed on this collection.
	 * This information is used by the iterator to provide a fail-fast
	 * iterator. Any operation that changes the size of this collection
	 * should add 1 to
	 * <code>modcount</code> for <it>each</it> change made.
	 */
	protected transient int modCount = 0;

	/**
	 * Constructs an empty collection.
	 */
	public BasicCollection()
	{
		collection = new SinglyLinkedList<>();
		size = 0;
		modCount = 0;
	}

	/**
	 * Constructs a collection containing the elements of the specified
	 * collection.
	 *
	 * @param c the collection whose elements are to be placed into this
	 * collection.
	 * @throws IllegalArgumentException - if <code>c</code>
	 * is <code>null</code>.
	 */
	public BasicCollection(Collection<? extends E> c)
	{
		addAll(c);
		modCount = 0;
	}

	/**
	 * Ensures that this collection contains the specified element. The
	 * collection does not support
	 * <code>null</code> elements. <p> Returns
	 * <code>true</code> if the collection is changed as a result of the
	 * call.
	 *
	 * @param element the element whose presence in this collection is to be
	 * ensured.
	 * @return <code>true</code> if the collection changed as a result of
	 * the call.
	 * @throws IllegalArgumentException if the argument is
	 * <code>null</code>.
	 */
	@Override
	public boolean add(E element)
	{
		if (element == null)
		{
			throw new java.lang.IllegalArgumentException();
		}
		collection.add(element);
		size++;
		modCount++;
		return true;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		if (c == null)
		{
			throw new java.lang.IllegalArgumentException();
		}
		collection = new SinglyLinkedList<>();
		for (E item : c)
		{
			add(item);
		}
		modCount++;
		return true;
	}

	/**
	 * Removes a single instance of the specified element from this
	 * collection, if it is present.
	 *
	 * @param <code>element</code> the element to be removed from the
	 * collection.
	 * @return <code>true</code> if this collection changed as a result of
	 * the call (this can only be true if there was at least one instance *
	 * of <code>element</code> in this collection).
	 * @throws IllegalArgumentException if <code>element</code>
	 * is <code>null</code>.
	 */
	@Override
	public boolean remove(Object element)
	{
		if (element == null)
		{
			throw new IllegalArgumentException();
		}
		int p = find(element);
		if (p == -1)
		{
			return false;
		}
		collection.remove(p);

		// Comment out the next line to illustrate
		//  the behavior of JUnit when a test fails.
		size--;
		modCount++;
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		for (Object item : c)
		{
			remove(item);
		}
		size = 0;
		modCount++;
		return true;
	}

	/**
	 * Returns the number of elements in this collection.
	 *
	 * @return the number of elements in this collection.
	 */
	@Override
	public int size()
	{
		return this.size;
	}

	/**
	 * Returns an iterator over the elements contained in this collection.
	 *
	 * @return an iterator over the elements contained in this collection.
	 */
	@Override
	public Iterator<E> iterator()
	{
		return new BasicIterator();
	}

	private int find(Object element)
	{
		for (int i = 0; i < size; i++)
		{
			if (element.equals(collection.getElementAt(i)))
			{
				return i;
			}
		}
		return -1; // failure
	}

	private class BasicIterator implements Iterator<E>
	{

		/**
		 * cursor is used to access the next element in the sequence. In
		 * its implementation, cursor is always the index of the next
		 * element to return. So cursor should be incremented _after_
		 * retrieving the next element in the sequence.
		 */
		private int cursor;
		/**
		 * Provides fail-fast operation of the iterator. For each call
		 * to an iterator method, expectedModcount should be equal to
		 * the collection's modCount, otherwise an intervening change
		 * (concurrent modification) to the collection has been made and
		 * we cannot guarantee that the iterator will behave correctly.
		 */
		private int expectedModcount;
		/**
		 * the contract of remove() says that each call to remove() must
		 * have been preceded by a call to next() (they are paired). So
		 * if there has been NO call to next() prior to a remove() or if
		 * there were two remove() calls without an intervening next()
		 * call, it is NOT ok to try to remove an item.
		 */
		private boolean okToRemove;

		public BasicIterator()
		{
			cursor = 0;
			expectedModcount = modCount;
			okToRemove = false;
		}

		/**
		 * Determine if there are more elements in the iteration
		 * sequence.
		 *
		 * @returns boolean <code>true</code> if there are more elements
		 * in the iteration sequence.
		 */
		@Override
		public boolean hasNext()
		{
			return cursor != size;
		}

		/**
		 * Returns the next element in the iteration sequence.
		 *
		 * @returns Object next element in the iteration sequence
		 * @throws ConcurrentModificationException if this collection
		 * has been modified by a method outside of this iterator.
		 * @throws NoSuchElementException if hasNext() is false
		 */
		@Override
		public E next()
		{
			// check for concurrent modification
			if (expectedModcount != modCount)
			{
				throw new java.util.ConcurrentModificationException();
			}

			// check that there are more elements in the iterator
			// sequence
			if (!hasNext())
			{
				throw new java.util.NoSuchElementException();
			}

			// indicate that we have met the contract
			// requirements for remove()
			okToRemove = true;

			// there are more elements to retrieve, so
			// 1. get the element in cursor's position
			// 2. advance the cursor to the next element
			E element = collection.getElementAt(cursor);
			cursor++;
			return element;
		}

		/**
		 * remove the element returned by the last call to
		 * <code>next()</code>.
		 *
		 * @throws ConcurrentModificationException if this collection
		 * has been modified by a method outside of this iterator.
		 * @throws IllegalStateException if there has been no call to
		 * next() for this iteration or if two calls to remove() have
		 * been made with no intervening call to next().
		 */
		@Override
		public void remove()
		{
			// check for concurrent modification
			if (expectedModcount != modCount)
			{
				throw new java.util.ConcurrentModificationException();
			}

			// check that there has been a next() message to
			// provide an element to remove
			if (!okToRemove)
			{
				throw new IllegalStateException();
			}

			okToRemove = false;

			// Use BasicCollection's remove() method to do the
			// actual removal. Need to predecrement cursor to
			// get to the LAST element returned by next(). After
			// the removal, this will be the value cursor should
			// have for the next call to next().
			--cursor;
			BasicCollection.this.remove(collection.getElementAt(cursor));

			// increment expectedModcount since the remove()
			// message above to the collection object will
			// have incremented modCount
			expectedModcount++;
		}
	}
}
