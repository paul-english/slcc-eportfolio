/*
 * Recursive Binary Search
 *
 * Modify Fig. 19.4 to use recursive method recursiveBinary-
 * Search to perform a binary search of the array. The method should receive the search key, starting
 * index and ending index as arguments. If the search key is found, return its index in the array. If the
 * search key is not found, return –1.
 */

import java.util.Scanner;

public class BinarySearchTest
{

	public static void main(String[] args)
	{
		// create Scanner object to input data
		Scanner input = new Scanner(System.in);

		int searchInt; // search key
		int position; // location of search key in array

		// create array and output it
		BinaryArray searchArray = new BinaryArray(15);
		System.out.println(searchArray);

		// get input from user
		System.out.print(
			"Please enter an integer value (-1 to quit): ");
		searchInt = input.nextInt(); // read an int from user
		System.out.println();

		// repeatedly input an integer; -1 terminates the program
		while (searchInt != -1)
		{
			// use binary search to try to find integer
			//position = searchArray.binarySearch(searchInt);

			// use recursive binary search to try to find integer
			position = searchArray.recursiveBinarySearch(searchInt);

			// return value of -1 indicates integer was not found
			if (position == -1)
			{
				System.out.println("The integer " + searchInt
						   + " was not found.\n");
			}
			else
			{
				System.out.println("The integer " + searchInt
						   + " was found in position " + position + ".\n");
			}

			// get input from user
			System.out.print(
				"Please enter an integer value (-1 to quit): ");
			searchInt = input.nextInt(); // read an int from user
			System.out.println();
		} // end while
	} // end main
} // end class BinarySearchTest


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/