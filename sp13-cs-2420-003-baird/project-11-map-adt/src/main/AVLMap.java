package main;

import gray.adts.binarysearchtree.AVLTree;
import gray.adts.map.Entry;
import gray.adts.map.Map;

import java.util.ArrayList;
import java.util.Collection;

public class AVLMap<K extends Comparable<? super K>, V extends Comparable<? super V>>
		implements Map<K, V>
{

	private final AVLTree<Entry<K, V>> map = new AVLTree<>();

	@Override
	public void clear()
	{
		this.map.clear();
	}

	@Override
	public boolean containsKey(K key)
	{
		for (Entry<K, V> entry : this.map)
		{
			if (entry.key() == key)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(V value)
	{
		for (Entry<K, V> entry : this.map)
		{
			if (entry.value() == value)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(K key)
	{
		for (Entry<K, V> entry : this.map)
		{
			if (entry.key() == key)
			{
				return entry.value();
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return this.map.isEmpty();
	}

	@Override
	public V put(K key, V value)
	{
		V old = null;
		if (this.containsKey(key))
		{
			old = this.remove(key);
		}
		Entry<K, V> entry = new Entry<K, V>(key, value);
		this.map.add(entry);
		return old;
	}

	@Override
	public V remove(K key)
	{
		for (Entry<K, V> entry : this.map)
		{
			if (entry.key() == key)
			{
				this.map.remove(entry);
				return entry.value();
			}
		}
		return null;
	}

	@Override
	public int size()
	{
		return this.map.size();
	}

	@Override
	public Collection<V> values()
	{
		Collection<V> values = new ArrayList<>();
		for (Entry<K, V> entry : this.map)
		{
			values.add(entry.value());
		}
		return values;
	}

}
