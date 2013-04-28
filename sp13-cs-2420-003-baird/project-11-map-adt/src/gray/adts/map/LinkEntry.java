package gray.adts.map;

/**
 * A linked-list implementation of the <code>Entry</code> class used to create a
 * chained hash table.
 */
public class LinkEntry<K extends Comparable<? super K>, V extends Comparable<? super V>>
		extends Entry<K, V> implements java.io.Serializable
{

	private LinkEntry<K, V> successor;

	/**
	 * Create an entry for key <code>k</code> and value <code>v</code>.
	 * 
	 * @param k
	 *            the key for this entry
	 * @param v
	 *            the value associated with key <code>k</code> for this entry
	 * @param n
	 *            the link to the successor entry in this chain
	 * @throws <IllegalArgumentException> if either <code>k</code> or
	 *         <code>v</code> is <code>null</code>
	 */
	public LinkEntry(K k, V v, LinkEntry<K, V> n)
	{
		super(k, v);
		this.successor = n;
	}

	/**
	 * Reset the successor to this entry in the chain.
	 * 
	 * @param newSuccessor
	 *            the new link to the successor entry
	 *            in this chain
	 */
	public void setNext(LinkEntry<K, V> newSuccessor)
	{
		this.successor = newSuccessor;
	}

	/**
	 * Return a reference to the successor to this link entry.
	 * 
	 * @return the successor to this link entry
	 */
	public LinkEntry<K, V> successor()
	{
		return this.successor;
	}
}
