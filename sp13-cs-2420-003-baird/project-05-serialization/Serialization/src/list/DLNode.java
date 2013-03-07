/**
 * A doubly-linked list node.
 * <p>
 */
package list;

import java.io.Serializable;

@SuppressWarnings( "serial" )
public class DLNode< E > implements Serializable
{

	private E element;       // the data field
	private DLNode< E > predecessor;   // link to previous (predecessor) DLNode
	private DLNode< E > successor;     // the link to next (successor) DLNode

	public DLNode( )
	{
		this.element = null;
		this.predecessor = null;
		this.successor = null;
	}

	public DLNode( E list_element, DLNode< E > pred, DLNode< E > succ )
	{
		this.element = list_element;
		this.predecessor = pred;
		this.successor = succ;
	}

	public void setElement( E list_element )
	{
		this.element = list_element;
	}

	public E getElement( )
	{
		return this.element;
	}

	public DLNode< E > getPredecessor( )
	{
		return this.predecessor;
	}

	public void setPredecessor( DLNode< E > new_predecessor )
	{
		this.predecessor = new_predecessor;
	}

	public DLNode< E > getSuccessor( )
	{
		return this.successor;
	}

	public void setSuccessor( DLNode< E > new_successor )
	{
		this.successor = new_successor;
	}
}
