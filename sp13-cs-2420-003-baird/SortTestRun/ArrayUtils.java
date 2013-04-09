//package gray.adts.misc;

import java.lang.NullPointerException;
import java.util.Comparator;

/**
 * A collection of methods for sorting and printing arrays.
 */
public class ArrayUtils {

  /**
   * Sort the array elements in ascending order using selection sort.
   * @param a the array of Comparable objects to sort
   * @param n the number of elements in <tt>a</tt> to sort; assumes
   *             <tt>n</tt> less than or equal to <tt>a.length</tt>
   * @throws NullPointerException  if a is null
   * @throws IndexOutOfBoundsException if <tt>n</tt> > <tt>a.length</tt>
   */
  public static<T extends Comparable<T>>void selectionSort( T[] a, int n ) {
    if ( a == null ) {
      throw new NullPointerException();
    }
    if ( n > a.length ) {
      throw new IndexOutOfBoundsException();
    }

    // while the size of the unsorted section is > 1
    for ( int unsortedSize = n; unsortedSize > 1; unsortedSize-- ) {
      // find the position of the largest element in the unsorted section
      int maxPos = 0;
      for ( int pos = 1; pos < unsortedSize; pos++ ) {
        if ( a[pos].compareTo( a[maxPos] ) > 0 ) {
          maxPos = pos;
        }
      }
      // postcondition: maxPos is the position of the largest element in the unsorted section

      // Swap the largest value with the last value in the unsorted section
      T temp = a[unsortedSize - 1];
      a[unsortedSize - 1] = a[maxPos];
      a[maxPos] = temp;
    }
  }

  /**
   * Sort the array elements in ascending order using selection sort.
   * @param a the array of Comparable objects to sort
   * @param n the number of elements in <tt>a</tt> to sort; assumes
   *             <tt>n</tt> less than or equal to <tt>a.length</tt>
   * @throws NullPointerException  if a is null
   * @throws IndexOutOfBoundsException if <tt>n</tt> > <tt>a.length</tt>
   */
  public static<T>void selectionSort( T[] a, int n,
                                      Comparator<? super T>comparator ) {
    if ( ( a == null ) || ( comparator == null ) ) {
      throw new NullPointerException();
    }

    if ( n > a.length ) {
      throw new IndexOutOfBoundsException();
    }

    // while the size of the unsorted section is > 1
    for ( int unsortedSize = n; unsortedSize > 1; unsortedSize-- ) {
      // find the position of the largest element in the unsorted section
      int maxPos = 0;
      for ( int pos = 1; pos < unsortedSize; pos++ ) {
        if ( comparator.compare( a[pos], a[maxPos] ) > 0 ) {
          maxPos = pos;
        }
      }
      // postcondition: maxPos is the position of the largest element in the unsorted section

      // Swap the largest value with the last value in the unsorted section
      T temp = a[unsortedSize - 1];
      a[unsortedSize - 1] = a[maxPos];
      a[maxPos] = temp;
    }
  }

  /**
   * Merge two sorted partitions.
   * The partitions to be merged are always adjacent in the array.
   * @param inputArray - the array containing the two partitions to be merged.
   * @param first - the index of the first element of the first partition.
   * @param mid - the index of the first element of the second partition.
   *              <tt>mid - 1</tt> is the index of the last element of the first partition
   * @param last - the index of the last element in the second partition.
   * @pre 0 <= first < mid <= last < inputArray.length
   * @pre the elements from inputArray[first] to inputArray[mid - 1] are sorted.
   * @pre the elements from inputArray[mid] to inputArray[last] are sorted.
   * @post the elements from inputArray[first] to inputArray[last] are sorted.
   */
  private static void merge( Comparable[] inputArray, Comparable[] tempArray,
                             int first, int mid, int last ) {
    int tempSize = last - first + 1;
    int insertIndex = first, firstPartitionIndex = 0,
        secondPartitionIndex = mid;

    // copy the first partition to the temp array
    System.arraycopy( inputArray, first, tempArray, 0, mid - first );

    while ( ( firstPartitionIndex < ( mid - first ) ) &&
            ( secondPartitionIndex <= last ) ) {
      if ( tempArray[firstPartitionIndex].compareTo( inputArray[
          secondPartitionIndex] ) < 0 ) {
        inputArray[insertIndex] = tempArray[firstPartitionIndex];
        firstPartitionIndex++;
      }
      else {
        inputArray[insertIndex] = inputArray[secondPartitionIndex];
        secondPartitionIndex++;
      }
      insertIndex++;
    }
    // postcondition: one of the partitions is empty.

    // if the first partition is empty we are done since the second partition
    //   is already in inputArray

    // if the second partition is empty, copy the remainder of the first partition from tempArray
    while ( firstPartitionIndex < ( mid - first ) ) {
      inputArray[insertIndex] = tempArray[firstPartitionIndex];
      firstPartitionIndex++;
      insertIndex++;
    }
  }

