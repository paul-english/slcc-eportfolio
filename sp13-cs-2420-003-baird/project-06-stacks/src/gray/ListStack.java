package src.gray;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * An implementation of the Stack interface using a List as the
 * underlying data structure.
 */
public class ListStack< E > implements Stack< E >
{
	private final java.util.List< E > stack;

	// the top of stack is represented by position
	// s.size() - 1 in the list.

	/**
	 * Create an empty stack.
	 */
	public ListStack( )
	{
		this.stack = new LinkedList< E >( );
	}

	/**
	 * Determine if the stack is empty.
	 * 
	 * @return <tt>true</tt> if the stack is empty,
	 *         otherwise return false
	 */
	@Override
	public boolean isEmpty( )
	{
		return this.stack.isEmpty( );
	}

	/**
	 * Return the top element of the stack without removing it.
	 * This operation does not modify the stack.
	 * 
	 * @return topmost element of the stack
	 * @throws StackEmptyException
	 *             if the stack is empty
	 */
	@Override
	public E peek( )
	{
		if ( this.stack.isEmpty( ) )
		{
			throw new EmptyStackException( );
		}
		return this.stack.get( this.stack.size( ) - 1 );
	}

	/**
	 * Pop the top element from the stack and return it.
	 * 
	 * @return topmost element of the stack
	 * @throws StackEmptyException
	 *             if the stack is empty
	 */
	@Override
	public E pop( )
	{
		if ( this.stack.isEmpty( ) )
		{
			throw new EmptyStackException( );
		}
		return this.stack.remove( this.stack.size( ) - 1 );
	}

	/**
	 * Push <tt>element</tt> on top of the stack.
	 * 
	 * @param element
	 *            the element to be pushed on the stack.
	 */
	@Override
	public void push( E element )
	{
		this.stack.add( this.stack.size( ), element );
	}

	/**
	 * Return the number of elements currently stored in the stack.
	 * 
	 * @return topmost element of the stack
	 */
	@Override
	public int size( )
	{
		return this.stack.size( );
	}

}// end ListStack class
