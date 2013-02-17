/*
 * Inserting into an Ordered List
 * Write a program that inserts 25 random integers from 0 to
 * 100 in order into a linked-list object. For this exercise, you’ll need to modify the List<T> class
 * (Fig. 22.3) to maintain an ordered list. Name the new version of the class SortedList.
 */
package orderedlist;

/**
 *
 * @author nrub
 */
public class OrderedList
{

	public static SortedList<Integer> list = new SortedList<Integer>();

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		for (int i = 0; i < 25; i++)
		{
			int rand = (int) Math.floor(Math.random() * 100);
			list.insert(rand);
			list.print();
			System.out.println("---------");
		}

	}
}
