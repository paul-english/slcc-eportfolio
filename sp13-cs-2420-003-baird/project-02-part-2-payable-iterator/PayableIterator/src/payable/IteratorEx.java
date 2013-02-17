/*
 * Modify IteratorEx.java (from \Text_Gray\Chapter 04\Student\) to iterate over a collection of Payable objects.
 * 1. Download Payable.zip
 *    1. Extract it into a folder named Payable.
 *    2. Compile and run PayableInterfaceTest.java.
 * 2. Modify InteratorEx.java:
 *    1. Create a BasicCollection of Payable objects:
 *       Collection<Payable> payable = new BasicCollection<Payable>();
 *       //add Invoices and Employees to the collection
 *    2. Create a Payable iterator:
 *       Iterator<Payable> iter = payable.iterator();
 *    3. Use the iterator to print each payable in the collection:
 *       while( iter.hasNext() )
 *            System.out.println( iter.next() );
 */
package payable;

import java.util.Collection;
import java.util.Iterator;
import gray.adts.collection.*;

/**
 * Illustrate the use of an iterator on a BasicCollection object.
 */
public class IteratorEx
{

	public static void main(String[] args)
	{

		Collection<String> movies = new BasicCollection<String>();
		movies.add("Cinema Paradiso");
		movies.add("Lilies of the Field");
		movies.add("In the Heat of the Night");

		System.out.println("Here are the film titles in "
				   + "the collection:");
		Iterator<String> iter;
		for (iter = movies.iterator(); iter.hasNext();)
		{
			System.out.println("   " + iter.next());
		}

		// use iterator's remove() method to remove all titles
		// containing "of"
		iter = movies.iterator(); // need to get another iterator
		while (iter.hasNext())
		{
			String str = iter.next();
			if (str.indexOf("of") != -1)
			{
				iter.remove();
			}
		}

		System.out.println("\nAfter removing all titles "
				   + "containing \"of\", here is what is left:");
		for (String movie : movies)
		{
			System.out.println("   " + movie);
		}

		Collection<Payable> payables = new BasicCollection<Payable>();

		// add Invoices and Employees to the collection
		payables.add(new SalariedEmployee("Helen", "Roberts", "053-28-4616", 85000.00));
		payables.add(new SalariedEmployee("Erick", "Adair", "539-96-8350", 95000.00));
		payables.add(new Invoice("00000001", "2000 Saleen S7", 2, 10.00));
		payables.add(new SalariedEmployee("Joe", "Nunez", "033-48-6424", 65000.00));
		payables.add(new Invoice("00000002", "2002 Toyota FCHV 5", 10, 2.00));
		payables.add(new Invoice("00000003", "1996 Audi RS2", 3, 7.50));

		// PE NOTE renamed iter to prevent naming conflict of above code.
		Iterator<Payable> payableIter = payables.iterator();
		while (payableIter.hasNext())
		{
			System.out.println(payableIter.next());
		}
	}
}
