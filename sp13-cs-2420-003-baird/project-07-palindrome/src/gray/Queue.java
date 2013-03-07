/***********************************************************
 * Programming Assignment 7
 * Palindrome program
 * Programmer: Mark Eatough and Paul English
 * Course: CS 2410
 * Created March 6, 2013
 * 
 * This checks to see if a string is a palindrome, and
 * outputs a message so say if it is or not.
 ***********************************************************/
package gray;

/**
 * Interface for the Queue ADT with a fixed upper bound on
 * the number of elements that can be stored in the queue.
 */
public interface Queue< E > extends java.io.Serializable
{

	/**
	 * The default number of entries in a Queue.
	 */
	static final int DEFAULT_CAPACITY = 100;

	/**
	 * Return the upper bound on the number of elements this
	 * Queue can store.
	 * 
	 * @return the capacity of this queue.
	 */
	public int capacity( );

	/**
	 * Empty the queue of all elements.
	 */
	public void clear( );

	/**
	 * Remove and return the element at the front of the queue.
	 * 
	 * @return this queue's front element
	 * @throws EmptyQueueException
	 *             if the queue is empty
	 */
	public E dequeue( );

	/**
	 * Add <tt>element</tt> to the end of the queue.
	 * 
	 * @param element
	 *            The element to add to the rear of the queue
	 * @throws FullQueueException
	 *             if the queue is full
	 */
	public void enqueue( E element );

	/**
	 * Determine if this queue has any elements.
	 * 
	 * @return <tt>true</tt> if this queue has no elements
	 *         (<tt>size() == 0</tt>); <tt>false</tt> otherwise.
	 */
	public boolean isEmpty( );

	/**
	 * Determine if this queue has room for more elements.
	 * 
	 * @return <tt>true</tt> if this queue has room for more
	 *         elements (<tt>size() == capacity()</tt>); <tt>false</tt>
	 *         otherwise.
	 */
	public boolean isFull( );

	/**
	 * Return the element at the front of this queue. This
	 * operation does not change the state of this queue.
	 * 
	 * @return the element at the front of this queue
	 * @throws EmptyQueueException
	 *             if the queue is empty
	 */
	public E peek( );

	/**
	 * Determine the number of elements stored in this queue.
	 * 
	 * @return the number of elements in this queue
	 */
	public int size( );
}
