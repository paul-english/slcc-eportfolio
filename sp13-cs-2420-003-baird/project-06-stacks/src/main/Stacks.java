/**
 * Project : Stacks
 * File : Stacks.java
 * Name : Paul English
 * Date : Mar 4, 2013
 * 
 * Description :
 * 
 * Write a generic method that uses a stack to reverse the elements of a list.
 * 
 * Specification
 * 
 * 1. The method should accept a reference to an array-based list.
 * 2. Create a test program to test your method on a list of Strings and a list
 * of Integers by printing each list first in-order and then in reverse-order.
 */
package src.main;

import java.util.ArrayList;
import java.util.ListIterator;

import src.gray.ListStack;

/**
 * @author Paul English
 * 
 */
public class Stacks
{

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		ArrayList< String > stringList = new ArrayList<>( );
		stringList.add( "one" );
		stringList.add( "two" );
		stringList.add( "three" );

		System.out.println( "Print a list of Strings in-order" );
		Stacks.printList( stringList );
		System.out.println( "Print a list of Strings in reverse-order" );
		Stacks.reverse( stringList );
		Stacks.printList( stringList );

		ArrayList< Integer > intList = new ArrayList<>( );
		intList.add( 1 );
		intList.add( 2 );
		intList.add( 3 );

		System.out.println( "Print a list of Integers in-order" );
		Stacks.printList( intList );
		System.out.println( "Print a list of Integers in reverse-order" );
		Stacks.reverse( intList );
		Stacks.printList( intList );

	}

	public static < E > void printList( ArrayList< E > list )
	{
		for ( E item : list )
		{
			System.out.println( item );
		}
	}

	public static < E > void reverse( ArrayList< E > list )
	{
		ListStack< E > stack = new ListStack< E >( );
		ListIterator< E > iter = list.listIterator( );
		while ( iter.hasNext( ) )
		{
			stack.push( iter.next( ) );
		}
		list.clear( );
		while ( !stack.isEmpty( ) )
		{
			list.add( stack.pop( ) );
		}
	}

}
