package main;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * @author nrub
 */
public class CityGraphTests extends TestCase
{

	public static void main(String[] args)
	{
		String[] distanceTest =
		{ CityGraphTests.class.getName() };
		junit.textui.TestRunner.main(distanceTest);
	}

	public static void setUpClass()
	{
	}

	public static Test suite()
	{
		return new TestSuite(CityGraphTests.class);
	}

	public static void tearDownClass()
	{
	}

	@Override
	public void setUp()
	{
	}

	@Override
	public void tearDown()
	{
	}

	public void testGetInches()
	{
		// TODO
	}
}
