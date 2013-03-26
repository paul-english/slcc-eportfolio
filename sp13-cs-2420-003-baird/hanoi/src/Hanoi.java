/**
 * Project : Hanoi
 * File : Hanoi.java
 * Name : Paul English
 * Date : Mar 11, 2013
 * 
 * Description :
 * 
 * TODO
 */

/**
 * @author Paul English
 * 
 */
public class Hanoi
{
	private static int count = 1;

	private static void hanoi( int d, char src, char dest, char interm )
	{
		if ( d >= 1 )
		{
			Hanoi.hanoi( d - 1, src, interm, dest );
			System.out.printf( "%d) move a disk from %c to %c.\n", Hanoi.count,
					src, dest );
			Hanoi.count++;
			Hanoi.hanoi( d - 1, interm, dest, src );
		}
	}

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		int d;
		char a = 'a', b = 'b', c = 'c';
		d = 6;
		Hanoi.hanoi( d, a, b, c );
	}

}
