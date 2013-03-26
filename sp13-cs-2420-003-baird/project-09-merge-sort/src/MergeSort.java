import java.util.LinkedList;
import java.util.Random;

/**
 * Project : MergeSort
 * File : MergeSort.java
 * Name : Paul English
 * Date : Mar 13, 2013
 * 
 * Description :
 * 
 * Problem
 * 
 * Create a program to perform a merge sort on a linked list.
 * 
 * Specification
 * 
 * 1. Create a linked list of 100 random integers in the range 1-1000.
 * 2. Display the unsorted linked list in a 10 x 10 table.
 * 3. To sort the linked list using a merge sort routine:
 * - Convert the linked list to an array.
 * - Perform a recursive merge sort on the array.
 * - Change the merge sort algorithm to use a non-recursive algorithm (selection
 * sort, insertion sort) when the size of the partitions is below some
 * threshold.
 * - Insert a comment in the merge sort routine that explains how you decided
 * what the threshold would be.
 * - Once the sort is complete, convert the array back into a linked list.
 * 4. Display the sorted linked list in a 10 x 10 table.
 */

/**
 * @author Paul English
 * 
 */
public class MergeSort
{

	public static int calculateThreshold( )
	{
		int testIterations = 10000;
		int maxThreshold = 20;
		int n = 1000;
		LinkedList< Integer > list = new LinkedList<>( );
		Integer[ ] arr = null;
		long time = 0;
		long minTime = Long.MAX_VALUE;
		int threshold = 0;

		for ( int i = 1; i < maxThreshold; i++ )
		{

			time = System.nanoTime( );
			for ( int j = 0; j < testIterations; j++ )
			{
				list.clear( );
				MergeSort.populateListWithWorstCase( list, n );
				arr = list.toArray( new Integer[ n ] );

				MergeSort.thresholdMergeSort( arr, i );
			}
			time = System.nanoTime( ) - time;

			System.out.printf(
					"- test for threshold %2d took %7.2f milliseconds\n", i,
					( time / 1000000.0 ) );
			if ( time < minTime )
			{
				minTime = time;
				threshold = i;
			}
			minTime = Math.min( time, minTime );
		}
		return threshold;
	}

	/**
	 * Sort an array of integers in ascending order using insertion sort.
	 * 
	 * @param a
	 *            the array of integers to sort
	 * @throws NullPointerException
	 *             if the array object is null
	 */
	public static void insertionSort( Integer[ ] arr, final int first,
			final int last )
	{
		int target; // the element we want to insert
		int targetPos; // position of the first element of the unsorted section
		int pos;

		if ( arr == null )
		{
			throw new NullPointerException( );
		}
		if ( last > arr.length )
		{
			throw new IndexOutOfBoundsException( );
		}

		// while the size of the unsorted section is greater than 0
		// when targetPos reaches a.length, there are no more unsorted elements
		for ( targetPos = first + 1; targetPos < ( last + 1 ); targetPos++ )
		{
			// get a copy of the first element in the unsorted section
			target = arr[ targetPos ];

			// while there are elements in the unsorted section to examine AND
			// we haven't found the insertion point for target
			for ( pos = targetPos - 1; ( pos >= first )
					&& ( arr[ pos ] > target ); pos-- )
			{
				// the element at pos is > target, so move it up in the array
				arr[ pos + 1 ] = arr[ pos ];
			}
			// loop postcondition: pos == -1 or a[pos] <= target,
			// so pos + 1 is the new home for target

			// insert target in its final sorted position
			arr[ pos + 1 ] = target;

		}

	}

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		LinkedList< Integer > list = new LinkedList<>( );
		Integer[ ] arr = null;
		long time = 0;

		MergeSort.populateListWithRandomInts( list, 100, 1000 );
		arr = list.toArray( new Integer[ 100 ] );

		System.out.println( "-----" );
		System.out.println( "Unsorted List" );
		System.out.println( "-----" );
		MergeSort.printArrayInGrid( arr );
		time = System.currentTimeMillis( );
		MergeSort.recursiveMergeSort( arr );
		time = System.currentTimeMillis( ) - time;
		System.out.println( "-----" );
		System.out.println( "Sorted List (Merge) - Time: " + time );
		System.out.println( "-----" );
		MergeSort.printArrayInGrid( arr );

		System.out.println( "\n\n" );

		list.clear( );
		MergeSort.populateListWithRandomInts( list, 100, 1000 );
		arr = list.toArray( new Integer[ 100 ] );

		// I'm choosing the threshold using empirical evidence from several list
		// sorts just for fun. It always chooses 3, which makes sense given that
		// recursing
		// and merging will be faster than the insertion sort,
		// but if you try to recurse past 3 element partitions you end up with a
		// split of 2 and 1 which leaves you with one swap and one pointless
		// function call. By stopping the merge at three values we always avoid
		// (n / 2) functions being added to the call stack and replace it with a
		// sort call that is plenty fast for 3 element
		int threshold = MergeSort.calculateThreshold( );
		// int threshold = 4;

