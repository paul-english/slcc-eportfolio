/**
 * Linked implementation of the <code>java.util.List</code> interface
 * by extending <code>java.util.AbstractSequentialList</code>.
 * <p>
 */
package list;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings( "serial" )
public class LinkedList< E > extends AbstractSequentialList< E > implements
		Serializable
{

	// inner class implementing the list iterator
	/*
	 * As before, some methods can be implemented in the abstract class using
	 * other methods defined in the class. A very simple example is
	 * listIterator() which returns a ListIterator object which will begin
	 * its iteration with the first element in the list. This is easily
	 * implemented as return listIterator(0);
	 * But ASL makes much more use of this ability.
	 * ASL is written assuming a sequential access structure will be used
	 * as the backing store. This means that all the indexed ("random access")
	 * operations are written on top of the list iterator. For example,
	 * add(index, element) can easily be implemented as
	 * ListIterator iter = new ListIterator(index);
	 * iter.add( element );
	 * Implementations of remove(index), set(index), addAll(index, collection)
	 * can easily be implemented in a similar fashion.
	 * But how can there be concrete implementations of the optional methods
	 * defined
	 * in ASL? If these methods are not needed by a List implementation, they
	 * should throw an UnsupportedExceptionOperation. The answer is rather
	 * neat. By building the optional methods on top of the ListIterator
	 * methods,
	 * we can defer throwing an exception to ListIterator. If, on the other
	 * hand,
	 * we want to support an optional method, all we need to do is to provide
	 * the necessary implementation in the ListIterator class! For example, the
	 * add(index, element) method uses the add(element) method from
	 * ListIterator.
	 * If add() operations are not supported for a particular list
	 * implementation,
	 * all you need to do is
	 * implement ListIterator.add(element) to throw an
	 * UnsupportedExceptionOperation.
	 * If List.add(index, element) is invoked, it will throw an
	 * UnsupportedExceptionOperation
	 * when it invokes the ListIterator.add(element) method. Alternatively, if
	 * add() is to be supported, ListIterator.add(element) is implemented
	 * accordingly (as we will do).
	 * To support checks for concurrent modification, AL defines a modCount
	 * data field to keep track of all structural modifications to the list.
	 * This field is marked as protected in AL, which means that it is not
	 * available outide of the class, but it is available to subclasses
	 * of AL. Each time the list is structurally modified, the modCount field
	 * must be incremented. As before, when an Iterator or a ListIterator
	 * object is created, it must make a copy of the modCount field. If the
	 * expectedModCount value is different from modCount when any Iterator
	 * or ListIterator method is called, a ConcurrentModificationException
	 * must be thrown. The updating of the modCount field must be done by the
	 * add() and remove() methods from ListIterator because the add() and
	 * remove()
	 * methods defined in ASL do not do this.
	 * While having the abstract classes available is a real help, it also
	 * incurs a responsibility to check the contracts for those classes to
	 * make sure that the methods we implement in LinkedList meet all the
	 * obligations laid out by an ancestor class. For example,
	 */
	@SuppressWarnings( "hiding" )
	public class LinkedListIterator< E > implements ListIterator< E >
	{
		// invariant: cursor should always reference a node from
		// head's successor to tail. cursor should never reference head.

		private DLNode< E > cursor;  // references node to be returned by next(),
		/**
		 * Provides fail-fast operation of the iterator. For each call
		 * to an
		 * iterator method, expectedModCount should be equal to the
		 * collection's
		 * modCount, otherwise an intervening change (concurrent
		 * modification)
		 * to the collection has been made and we cannot guarantee that
		 * the
		 * iterator will behave correctly.
		 */
		private int expectedModCount;
		// which
		// is successor to node to be returned by previous()
		private DLNode< E > lastNodeReturned;  // last node reterned by next() or
		// previous()
		private int nextIndex; // index of node returned by NEXT call to next()
		/**
		 * the contract of remove() says that each call to remove() must
		 * have
		 * been preceded by a call to next()/previous() (they are
		 * paired). So if there has
		 * been NO call to next()/previous() prior to a remove() or if
		 * there were two
		 * remove() calls without an intervening next()/previous() call,
		 * it is NOT ok to
		 * try to remove an item.
		 */
		private boolean okToRemove;

		// pre: 0 <= index <= size()
		@SuppressWarnings( "unchecked" )
		public LinkedListIterator( int index )
		{
			if ( ( index < 0 ) || ( index > LinkedList.this.size ) )
			{
				throw new IndexOutOfBoundsException( "index " + index
						+ " is out of range: 0 to " + LinkedList.this.size );
			}
			// cursor starts out at the target node's predecessor
			// DLNode temp = head;
			if ( index == 0 )
			{
				this.cursor = (DLNode< E >) LinkedList.this.head.getSuccessor( );
			}
			else if ( index == LinkedList.this.size )
			{
				this.cursor = (DLNode< E >) LinkedList.this.tail;
			}
			else
			{
				this.cursor = (DLNode< E >) LinkedList.this.getNodeAt( index );
			}
			this.nextIndex = index;
			this.okToRemove = false;
			this.expectedModCount = LinkedList.this.modCount;
			this.lastNodeReturned = null;
		}

		@Override
		public void add( E o )
		{
			this.checkForConcurrentModification( );

			this.okToRemove = false;

			DLNode< E > newnode = new DLNode< E >( o,
					this.cursor.getPredecessor( ), this.cursor );
			newnode.getPredecessor( ).setSuccessor( newnode );
			this.cursor.setPredecessor( newnode );

			this.nextIndex++;
			LinkedList.this.size++;       // update List data field
			LinkedList.this.modCount++;   // update List data field
			this.expectedModCount = LinkedList.this.modCount;
		}

		private void checkForConcurrentModification( )
		{
			if ( this.expectedModCount != LinkedList.this.modCount )
			{
				throw new java.util.ConcurrentModificationException( );
			}
		}

		@Override
		public boolean hasNext( )
		{
			this.checkForConcurrentModification( );
			return this.cursor != LinkedList.this.tail;
		}

		@Override
		public boolean hasPrevious( )
		{
			this.checkForConcurrentModification( );
			return this.cursor.getPredecessor( ) != LinkedList.this.head;
		}

		@Override
		public E next( )
		{
			if ( !this.hasNext( ) )
			{
				throw new NoSuchElementException( "no next element" );
			}

			this.checkForConcurrentModification( );

			this.okToRemove = true;

			// next() is the inverse of previous():
			// always get the element field THEN advance the cursor
			this.nextIndex++;
			E element = this.cursor.getElement( );
			this.lastNodeReturned = this.cursor;
			this.cursor = this.cursor.getSuccessor( );
			return element;
		}

		@Override
		public int nextIndex( )
		{
			this.checkForConcurrentModification( );
			if ( this.hasNext( ) )
			{
				return this.nextIndex;
			}
			else
			{
				return LinkedList.this.size;
			}
		}

		@Override
		public E previous( )
		{
			this.checkForConcurrentModification( );
			if ( !this.hasPrevious( ) )
			{
				throw new NoSuchElementException( "no previous element" );
			}

			this.okToRemove = true;

			// previous() is the inverse of next():
			// always decrement the cursor THEN get the element field
			this.nextIndex--;
			this.cursor = this.cursor.getPredecessor( );
			this.lastNodeReturned = this.cursor;
			// System.err.println("previous(): cursor is " + cursor);
			return this.cursor.getElement( );
		}

		// nextIndex is the index of the element to be returned by next(),
		// so the previous index will be one less than nextIndex
		@Override
		public int previousIndex( )
		{
			this.checkForConcurrentModification( );
			if ( this.hasPrevious( ) )
			{
				return this.nextIndex - 1;
			}
			else
			{
				return -1;
			}
		}

		@Override
		public void remove( )
		{
			this.checkForConcurrentModification( );

			// check that there has been a next()/previous() message to provide
			// an element to remove
			if ( !this.okToRemove )
			{
				throw new IllegalStateException( );
			}

			this.okToRemove = false;

			// either the cursor or nextIndex needs to be updated
			if ( this.cursor == this.lastNodeReturned )  // removing item
														// returned by a
			// previous() call
			{
				this.cursor = this.cursor.getSuccessor( );     // move cursor
															// forward
			}
			else
			// removing item returned by a next() call
			{
				this.nextIndex--;                   // move nextIndex backward
			}
			this.lastNodeReturned.getPredecessor( ).setSuccessor(
					this.lastNodeReturned.getSuccessor( ) );
			this.lastNodeReturned.getSuccessor( ).setPredecessor(
					this.lastNodeReturned.getPredecessor( ) );

			// now do cleanup
			this.lastNodeReturned.setSuccessor( null );
			this.lastNodeReturned.setPredecessor( null );
			this.lastNodeReturned.setElement( null );
			this.lastNodeReturned = null;

			LinkedList.this.size--;       // update LinkedList data field
			LinkedList.this.modCount++;   // update AbstractList data field
			this.expectedModCount = LinkedList.this.modCount;
		}

		// change the value stored by the last node returned by next() or
		// previous()
		@Override
		public void set( E o )
		{
			this.checkForConcurrentModification( );
			this.lastNodeReturned.setElement( o );
		}
	}

	private final DLNode< E > head;
	private int size = 0;   // size can never be < 0

	private final DLNode< E > tail;

	public LinkedList( )
	{
		this.size = 0;
		this.tail = new DLNode< E >( );		         // the tail dummy node
		this.head = new DLNode< E >( null, null, this.tail );  // the head dummy
																// node
		this.tail.setPredecessor( this.head );
		this.modCount = 0;
	}

	@Override
	public void add( int index, E o )
	{
		ListIterator< E > iter = this.listIterator( index );
		iter.add( o );
	}

	/*
	 * pre: 0 <= index <= size()
	 * We DO NOT check that this is true!
	 */
	private DLNode< E > getNodeAt( int index )
	{
		// check for empty list and appending at the tail
		if ( index == this.size )
		{
			return this.tail;
		}
		DLNode< E > p = null;

		if ( ( index < ( this.size / 2 ) ) )
		{ // start at beginning of the list
			p = this.head.getSuccessor( );
			for ( int i = 0; i != index; i++ )
			{
				p = p.getSuccessor( );
			}
		}
		else
		{
			p = this.tail.getPredecessor( );
			for ( int i = this.size - 1; i != index; i-- )
			{
				p = p.getPredecessor( );
			}
		}
		return p;
	}

	// public void add( int index, E e ) {
	// // add() and listIterator() have the same requirements with respect to
	// // index, so let listIterator() do the checking
	// ListIterator<E> iter = listIterator( index );
	// iter.add( e );
	// modCount++;
	// }
	// public Object remove( int index ) {
	// // verify that index is legal
	// if (( index < 0 ) || ( index >= size ) )
	// throw new IllegalArgumentException("index " + index
	// + " is out of range: 0 to " + (this.size - 1));
	// ListIterator<E> iter = listIterator( index );
	// E element = iter.next();
	// iter.remove( );
	// modCount++;
	// return element;
	// }

	@Override
	public ListIterator< E > listIterator( int index )
	{
		if ( ( index < 0 ) || ( index > this.size ) )
		{
			throw new IndexOutOfBoundsException( "index " + index
					+ " is out of range: 0 to " + this.size );
		}
		return new LinkedListIterator< E >( index );
	}

	@Override
	public int size( )
	{
		return this.size;
	}
}
