/*
 * Problem
 *
 * Write a program to demonstrate basic List ADT operations using arrays.
 *
 * Specification
 *
 * 1. Implement the following basic list operations using a single-subscripted
 *    generic array as the backing store.
 *
 *    * Constructors: default capacity, specific capacity
 *    * Traverse
 *    * Resize (allows for additional elements beyond current capacity)
 *    * Replace (position; specific value)
 *    * Insert (at end; at specific position)
 *    * Delete (position; specific value)
 *
 * 2. Create arrays of at least two different types to test the ADT.
 *
 */
package basiclistoperationsarrays;

import junit.framework.*;
import junit.extensions.*;

/**
 *
 * @author nrub
 */
public class BasicListOperationsArrays extends TestCase
{

	public static void setUpClass()
	{
	}

	public static void tearDownClass()
	{
	}

	public void setUp()
	{
	}

	public void tearDown()
	{
	}

	public void testConstructors()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		assertEquals("myStringList should have a default capacity of 10", 10, myStringList.getCapacity());

		MyArrayList<String> myStringListOfSpecificSize = new MyArrayList<>(32);
		assertEquals("myStringListOfSpecificSize should have a capacity of 32", 32, myStringListOfSpecificSize.getCapacity());

		MyArrayList<Float> myFloatList = new MyArrayList<>();
		assertEquals("myFloatList should have a default capacity of 10", 10, myFloatList.getCapacity());

