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

import gray.ListQueue;
import gray.ListStack;
import gray.Queue;
import gray.Stack;

public class Palindrome
{
	// method to check if our word length is odd or even
	public static boolean isOdd( int k )
	{
		return ( k % 2 ) == 1;
	}

	private int index = 0;

	private final Queue< Character > queue = new ListQueue< Character >( );
	private final Stack< Character > stack = new ListStack< Character >( );

	// private fields
	private final String word;

	// constructor
	public Palindrome( String anyString )
	{
		this.word = anyString;
	}

	public boolean isPalindrome( )
	{
		// set default result to true
		boolean result = true;
		// use i to keep track of word length
		int i = this.word.length( ) / 2;

		// add characters to stack starting from beginning of word
		while ( this.index < i )
		{
			char s = this.word.charAt( this.index );
			s = Character.toLowerCase( s );
			this.stack.push( s );
			this.index++;
		}

		// check to see if length is odd
		if ( Palindrome.isOdd( this.word.length( ) ) )
		{
			i++;	// if word length is odd increment i,
					// so we don't check the middle letter
		}

		// add characters to que starting from middle of word
		while ( i < this.word.length( ) )
		{
			char q = ( this.word.charAt( i ) );
			q = Character.toLowerCase( q );
			this.queue.enqueue( q );
			i++;
		}

		// check to see if characters are equal
		while ( this.stack.isEmpty( ) != true )
		{
			char s = this.stack.pop( );
			char q = this.queue.dequeue( );

			if ( s != q )
			{
				result = false;
			}
		}
		return result;
	}

}// end palindrome class