		System.out.println( "-----" );
		System.out.println( "Unsorted List" );
		System.out.println( "-----" );
		MergeSort.printArrayInGrid( arr );
		time = System.currentTimeMillis( );
		MergeSort.thresholdMergeSort( arr, threshold );
		time = System.currentTimeMillis( ) - time;
		System.out.println( "-----" );
		System.out.println( "Sorted List (Threshold Merge) - Time: " + time
				+ ", Threshold: " + threshold );
		System.out.println( "-----" );
		MergeSort.printArrayInGrid( arr );
	}

	public static void merge( Integer[ ] arr, Integer[ ] temp, int first,
			int mid, int last )
	{
		int insertIndex = first, firstPartitionIndex = 0, secondPartitionIndex = mid;

		// copy the first partition to the temp array
		System.arraycopy( arr, first, temp, 0, mid - first );

		while ( ( firstPartitionIndex < ( mid - first ) )
				&& ( secondPartitionIndex <= last ) )
		{
			if ( temp[ firstPartitionIndex ] < arr[ secondPartitionIndex ] )
			{
				arr[ insertIndex ] = temp[ firstPartitionIndex ];
				firstPartitionIndex++;
			}
			else
			{
				arr[ insertIndex ] = arr[ secondPartitionIndex ];
				secondPartitionIndex++;
			}
			insertIndex++;
		}
		// postcondition: one of the partitions is empty.

		// if the first partition is empty we are done since the second
		// partition
		// is already in inputArray

		// if the second partition is empty, copy the remainder of the first
		// partition from tempArray
		while ( firstPartitionIndex < ( mid - first ) )
		{
			arr[ insertIndex ] = temp[ firstPartitionIndex ];
			firstPartitionIndex++;
			insertIndex++;
		}
	}

	public static void populateListWithRandomInts( LinkedList< Integer > list,
			int size, int max )
	{
		Random r = new Random( );
		int i = size;
		while ( i-- > 0 )
		{
			list.add( r.nextInt( max ) );
		}
	}

	public static void populateListWithWorstCase( LinkedList< Integer > list,
			int size )
	{
		int i = size;
		while ( i-- > 0 )
		{
			list.add( i );
		}
	}

	// TODO make this work with a LinkedList, not an array
	public static void printArrayInGrid( Integer[ ] arr )
	{
		int size = (int) Math.ceil( Math.sqrt( arr.length ) );
		for ( int i = 0; i < arr.length; i += size )
		{
			for ( int j = 0; ( j < size ) && ( ( i + j ) < arr.length ); j++ )
			{
				System.out.printf( "%4d", arr[ i + j ] );
			}
			System.out.print( "\n" );
		}
	}

	/**
	 * Sort the array of integers using the Merge Sort algorithm.
	 * 
	 * @param inputArray
	 *            The array of integers to be sorted.
	 * @throws NullPointerException
	 *             if the argument is null.
	 */
	public static void recursiveMergeSort( Integer[ ] arr )
	{
		if ( arr == null )
		{
			throw new NullPointerException( );
		}

		Integer temp[] = new Integer[ arr.length / 2 ];
		MergeSort.recursiveMergeSort( arr, temp, 0, arr.length - 1 );
	}

	/**
	 * The recursive Merge Sort algorithm.
	 * 
	 * @pre The array arguments are not null
	 * @pre first and last are within the bounds of the inputArray
	 * @post The inputArray is sorted in non-decreasing order.
	 */
	public static void recursiveMergeSort( Integer[ ] arr, Integer[ ] temp,
			int first, int last )
	{
		if ( ( ( last - first ) + 1 ) <= 1 )
		{
			return; // base case - partition size is 1
		}

		// find the mid point of the partition from first to last
		int mid = ( ( first + last + 1 ) / 2 );
		MergeSort.recursiveMergeSort( arr, temp, first, mid - 1 );
		MergeSort.recursiveMergeSort( arr, temp, mid, last );
		MergeSort.merge( arr, temp, first, mid, last );
	}

	public static void thresholdMergeSort( Integer[ ] arr, int threshold )
	{
		if ( arr == null )
		{
			throw new NullPointerException( );
		}

		Integer temp[] = new Integer[ arr.length / 2 ];
		MergeSort.thresholdMergeSort( arr, temp, 0, arr.length - 1, threshold );
	}

	public static void thresholdMergeSort( Integer[ ] arr, Integer[ ] temp,
			int first, int last, int threshold )
	{
		int mid = ( ( first + last + 1 ) / 2 );

		if ( ( last - first ) <= threshold )
		{
			MergeSort.insertionSort( arr, first, last );
			return;
		}

		if ( ( ( last - first ) + 1 ) <= 1 )
		{
			return;
		}

		MergeSort.thresholdMergeSort( arr, temp, first, mid - 1, threshold );
		MergeSort.thresholdMergeSort( arr, temp, mid, last, threshold );
		MergeSort.merge( arr, temp, first, mid, last );
	}
}
