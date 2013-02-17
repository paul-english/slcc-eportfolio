package gray.adts.collection;

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
public class BasicCollection<E> extends java.util.AbstractCollection<E> implements
	Cloneable
{

	private static final int DEFAULT_SIZE = 100;
	/**
	 * The array buffer into which the elements are stored. The array is
	 * resized when an add() occurs and the capacity of the array has been
	 * reached.
	 */
	private E[] collection;
	/**
	 * The number of elements contained in this collection.
	 */
	private int size;
	/**
	 * The number of add and remove operations performed on this collection.
	 * This information is used by the iterator to provide a fail-fast
	 * iterator. Any operation that changes the size of this collection
	 * should add 1 to
	 * <code>modcount</code> for <it>each</it> change made.
	 */
	protected transient int modCount;

	/**
	 * Constructs an empty collection.
	 */
	public BasicCollection()
	{
		collection = (E[]) (new Object[DEFAULT_SIZE]);
		size = 0;
		modCount = 0;
	}

	/**
	 * Constructs a collection containing the elements of the specified
	 * collection.
	 *
	 * @param c the collection whose elements are to be placed into this
	 * collection.
	 * @throws IllegalArgumentException - if <code>c</code>     is <code>null</code>.
	 */
	public BasicCollection(Collection<? extends E> c)
	{
		if (c == null)
		{
			throw new java.lang.IllegalArgumentException();
		}
		int size = c.size() > DEFAULT_SIZE
			   ? (c.size() * 110) / 100 : DEFAULT_SIZE;
		collection = (E[]) new Object[size];
		c.toArray(collection);
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
	public boolean add(E element)
	{
		if (element == null)
		{
			throw new java.lang.IllegalArgumentException();
		}
		// if the collection is at capacity, make it bigger by 50%
		if (this.size == collection.length)
		{
			resize(this.size + this.size / 2);
		}
		collection[size] = element;
		size++;
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
	 * the call (this can only be true if there was at least one instance
	 * of <code>element</code> in this collection).
	 * @throws IllegalArgumentException if <code>element</code>     is <code>null</code>.
	 */
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
		for (int i = p; i < size - 1; i++)
		{
			collection[i] = collection[i + 1];
		}
		collection[size - 1] = null; // be neat!

		// Comment out the next line to illustrate
		//  the behavior of JUnit when a test fails.
		size--;
		modCount++;
		return true;
	}

	/**
	 * Creates and returns a copy of this object.
	 *
	 * The following is true of the clone and the original: 	 <blockquote><pre>
   * x.clone() != x
	 * x.clone().getClass() == x.getClass()
	 * x.clone().equals(x)
	 * </pre></blockquote>
	 *
	 * @return a clone of this instance.
	 * @exception OutOfMemoryError if there is not enough memory
	 * @see java.lang.Cloneable
	 */
	public Object clone()
	{
		BasicCollection<E> c = null;
		// 1. clone the entire collection object
		try
		{
			c = (BasicCollection<E>) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// shouldn't get here, so don't do anything
		}
		// 2. clone the collection array
		c.collection = (E[]) this.collection.clone();
		return c;
		/*     // the following produces a shallow clone of the collection
		 Object result = null;
		 try {
		 result = super.clone();
		 }catch( CloneNotSupportedException e )
		 { // shouldn't get here, so don't do anything
		 }
		 return result;
		 */
	}

	/**
	 * Returns the number of elements in this collection.
	 *
	 * @return the number of elements in this collection.
	 */
	public int size()
	{
		return this.size;
	}

	/**
	 * Returns an iterator over the elements contained in this collection.
	 *
	 * @return an iterator over the elements contained in this collection.
	 */
	public Iterator<E> iterator()
	{
		return new BasicIterator();
	}

	private void resize(int new_length)
	{
		E[] temp = (E[]) new Object[new_length];
		for (int i = 0; i < collection.length; i++)
		{
			temp[i] = collection[i];
			collection[i] = null; // cleanup
		}
		collection = temp;
	}

	private int find(Object element)
	{
		for (int i = 0; i < size; i++)
		{
			if (element.equals(collection[i]))
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
			E element = collection[cursor];
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
			BasicCollection.this.remove(collection[cursor]);

			// increment expectedModcount since the remove()
			// message above to the collection object will
			// have incremented modCount
			expectedModcount++;
		}
	}
}