  private static void internalMergesort( Comparable[] inputArray,
                                         Comparable[] tempArray, int first,
                                         int last ) {
    if ( ( last - first + 1 ) <= 1 ) {
      return; // base case - partition size is 1
    }

    // find the mid point of the partition from first to last
    int mid = first + ( ( last - first + 1 ) / 2 );
    internalMergesort( inputArray, tempArray, first, mid - 1 );
    internalMergesort( inputArray, tempArray, mid, last );
    merge( inputArray, tempArray, first, mid, last );
  }

  /**
   * Perform a merge sort on the array.
   * Uses the Merse Sort algorithm to sort the elements from <tt>first</tt> to
   * <tt>last</tt> (inclusive) in non-decreasing order.
   * @parm <tt>inputArray</tt> - the array to be sorted.
   * @parm <tt>first</tt> - the lowerbound of the range to be included in the sort.
   * @parm <tt>last</tt> - the upperbound of the range to be included in the sort.
   * @throws NullPointerException - if inputArray is null.
   * @throws IllegalArgumentException if first > last.
   * @throws ArrayIndexOutOfBoundsException if first < 0 or last >= inputArray.length.
   */
  public static void mergeSort( Comparable[] inputArray, int first, int last ) {
    if ( inputArray == null ) {
      throw new NullPointerException();
    }
    if ( first > last ) {
      throw new IllegalArgumentException();
    }
    if ( ( first < 0 ) || ( last >= inputArray.length ) ) {
      throw new ArrayIndexOutOfBoundsException();
    }

    Comparable tempArray[] = new Comparable[inputArray.length / 2];
    internalMergesort( inputArray, tempArray, first, last );
  }

  /**
   * Perform a merge sort on the array.
   * Uses the Merse Sort algorithm to sort the elements of the array in
   * non-decreasing order.
   * @parm inputArray the array to be sorted.
   * @param n the number of elements in <tt>inputArray</tt> to sort; assumes
   *             <tt>n</tt> less than or equal to <tt>inputArray.length</tt>
   * @throws NullPointerException  if <tt>inputArray</tt> is null
   * @throws IndexOutOfBoundsException if <tt>n</tt> > <tt>inputArray.length</tt>
   */
  public static void mergeSort( Comparable[] inputArray, int n ) {
    if ( inputArray == null ) {
      throw new NullPointerException();
    }
    if ( n > inputArray.length ) {
      throw new IndexOutOfBoundsException();
    }

    Comparable tempArray[] = new Comparable[n / 2];
    int first = 0;
    int last = inputArray.length - 1;
    internalMergesort( inputArray, tempArray, first, last );
  }

  private static<T>void internalMergesort( T[] inputArray, T[] tempArray,
                                           int first, int last,
                                           Comparator<? super T>c ) {
    if ( ( last - first + 1 ) <= 1 ) {
      return; // base case - partition size is 1
    }

    // find the mid point of the partition from first to last
    int mid = first + ( ( last - first + 1 ) / 2 );
    internalMergesort( inputArray, tempArray, first, mid - 1, c );
    internalMergesort( inputArray, tempArray, mid, last, c );
    merge( inputArray, tempArray, first, mid, last, c );
  }

  /**
   * Perform a merge sort on the array.
   * Uses the Merse Sort algorithm to sort the elements of the array in
   * non-decreasing order. The ordering of the elements is determined by the
   * Comparator argument.
   * @parm inputArray The array to be sorted.
   * @param n the number of elements in <tt>inputArray</tt> to sort
   * @parm c The comparator to use to produce the ordering.
   * @throws NullPointerException - if inputArray or c are null.
   * @throws IndexOutOfBoundsException if <tt>n</tt> > <tt>inputArray.length</tt>
   */
  public static<T>void mergeSort( T[] inputArray, int n, Comparator<? super T>c ) {
    if ( ( inputArray == null ) || ( c == null ) ) {
      throw new NullPointerException();
    }
    if ( n > inputArray.length ) {
      throw new IndexOutOfBoundsException();
    }

    T tempArray[] = ( T[] )new Object[inputArray.length / 2];
    int first = 0;
    int last = inputArray.length - 1;
    internalMergesort( inputArray, tempArray, first, last, c );
  }