		MyArrayList<Float> myFloatListOfSpecificSize = new MyArrayList<>(32);
		assertEquals("myFloatListOfSpecificSize should have a default capacity of 10", 32, myFloatListOfSpecificSize.getCapacity());
	}

	public void testForwardTraversal()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		for (int i = 0; i < 10; i++)
		{
			String element = myStringList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is one", "one", element);
					break;
				case 1:
					assertEquals("first element is two", "two", element);
					break;
				case 2:
					assertEquals("first element is three", "three", element);
					break;
				default:
					assertEquals("all following elements are null", null, element);
					break;
			}
		}


		MyArrayList<Float> myFloatList = new MyArrayList<>();
		myFloatList.insert(new Float(0.10));
		myFloatList.insert(new Float(0.24));
		myFloatList.insert(new Float(0.33));

		for (int i = 0; i < 10; i++)
		{
			Float element = myFloatList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is 0.10", new Float(0.10), element);
					break;
				case 1:
					assertEquals("first element is 0.24", new Float(0.24), element);
					break;
				case 2:
					assertEquals("first element is 0.33", new Float(0.33), element);
					break;
				default:
					assertEquals("all following elements are null", null, element);
					break;
			}
		}
	}

	public void testBackwardTraversal()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		for (int i = myStringList.getCapacity() - 1; i >= 0; --i)
		{
			String element = myStringList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is one", "one", element);
					break;
				case 1:
					assertEquals("first element is two", "two", element);
					break;
				case 2:
					assertEquals("first element is three", "three", element);
					break;
				default:
					assertEquals("all following elements are null", null, element);
					break;
			}
		}


		MyArrayList<Float> myFloatList = new MyArrayList<>();
		myFloatList.insert(new Float(0.10));
		myFloatList.insert(new Float(0.24));
		myFloatList.insert(new Float(0.33));

		for (int i = myFloatList.getCapacity() - 1; i >= 0; --i)
		{
			Float element = myFloatList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is 0.10", new Float(0.10), element);
					break;
				case 1:
					assertEquals("first element is 0.24", new Float(0.24), element);
					break;
				case 2:
					assertEquals("first element is 0.33", new Float(0.33), element);
					break;
				default:
					assertEquals("all following elements are null", null, element);
					break;
			}
		}
	}

	public void testMidListForwardTraversal()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		for (int i = 0; i < myStringList.getNumElements(); ++i)
		{
			String element = myStringList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is one", "one", element);
					break;
				case 1:
					assertEquals("first element is two", "two", element);
					break;
				case 2:
					assertEquals("first element is three", "three", element);
					break;
				default:
					fail("we only want to traverse active values");
					break;
			}
		}


		MyArrayList<Float> myFloatList = new MyArrayList<>();
		myFloatList.insert(new Float(0.10));
		myFloatList.insert(new Float(0.24));
		myFloatList.insert(new Float(0.33));

		for (int i = 0; i < myFloatList.getNumElements(); ++i)
		{
			Float element = myFloatList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is 0.10", new Float(0.10), element);
					break;
				case 1:
					assertEquals("first element is 0.24", new Float(0.24), element);
					break;
				case 2:
					assertEquals("first element is 0.33", new Float(0.33), element);
					break;
				default:
					fail("we only want to traverse active values");
					break;
			}
		}
	}

	public void testMidListBackwardTraversal()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		for (int i = myStringList.getNumElements() - 1; i >= 0; --i)
		{
			String element = myStringList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is one", "one", element);
					break;
				case 1:
					assertEquals("first element is two", "two", element);
					break;
				case 2:
					assertEquals("first element is three", "three", element);
					break;
				default:
					fail("we only want to traverse active values");
					break;
			}
		}


		MyArrayList<Float> myFloatList = new MyArrayList<>();
		myFloatList.insert(new Float(0.10));
		myFloatList.insert(new Float(0.24));
		myFloatList.insert(new Float(0.33));

		for (int i = myFloatList.getNumElements() - 1; i >= 0; --i)
		{
			Float element = myFloatList.getElementAt(i);
			switch (i)
			{
				case 0:
					assertEquals("first element is 0.10", new Float(0.10), element);
					break;
				case 1:
					assertEquals("first element is 0.24", new Float(0.24), element);
					break;
				case 2:
					assertEquals("first element is 0.33", new Float(0.33), element);
					break;
				default:
					fail("we only want to traverse active values");
					break;
			}
		}
	}

	public void testResizing()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();
		assertEquals("myStringList should have capacity of 10", 10, myStringList.getCapacity());

		myStringList.resize(12);
		assertEquals("myStringList should have capacity of 12", 12, myStringList.getCapacity());

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");
		myStringList.resize(1);

		assertEquals("myStringList should never remove elements, but should shring capacity to 3", 3, myStringList.getCapacity());

	}

	public void testReplacing()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("a value");
		try
		{
			myStringList.replace("a value", "steve");
		}
		catch (Exception e)
		{
			fail("myStringList replace shouldn't throw an exception");
		}
		assertEquals("myStringList should have 'steve' in the first element", "steve", myStringList.getElementAt(0));
		assertEquals("myStringList should have the same number of elements", 1, myStringList.getNumElements());

		myStringList.replace(0, "twelve");
		assertEquals("myStringList should have 'twelve' in the first element", "twelve", myStringList.getElementAt(0));
		assertEquals("myStringList should have the same number of elements", 1, myStringList.getNumElements());

		myStringList.replace(3, "sixteen");
		assertEquals("myStringList should have 'sixteen' in the fourth element", "sixteen", myStringList.getElementAt(3));
		assertEquals("myStringList should have 2 of elements", 2, myStringList.getNumElements());

		myStringList.replace(35, "should increase capacity as necessary");
		assertEquals("myStringList should have our string in the 36 element", "should increase capacity as necessary", myStringList.getElementAt(35));
		assertEquals("myStringList should have an increased capacity", 40, myStringList.getCapacity());
		assertEquals("myStringList should have 3 of elements", 3, myStringList.getNumElements());


		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(29.39));
		try
		{
			myFloatList.replace(new Float(29.39), new Float(6.9));
		}
		catch (Exception e)
		{
			fail("myFloatList replace shouldn't throw an exception");
		}
		assertEquals("myFloatList should have 6.9 in the first element", new Float(6.9), myFloatList.getElementAt(0));
		assertEquals("myFloatList should have the same number of elements", 1, myFloatList.getNumElements());

		myFloatList.replace(0, new Float(11.1));
		assertEquals("myFloatList should have 11.1 in the first element", new Float(11.1), myFloatList.getElementAt(0));
		assertEquals("myFloatList should have the same number of elements", 1, myFloatList.getNumElements());

		myFloatList.replace(3, new Float(2.2));
		assertEquals("myFloatList should have 2.2 in the fourth element", new Float(2.2), myFloatList.getElementAt(3));
		assertEquals("myFloatList should have 2 elements", 2, myFloatList.getNumElements());

		myFloatList.replace(35, new Float(42.42));
		assertEquals("myFloatList should have our string in the 36 element", new Float(42.42), myFloatList.getElementAt(35));
		assertEquals("myFloatList should have an increased capacity", 40, myFloatList.getCapacity());
		assertEquals("myFloatList should have 3 of elements", 3, myFloatList.getNumElements());

	}

	public void testInserting()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("A new value");
		assertEquals("myStringList should have 1 element in it", 1, myStringList.getNumElements());

		myStringList.insert("A second value");
		assertEquals("myStringList should have 2 elements in it", 2, myStringList.getNumElements());

		myStringList.insert(1, "insert a third value at an index");
		assertEquals("myStringList has our value at the index 1", "insert a third value at an index", myStringList.getElementAt(1));

		myStringList.insert("A fourth value");
		myStringList.insert("A fifth value");
		myStringList.insert("A sixth value");
		myStringList.insert("A seventh value");
		myStringList.insert("A eigth value");
		myStringList.insert("A ninth value");
		myStringList.insert("A tenth value");
		assertEquals("myStringList should have 10 elements in it", 10, myStringList.getNumElements());
		assertEquals("myStringList should have a capacity of 10", 10, myStringList.getCapacity());

		myStringList.insert("An eleventh value");
		assertEquals("myStringList should have 11 elements in it", 11, myStringList.getNumElements());
		assertEquals("myStringList should have a capacity of 20", 20, myStringList.getCapacity());

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(1.03));
		assertEquals("myFloatList should have 1 element in it", 1, myFloatList.getNumElements());

		myFloatList.insert(new Float(2.39));
		assertEquals("myFloatList should have 2 elements in it", 2, myFloatList.getNumElements());

		myFloatList.insert(1, new Float(3.94));
		assertEquals("myFloatList has our value at the index 1", new Float(3.94), myFloatList.getElementAt(1));

		myFloatList.insert(new Float(4.04));
		myFloatList.insert(new Float(5.15));
		myFloatList.insert(new Float(6.29));
		myFloatList.insert(new Float(7.23));
		myFloatList.insert(new Float(8.43));
		myFloatList.insert(new Float(9.23));
		myFloatList.insert(new Float(10.02));
		assertEquals("myFloatList should have 10 elements in it", 10, myFloatList.getNumElements());
		assertEquals("myFloatList should have a capacity of 10", 10, myFloatList.getCapacity());

		myFloatList.insert(new Float(11.42));
		assertEquals("myFloatList should have 11 elements in it", 11, myFloatList.getNumElements());
		assertEquals("myFloatList should have a capacity of 20", 20, myFloatList.getCapacity());
	}

	public void testDeletion()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		myStringList.delete(0);
		assertEquals("myStringList number of elements should be 2", 2, myStringList.getNumElements());
		assertEquals("myStringList first element should be two", "two", myStringList.getElementAt(0));
		assertEquals("myStringList second element should be three", "three", myStringList.getElementAt(1));

		try
		{
			myStringList.delete("two");
		}
		catch (Exception e)
		{
			fail("myStringList delete should not throw an exception");
		}
		assertEquals("myStringList number of elements should be 1", 1, myStringList.getNumElements());
		assertEquals("myStringList first element should be three", "three", myStringList.getElementAt(0));

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));

		myFloatList.delete(0);
		assertEquals("myStringList number of elements should be 2", 2, myFloatList.getNumElements());
		assertEquals("myStringList first element should be 0.02", new Float(0.02), myFloatList.getElementAt(0));
		assertEquals("myStringList second element should be 0.03", new Float(0.03), myFloatList.getElementAt(1));

		try
		{
			myFloatList.delete(new Float(0.03));
		}
		catch (Exception e)
		{
			fail("myFloatList delete should not throw an exception");
		}
		assertEquals("myStringList number of elements should be 1", 1, myFloatList.getNumElements());
		assertEquals("myStringList first element should be 0.02", new Float(0.02), myFloatList.getElementAt(0));

	}

	public void testNext()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		assertEquals("one", myStringList.next());
		assertEquals("two", myStringList.next());
		assertEquals("three", myStringList.next());

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));

		assertEquals(new Float(0.01), myFloatList.next());
		assertEquals(new Float(0.02), myFloatList.next());
		assertEquals(new Float(0.03), myFloatList.next());
	}

	public void testHasNext()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		assertFalse(myStringList.hasNext());

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		assertTrue(myStringList.hasNext());

		myStringList.next();
		myStringList.next();
		assertTrue(myStringList.hasNext());

		myStringList.next();
		assertFalse(myStringList.hasNext());

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		assertFalse(myFloatList.hasNext());

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));

		assertTrue(myFloatList.hasNext());

		myFloatList.next();
		myFloatList.next();
		assertTrue(myFloatList.hasNext());

		myFloatList.next();
		assertFalse(myFloatList.hasNext());
	}

	public void testSetCursor()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		try
		{
			myStringList.setCursor(1);
			assertEquals(1, myStringList.getCursor());
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}
		try
		{
			myStringList.setCursor(2);
			assertEquals(2, myStringList.getCursor());
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}
		try
		{
			myStringList.setCursor(4);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}
		try
		{
			myStringList.setCursor(0);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}
		try
		{
			myStringList.setCursor(10);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));

		try
		{
			myFloatList.setCursor(1);
			assertEquals(1, myFloatList.getCursor());
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}
		try
		{
			myFloatList.setCursor(2);
			assertEquals(2, myFloatList.getCursor());
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}
		try
		{
			myFloatList.setCursor(4);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}
		try
		{
			myFloatList.setCursor(0);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}
		try
		{
			myFloatList.setCursor(10);
			fail("should throw an error");
		}
		catch (Exception e)
		{
			assertEquals("Cursor out of bounds", e.getMessage());
		}

	}

	public void testPrev()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");
		try
		{
			myStringList.setCursor(3);
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}

		assertEquals("three", myStringList.prev());
		assertEquals("two", myStringList.prev());
		assertEquals("one", myStringList.prev());

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));
		try
		{
			myFloatList.setCursor(3);
		}
		catch (Exception e)
		{
			fail("shouldn't throw an error");
		}

		assertEquals(new Float(0.03), myFloatList.prev());
		assertEquals(new Float(0.02), myFloatList.prev());
		assertEquals(new Float(0.01), myFloatList.prev());
	}

	public void testHasPrevious()
	{
		MyArrayList<String> myStringList = new MyArrayList<>();

		assertFalse(myStringList.hasPrevious());

		myStringList.insert("one");
		myStringList.insert("two");
		myStringList.insert("three");

		assertFalse(myStringList.hasPrevious());

		myStringList.next();
		myStringList.next();
		assertTrue(myStringList.hasPrevious());

		myStringList.next();
		assertTrue(myStringList.hasPrevious());

		MyArrayList<Float> myFloatList = new MyArrayList<>();

		assertFalse(myFloatList.hasPrevious());

		myFloatList.insert(new Float(0.01));
		myFloatList.insert(new Float(0.02));
		myFloatList.insert(new Float(0.03));

		assertFalse(myFloatList.hasPrevious());

		myFloatList.next();
		myFloatList.next();
		assertTrue(myFloatList.hasPrevious());

		myFloatList.next();
		assertTrue(myFloatList.hasPrevious());
	}

	public static Test suite()
	{
		return new TestSuite(BasicListOperationsArrays.class);
	}

	public static void main(String[] args)
	{
		String[] distanceTest =
		{
			BasicListOperationsArrays.class.getName()
		};
		junit.textui.TestRunner.main(distanceTest);
	}
}
