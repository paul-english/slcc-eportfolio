//CS2420
//Example program to demo VisualVM

public class SortTestRun
{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		for(int i=1; i<=1000; i++)
		{
			System.out.println(i);
			new SortTest().runTest();
		}
	}

}
