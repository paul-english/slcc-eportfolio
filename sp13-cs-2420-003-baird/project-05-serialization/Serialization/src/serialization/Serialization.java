/**
 * Project : Serialization
 * File : Serialization.java
 * Name : Paul English
 * Date : Mar 4, 2013
 * 
 * Description :
 * 
 * Write a program that reads and writes a list of client accounts.
 * 
 * Specification
 * 
 * 1. Download and use the AccountRecordSerializable class.
 * 2. Use Gray's LinkedList class
 * 3. Create a list of at least 5 client account records and do the following:
 * - Display the entire list traversing head to tail.
 * - Display the entire list traversing tail to head.
 * - Display the list from indices 1 to 3 inclusive.
 * - Write the list to disk.
 * 4. Create a new list of client records and do the following:
 * - Read the saved client records into this new list.
 * - Display the entire list traversing head to tail.
 * 5. Read section 5.7 Analysis and Measurement in the Gray text. Write a
 * reflection paper summarizing this section by describing the tradeoff between
 * flexibility and efficiency for the two implementations of the List ADT. Save
 * your paper in PDF format.
 */
package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import list.LinkedList;

/**
 * 
 * @author Paul English
 */
public class Serialization
{

	/**
	 * @param args
	 *            the command line arguments
	 */
	@SuppressWarnings( "unchecked" )
	public static void main( String[ ] args ) throws IOException
	{

		LinkedList< AccountRecordSerializable > list = new LinkedList<>( );
		list.add( new AccountRecordSerializable( 1, "Steve", "Jobs", 10 ) );
		list.add( new AccountRecordSerializable( 2, "Steve", "Ballmer", 23 ) );
		list.add( new AccountRecordSerializable( 3, "Steve", "Erwin", 92 ) );
		list.add( new AccountRecordSerializable( 4, "Steve", "Hansen", 12 ) );
		list.add( new AccountRecordSerializable( 5, "Steve", "Jones", 24 ) );

		ListIterator< AccountRecordSerializable > iter = list.listIterator( );

		System.out.println( "---" );
		System.out.println( "Display the entire list traversing head to tail." );
		while ( iter.hasNext( ) )
		{
			System.out.println( iter.next( ) );
		}

		iter = list.listIterator( list.size( ) );

		System.out.println( "---" );
		System.out.println( "Display the entire list traversing tail to head." );
		while ( iter.hasPrevious( ) )
		{
			System.out.println( iter.previous( ) );
		}

		System.out.println( "---" );
		System.out.println( "Display the list from indices 1 to 3 inclusive." );
		List< AccountRecordSerializable > sublist = list.subList( 1, 4 );
		ListIterator< AccountRecordSerializable > subIter = sublist
				.listIterator( );
		while ( subIter.hasNext( ) )
		{
			System.out.println( subIter.next( ) );

		}

		System.out.println( "---" );
		System.out.println( "Write the list to disk." );
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(
					new FileOutputStream( "list.ser" ) );
			output.writeObject( list );
			output.close( );
		}
		catch ( IOException ex )
		{
			Logger.getLogger( Serialization.class.getName( ) ).log(
					Level.SEVERE, null, ex );
			System.exit( 1 );
		}

		System.out.println( "---" );
		System.out
				.println( "Read the saved client records into this new list." );
		ObjectInputStream input = null;
		try
		{
			FileInputStream inStream = new FileInputStream( "list.ser" );
			input = new ObjectInputStream( inStream );
		}
		catch ( IOException ex )
		{
			Logger.getLogger( Serialization.class.getName( ) ).log(
					Level.SEVERE, null, ex );
			System.exit( 1 );
		}

		try
		{
			list = (LinkedList< AccountRecordSerializable >) input.readObject( );
			input.close( );
		}
		catch ( ClassNotFoundException ex )
		{
			Logger.getLogger( Serialization.class.getName( ) ).log(
					Level.SEVERE, null, ex );
			System.exit( 1 );
		}

		System.out.println( "---" );
		System.out.println( "Display the entire list traversing head to tail." );
		iter = list.listIterator( );
		while ( iter.hasNext( ) )
		{
			System.out.println( iter.next( ) );
		}

	}
}
