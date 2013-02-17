// Fig. 22.3: SortedList.java
// ListNode and SortedList class declarations.
package orderedlist;

// class to represent one node in a list

import java.util.Comparator;

class ListNode<T extends Comparable<? super T>>
{
	// package access members; SortedList can access these directly

	T data; // data for this node
	ListNode< T> nextNode; // reference to the next node in the list

	// constructor creates a ListNode that refers to object
	ListNode(T object)
	{
		this(object, null);
	} // end ListNode one-argument constructor

	// constructor creates ListNode that refers to the specified
	// object and to the next ListNode
	ListNode(T object, ListNode< T> node)
	{
		data = object;
		nextNode = node;
	} // end ListNode two-argument constructor

	// return reference to data in node
	T getData()
	{
		return data; // return item in this node
	} // end method getData

	// return reference to next node in list
	ListNode< T> getNext()
	{
		return nextNode; // get next node
	} // end method getNext

	public int compareTo(ListNode<T> o) {
	    return this.data.compareTo(o.data);
	}
} // end class ListNode< T >

// class SortedList definition
public class SortedList<T extends Comparable<? super T>>
{

	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing

	// constructor creates empty SortedList with "list" as the name
	public SortedList()
	{
		this("list");
	} // end SortedList no-argument constructor

	// constructor creates an empty SortedList with a name
	public SortedList(String listName)
	{
		name = listName;
		firstNode = lastNode = null;
	} // end SortedList one-argument constructor

	public void insert(T item) {
		ListNode<T> newNode = new ListNode<>(item);

		if (isEmpty() || newNode.compareTo(firstNode) < 0) {
			insertAtFront(newNode);
		} else if (newNode.compareTo(lastNode) > 0) {
			insertAtBack(newNode);
		} else {
			ListNode cursor = firstNode.nextNode;
			ListNode last = firstNode;
			while(newNode.compareTo(cursor) > 0) {
				last = cursor;
				cursor = cursor.nextNode;
			}
			newNode.nextNode = cursor;
			last.nextNode = newNode;
		}
	}
	// insert item at front of SortedList
	private void insertAtFront(ListNode node)
	{
		if (isEmpty()) // firstNode and lastNode refer to same object
		{
			lastNode = node;
			firstNode = lastNode;
		}
		else // firstNode refers to new node
		{
			node.nextNode = firstNode;
			firstNode = node;
		}
	} // end method insertAtFront

	// insert item at end of SortedList
	private <T extends Comparable> void insertAtBack(ListNode node)
	{
		if (isEmpty()) // firstNode and lastNode refer to same object
		{
			firstNode = lastNode = node;
		}
		else // lastNode's nextNode refers to new node
		{
			lastNode = lastNode.nextNode = node;
		}
	} // end method insertAtBack

	// remove first node from SortedList
	public T removeFromFront() throws EmptyListException
	{
		if (isEmpty()) // throw exception if SortedList is empty
		{
			throw new EmptyListException(name);
		}

		T removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode)
		{
			firstNode = lastNode = null;
		}
		else
		{
			firstNode = firstNode.nextNode;
		}

		return removedItem; // return removed node data
	} // end method removeFromFront

	// remove last node from SortedList
	public T removeFromBack() throws EmptyListException
	{
		if (isEmpty()) // throw exception if SortedList is empty
		{
			throw new EmptyListException(name);
		}

		T removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode)
		{
			firstNode = lastNode = null;
		}
		else // locate new last node
		{
			ListNode< T> current = firstNode;

			// loop while current node does not refer to lastNode
			while (current.nextNode != lastNode)
			{
				current = current.nextNode;
			}

			lastNode = current; // current is new lastNode
			current.nextNode = null;
		} // end else

		return removedItem; // return removed node data
	} // end method removeFromBack

	// determine whether list is empty
	public boolean isEmpty()
	{
		return firstNode == null; // return true if list is empty
	} // end method isEmpty

	// output list contents
	public void print()
	{
		if (isEmpty())
		{
			System.out.printf("Empty %s\n", name);
			return;
		} // end if

		System.out.printf("The %s is: ", name);
		ListNode< T> current = firstNode;

		// while not at end of list, output current node's data
		while (current != null)
		{
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		} // end while

		System.out.println();
	} // end method print
} // end class SortedList< T >
/**
 * ************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */
