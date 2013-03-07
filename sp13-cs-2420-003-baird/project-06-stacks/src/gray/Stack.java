package src.gray;

import java.util.EmptyStackException;

/**
 * A stack provides last-in-first-out behavior. All access
 * operations on a stack are done at its <code>top</code>.
 */
public interface Stack< E >
{

	/**
	 * Determine if the stack is empty.
	 * 
	 * @return <code>true</code> if the stack is empty,
	 *         otherwise return false
	 */
	public boolean isEmpty( );

	/**
	 * Return the top element of the stack without removing it.
	 * This operation does not modify the stack.
	 * 
	 * @return topmost element of the stack
	 * @throws EmptyStackException
	 *             if the stack is empty
	 */
	public E peek( );

	/**
	 * Pop the top element from the stack and return it.
	 * 
	 * @return topmost element of the stack
	 * @throws EmptyStackException
	 *             if the stack is empty
	 */
	public E pop( );

	/**
	 * Push <code>element</code> on top of the stack.
	 * 
	 * @param element
	 *            the element to be pushed on the stack.
	 */
	public void push( E element );

	/**
	 * Return the number of elements currently stored in the stack.
	 * 
	 * @return topmost element of the stack
	 */
	public int size( );

}// end stack class
