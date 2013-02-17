/**
 * Problem
 *
 * Create a BasicLinkedCollection class that uses a linked list as the backing
 * store.
 *
 * Specification
 *
 * 1. Extend AbstractCollection<E> from the Java API. 2. Use the
 * SinglyLinkedList<E> class provided in the text. 3. Override the following
 * optional methods inherited from AbstractCollection<E>: - add(E o):boolean -
 * addAll(Collection<? extends E> c):boolean - remove(Object o):boolean -
 * removeAll(Collection<?> c):boolean 4. Develop a test plan, and create a test
 * program using the JUnit framework, for your BasicLinkedCollection class. -
 * Use BasicCollectionTester.java as the model for your test program. 1. Make
 * the test program independent of your IDE (i.e. don't allow the IDE wizard to
 * create the program.) 2. The test program must have a main method so it can be
 * run independently from your IDE. - Make sure every method in
 * BasicLinkedCollection is tested.
 */
package basiclinkedcollection;

import java.util.ArrayList;
import junit.framework.*;
import java.util.Collection;
import java.util.Iterator;

//  Step 1. Create a testing class that extends TestCase.
public class BasicCollectionTester extends TestCase
{
	// Step 2: Create the test fixture. Declare the instance variables
	//         to references the objects to be used in the test methods.

	protected BasicCollection<String> c;

	// Step 3: Create a constructor that invokes the super constructor.
	//         The name argument is the name of a test case (see the
	//         suite() method).
	public BasicCollectionTester(String name)
	{
		super(name);
	}

	// Step 4. Create a setUp() method to instantiate and initialize
	//         the objects under test. This method is invoked before
	//         EVERY test case.
	protected void setUp()
	{
		c = new BasicCollection<String>();
		c.add(new String("A"));
		c.add(new String("B"));
		c.add(new String("C"));
	}

	// Step 5. Unless you need something more than general garbage ,
	//         collection such as closing I/O streams, you can leave
	//         this method out.
	protected void tearDown()
	{
		c = null;
	}

	// Step 6. Create the test cases. Each test case should follow the
	//         pattern void testXXX() where XXX is the name of the test
	//         we want to perform.

	/*
	 Test Case 1: Verify that instantiation was done properly. Note
	 that setUp() is called before this method, but isn't needed.
	 */
	public void testInstantiate()
	{
		Collection cEmpty = new BasicCollection();
		assertEquals(cEmpty.size(), 0);
		assertTrue(cEmpty.isEmpty());
	}

	/**
	 * Test Case 2: Verify the three add() ops done in setUp() and that
	 * contains() returns false when we look for something not in the
	 * collection.
	 */
	public void testAddToEmptyCollection()
	{
		assertEquals("verify size after the 3 add ops", c.size(), 3);
		assertTrue(!c.isEmpty());
		assertTrue(c.contains("A"));
		assertTrue(c.contains("B"));
		assertTrue(c.contains("C"));
		assertTrue(!c.contains("Missing"));
	}

	/**
	 * Test Case 3: Verify removing a unique element from the collection.
	 */
	public void testRemoveUniqueElement()
	{
		assertTrue(c.remove("B"));
		assertEquals(c.size(), 2);
		assertTrue("Argh! Removed element is still in the collection!",
			   !c.contains("B"));
		assertTrue(!c.isEmpty());
	}

	public void testAddAll()
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		c = new BasicCollection<>();
		c.addAll(list);
		Iterator<String> iter = c.iterator();
		while (iter.hasNext())
		{
			assertTrue("Expect item inside of collection", list.contains(iter.next()));
		}
	}

	public void testRemoveAll()
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		c = new BasicCollection<>(list);

		c.removeAll(list);

		assertEquals("no items present", c.size(), 0);
	}

	// Step 7: Create a suite of test cases.
	public static Test suite()
	{
		// The simplest approach is to let Junit do all the work using
		// Java's reflection mechanism.
		return new TestSuite(BasicCollectionTester.class);

		// Alternatively, you can create a TestSuite object and add the
		// tests manually - ugh! But this shows the purpose of the String
		// arg in the BasicCollectionTest constructor.
    /*
		 TestSuite suite = new TestSuite();
		 suite.addTest(new BasicCollectionTester("testInstantiate"));
		 suite.addTest(new BasicCollectionTester("testAddToEmptyCollection"));
		 suite.addTest(new BasicCollectionTester("testRemoveUniqueElement"));
		 return suite;
		 */
	}

	// Step 8: Define a main() method that invokes JUnit to run the test
	//         application.
	public static void main(String[] args)
	{
		// Use Java's reflection mechanism to get the name of this class.
		String[] TestCaseName =
		{
			BasicCollectionTester.class.getName()
		};
		junit.textui.TestRunner.main(TestCaseName);
	}
}
