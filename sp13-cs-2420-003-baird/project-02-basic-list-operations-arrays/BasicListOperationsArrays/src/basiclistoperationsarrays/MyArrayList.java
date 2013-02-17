/********************************************************
 *
 *  Project :  Basic List Operations - Arrays
 *  File    :  MyArrayList.java
 *  Name    :  Paul English
 *  Date    :  02/11/2013
 *
 *  Description : A list class that uses an array to manage data.
 *
 ********************************************************/
package basiclistoperationsarrays;

/**
 * A list class that uses an array to manage data.
 *
 * @param <T>
 * @author nrub
 */
public class MyArrayList<T>
{

	private T[] array;
	private int numElements = 0;
	private static final int defaultCapacity = 10;
	private int capacity = 0;
	private int cursor = 0;

	/**
	 * A default constructor for creating an instance of MyArrayList with a
	 * default capacity.
	 */
	public MyArrayList()
	{
		this(defaultCapacity);
	}

	/**
	 * A constructor that allows you to create an instance of MyArrayList
	 * with any desired capacity.
	 *
	 * @param size The capacity your list will be set to.
	 */
	public MyArrayList(int size)
	{
		array = (T[]) new Object[size];
		capacity = size;
	}

	/**
	 * Returns the number of elements in your MyArrayList instantiation.
	 *
	 * @return An integer representing the number of elements in this list.
	 */
	public int getNumElements()
	{
		return numElements;
	}

	/**
	 * Returns the current capacity of your list.
	 *
	 * @return An integer representing the current list capacity, or size of
	 * the underlying array.
	 */
	public int getCapacity()
	{
		return capacity;
	}

	private void doubleSize()
	{
		resize(capacity * 2);
	}

	/**
	 * Allows you to set a new capacity for the underlying array. Will not
	 * allow you to resize if the new capacity is smaller than the current
	 * number of elements.
	 *
	 * @param newCapacity The new capacity to set.
	 */
	public void resize(int newCapacity)
	{
		// TODO throw an error when capacity less than numElements
		T[] newArray = (T[]) new Object[newCapacity];
		if (newCapacity < numElements)
		{
			newCapacity = numElements;
		}
		for (int i = 0; i < array.length && i < newArray.length; i++)
		{
			newArray[i] = array[i];
		}
		this.array = newArray;
		this.capacity = newCapacity;
	}

	/**
	 * Will replace the element at position with the newValue.
	 *
	 * @param position A position in the list to containing the element to
	 * replace.
	 * @param newValue The value that will be assigned to the element at
	 * position.
	 */
	public void replace(int position, T newValue)
	{
		while (position > capacity)
		{
			doubleSize();
		}
		if (array[position] == null)
		{
			numElements += 1;
		}
		array[position] = newValue;

	}

	/**
	 *
	 * @param oldValue
	 * @param newValue
	 * @throws Exception
	 */
	public void replace(T oldValue, T newValue) throws Exception
	{
		int position = getIndexOf(oldValue);
		replace(position, newValue);
	}

	/**
	 *
	 * @param position
	 * @param newValue
	 */
	public void insert(int position, T newValue)
	{
		while (position > capacity || numElements + 1 > capacity)
		{
			doubleSize();
		}
		if (array[position] != null)
		{
			shift(position);
		}
		array[position] = newValue;
		numElements += 1;
	}

	/**
	 *
	 * @param newValue
	 */
	public void insert(T newValue)
	{
		insert(numElements, newValue);
	}

	/**
	 *
	 * @param position
	 */
	public void delete(int position)
	{
		if (position >= capacity)
		{
			throw new ArrayIndexOutOfBoundsException("Unable to delete elements outside of bounds");
		}
		deshift(position);
		numElements -= 1;
	}

	/**
	 *
	 * @param value
	 * @throws Exception
	 */
	public void delete(T value) throws Exception
	{
		int position = getIndexOf(value);
		delete(position);
	}

	/**
	 *
	 * @param position
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public T getElementAt(int position) throws ArrayIndexOutOfBoundsException
	{
		return array[position];
	}

	/**
	 *
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public int getIndexOf(T value) throws Exception
	{
		for (int i = 0; i < numElements; i++)
		{
			if (array[i].equals(value))
			{
				return i;
			}
		}
		throw new Exception("Element not found");
	}

	private void shift(int position)
	{
		T current = null;
		for (int i = position; i < numElements; i++)
		{
			T next = array[i];
			array[i] = current;
			current = next;
		}
	}

	private void deshift(int position)
	{
		for (int i = position; i < numElements - 1; i++)
		{
			array[i] = array[i + 1];
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean hasNext()
	{
		return cursor >= 0 && cursor < numElements;
	}

	/**
	 *
	 * @return
	 */
	public T next()
	{
		return array[cursor++];
	}

	/**
	 *
	 * @return
	 */
	public boolean hasPrevious()
	{
		return cursor > 0 && cursor <= numElements;
	}

	/**
	 *
	 * @return
	 */
	public T prev()
	{
		return array[--cursor];
	}

	/**
	 *
	 * @return
	 */
	public int getCursor()
	{
		return cursor;
	}

	/**
	 *
	 * @param newCursor
	 * @throws Exception
	 */
	public void setCursor(int newCursor) throws Exception
	{
		if (newCursor > numElements || newCursor <= 0)
		{
			throw new Exception("Cursor out of bounds");
		}
		cursor = newCursor;
	}
}