  /**
   * Merge two sorted partitions.
   * The partitions to be merged are always adjacent in the array.
   * @param inputArray The array containing the two partitions to be merged.
   * @param tempArray The temporary array to use for the merging.
   * @param first The index of the first element of the first partition.
   * @param mid The index of the first element of the second partition.
   *              <tt>mid - 1</tt> is the index of the last element of the first partition
   * @param last The index of the last element in the second partition.
   * @param c The <tt>Comparator</tt> to use to produce an ordering.
   * @pre inputArray, tempArray and c are not null
   * @pre 0 <= first < mid <= last < inputArray.length
   * @pre The elements from inputArray[first] to inputArray[mid - 1] are sorted.
   * @pre The elements from inputArray[mid] to inputArray[last] are sorted.
   * @post The elements from inputArray[first] to inputArray[last] are sorted.
   */
  private static<T>void merge( T[] inputArray, T[] tempArray, int first,
                               int mid, int last, Comparator<? super T>c ) {
    int tempSize = last - first + 1;
    int insertIndex = first, firstPartitionIndex = 0,
        secondPartitionIndex = mid;

    // copy the first partition to the temp array
    System.arraycopy( inputArray, first, tempArray, 0, mid - first );

    while ( ( firstPartitionIndex < ( mid - first ) ) &&
            ( secondPartitionIndex <= last ) ) {
      if ( c.compare( tempArray[firstPartitionIndex],
                      inputArray[secondPartitionIndex] ) < 0 ) {
        inputArray[insertIndex] = tempArray[firstPartitionIndex];
        firstPartitionIndex++;
      }
      else {
        inputArray[insertIndex] = inputArray[secondPartitionIndex];
        secondPartitionIndex++;
      }
      insertIndex++;
    }
    // postcondition: one of the partitions is empty.

    // if the first partition is empty we are done since the second partition
    //   is already in inputArray

    // if the second partition is empty, copy the remainder of the first partition from tempArray
    while ( firstPartitionIndex < ( mid - first ) ) {
      inputArray[insertIndex] = tempArray[firstPartitionIndex];
      firstPartitionIndex++;
      insertIndex++;
    }

  }

  /**
   * Searches <tt>array</tt> for <tt>target</tt> using the binary search
   * algorithm. The array must be sorted into ascending order. If it is
   * not sorted, the results are undefined. If the array contains multiple
   * elements equal to <tt>target</tt>, there is no guarantee which one
   * will be found.
   * @param array the array to search, must be sorted in ascending order
   * @param first index of the first element in the search space; must be
   *   in the bounds of the array
   * @param last index of the last element in the search space; must be
   *   in the bounds of the array
   * @param target the data item we are looking for
   * @return the index of <tt>target</tt> in the array if found, -1 otherwise
   * @throws IndexOutOfBoundsException if <tt>first</tt> or <tt>last</tt> is
   *  less than 0 or greater than or equal to <tt>array.length</tt>
   */
  public static<T extends
      Comparable<? super T>>int binarySearch( T[] array, int first, int last,
                                              T target ) {
    if ( first > last ) {
      return -1; //  Base case - failure
    }

    if ( ( first < 0 ) || ( first >= array.length ) ||
         ( last < 0 ) || ( last >= array.length ) ) {
      throw new IndexOutOfBoundsException();
    }

    int mid = ( first + last ) / 2;
    if ( array[mid].compareTo( target ) == 0 ) {
      return mid; // Base case - success
    }
    if ( array[mid].compareTo( target ) < 0 ) { // recursive cases
      return binarySearch( array, mid + 1, last, target );
    }
    else {
      return binarySearch( array, first, mid - 1, target );
    }
  }

  /**
   * Print out the elements of an array of objects from start to finish
   * @param a the array of objects
   * @param start the index of the first element to print
   * @param finish the index of the last element to print
   */
  public static<T>void print( T[] a, int start, int finish ) {
    for ( int i = start; i <= finish; i++ ) {
      System.out.println( a[i] );
    }
  }

}
