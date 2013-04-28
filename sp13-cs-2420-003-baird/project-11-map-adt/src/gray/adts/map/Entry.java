package gray.adts.map;

public class Entry<K extends Comparable<? super K>, V extends Comparable<? super V>>
		implements Comparable<Entry<K, V>>, java.io.Serializable
{

	private final K key;
	private V value;

	public Entry()
	{
		this.key = null;
		this.value = null;
	}

	/**
	 * Create an entry for key <code>k</code> and value <code>v</code>.
	 * 
	 * @param k
	 *            the key for this entry
	 * @param v
	 *            the value associated with key <code>k</code> for this entry
	 * @throws <IllegalArgumentException> if either <code>k</code> or
	 *         <code>v</code> is <code>null</code>
	 */
	public Entry(K k, V v)
	{
		if ((k == null) || (v == null))
		{
			throw new IllegalArgumentException("null argument ");
		}
		this.key = k;
		this.value = v;
	}

	@Override
	public int compareTo(Entry<K, V> entry)
	{
		return this.key().compareTo(entry.key());
	}

	/**
	 * Return the <code>key</code> for this entry.
	 * 
	 * @return the <code>key</code> for this entry
	 */
	public K key()
	{
		return this.key;
	}

	/**
	 * Set the <code>value</code> field for this entry to <code>newValue</code>.
	 * 
	 * @param newValue
	 *            the new value for this entry
	 * @return the old <code>value</code> for this entry
	 */
	public V setValue(V newValue)
	{
		if (newValue == null)
		{
			throw new IllegalArgumentException("null argument ");
		}
		V tempValue = this.value;
		this.value = newValue;
		return tempValue;
	}

	/**
	 * Overridden method from <code>Object</Code>.
	 * 
	 * @return <code>String</code> representation of this entry.
	 */
	@Override
	public String toString()
	{
		return "Key: " + this.key + "\nValue: " + this.value;
	}

	/**
	 * Return the <code>value</code> for this entry.
	 * 
	 * @return the <code>value</code> for this entry
	 */
	public V value()
	{
		return this.value;
	}

}
