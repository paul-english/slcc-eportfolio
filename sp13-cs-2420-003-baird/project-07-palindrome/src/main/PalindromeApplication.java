/***********************************************************
 * Programming Assignment 7
 * Palindrome program
 * Programmer: Mark Eatough and Paul English
 * Course: CS 2410
 * Created March 6, 2013
 * 
 * This checks to see if a string is a palindrome, and
 * outputs a message so say if it is or not.
 ***********************************************************/
package main;

import java.util.Scanner;

public class PalindromeApplication
{
	public static void main( String[ ] args )
	{
		String pal;
		char choice;
		Scanner inputChar = new Scanner( System.in );
		Scanner inputString = new Scanner( System.in );

		do
		{
			System.out
					.println( "\n        Check to see if your word is a palindrome!!" );
			System.out.println( "\n    1 . . . Enter your word " );
			System.out.print( "    Press any other key to exit \n\n" );
			choice = inputChar.nextLine( ).charAt( 0 );

			switch ( choice )
			{
				case '1':  				// add an item
					System.out.println( "Enter your word or phrase: \n" );
					pal = inputString.nextLine( );

					String temp = pal.replaceAll( "\\W", "" );

					Palindrome myPalindrome = new Palindrome( temp );

					if ( myPalindrome.isPalindrome( ) )
					{
						System.out.printf( "\n%s is a palindrome\n\n", pal );
					}
					else
					{
						System.out.printf( "\n%s is not a palindrome\n\n", pal );
					}
					break;

				default:
					System.out.println( "Goodbye" );
			}
		}
		while ( "1".indexOf( choice ) != -1 );

	}// end main method
}// end applicaiton class
