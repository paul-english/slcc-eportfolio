//CS2420
//Example program to demo VisualVM

import java.util.Random;

public class SortTest
{

	Integer[] data = new Integer[this.SIZE];
	private final Random random;
	private final int SIZE = 10000;

	public SortTest()
	{
		this.random = new Random();
		for (int i = 0; i < this.SIZE; i++)
		{
			this.data[i] = this.random.nextInt(1000);
		}
	}

	public void runTest() throws InterruptedException
	{
		System.out.println("Selection sort...");
		ArrayUtils.selectionSort(this.data, this.data.length - 1);
		// Thread.sleep(500);
		System.out.println("Merge sort...\n");
		ArrayUtils.mergeSort(this.data, 0, this.data.length - 1);
		Thread.sleep(500);
	}// end runTest()

}
