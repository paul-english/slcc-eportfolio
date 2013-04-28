package gray.adts.map;

import java.util.Collection;
import java.util.ConcurrentModificationException;

/**
 * Hash table implementation of the <code>Map</code> interface. This
 * implementation does not allow either the key or the value to
 * be <code>null</code>.
 */
public class HashMap<K extends Comparable<? super K>, V extends Comparable<? super V>>
		implements Map<K, V>, java.io.Serializable
{

	/**
	 * This iterator is used as a utility in support of the
	 * containsValue() and values() methods. It returns Entries,
	 * leaving it to the caller to extract the fields needed.
	 */
	private class HashTableIterator implements java.util.Iterator
	{

		/**
		 * The bucket number of the currrent chain being
		 * iterated over.
		 */
		private int bucket;

		/**
		 * Reference to the entry to be returned by the next call
		 * to successor(); successor() makes cursor null when the entry has
		 * been iterated over and hasNext() advances it to the
		 * next entry to be returned.
		 */
		private LinkEntry<K, V> cursor;

		/**
		 * Provides fail-fast operation of the iterator. For each
		 * call to an iterator method, expectedModcount should be
		 * equal to the collection's modCount, otherwise an
		 * intervening change (concurrent modification) to the
		 * collection has been made and we cannot guarantee that
		 * the iterator will behave correctly.
		 */
		private int expectedModcount;

		/**
		 * The iterator type determines what kind of iterator
		 * this is, which determines what is returned by successor():
		 * a key, a value or an entry.
		 */
		private final int iteratorType;

		/**
		 * Reference to the last entry returned by successor(). Use
		 * this to advance through the chain for the bucket at
		 * table[bucket].
		 */
		private LinkEntry<K, V> last;

		/**
		 * the contract of remove() says that each call to remove()
		 * must have been preceded by a call to successor() (they are
		 * paired). So if there has been NO call to successor() prior to
		 * a remove() or if there were two remove() calls without
		 * an intervening successor() call, it is NOT ok to try to
		 * remove an item.
		 */
		private boolean okToRemove;

		public HashTableIterator(int theType)
		{
			this.iteratorType = theType;
			this.bucket = -1;
			this.cursor = this.last = null;
			this.expectedModcount = HashMap.this.modCount;
			this.okToRemove = false;
			// hasNext();
		}

		@Override
		public boolean hasNext()
		{
			// check for concurrent modification
			if (this.expectedModcount != HashMap.this.modCount)
			{
				throw new ConcurrentModificationException();
			}

			if (this.bucket == HashMap.this.capacity)
			{
				return false;
			}

			// see if client has consumed last entry found by
			// hasNext()
			if (this.cursor != null)
			{
				return true;
			}

			// see if there are more entries in the current chain
			if (this.last != null)
			{
				// get to next entry in the chain, if it exists
				this.cursor = this.last.successor();
				if (this.cursor != null)
				{ // got an entry
					return true;
				}
				else
				{ // exhausted this chain; advance in table
					this.last = null;
				}
			}

			// exhausted the last chain, advance to the next
			// non-empty bucket
			this.bucket++;
			while ((this.bucket < HashMap.this.capacity)
					&& (HashMap.this.table[this.bucket] == null))
			{
				this.bucket++;
			}
			if (this.bucket >= HashMap.this.capacity)
			{
				return false;
			}
			// at least one more entry to return
			this.cursor = HashMap.this.table[this.bucket];

			return true;
		}

		@Override
		public Object next()
		{
			if (!this.hasNext())
			{
				throw new java.util.NoSuchElementException();
			}

			// check for concurrent modification
			if (this.expectedModcount != HashMap.this.modCount)
			{
				throw new ConcurrentModificationException();
			}

			this.okToRemove = true;
			this.last = this.cursor;
			this.cursor = null;
			Object o = null;
			switch (this.iteratorType)
			{
			case HashMap.KEY_ITERATOR:
				o = this.last.key();
				break;
			case HashMap.VALUE_ITERATOR:
				o = this.last.value();
				break;
			case HashMap.ENTRY_ITERATOR:
				o = this.last;
			}
			return o;
		}

		/**
		 * Remove the element returned by the last call to
		 * <code>successor()</code>.
		 * 
		 * @throws <code>ConcurrentModificationException</code> if this
		 *         collection has been modified by a method outside of this
		 *         iterator.
		 * @throws <code>IllegalStateException</code> if there has been
		 *         no call to <code>successor()</code> for this iteration or if
		 *         two
		 *         calls to <code>remove()</code> have been made with no
		 *         intervening call to <code>successor()</code>.
		 */
		@Override
		public void remove()
		{
			// check for concurrent modification
			if (this.expectedModcount != HashMap.this.modCount)
			{
				throw new ConcurrentModificationException();
			}

			// check that there has been a successor() message to
			// provide an element to remove
			if (!this.okToRemove)
			{
				throw new IllegalStateException();
			}

			this.expectedModcount++;
			this.okToRemove = false;
			HashMap.this.remove(this.last.key());
		}
	}

	/**
	 * The default capacity of the table. To facilitate uniform
	 * distribution of keys over the table, capacity should be
	 * a prime number.
	 */
	private static final transient int DEFAULT_CAPACITY = 11;
	private static final int ENTRY_ITERATOR = 2;

	/**
	 * Fields used to determine the type of iterator created.
	 * Depending on the type, an interator will return an entry,
	 * an entry's key or an entry's value.
	 */
	private static final int KEY_ITERATOR = 0;

	/**
	 * The maximum load factor the table will sustain before
	 * resizing.
	 */
	private static final transient float MAX_LOAD_FACTOR = .70f;

	private static final int VALUE_ITERATOR = 1;

	/**
	 * The actual number of buckets in this hash table. This value
	 * will change over time if the table is resized.
	 */
	private int capacity;

	/**
	 * This is the <code>Collection</code> view of this map.
	 */
	private Collection<V> collectionView = null;

	private Collection<K> keyView = null;

	/**
	 * The number of add and remove operations performed on this
	 * collection. This information is used by the iterator to
	 * provide a fail-fast iterator. Any operation that changes the
	 * size of this collection should add 1 to <code>modcount</code> for
	 * <it>each</it> change made.
	 */
	protected transient int modCount;

	/**
	 * The number of entries stored in this hash table.
	 */
	private int size;

	/**
	 * The hash table.
	 */
	private LinkEntry<K, V> table[];

	/**
	 * Constructor. Create an instance of a map.
	 */
	public HashMap()
	{
		this.capacity = HashMap.DEFAULT_CAPACITY;
		this.table = (new LinkEntry[this.capacity]);
		this.clear();
	}

	/**
	 * Removes all the entries from this map.
	 * <P>
	 * 
	 * @post size() is 0
	 */
	@Override
	public void clear()
	{
		this.size = 0;
		for (int i = 0; i < this.capacity; i++)
		{
			this.table[i] = null;
		}
	}

	/**
	 * Determines if the map contains an entry containing <code>key</code>.
	 * 
	 * @param key
	 *            the key to search for in the map.
	 * @return true if <code>key</code> was not found in the map,
	 *         false otherwise.
	 * @throws <code>IllegalArgumentException</code> if <code>key</code> is
	 *         <code>null</code>.
	 */
	@Override
	public boolean containsKey(K key)
	{
		return (this.get(key) != null);
	}

	/**
	 * Determines if the map contains an entry containing <code>value</code>.
	 * 
	 * @param value
	 *            the value to search for in the map.
	 * @return true if <code>value</code> was not found in the map,
	 *         false otherwise.
	 * @throws <code>IllegalArgumentException</code> if <code>value</code> is
	 *         <code>null</code>.
	 */
	@Override
	public boolean containsValue(V target)
	{
		java.util.Iterator iter = new HashTableIterator(HashMap.VALUE_ITERATOR);
		while (iter.hasNext())
		{
			V value = (V) iter.next();
			if (value.equals(target))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Utility method to locate an entry in the hash table.
	 * 
	 * @param current
	 *            the entry point to a hash chain
	 * @param targetKey
	 *            the key we are search for
	 * @return null if the key was not found, a reference to its
	 *         entry otherwise
	 */
	private LinkEntry<K, V> find(LinkEntry<K, V> current, K targetKey)
	{
		while ((current != null) && (!current.key().equals(targetKey)))
		{
			current = current.successor();
		}
		return current;
	}

	/**
	 * Gets the value associated with <code>key</code> from this map,
	 * if it exists.
	 * 
	 * @param key
	 *            the key to use to search the map; cannot be <code>null</code>.
	 * @return <code>null</code> if <code>key</code> was not found in the
	 *         map, the value associated with <code>key</code> otherwise.
	 * @throws <code>IllegalArgumentException</code> if <code>key</code> is
	 *         <code>null</code>.
	 */
	@Override
	public V get(K key)
	{
		if (key == null)
		{
			throw new IllegalArgumentException("null argument");
		}

		int hashIndex = this.getHashIndex(key);
		LinkEntry<K, V> entry = this.find(this.table[hashIndex], key);

		return entry == null ? null : entry.value();
	}

	/**
	 * Compute a hash index for <code>key</code> in the range 0 to
	 * <code>this.capacity - 1</code>
	 * 
	 * @param <code>key</Code> the key for which we want a hash
	 *        index - cannot be null (not checked)
	 * @return an integer in the range 0 to this.capacity - 1
	 */
	private int getHashIndex(K key)
	{
		int hashIndex = key.hashCode();
		if (hashIndex < 0)
		{
			hashIndex = -hashIndex;
		}
		hashIndex = hashIndex % this.capacity; // get it in range
		return hashIndex;
	}

	/**
	 * Determine if this map is empty or not
	 * 
	 * @return true if there are no values in this map
	 */
	@Override
	public boolean isEmpty()
	{
		return this.size() == 0;
	}

	public Collection<K> keys()
	{
		// if there is already a Collection object for this map,
		// return it
		if (this.keyView == null)
		{
			// otherwise, create one
			this.keyView = new java.util.AbstractCollection<K>()
			{

				@Override
				public boolean add(K o)
				{
					if (HashMap.this.containsKey(o))
					{
						return false;
					}
					super.add(o);
					return true;
				}

				@Override
				public void clear()
				{
					HashMap.this.clear();
				}

				@Override
				public boolean contains(Object target)
				{
					return HashMap.this.containsKey((K) target);
				}

				// and fill in the missing (abstract) methods
				@Override
				public java.util.Iterator<K> iterator()
				{
					return new HashTableIterator(HashMap.KEY_ITERATOR);
				}

				@Override
				public int size()
				{
					return HashMap.this.size();
				}
			};
		}
		return this.keyView;
	}

	/**
	 * Puts the (<code>key</code>, <code>value</code>) pair into this
	 * map. If an entry with this <code>key</code> already exists in
	 * the map, its <code>value</code> is replaced with the new
	 * <code>value</code> and the old <code>value</code> is returned.
	 * 
	 * @param key
	 *            the key for this map entry; cannot be <code>null</code>.
	 * @param value
	 *            the value for this map entry; cannot
	 *            be <code>null</code>.
	 * @return <code>null</code> if the <code>key</code> was not already.
	 *         in the map, the old value associated with <code>key</code>
	 *         otherwise.
	 * @throws <code>IllegalArgumentException</code> if <code>key</code> or
	 *         <code>value</code> are <code>null</code>.
	 */
	@Override
	public V put(K key, V value)
	{
		if ((key == null) || (value == null))
		{
			throw new IllegalArgumentException("null argument");
		}

		if (((float) this.size / this.capacity) >= HashMap.MAX_LOAD_FACTOR)
		{
			this.resize();
		}

		this.modCount++;

		int hashIndex = this.getHashIndex(key);
		LinkEntry<K, V> entry = this.find(this.table[hashIndex], key);

		// if we hit the end of the chain, the key isn't already
		// in the table, so put this new entry at the head of
		// the chain
		if (entry == null)
		{
			entry = new LinkEntry<K, V>(key, value, this.table[hashIndex]);
			this.table[hashIndex] = entry;
			this.size++;
			return null;
		}
		else
		{ // key is in the table, so replace its value field
			V tempValue = entry.value();
			entry.setValue(value);
			return tempValue;
		}
	}

	/**
	 * Remove the element from this the map associated with <code>key</code>. If
	 * a <code>value</code> with this <code>key</code> exists in the map, it is
	 * returned, otherwise <code>null</code> is returned.
	 * 
	 * @param key
	 *            remove the entry identified by <code>key</code>;
	 *            cannot be <code>null</code>.
	 * @return <code>null</code> if <code>key</code> was not found in the
	 *         map, the <code>value</code> associated with <code>key</code>
	 *         otherwise.
	 * @throws <code>IllegalArgumentException</code> if <code>key</code> is
	 *         <code>null</code> or cannot be compared to other keys in
	 *         the map.
	 */
	@Override
	public V remove(K key)
	{
		if (key == null)
		{
			throw new IllegalArgumentException("null argument");
		}

		this.modCount++;

		int hashIndex = this.getHashIndex(key);
		LinkEntry<K, V> prev = null, current = this.table[hashIndex];

		while ((current != null) && (!current.key().equals(key)))
		{
			prev = current;
			current = current.successor();
		}
		if (current == null)
		{
			return null;
		}

		this.size--;

		if (prev != null)
		{
			prev.setNext(current.successor());
		}
		else
		{ // at the head of the chain
			this.table[hashIndex] = current.successor();
		}

		current.setNext(null);

		return current.value();
	}

	/**
	 * Double the capacity of the hash table and rehash all the
	 * entries into it. This method is only called when the load
	 * factor of the table meets or exceeds MAX_LOAD_FACTOR.
	 */
	private void resize()
	{
		// int oldSize = this.size();
		int newCapacity = this.capacity * 2;

		LinkEntry[] newTable = new LinkEntry[this.capacity * 2];
		for (int i = 0; i < newCapacity; i++)
		{
			newTable[i] = null;
		}

		java.util.Iterator<LinkEntry<K, V>> iter = new HashTableIterator(
				HashMap.ENTRY_ITERATOR);

		while (iter.hasNext())
		{
			LinkEntry<K, V> entry = iter.next();
			int hashIndex = entry.key().hashCode();
			if (hashIndex < 0)
			{
				hashIndex = -hashIndex;
			}
			hashIndex = hashIndex % newCapacity;
			new LinkEntry<K, V>(entry.key(), entry.value(), newTable[hashIndex]);
			newTable[hashIndex] = entry;
		}
		// now clear out the old entries and reset the relevant
		// data fields.
		this.clear();
		this.capacity = newCapacity;
		this.table = newTable;
	}

	/**
	 * Return the number of entries in this map.
	 * 
	 * @return the number of entries in this map.
	 */
	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public Collection<V> values()
	{
		// if there is already a Collection object for this map,
		// return it
		if (this.collectionView == null)
		{
			// otherwise, create one
			this.collectionView = new java.util.AbstractCollection<V>()
			{

				@Override
				public void clear()
				{
					HashMap.this.clear();
				}

				@Override
				public boolean contains(Object target)
				{
					return HashMap.this.containsValue((V) target);
				}

				// and fill in the missing (abstract) methods
				@Override
				public java.util.Iterator<V> iterator()
				{
					return new HashTableIterator(HashMap.VALUE_ITERATOR);
				}

				@Override
				public int size()
				{
					return HashMap.this.size();
				}
			};
		}
		return this.collectionView;
	}
}
