import gray.SinglyLinkedList;
import person.Person;

/**
 * Project : Recursion
 * File : Recursion.java
 * Name : Paul English
 * Date : Mar 13, 2013
 * 
 * Description :
 * 
 * Problem
 * 
 * Write a generic recursive method that prints a linked list in reverse order.
 * 
 * Specification
 * 
 * 1. Use Gray's SinglyLinkedList class.
 * 2. The method should accept a reference to a generic single-linked list and
 * recursively print the list in reverse order.
 * 3. Create a test program that:
 * - creates linked lists of Strings, Integers and Persons.
 * - prints each list in-order then passes the list to your method to be printed
 * in reverse-order.
 * 4. In the method's header comment, include the recursive definition
 * describing the recursive process and base case.
 */

/**
 * @author Paul English
 * 
 */
public class Recursion
{

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		SinglyLinkedList< String > lst = new SinglyLinkedList<>( );
		lst.add( "one" );
		lst.add( "two" );
		lst.add( "three" );
		lst.add( "four" );

		SinglyLinkedList< Integer > integerList = new SinglyLinkedList<>( );
		integerList.add( 1 );
		integerList.add( 2 );
		integerList.add( 3 );
		integerList.add( 4 );

		SinglyLinkedList< Person > peopleList = new SinglyLinkedList<>( );
		peopleList.add( new Person( "Stanley K. Funk", 40 ) );
		peopleList.add( new Person( "Clint L. Thompson", 73 ) );
		peopleList.add( new Person( "Warren H. Vaughan", 79 ) );
		peopleList.add( new Person( "Albert R. Gosnell", 64 ) );

		System.out.println( "Forward" );
		System.out.print( "\nStrings:   " );
		Recursion.printForward( lst );
		System.out.print( "\nIntegers:  " );
		Recursion.printForward( integerList );
		System.out.print( "\nPeople:    " );
		Recursion.printForward( peopleList );
		System.out.println( "\n---" );

		System.out.println( "Backwards with recursion" );
		System.out.print( "\nStrings:   " );
		Recursion.printReverse( lst );
		System.out.print( "\nIntegers:  " );
		Recursion.printReverse( integerList );
		System.out.print( "\nPeople:    " );
		Recursion.printReverse( peopleList );
		System.out.println( "\n---" );
	}

	public static void printForward( SinglyLinkedList< ? > lst )
	{
		for ( int i = 0; i < lst.getLength( ); i++ )
		{
			System.out.printf( "%s:[ %-22s ]   ", i, lst.getElementAt( i ) );
		}
	}

	/**
	 * Recursively prints in reverse all elements in a list.
	 * 
	 * @param lst
	 */
	public static void printReverse( SinglyLinkedList< ? > lst )
	{
		Recursion.printReverse( lst, lst.getLength( ) );
	}

	/**
	 * Recursively prints in reverse n elements from a list.
	 * 
	 * It will print the last element capped by the length of n,
	 * if there are more elements to print it will recurse to the
	 * previous elements in the list. The base case will prevent
	 * further recursion once we've reached the front of the list.
	 * 
	 * @param lst
	 * @param n
	 *            The number of elements to print
	 */

	public static void printReverse( SinglyLinkedList< ? > lst, int n )
	{
		int i = n - 1;
		System.out.printf( "%s:[ %-22s ]   ", i, lst.getElementAt( i ) );
		if ( i > 0 )
		{
			Recursion.printReverse( lst, i );
		}
	}
}
