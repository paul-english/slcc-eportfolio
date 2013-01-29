import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import unittesting.Distance;

/**
 *
 * @author nrub
 */
public class DistanceTest {

    // 1. Modify the Distance.java class to include the following:
    //   * Add appropriate get and set methods. (set methods should allow only positive whole numbers.)
    //   * Include methods to add and subtract two Distance classes.
    //   * Override the equals() method
    //   * Override the hashCode() method.
    //   * Implement the compareTo() method from the Comparable interface.
    // 2. Implement the exception handling mechanism for the Distance class
    //    using custom Exceptions.
    // 3. Design a test plan (saved in .pdf format) to be used when implementing
    //    the Distance class.
    // 4. Create a test suite to validate the methods of the Distance class
    //    using JUnit. (Develop the test suite before you modify the Distance
    //    class, then add and implement methods to the Distance class
    //    incrementally.)
    // 5. Write a 3-5 paragraph "reflection paper" (saved in .pdf format)
    //    discussing the concepts of robustness, correctness and efficiency
    //    as they relate to software engineering. Include comments on your
    //    feelings about the effectiveness of using JUnit to test for
    //    correctness.

    public Distance d;
    public Distance d2;
    public Distance d3;

    public DistanceTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        d = new Distance();
        try
        {
            d2 = new Distance(3, 5);
        }
        catch (Distance.OutOfRangeException e)
        {
            fail("Constructing a valid distance shouldn't throw an exception.");
        }
        try
        {
            d3 = new Distance(3, 5);
        }
        catch (Distance.OutOfRangeException e)
        {
            fail("Constructing a valid distance shouldn't throw an exception.");
        }
    }

    @After
    public void tearDown()
    {
        d = null;
    }

    @Test
    public void hello()
    {
        assertNotNull("Has a basic test");
    }

    @Test
    public void testGetInches()
    {
        assertEquals("getInches should return a default value",
                1, d.getInches());

        assertEquals("getInches should return the inches it was constructed with",
                5, d2.getInches());
    }

    @Test
    public void testGetFeet()
    {
        assertEquals("getFeet should return a default value",
                1, d.getFeet());

        assertEquals("getFeet should return the feet it was constructed with",
                3, d2.getFeet());
    }

    @Test
    public void testSetInches()
    {
        try
        {
            d.setInches(29);
            assertEquals("setInches should take an integer and set the correct value",
                    29, d.getInches());
        }
        catch (Distance.InchesOutOfRangeException e)
        {
            fail("Setting inches should not throw an exception.");
        }

        try
        {
            d.setInches(-4);
            fail("setInches should throw an exception when an invalid integer is passed");
        }
        catch(Distance.InchesOutOfRangeException e)
        {
            assertNotNull("InvalidInchesException should not be null", e);
        }
    }

    @Test
    public void testSetFeet()
    {
        try
        {
            d.setFeet(13);
            assertEquals("setFeet should take an integer and set the correct value",
                    13, d.getFeet());
        }
        catch (Distance.FeetOutOfRangeException e)
        {
            fail("Setting feet should not throw an exception.");
        }

        try
        {
            d.setFeet(-2);
            fail("setInches should throw an exception when an invalid integer is passed");
        }
        catch(Distance.FeetOutOfRangeException e)
        {
            assertNotNull("InvalidInchesException should not be null", e);
        }
    }

    @Test
    public void testAddDistances()
    {
        try
        {
            Distance added = Distance.add(d, d2);
            assertEquals("Adding distances calculates the right feet value", 4, added.getFeet());
            assertEquals("Adding distances calculates the right inches value", 6, added.getInches());
        }
        catch (Distance.OutOfRangeException e)
        {
            fail("Adding distances should not result in an exception.");
        }
    }

    @Test
    public void testSubtractDistances()
    {
        try
        {
            Distance subtracted = Distance.subtract(d2, d);
            assertEquals("Subtracting distances calculates the right feet value", 2, subtracted.getFeet());
            assertEquals("Subtracting distances calculates the right inches value", 4, subtracted.getInches());
        }
        catch (Distance.OutOfRangeException e)
        {
            fail("Adding distances should not result in an exception.");
        }

        try
        {
            Distance subtracted = Distance.subtract(d, d2);
            fail("Subtracting resulted in a negative value and didn't throw an exception");
        }
        catch (Distance.OutOfRangeException e)
        {
            assertNotNull("Subtracting resulting in a negative value should throw an exception", e);
        }
    }

    @Test
    public void testEquals()
    {
        assertFalse("d & d2 should not be equal", d.equals(d2));
        assertTrue("d2 & d3 should be equal", d2.equals(d3));
    }

    @Test
    public void testHashCode()
    {
        assertEquals("A distance should have a hashCode", 31285, d.hashCode());
        assertEquals("Equal distances should have the same hashCode", d2.hashCode(), d3.hashCode());
        Assert.assertNotSame("Non-equal distances should have different hashCodes", d.hashCode(), d2.hashCode());
    }

    @Test
    public void testCompareTo()
    {
        assertEquals("d should compare to less than d2", -1, d.compareTo(d2));
        assertEquals("d2 & d3 should compare the same", 0, d2.compareTo(d3));
        assertEquals("d3 should compare greater than d", 1, d3.compareTo(d));
    }

}
