package gray.adts.map;

/**
 * A Map associates keys with values in map entries. Given a key,
 * the map produces the associated value. Duplicate keys are not
 * allowed and a key can be associated with only a single value.
 * However, duplicate values are allowed, so a value may be
 * associated with multiple keys.
 */
public interface Map<K, V> {

  /**
   * Removes all the entries from this map.
   */
  public void clear();

  /**
   * Determines if the map contains an entry containing
   * <code>key</code>.
   * @param key the key to search for in the map.
   * @return <code>true</code> if <code>key</code> was not found
   * in the map, <code>false</code> otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   * is <code>null</code>.
   */
  public boolean containsKey( K key );

  /**
   * Determines if the map contains an entry containing
   * <code>value</code>.
   * @param value the value to search for in the map.
   * @return <code>true</code> if <code>value</code> was not found
   * in the map, <code>false</code> otherwise.
   * @throws <code>IllegalArgumentException</code> if
   * <code>value</code> is <code>null</code>.
   */
  public boolean containsValue( V value );

  /**
   * Gets the value associated with <code>key</code> from this map,
   *  if it exists.
   * @param key the key to use to search the map; cannot be
   *  <code>null</code>.
   * @return <code>null</code> if <code>key</code> was not found in the
   * map; the value associated with <code>key</code> otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   * is <code>null</code>.
   */
  public V get( K key );

  /**
   * Determine if this map is empty.
   * @return <code>true</code> if there are no values in this map
   */
  public boolean isEmpty();

  /**
   * Puts the (<code>key</code>, <code>value</code>) pair into this
   * map. If an entry with this <code>key</code> already exists in
   * the map, its <code>value</code> is replaced with the new
   * <code>value</code> and the old <code>value</code> is returned.
   * @param key the key for this map entry; cannot be
   *  <code>null</code>.
   * @param value the value for this map entry; cannot
   *  be <code>null</code>.
   * @return <code>null</code> if the <code>key</code> was not already.
   * in the map; the old value associated with <code>key</code>
   * otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   * or <code>value</code> are <code>null</code>.
   */
  public V put( K key, V value );

  /**
   * Remove the element from this the map associated with
   * <code>key</code>. If a <code>value</code> with this <code>key</code>
   * exists in the map, it is returned, otherwise <code>null</code>
   * is returned.
   * @param key remove the entry identified by <code>key</code>;
   * cannot be <code>null</code>.
   * @return <code>null</code> if <code>key</code> was not found in the
   * map, the <code>value</code> associated with <code>key</code>
   * otherwise.
   * @throws <code>IllegalArgumentException</code> if <code>key</code>
   * is <code>null</code> or cannot be compared to other keys in
   * the map.
   */
  public V remove( K key );

  /**
   * Return the number of entries in this map.
   * @return the number of entries in this map.
   */
  public int size();

  /**
   * Provides a <code>Collection</code> view of all the values
   * contained in his map.
   * @return a <code>Collection</code> view of the values
   * stored in this map.
   */
  public java.util.Collection<V> values();
}
